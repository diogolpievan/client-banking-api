package com.diogo.client_banking_api.service.impl;

import org.springframework.stereotype.Service;

import com.diogo.client_banking_api.dto.BankAccountRequestDTO;
import com.diogo.client_banking_api.model.Bank;
import com.diogo.client_banking_api.model.BankAccount;
import com.diogo.client_banking_api.model.Client;
import com.diogo.client_banking_api.repository.BankAccountRepository;
import com.diogo.client_banking_api.service.BankAccountService;
import com.diogo.client_banking_api.service.BankService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{
    
    private final BankAccountRepository bankAccountRepository;
    private final BankService bankService;

    @Override
    public BankAccount createBankAccount(BankAccountRequestDTO bankAccountDTO, Client client){
        Bank bank = bankService.findOrCreateBank(bankAccountDTO.getBankCode());

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBranchCode(bankAccountDTO.getBranchCode());
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        bankAccount.setAccountType(bankAccountDTO.getAccountType());
        bankAccount.setBank(bank);
        bankAccount.setClient(client);

        return bankAccountRepository.save(bankAccount);
    }
}
