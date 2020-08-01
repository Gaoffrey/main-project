package ww.gaofeng.modulea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAController {
    @GetMapping("/hi")
    public String hi(){
        return "Hello World moduleA!";
    }
}
