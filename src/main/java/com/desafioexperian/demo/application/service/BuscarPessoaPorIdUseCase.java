package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.application.port.in.BuscarPessoaService;
import com.desafioexperian.demo.application.port.out.BuscarPessoaPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPessoaPorIdUseCase implements BuscarPessoaService {


    private final BuscarPessoaPort buscarPessoaPort;

    public BuscarPessoaPorIdUseCase(BuscarPessoaPort buscarPessoaPort) {
        this.buscarPessoaPort = buscarPessoaPort;
    }

    public PessoaResponse buscarPessoaPorId(Long id)  {

        Optional<Pessoa> oPessoa = buscarPessoaPort.buscarPessoaPorId(id);

        if (!oPessoa.isPresent()){
            throw new RuntimeException("Usuario não encontrado");
        }
        Pessoa pessoa = oPessoa.get();
        PessoaResponse pessoaResponse = new PessoaResponse(
                pessoa.getNome(),
                pessoa.getCidade(),
                pessoa.getEstado(),
                pessoa.getScoreDecricao()
        );
        return pessoaResponse;
    }
}
