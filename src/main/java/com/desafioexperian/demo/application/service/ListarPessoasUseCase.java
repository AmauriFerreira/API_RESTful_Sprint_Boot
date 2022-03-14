package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.application.port.in.ListarPessoasService;
import com.desafioexperian.demo.application.port.out.ListarPessoasPort;
import com.desafioexperian.demo.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPessoasUseCase implements ListarPessoasService {


    private final ListarPessoasPort listarPessoasPort;

    public ListarPessoasUseCase(ListarPessoasPort listarPessoasPort) {

        this.listarPessoasPort = listarPessoasPort;
    }


    public List<PessoaResponse> listPessoas() {
    List<Pessoa> pessoas= listarPessoasPort.getPessoas();
    List<PessoaResponse> pessoasResponse = pessoas.stream().map(pessoa -> new PessoaResponse(
                    pessoa.getNome(),
                    pessoa.getCidade(),
                    pessoa.getEstado(),
                    pessoa.getScoreDecricao()
                    )).collect(Collectors.toList());

        return pessoasResponse ;
    }
}


