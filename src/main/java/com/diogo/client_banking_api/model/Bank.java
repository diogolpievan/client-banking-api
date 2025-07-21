package com.diogo.client_banking_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="bank")
@Getter
@Setter
public class Bank {

    @Id
    private Integer code;

    private String isbp;
    private String name;
    private String fullName;
    
}
