package com.diogo.client_banking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogo.client_banking_api.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
