package com.vigoss.shop.management.api.support;

//import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * @Author:czq
 * @Description:
 * @Date: 16:38 2018/5/25
 * @Modified By:
 */
public class FreeMarkerConfigExtend extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
//        super.afterPropertiesSet();
//        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
}