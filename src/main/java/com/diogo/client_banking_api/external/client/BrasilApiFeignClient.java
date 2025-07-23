package com.diogo.client_banking_api.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diogo.client_banking_api.model.Bank;

@FeignClient(name = "brasilapi", url = "https://brasilapi.com.br/api")
public interface BrasilApiFeignClient {

    @GetMapping("/banks/v1/{code}")
    Bank getBankByCode(@PathVariable("code") Integer code);
}
