package com.vigoss.wechat.core;

import java.nio.charset.Charset;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public class MessageConstant {
    /**
     * 奇素数，用于hashcode计算
     */
    public static final int odd_prime = 31;
    //配合奇素数
    public static final int result = 17;

    public static final String PROTOCOL_FILE = "file";

    public static final String PROTOCOL_JAR = "jar";

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String AES = "AES";

    public static final String SHA1 = "SHA-1";
}
