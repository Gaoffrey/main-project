package ww.gaofeng.modulec.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ww.gaofeng.modulec.service.impl.HelloRemoteHystrix;

@FeignClient(name="spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("hi")
    public String hi(@RequestParam("name") String name);

}
