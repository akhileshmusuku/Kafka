package com.akhil.kafkaconsumer.config;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.akhil.kafkaconsumer.model.ProductVo;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Value("${kafka.host}")
	private String host;

	@Value("${kafka.groupId}")
	private String groupId;

	@Bean
	public ConsumerFactory<String, ProductVo> consumerFactory() {
		HashMap<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.akhil.kafkaconsumer.model.*");
		config.put(JsonDeserializer.TYPE_MAPPINGS, "message:com.akhil.kafkaconsumer.model.ProductVo");

		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ProductVo> productContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, ProductVo> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;

	}

}
