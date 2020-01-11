package com.capitalone.AccountServiceProducer.Deserializer;

import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.core.io.ClassPathResource;

import com.capitalone.AccountServiceProducer.model.Customer;
import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;

public class ConsumerAvoraDeserializer implements Deserializer<Customer> {

	@Override
	public Customer deserialize(String topic, byte[] data) {
		Customer customer=null;
		try
		{
			Schema schema = new Schema.Parser()
					.parse(new ClassPathResource("avro/customer-v1.avsc").getInputStream());
			
			AvroSchema avroSchema = new AvroSchema(schema);
			AvroMapper avroMapper = new AvroMapper();
		 customer =	avroMapper.readerFor(Customer.class).with(avroSchema).readValue(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

}
