package com.diogo.client_banking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogo.client_banking_api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
