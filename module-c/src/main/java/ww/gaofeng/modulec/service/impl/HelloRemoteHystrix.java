package ww.gaofeng.modulec.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ww.gaofeng.modulec.service.HelloRemote;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @RequestMapping("hi")
    public String hi(@RequestParam("name") String name){
        return "hi "+name+" is down";
    }

}
