package ww.gaofeng.moduleb.controller;

import ww.gaofeng.moduleb.bean.User;
import ww.gaofeng.moduleb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @RequestMapping("m_add")
    public User m_add() {

        User user = new User();
        user.setName("ww1");
        user.setTel("182");

        Integer result =userService.insert(user);
        System.out.println(result);

        return user;
    }

    @RequestMapping("m_hello")
    public String sayHello() {
        return "hello mybatis plus";
    }

}
