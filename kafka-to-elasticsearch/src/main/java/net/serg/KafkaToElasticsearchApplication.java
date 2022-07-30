package net.serg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class KafkaToElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaToElasticsearchApplication.class, args);
    }
}

