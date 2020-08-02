package ww.gaofeng.modulec;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients     //启用feign进行远程调用
@EnableAdminServer
public class ModuleCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleCApplication.class, args);
    }



}
