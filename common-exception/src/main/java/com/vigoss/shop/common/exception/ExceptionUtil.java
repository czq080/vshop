package com.vigoss.shop.common.exception;

import com.vigoss.shop.common.exception.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/**
 * 异常类工具，提供加载异常提示语，提供约定的逻辑以及常用方法
 * 约定逻辑：，
 * 1.提供异常类和提示语的对应关系
 * 提供方法：
 * 1.可根据异常类进行 获取没有前缀的 配置key
 * 2.可根据【没有前缀的 配置key】进行en,zh,code,devmsg的获取
 * 3.提供异常类中/英文的J @ExceptionUtil.getExceptionJTip ,
 *
 * @author Jamefeng
 * @date 2017-04-08
 */
public class ExceptionUtil {
    public static final String SUFFIX_SEPARATOR = ".";  //包的节点
    public static final String SUFFIX_STEP_SEPARATOR = "|";  //步骤的节点
    /**
     * 配置项，即配置文件的前缀
     */
    public static final String SUFFIX_ZH = LangType.ZH.getLang() + SUFFIX_SEPARATOR;
    public static final String SUFFIX_EN = LangType.EN.getLang() + SUFFIX_SEPARATOR;
    public static final String CODE = "code";
    public static final String SUFFIX_CODE = CODE + SUFFIX_SEPARATOR;
    public static final String DEVMSG = "devmsg";
    public static final String SUFFIX_DEVMSG = DEVMSG + SUFFIX_SEPARATOR;
    /**
     * 返回特定错误原因字符串
     */
    public static final String EXTRA_REASON_JSON_FOMART = "{" +
            "\"show\":\"%s\"" +
            ",\"code\":\"%s\"," +
            "\"message\":\"%s\"}";
    public static final Integer CODE_CHAR_SUFFIX_LENGTH = 1;
    /**
     * 未捕获的异常 key
     */
    public static final String UNCATCH_CODE_EXTRA = "ext.exception.common.uncatchcodeextra";
    public static final String PACKAGE_NAME = "com.vigoss.shop.common.";
    /**
     * #程序最终返回异常码为空，未捕获的异常(此码直接在代码中定义程序，无直接使用此项配置)
     */
    public static final UnCatchShopErrorConfigNoUseException UNCATCH_CODE_EXTRA_EORROR_CONFIG_EXCEPTION = new UnCatchShopErrorConfigNoUseException();
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtil.class);
    private static final String CONFILE_NAME = "exception-config.properties";
    private static final String EXCEPTION_CONFIG_FILES = "exception.config.files";

    private static ThreadLocal<String> localThreadLang = new ThreadLocal<String>() {
        protected String initialValue() {
            return LangType.ZH.getLang();
        }
    };
    private static Properties exceptionConfigsProps = new Properties();

    static {
        initExceptionConfigFromFile();
    }

    public static ThreadLocal<String> getLocalThreadLang() {
        return localThreadLang;
    }

    /**
     * 加载异常配置到
     *
     * @author Jamefeng
     * @Date:2017年4月6日
     */
    private static void initExceptionConfigFromFile() {
        long start = System.currentTimeMillis();
        Properties configProps = new Properties();
        String[] exception_seat_config_file = null;
        try {
            configProps.load(new InputStreamReader(ExceptionUtil.class.getClassLoader().getResourceAsStream(CONFILE_NAME)));
            exception_seat_config_file = configProps.getProperty(EXCEPTION_CONFIG_FILES).split(",");
        } catch (IOException e) {
            LOGGER.error("加载异常配置{}出错！！！,全部:{},错误信息:{}", EXCEPTION_CONFIG_FILES, exception_seat_config_file, e.getMessage());
            return;
        }
        for (String config : exception_seat_config_file) {
            try {
                Properties props = new Properties();
                props.load(new InputStreamReader(
                        ExceptionUtil.class.getClassLoader().getResourceAsStream(config),
                        "UTF-8"));
                Enumeration<Object> keys = props.keys();
                while (keys.hasMoreElements()) {
                    Object key = keys.nextElement();
                    String value = props.getProperty(key.toString());
                    if (!(key instanceof String))
                        LOGGER.warn("配置:{},value:{}出现异常！非String", key, value);
                    else
                        exceptionConfigsProps.put(key.toString().toLowerCase(), value);
                }
                LOGGER.info("加载异常的配置:{} >>>>>> done。", config);
            } catch (Exception e) {
                LOGGER.warn("加载异常配置{}出错！！！,错误信息:{}", config, e.getMessage());
            }
        }
        LOGGER.info("加载异常配置文件集合 >>>>>> {} >>>>>> done >>>>>> cost(millis):{}", exception_seat_config_file, System.currentTimeMillis() - start);
    }

    public static Properties getExceptionConfigsProps() {
        if (exceptionConfigsProps.isEmpty()) {
            initExceptionConfigFromFile();
        }
        return exceptionConfigsProps;
    }

    public static String get(String key) {
        return exceptionConfigsProps.getProperty(key);
    }

    /**
     * 获取类对应配置的项(类包名路径T)   配置key由 【 配置项.类包名路径T】
     * <p>
     * 子类实例时获取包路径以及类名，去除前缀“com.csair.“并且去除后缀“Exception”，然后全转为小写
     *
     * @param clazz
     * @return
     */
    public static String getNoSuffixConfigKeyName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        String configKeyName = clazz.getName().replaceFirst(PACKAGE_NAME, "");
        int lastIndex = configKeyName.lastIndexOf(getRemoveTailStr());
        if (lastIndex >= 0) {
            configKeyName = configKeyName.substring(0, lastIndex) + configKeyName.substring(lastIndex).replaceFirst(getRemoveTailStr(), "");
        }
        configKeyName = configKeyName.toLowerCase(Locale.getDefault());
        return configKeyName;
    }

    /**
     * 需要替换的后缀，区分大小写
     * 例如  输入：CheckInEtException
     * 输出：CheckInEt
     *
     * @return
     * @author Jamefeng
     * @date 2017-04-06
     */
    public static String getRemoveTailStr() {
        return "Exception";
    }

    /**
     * @param noSuffixKey 没有 en. 前缀
     * @return
     * @author Jamefeng
     * @Date:2017年4月6日
     */
    public static String getExceptionCode(String noSuffixKey) {
        return exceptionConfigsProps.getProperty(SUFFIX_CODE + noSuffixKey);
    }

    public static Map<String, String> getExceptionMap(String noSuffixKey) {
        Enumeration<Object> keys = exceptionConfigsProps.keys();

        Map codeMap = new HashMap<String, String>();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            int index = key.indexOf(noSuffixKey);
            if (index < 0) {
                continue;
            }
            String suffixKey = key.substring(0, index - 1);
            codeMap.put(suffixKey, exceptionConfigsProps.getProperty(key));
        }
        return codeMap;
    }

    public static String getExceptionDevMsg(String noSuffixKey) {
        return exceptionConfigsProps.getProperty(SUFFIX_DEVMSG + noSuffixKey);
    }

    public static String getExceptionTip(String noSuffixKey, Map paramMap) {
        String lang = localThreadLang.get();
        return getExceptionTip(null, noSuffixKey, paramMap, lang);
    }

    public static String getExceptionTip(Class clazz, Map paramMap) {
        String lang = localThreadLang.get();
        return getExceptionTip(null, getNoSuffixConfigKeyName(clazz), paramMap, lang);
    }

    public static String getExceptionTip(String suffixStepStr, Class clazz, Map paramMap) {
        String lang = localThreadLang.get();
        return getExceptionTip(suffixStepStr.toLowerCase(), getNoSuffixConfigKeyName(clazz), paramMap, lang);
    }

    /**
     * 获取提示语（取对应语言版）
     * 不对外，通过开始线程或者请求入口分配线程是时去初始化去设置
     *
     * @param noSuffixKey
     * @param paramMap
     * @param lang
     * @return
     */
    private static String getExceptionTip(String suffixStepStr, String noSuffixKey, Map paramMap, String lang) {
        String suffixStepStrNew = "";
        if (StringUtils.isNotBlank(suffixStepStr)) {
            suffixStepStrNew = suffixStepStr.trim() + SUFFIX_STEP_SEPARATOR;
        }
        String lowerlang = lang;
        if (StringUtils.isBlank(lang)) {
            lowerlang = LangType.ZH.getLang();
        }
        String message = exceptionConfigsProps.getProperty(suffixStepStrNew + lowerlang + SUFFIX_SEPARATOR + noSuffixKey);
        message = message == null ? exceptionConfigsProps.getProperty(lowerlang + SUFFIX_SEPARATOR + noSuffixKey) : message;
        message = message == null ? exceptionConfigsProps.getProperty(SUFFIX_ZH + noSuffixKey) : message;
        LangType type = LangType.getType(lang);
        return replaceVal(message, paramMap);


    }

    /**
     * 目前只支持选座，以后可扩展
     * 获取特定的字符串，统一输出格式
     * {   "show":false,
     * "code":"SI001",
     * "message":{"%s"
     * }
     *
     * @param isShow      是否展示
     * @param noSuffixKey ExtException异常的类
     * @return
     * @author Jamefeng
     * @date 2017-04-11
     */
    public static String getReasonStrExceptionJsonTip(boolean isShow, String noSuffixKey, ShopTypeCode type, Map paramMap) {
        return String.format(ExceptionUtil.EXTRA_REASON_JSON_FOMART,
                isShow,
                type.getType() + "" + getExceptionCode(noSuffixKey),
                getExceptionTip(noSuffixKey, paramMap));
    }

    public static String replaceVal(String content, Map<String, String> paramMap) {
        if (paramMap == null || paramMap.isEmpty() || content == null) {
            return content;
        }
        for (Entry<String, String> entry : paramMap.entrySet()) {
            String key = "#{" + entry.getKey() + "}";  //replace 查最好只循环一次  @TODO
            content = content.replace(key, entry.getValue());
        }
        return content;
    }

    /**
     * 从异常类拿到对应的提提示ExtException类
     * 如果异常不是继承 ExtException的，则抛出未捕获的提示语。
     *
     * @param e
     * @return
     */
    public static ShopException getTipExtException(Exception e) {
        ShopException shopException = null;
        if (e instanceof ShopException) {
            shopException = (ShopException) e;
        } else {
            shopException = new UnCatchShopException(e);
        }
        /**
         * 处理最终获取 ExtException没有对应的信息
         */
        if (shopException == null
                || shopException.getNoSuffixRespCode() == null || "".equals(shopException.getNoSuffixRespCode().trim())
                || shopException.getExceptionMsg() == null || "".equals(shopException.getExceptionMsg().trim())) {
            shopException = new UnCatchShopException(e).build(
                    UNCATCH_CODE_EXTRA_EORROR_CONFIG_EXCEPTION.getRespCode(),
                    UNCATCH_CODE_EXTRA_EORROR_CONFIG_EXCEPTION.getExceptionMsg(),
                    UNCATCH_CODE_EXTRA_EORROR_CONFIG_EXCEPTION.getDevMsg());
        }
        return shopException;

    }

    /**
     * 支持的语言
     */
    public static enum LangType {
        EN("en"),
        ZH("zh"),;

        String lang;

        LangType(String lang) {
            this.lang = lang;
        }

        /**
         * 获取语言，默认中文
         *
         * @param lang
         * @return
         */
        public static LangType getType(String lang) {
            for (LangType type : LangType.values()) {
                if (lang != null && type.getLang() == lang.toLowerCase()) {
                    return type;
                }
            }
            return ZH;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
}
