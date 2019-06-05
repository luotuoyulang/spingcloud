package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootApplication
@EnableZuulProxy //（启动zuul服务额度注解）
@EnableDiscoveryClient //（注册到注册中心的注解）
@EnableRedisHttpSession
public class Gitway {
    public static void main(String[] args) {
        SpringApplication.run(Gitway.class,args);
    }

    /**
     * 支持跨1域123
     * @return
     */
    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();
                headers.setAccessControlAllowOrigin((request.getHeaders().get(HttpHeaders.ORIGIN)).get(0));
                headers.setAccessControlAllowCredentials(true);
                headers.setAccessControlMaxAge(Integer.MAX_VALUE);
                headers.setAccessControlAllowHeaders(Arrays.asList("*"));
                headers.setAccessControlAllowMethods(Arrays.asList(HttpMethod.OPTIONS,
                        HttpMethod.GET, HttpMethod.HEAD, HttpMethod.POST,
                        HttpMethod.DELETE, HttpMethod.PUT));
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }
}
