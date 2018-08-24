package com.kafka.client.config;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ConfigFileParserTest {

    @Test
    public void shouldParseKafkaConfigYaml() {
        ConfigFileParser configFileParser = ConfigFileParser.getInstance();
        KafkaProperties kafkaProperties = configFileParser.parse(ConfigFileParserTest.class.getClassLoader()
                .getResource("kafka.yaml").getFile());
        Assertions.assertThat(kafkaProperties)
                .extracting("topic", "servers", "groupid", "poll",
                        "ssl.protocol", "ssl.truststore.location", "ssl.truststore.password",
                        "ssl.keystore.location", "ssl.keystore.password")
                .containsExactly("sample", "localhost:9091", "sample-group", 1000L,
                        "SSL", "/Users/Sanjaya/kafka-cert/kafka.client.truststore.jks", "sushama123",
                        "/Users/Sanjaya/kafka-cert/kafka.client.keystore.jks", "sushama123");
    }
}
