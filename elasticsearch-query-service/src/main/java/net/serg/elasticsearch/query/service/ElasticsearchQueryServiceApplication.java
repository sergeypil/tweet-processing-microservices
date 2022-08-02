package net.serg.elasticsearch.query.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "net.serg")
public class ElasticsearchQueryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchQueryServiceApplication.class, args);
    }
}
