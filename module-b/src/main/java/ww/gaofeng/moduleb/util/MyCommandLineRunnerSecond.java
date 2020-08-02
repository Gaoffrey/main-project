package ww.gaofeng.moduleb.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyCommandLineRunnerSecond implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner second start to initialize ...");
    }
}
