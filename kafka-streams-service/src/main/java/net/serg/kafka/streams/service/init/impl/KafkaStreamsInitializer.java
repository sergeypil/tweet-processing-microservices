package net.serg.kafka.streams.service.init.impl;

import lombok.extern.slf4j.Slf4j;
import net.serg.config.KafkaConfigData;
import net.serg.kafka.admin.client.KafkaAdminClient;
import net.serg.kafka.streams.service.init.StreamsInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaStreamsInitializer implements StreamsInitializer {

    private final KafkaConfigData kafkaConfigData;

    private final KafkaAdminClient kafkaAdminClient;

    public KafkaStreamsInitializer(KafkaConfigData configData, KafkaAdminClient adminClient) {
        this.kafkaConfigData = configData;
        this.kafkaAdminClient = adminClient;
    }

    @Override
    public void init() {
        kafkaAdminClient.checkTopicsCreated();
        kafkaAdminClient.checkSchemaRegistry();
        log.info("Topics with name {} is ready for operations!", kafkaConfigData.getTopicNamesToCreate().toArray());
    }
}
