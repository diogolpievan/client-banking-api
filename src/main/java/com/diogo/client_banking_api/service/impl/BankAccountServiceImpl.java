package com.diogo.client_banking_api.service.impl;

import org.springframework.stereotype.Service;

import com.diogo.client_banking_api.dto.BankAccountDTO;
import com.diogo.client_banking_api.model.Bank;
import com.diogo.client_banking_api.model.BankAccount;
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
    public BankAccount createBankAccount(BankAccountDTO dto){
        Bank bank = bankService.findOrCreateBank(dto.getBankCode());

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBranchCode(dto.getBranchCode());
        bankAccount.setAccountNumber(dto.getAccountNumber());
        bankAccount.setAccountType(dto.getAccountType());
        bankAccount.setBank(bank);

        return bankAccountRepository.save(bankAccount);
    }
}
