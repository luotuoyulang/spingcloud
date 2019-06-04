package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class Eureka_5000 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_5000.class,args);
    }
}
