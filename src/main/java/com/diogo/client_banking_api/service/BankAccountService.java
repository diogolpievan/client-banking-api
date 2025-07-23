package com.diogo.client_banking_api.service;

import com.diogo.client_banking_api.dto.BankAccountDTO;
import com.diogo.client_banking_api.model.BankAccount;

public interface BankAccountService {

    BankAccount createBankAccount(BankAccountDTO bankAccountDTO);
}
