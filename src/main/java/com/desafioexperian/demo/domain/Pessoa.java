package com.desafioexperian.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    private String estado;
    private int score;

    public String getScoreDecricao() {
        if (score >=0 && score <=200){
            return "Insuficiente";}

        if (score >=201 && score <=500){
            return "Inaceitável";}

        if (score >=501 && score <=700){
            return "Aceitável";}

        if (score >=701 && score <=1000){
            return "Recomendável";}

        return "Erro, valor não permitido digite um valor entre 0 e 1000!";
    }

}
