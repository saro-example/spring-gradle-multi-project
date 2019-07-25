package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({@ComponentScan({"data", "data.*"}), @ComponentScan({"web", "web.*"})})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}