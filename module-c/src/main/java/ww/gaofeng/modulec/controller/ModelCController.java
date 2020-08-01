package ww.gaofeng.modulec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ww.gaofeng.modulec.service.HelloRemote;

@RestController
public class ModelCController {

    @Autowired
    private HelloRemote helloRemote;

    //@PathVariable的作用是把url中的name变量传给接口中接受的形参，即使name变量和形参一致，也要写@PathVariable
    //@RequestParam的作用是把url帶的name参数传给接口中接受的形参，如果name参数和形参一致，可以不写@RequestParam
    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name")String name){
        return helloRemote.hi(name);
//        return "Hello World moduleC!";
    }


}
