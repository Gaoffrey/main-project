package ww.gaofeng.moduleb.controller;

import org.springframework.web.bind.annotation.PathVariable;
import ww.gaofeng.moduleb.bean.User;
import ww.gaofeng.moduleb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @RequestMapping("m_add")
    public User m_add() {

        User user = new User();
        user.setName("ww1");
        user.setTel("182");

        userService.insert(user);

        return user;
    }

    @RequestMapping("m_select/{id}")
    public User m_select(@PathVariable("id") Integer id) {

        User user =userService.selectByPrimaryKey(id);

        System.out.println(user);
        return user;
    }

    @RequestMapping("m_all")
    public List<User> m_all() {

        List<User> userList =userService.selectList();

        System.out.println(userList);
        return userList;
    }

    @RequestMapping("m_hello")
    public String sayHello() {
        return "hello mybatis plus";
    }

}
