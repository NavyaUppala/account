package com.capitalone.AccountServiceProducer.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.capitalone.AccountServiceProducer.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class CustomerListner {
	
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

    //	acknowledgment.acknowledge();
      
    }
}
