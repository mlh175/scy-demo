package tech.aistar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启事务
@SpringBootApplication
public class ScyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScyDemoApplication.class, args);
    }

}
