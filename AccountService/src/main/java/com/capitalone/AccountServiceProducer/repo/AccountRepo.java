package com.capitalone.AccountServiceProducer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitalone.AccountServiceProducer.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

}
