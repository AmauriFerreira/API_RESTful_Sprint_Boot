package com.desafioexperian.demo.adapter.out.persistence;

import com.desafioexperian.demo.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaH2Repository extends JpaRepository<Pessoa,Long>{

}
