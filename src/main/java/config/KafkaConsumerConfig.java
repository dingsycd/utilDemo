package config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * KafkaConsumerConfig
 */
@Component
public class KafkaConsumerConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${bootstrap.servers.config}")
    private String bootstrapServersConfig;
    @Value("${group.id.config}")
    private String groupIdConfig;
    @Value("${auto.offset.reset.config}")
    private String autoOffsetResetConfig;

    private KafkaConsumer<String, String> kafkaConsumer;

    private void buildKafkaConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdConfig);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaConsumer = new KafkaConsumer(properties);
    }

    public KafkaConsumer<String, String> getKafkaConsumer() {
        if (kafkaConsumer == null) {
            buildKafkaConsumer();
            logger.info("-----kafka消费者对象_创建成功-----");
        }
        return kafkaConsumer;
    }

    public void closeKafkaConsumer() {
        if (kafkaConsumer != null) {
            kafkaConsumer.close();
            kafkaConsumer = null;
        }
        logger.info("-----kafka消费者对象_关闭成功-----");
    }

}
