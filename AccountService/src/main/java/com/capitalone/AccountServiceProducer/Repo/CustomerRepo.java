package com.capitalone.AccountServiceProducer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitalone.AccountServiceProducer.model.Account;

@Repository
public interface CustomerRepo extends JpaRepository<Account, Integer> {

}
