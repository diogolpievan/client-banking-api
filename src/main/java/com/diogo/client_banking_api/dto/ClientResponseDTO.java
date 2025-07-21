package com.diogo.client_banking_api.dto;

import com.diogo.client_banking_api.model.enums.TypeOfAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDTO {
    
    private Long id;
    private String name;
    private String email;
    private bankAccountDTO bankAccount;

    @Getter
    @Setter
    public static class bankAccountDTO {
        private String branchCode;
        private String accountNumber;
        private TypeOfAccount accountType;
        
        private Integer bankCode;
        private String bankName;
        private String fullBankName;
        private String ispb;
    }
}
