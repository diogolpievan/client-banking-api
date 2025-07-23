package com.diogo.client_banking_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDTO {

    private String name;
    private String email;
    private BankAccountDTO bankAccount;
}
