package com.kafka.client.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaProperties {

    private String topic;
    private String servers;
    private SSL ssl = new SSL();
    private String groupid;
    private long poll;

    @Getter
    @Setter
    public static class SSL {
        private String protocol;
        private Store truststore = new Store();
        private Store keystore = new Store();
    }

    @Getter
    @Setter
    public static class Store {
        private String location;
        private String password;
    }
}