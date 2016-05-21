package de.sturmm.app;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * Created by sturmm on 20.04.16.
 */
public class ConsumerApplication {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "test6");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put("group.id", "test6");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe("foo", "bar");
        while (true) {
            Map<String, ConsumerRecords<String, String>> records = consumer.poll(100);
//            for (Map.Entry<String, ConsumerRecords<String, String>> entry : records.entrySet()) {
//                System.out.printf("parition = %d, offset = %d, key = %s, value = %s\n", record.partition(), record.offset(), record.key(), record.value());
//            }
        }

    }

}
