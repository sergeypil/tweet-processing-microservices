package net.serg;

import lombok.extern.slf4j.Slf4j;
import net.serg.config.KafkaConfigData;
import net.serg.runner.StreamRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class TwitterToKafkaApplication implements CommandLineRunner {

    private final KafkaConfigData kafkaConfigData;
    private final StreamRunner streamRunner;

    public TwitterToKafkaApplication(KafkaConfigData kafkaConfigData, StreamRunner streamRunner) {
        this.kafkaConfigData = kafkaConfigData;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts");
        log.info(Arrays.toString(kafkaConfigData.getTwitterKeywords().toArray(new String[] {})));
        log.info(kafkaConfigData.getWelcomeMessage());
        streamRunner.start();
    }
}
