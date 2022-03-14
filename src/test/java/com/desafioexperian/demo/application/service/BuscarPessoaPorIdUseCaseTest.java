package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.application.port.out.BuscarPessoaPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class BuscarPessoaPorIdUseCaseTest {


    private final BuscarPessoaPort buscarPessoaPort =
            Mockito.mock(BuscarPessoaPort.class);

   private final BuscarPessoaPorIdUseCase serviceUnderTest =
           new BuscarPessoaPorIdUseCase(
                   buscarPessoaPort
           );


    @Test
    public void deveListarPessoas() {

        String baseUrl = "/pessoas";

        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Optional<Pessoa> optionalPessoa = Optional.of(pessoa);

        given(buscarPessoaPort.buscarPessoaPorId(anyLong())).willReturn(optionalPessoa);

        serviceUnderTest.buscarPessoaPorId(anyLong());

        then(buscarPessoaPort).should();

    }

}






