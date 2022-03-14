package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;
import com.desafioexperian.demo.application.port.out.SalvarPessoaPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class CriarPessoaUseCaseTest {

    private final SalvarPessoaPort salvarPessoaPort =
            Mockito.mock(SalvarPessoaPort.class);

    private final CriarPessoaUseCase serviceUnderTest =
            new CriarPessoaUseCase(
                    salvarPessoaPort
            );


    @Test
    public void deveCriarPessoa() throws Exception {

        given(salvarPessoaPort.savePessoa(any())).willReturn(pessoa());

        serviceUnderTest.createPessoa(new PessoaRequest(
                "teste",
                "99 99999-9999",
                12,
                "teste",
                "SP",
                1000
        ));

        then(salvarPessoaPort).should().savePessoa(any());

    }

    private Pessoa pessoa() {
        return Mockito.mock(Pessoa.class);
    }

}
