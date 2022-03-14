package com.desafioexperian.demo.application.service;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;
import com.desafioexperian.demo.application.port.in.CriarPessoaService;
import com.desafioexperian.demo.application.port.out.SalvarPessoaPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class CriarPessoaUseCase implements CriarPessoaService {

    private final SalvarPessoaPort salvarPessoaPort;

    public CriarPessoaUseCase(SalvarPessoaPort salvarUsuarioPort) {
        this.salvarPessoaPort = salvarUsuarioPort;
    }

    @Override
    public void createPessoa(PessoaRequest request) throws Exception {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setIdade(request.getIdade());
        pessoa.setCidade(request.getCidade());
        pessoa.setEstado(request.getEstado());
        if(request.getScore()>1000){
           throw new RuntimeException("Digite um valor entre 0 e 1000");
        }
        pessoa.setScore(request.getScore());
        salvarPessoaPort.savePessoa(pessoa);
    }
}