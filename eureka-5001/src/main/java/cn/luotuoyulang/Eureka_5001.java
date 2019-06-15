package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableEurekaServer
@SpringBootApplication
public class Eureka_5001 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_5001.class,args);
    }
}
