package com.diogo.client_banking_api.dto;

import com.diogo.client_banking_api.model.enums.TypeOfAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountRequestDTO {
    private String branchCode;
    private String accountNumber;
    private TypeOfAccount accountType;
    private Integer bankCode;
}
