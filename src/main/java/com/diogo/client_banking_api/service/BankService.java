package com.diogo.client_banking_api.service;

import com.diogo.client_banking_api.model.Bank;

public interface BankService {
    Bank findOrCreateBank(Integer code);
}

