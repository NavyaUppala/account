package com.capitalone.AccountServiceProducer.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.capitalone.AccountServiceProducer.model.Account;
import com.capitalone.AccountServiceProducer.model.Customer;
import com.capitalone.AccountServiceProducer.repo.AccountRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class CustomerListner {
	
	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private AccountRepo accountRepo;
	
	ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
    @KafkaListener(topics = "${kafka.topic.avro.customer}", groupId = "consumer2", containerFactory = "custKafkaListenerContainerFactory")
    public void listenToCustomerTopic(
    		@Header(name = KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId,
    		@Header(name = KafkaHeaders.OFFSET) int offset,
    		@Payload Customer customer, 
    		Acknowledgment acknowledgment) throws JsonProcessingException {
    	System.out.println("Consumer2");
    	System.out.println("Partition Id " + partitionId);
    	System.out.println("offset " + offset);
    	System.out.println(mapper.writeValueAsString(customer));
    	
    	Account account = conversionService.convert(customer, Account.class);
    	accountRepo.save(account);
    //	acknowledgment.acknowledge();
      
    }
}
