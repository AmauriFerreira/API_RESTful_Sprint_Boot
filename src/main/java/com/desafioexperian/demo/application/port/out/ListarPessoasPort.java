package com.desafioexperian.demo.application.port.out;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.domain.Pessoa;

import java.util.List;

public interface ListarPessoasPort {

    List<Pessoa> getPessoas();


}
