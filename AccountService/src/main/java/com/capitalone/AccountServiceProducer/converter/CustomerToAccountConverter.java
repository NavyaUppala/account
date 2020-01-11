package com.capitalone.AccountServiceProducer.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.capitalone.AccountServiceProducer.model.Account;
import com.capitalone.AccountServiceProducer.model.Customer;

@Component
public class CustomerToAccountConverter implements Converter<Customer, Account> {

	@Override
	public Account convert(Customer customer) {
		Account account = new Account();
		account.setCustomerFirstName(customer.getFname());
		account.setCustomerLastName(customer.getLname());
		return account;
	}

}
