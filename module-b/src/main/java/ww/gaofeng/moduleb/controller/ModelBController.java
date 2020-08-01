package ww.gaofeng.moduleb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelBController {
    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name){
        return "hi "+name;
//        return "Hello World moduleB!";
    }
}
