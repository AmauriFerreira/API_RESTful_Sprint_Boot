package com.desafioexperian.demo.application.port.out;

import com.desafioexperian.demo.domain.Pessoa;

import java.util.Optional;

public interface BuscarPessoaPort {

    Optional<Pessoa> buscarPessoaPorId(Long id);

}
