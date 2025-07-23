package com.diogo.client_banking_api.service;

import com.diogo.client_banking_api.dto.BankAccountRequestDTO;
import com.diogo.client_banking_api.model.BankAccount;
import com.diogo.client_banking_api.model.Client;

public interface BankAccountService {

    BankAccount createBankAccount(BankAccountRequestDTO bankAccountDTO, Client client);
}
