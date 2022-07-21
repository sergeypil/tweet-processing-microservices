package net.serg.listener;

import lombok.extern.slf4j.Slf4j;
import net.serg.config.KafkaConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Component
@Slf4j
public class TwitterKafkaStatusListener extends StatusAdapter {

    private final KafkaConfigData kafkaConfigData;

    public TwitterKafkaStatusListener(KafkaConfigData configData) {
        this.kafkaConfigData = configData;

    }

    @Override
    public void onStatus(Status status) {
        log.info("Received status text {} sending to kafka topic {}", status.getText());
    }
}
