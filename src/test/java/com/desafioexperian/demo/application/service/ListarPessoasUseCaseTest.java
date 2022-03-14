package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.application.port.out.ListarPessoasPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.hibernate.collection.internal.PersistentBag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


public class ListarPessoasUseCaseTest {


    private final ListarPessoasPort listarPessoasPort =
            Mockito.mock(ListarPessoasPort.class);

    private final ListarPessoasUseCase serviceUnderTest =
            new ListarPessoasUseCase(
                    listarPessoasPort
            );


    @Test
    public void deveListarPessoas() {

        String baseUrl = "/pessoas";

        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        pessoas.add(pessoa);

        given(listarPessoasPort.getPessoas()).willReturn(pessoas);


        serviceUnderTest.listPessoas();

        then(listarPessoasPort).should().getPessoas();


        }

    }
