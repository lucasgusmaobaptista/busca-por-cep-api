package com.lucasgusmao.busca_por_cep_api.client;

import com.lucasgusmao.busca_por_cep_api.dto.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    CepResponse buscarCep(@PathVariable("cep") String cep);
}
