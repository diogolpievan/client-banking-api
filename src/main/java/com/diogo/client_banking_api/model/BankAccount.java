package com.diogo.client_banking_api.model;

import com.diogo.client_banking_api.model.enums.TypeOfAccount;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="bank_account")
@Getter
@Setter
public class BankAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String accountNumber;
    private TypeOfAccount accountType;

    @ManyToOne
    @JoinColumn(name = "bank_code")
    private Bank bankDetails;
}
