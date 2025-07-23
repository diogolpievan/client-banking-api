package com.diogo.client_banking_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDTO {
    private Integer code;
    private String ispb;
    private String name;
    private String fullName;
}
