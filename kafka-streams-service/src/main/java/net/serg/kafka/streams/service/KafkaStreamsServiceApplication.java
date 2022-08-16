package net.serg.kafka.streams.service;

import lombok.extern.slf4j.Slf4j;
import net.serg.kafka.streams.service.init.StreamsInitializer;
import net.serg.kafka.streams.service.runner.StreamsRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"net.serg"})
@Slf4j
public class KafkaStreamsServiceApplication implements CommandLineRunner {

	private final StreamsRunner<String, Long> streamsRunner;

	private final StreamsInitializer streamsInitializer;

	public KafkaStreamsServiceApplication(StreamsRunner<String, Long> runner,
										  StreamsInitializer initializer) {
		this.streamsRunner = runner;
		this.streamsInitializer = initializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("App starts...");
		streamsInitializer.init();
		streamsRunner.start();
	}

}