package com.desafioexperian.demo.application.port.in;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;

public interface BuscarPessoaService {

    PessoaResponse buscarPessoaPorId(Long id) throws IllegalAccessException;


}
