package com.desafioexperian.demo.application.port.in;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;

public interface CriarPessoaService {

    void createPessoa(PessoaRequest request) throws Exception;

}
