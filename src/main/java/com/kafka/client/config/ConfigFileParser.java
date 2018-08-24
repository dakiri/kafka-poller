package com.kafka.client.config;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ConfigFileParser {

    private static final ConcurrentHashMap<String, KafkaProperties> cache = new ConcurrentHashMap<>();
    private static final String CACHE_KEY = "KAFKA";
    private final Yaml yaml;

    // eagerly initialize singleton
    private static final ConfigFileParser INSTANCE = new ConfigFileParser();

    private ConfigFileParser() {
        yaml = new Yaml();
    }

    public static ConfigFileParser getInstance() {
        return INSTANCE;
    }

    public KafkaProperties parse(String file) {
        if (cache.get(CACHE_KEY) != null) {
            return cache.get(CACHE_KEY);
        } else {
            KafkaProperties kafkaProperties = doParse(file);
            cache.put(CACHE_KEY, kafkaProperties);
            return kafkaProperties;
        }
    }

    private KafkaProperties doParse(String file) {
        try (InputStream stream = Files.newInputStream(Paths.get(file))) {
            log.info("Parsing kafka yaml, since not present in local cache");
            return yaml.loadAs(stream, KafkaProperties.class);
        } catch (Exception e) {
            log.error("The config file provided is not in correct format", e);
        }
        return null;
    }
}
