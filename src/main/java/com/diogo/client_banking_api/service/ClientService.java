package com.diogo.client_banking_api.service;

import com.diogo.client_banking_api.dto.ClientRequestDTO;
import com.diogo.client_banking_api.dto.ClientResponseDTO;

public interface ClientService {

    ClientResponseDTO createClient(ClientRequestDTO request);    

    ClientResponseDTO getClientById(Long id);
}
