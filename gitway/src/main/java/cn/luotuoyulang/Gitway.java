package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //（启动zuul服务额度注解）
@EnableDiscoveryClient //（注册到注册中心的注解）
public class Gitway {
    public static void main(String[] args) {
        SpringApplication.run(Gitway.class,args);
    }
}
