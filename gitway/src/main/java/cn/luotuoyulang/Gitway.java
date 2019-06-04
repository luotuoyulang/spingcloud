package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy //（启动zuul服务额度注解）
@EnableDiscoveryClient //（注册到注册中心的注解）
@EnableRedisHttpSession
public class Gitway {
    public static void main(String[] args) {
        SpringApplication.run(Gitway.class,args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        //config.addAllowedMethod("OPTIONS");
        //config.addAllowedMethod("HEAD");
        //config.addAllowedMethod("GET");
        //config.addAllowedMethod("PUT");
        //config.addAllowedMethod("POST");
        //config.addAllowedMethod("DELETE");
        //config.addAllowedMethod("PATCH");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("*//**", config);
        return new CorsFilter(source);
    }
}
