package com.desafioexperian.demo.application.port.out;

import com.desafioexperian.demo.domain.Pessoa;

public interface SalvarPessoaPort {

    Pessoa savePessoa(Pessoa pessoa);
}
