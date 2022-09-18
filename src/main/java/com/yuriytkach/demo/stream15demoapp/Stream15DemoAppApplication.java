package com.yuriytkach.demo.stream15demoapp;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@SpringBootApplication
@EnableCaching
public class Stream15DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Stream15DemoAppApplication.class, args);
	}

	@Bean
	public RedisCacheConfiguration redisCacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
			.entryTtl(Duration.ofMinutes(10))
			.disableCachingNullValues()
			.serializeValuesWith(RedisSerializationContext.SerializationPair
				.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

}
