package com.desafioexperian.demo.adapter.in.request;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PessoaRequest {

        private String nome;
        private String telefone;
        private int idade;
        private String cidade;
        private String estado;
        private int score;

}
