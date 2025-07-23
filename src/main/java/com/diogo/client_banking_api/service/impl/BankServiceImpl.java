package com.diogo.client_banking_api.service.impl;

import org.springframework.stereotype.Service;

import com.diogo.client_banking_api.external.client.BrasilApiFeignClient;
import com.diogo.client_banking_api.model.Bank;
import com.diogo.client_banking_api.repository.BankRepository;
import com.diogo.client_banking_api.service.BankService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{
    
    private final BankRepository bankRepository;
    private final BrasilApiFeignClient brasilApiFeignClient;

    @Override
    public Bank findOrCreateBank(Integer code){
        return bankRepository.findById(code)
                .orElseGet(() -> {
                    Bank bank = brasilApiFeignClient.getBankByCode(code);
                    return bankRepository.save(bank);
                });
    }
}
