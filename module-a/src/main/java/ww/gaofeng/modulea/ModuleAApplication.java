package ww.gaofeng.modulea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ModuleAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleAApplication.class, args);
    }



}
