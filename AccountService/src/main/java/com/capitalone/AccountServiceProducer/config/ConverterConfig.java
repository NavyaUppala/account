package com.capitalone.AccountServiceProducer.config;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

import com.capitalone.AccountServiceProducer.converter.CustomerToAccountConverter;

@Configuration
public class ConverterConfig {

	@Autowired
	private CustomerToAccountConverter customerToAccountConverter;
   
	@Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(Stream.of(customerToAccountConverter).collect(Collectors.toSet()));
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
