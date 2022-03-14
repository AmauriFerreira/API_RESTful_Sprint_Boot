package com.desafioexperian.demo.application.port.in;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;

import java.util.List;

public interface ListarPessoasService {

    List<PessoaResponse> listPessoas();

}
