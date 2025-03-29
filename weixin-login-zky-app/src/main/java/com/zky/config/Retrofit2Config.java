package com.zky.config;

import com.zky.infrastructure.gateway.IWeixinApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author: ZhangKaiYuan
 * @description: 通过Retrofit来构建和管理HTTP请求
 * @create: 2025/3/29
 */
@Slf4j
@Configuration
public class Retrofit2Config {

    private static final String BASE_URL = "https://api.weixin.qq.com/";

    /**
     * 构建一个 Retrofit 实例，设置它的基础URL，使用Jackson转换器工厂，将JSON格式数据转换为Java对象。
     * @return
     */
    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    /**
     * 生成微信API服务的代理接口
     * @param retrofit
     * @return
     */
    @Bean
    public IWeixinApiService weixinApiService(Retrofit retrofit) {
        return retrofit.create(IWeixinApiService.class);
    }

}
