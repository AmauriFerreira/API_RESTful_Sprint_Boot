package com.desafioexperian.demo.adapter.out.persistence;

import com.desafioexperian.demo.application.port.out.BuscarPessoaPort;
import com.desafioexperian.demo.application.port.out.ListarPessoasPort;
import com.desafioexperian.demo.application.port.out.SalvarPessoaPort;
import com.desafioexperian.demo.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class PessoaAdapterImpl
        implements
            BuscarPessoaPort, ListarPessoasPort, SalvarPessoaPort
{
    @Autowired
    PessoaH2Repository pessoaH2Repository;

    @Override
    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaH2Repository.findById(id);
    }

    @Override
    public List<Pessoa> getPessoas() {
        return pessoaH2Repository.findAll();
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaH2Repository.save(pessoa);
    }
}
