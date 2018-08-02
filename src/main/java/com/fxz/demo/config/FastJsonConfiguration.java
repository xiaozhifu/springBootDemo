package com.fxz.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by fuxiaozhi on 2018\8\1 0001.
 */

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter{

    @Override
    /**
     * 自定义消息类型转换器
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建FastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }

}
