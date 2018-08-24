package com.kafka.client;


import com.kafka.client.poller.KafkaMessagePoller;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.kafka.test.rule.KafkaEmbedded;

import java.util.List;
@Ignore
public class KafkaMessagePollerITest {

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "sample");


    @BeforeClass
    public static void init() {
        embeddedKafka.setKafkaPorts(9091);
    }


    @Test
    public void shouldPollMessages() {
        KafkaMessagePoller poller = KafkaMessagePoller
                .builder()
                .configFile(null)
                .build();
        List<String> messages = poller.poll();
    }
}
