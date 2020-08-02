package ww.gaofeng.moduleb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("ww.gaofeng.moduleb.mapper")     //扫描mapper接口
public class ModuleBApplication {

    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(ModuleBApplication.class, args);
        System.out.println("The service has started.");
    }

}
