package com.lucasgusmao.busca_por_cep_api.service;

import com.lucasgusmao.busca_por_cep_api.client.ViaCepClient;
import com.lucasgusmao.busca_por_cep_api.dto.CepResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    private final ViaCepClient viaCepClient;

    public CepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @Cacheable(value = "cepCache", key = "#cep")
    public CepResponse buscarCep(String cep) {
        return viaCepClient.buscarCep(cep);
    }

}
