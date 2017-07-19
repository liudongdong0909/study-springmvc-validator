package com.donggua.springmvc.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * freemark 工具类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-18 上午 11:07
 */
public class FreemarkUtil {

    private static FreeMarkerConfigurer freeMarkerConfigurer;

    public static final Logger LOGGER = LoggerFactory.getLogger(FreemarkUtil.class);

    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        FreemarkUtil.freeMarkerConfigurer = freeMarkerConfigurer;
    }

    /**
     * 创建静态页面
     *
     * @param templateName 模板名称
     * @param targetPath 生成模板绝对路径
     * @param model 数据模型
     */
    public static void process(String templateName, String targetPath, Map<String, Object> model){
        try {
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate(templateName);
            Writer out = new OutputStreamWriter(new FileOutputStream(new File(targetPath)));
            template.process(model, out);
            IOUtils.closeQuietly(out);
            LOGGER.info("静态化页面: templateName= {}, targetPath= {}, model= {}", template, targetPath, model);
        } catch (Exception e) {
            LOGGER.error("静态化页面失败：templateName= {}, targetPath= {}, model= {}", templateName, targetPath, model, e);
        }
    }

}
