package com.desafio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.dto.EnderecoDTO;

@Service
public class ViaCepService {

	private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public EnderecoDTO consultarEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = VIA_CEP_URL;
        EnderecoDTO endereco = restTemplate.getForObject(url, EnderecoDTO.class, cep);
        return endereco;
    }
}
