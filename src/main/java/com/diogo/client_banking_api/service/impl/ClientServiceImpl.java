package com.diogo.client_banking_api.service.impl;

import org.springframework.stereotype.Service;

import com.diogo.client_banking_api.dto.BankAccountRequestDTO;
import com.diogo.client_banking_api.dto.BankAccountResponseDTO;
import com.diogo.client_banking_api.dto.BankDTO;
import com.diogo.client_banking_api.dto.ClientRequestDTO;
import com.diogo.client_banking_api.dto.ClientResponseDTO;
import com.diogo.client_banking_api.model.Bank;
import com.diogo.client_banking_api.model.BankAccount;
import com.diogo.client_banking_api.model.Client;
import com.diogo.client_banking_api.repository.ClientRepository;
import com.diogo.client_banking_api.service.BankAccountService;
import com.diogo.client_banking_api.service.ClientService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final BankAccountService bankAccountService;

    @Override
    @Transactional
    public ClientResponseDTO createClient(ClientRequestDTO request) {
        Client client = new Client();

        client.setName(request.getName());
        client.setEmail(request.getEmail());

        Client savedClient = clientRepository.save(client);

        BankAccountRequestDTO bankAccountRequest = request.getBankAccount();
        BankAccount createdBankAccount = bankAccountService.createBankAccount(bankAccountRequest, savedClient);

        ClientResponseDTO response = new ClientResponseDTO();
        response.setId(savedClient.getId());
        response.setName(savedClient.getName());
        response.setEmail(savedClient.getEmail());

        BankAccountResponseDTO bankAccountResponse = new BankAccountResponseDTO();
        bankAccountResponse.setAccountNumber(createdBankAccount.getAccountNumber());
        bankAccountResponse.setBranchCode(createdBankAccount.getBranchCode());
        bankAccountResponse.setAccountType(createdBankAccount.getAccountType());
        Bank bank = createdBankAccount.getBank();

        BankDTO bankDTO = new BankDTO();
        bankDTO.setCode(bank.getCode());
        bankDTO.setIspb(bank.getIspb());
        bankDTO.setName(bank.getName());
        bankDTO.setFullName(bank.getFullName());

        bankAccountResponse.setBank(bankDTO);

        response.setBankAccount(bankAccountResponse);

        return response;
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));

        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());

        BankAccount bankAccount = client.getBankAccount();
        if (bankAccount != null) {
            BankAccountResponseDTO bankAccountResponse = new BankAccountResponseDTO();
            bankAccountResponse.setAccountNumber(bankAccount.getAccountNumber());
            bankAccountResponse.setBranchCode(bankAccount.getBranchCode());
            bankAccountResponse.setAccountType(bankAccount.getAccountType());

            Bank bank = bankAccount.getBank();
            if (bank != null) {
                BankDTO bankDTO = new BankDTO();
                bankDTO.setCode(bank.getCode());
                bankDTO.setIspb(bank.getIspb());
                bankDTO.setName(bank.getName());
                bankDTO.setFullName(bank.getFullName());
                bankAccountResponse.setBank(bankDTO);
            }
            dto.setBankAccount(bankAccountResponse);
        }
        return dto;
    }
}
