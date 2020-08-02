package ww.gaofeng.moduleb.controller;

import ww.gaofeng.moduleb.bean.User;
import ww.gaofeng.moduleb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    //下面是手动保存到redis
    @RequestMapping("hello")
    public User sayHello() {

        User user = new User(1, "ww", "182");
        redisTemplate.opsForValue().set("user",user,60, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("user"));

        return user;
    }

    //下面是自动保存到redis,需要实体类实现Serializable接口。
    //使用@Cacheable需要注释掉热部署的spring-boot-devtools依赖。
    //否则在将redis中持久化的对象取出并进行反序列化时出现“ClassCastException”。
    //https://blog.csdn.net/qq_33101675/article/details/78231053

    //@Cacheable先去缓存找，然后才执行方法。通常用于查询方法。
    //@CachePut每次都会执行，然后把缓存数据放到缓存里面。@CachePut("users")。通常用于更新方法。
    //@CacheEvict清除缓存，在类上面时就是其中所有的方法的执行都会触发缓存的清除操作。@CacheEvict(value="users", allEntries=true)。通常用于更新和删除方法。
    //https://www.cnblogs.com/fashflying/p/6908028.html

    @RequestMapping("cacheable")
    @Cacheable(value="user-key")
    public User testRedis_cacheable() {

        User user = new User(2, "ww2", "1822");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    //下午再测试一下@CachePut和@CacheEvict
    @RequestMapping("cacheput")
    @Cacheable(value="user-key")
    public User testRedis_cacheput() {

        User user =userService.selectByPrimaryKey(6);
        user.setTel("155");
        userService.updateByPrimaryKey(user);
        return user;
    }

    @RequestMapping("cacheevict")
    @Cacheable(value="user-key")
    public User testRedis_cacheevict() {
        User user =userService.selectByPrimaryKey(6);
        userService.deleteByPrimaryKey(user.getId());
        return user;
    }

    @RequestMapping("uuid")
    public String uuid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uuid");
        if(uuid ==null){
            uuid =UUID.randomUUID();
        }
        session.setAttribute("uuid",uuid);
        return session.getId();
    }



}
