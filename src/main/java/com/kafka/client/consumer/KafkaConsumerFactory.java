package com.kafka.client.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Map;

public class KafkaConsumerFactory<K, V> {

    private final Map<String, Object> configs;

    public KafkaConsumerFactory(Map<String, Object> configs) {
        this.configs = configs;
    }

    public KafkaConsumer<K, V> createKafkaConsumer() {
        return new KafkaConsumer<>(configs);
    }
}
