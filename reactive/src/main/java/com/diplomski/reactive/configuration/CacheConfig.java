package com.diplomski.reactive.configuration;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

    @Bean
    ReactiveRedisOperations<String, StockQuote> stockQuoteRedisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<StockQuote> serializer = new Jackson2JsonRedisSerializer<>(StockQuote.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, StockQuote> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, StockQuote> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

    @Bean
    ReactiveRedisOperations<String, StockOption> stockOptionRedisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<StockOption> serializer = new Jackson2JsonRedisSerializer<>(StockOption.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, StockOption> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, StockOption> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
