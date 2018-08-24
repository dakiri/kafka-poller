package com.kafka.client.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaConfiguration {

    // eagerly initialize singleton
    private static final KafkaConfiguration INSTANCE = new KafkaConfiguration();

    public static KafkaConfiguration getInstance() {
        return INSTANCE;
    }

    private KafkaConfiguration() {
    }

    public Map<String, Object> consumerConfiguration(KafkaProperties kafkaProperties) {
        Map<String, Object> props = new HashMap();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServers());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        /*props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafkaProperties.getSsl().getProtocol());
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, kafkaProperties.getSsl().getTruststore().getLocation());
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafkaProperties.getSsl().getTruststore().getPassword());
        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, kafkaProperties.getSsl().getKeystore().getLocation());
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, kafkaProperties.getSsl().getKeystore().getPassword());
        props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, kafkaProperties.getSsl().getKeystore().getPassword());*/
        return props;
    }
}
