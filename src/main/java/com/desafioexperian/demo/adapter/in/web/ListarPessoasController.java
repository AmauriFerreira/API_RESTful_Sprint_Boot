package com.desafioexperian.demo.adapter.in.web;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.application.port.in.ListarPessoasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarPessoasController {

    private final ListarPessoasService listarPessoasService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 204, message = "Lista não encontrada")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/pessoas")
    public ResponseEntity<List<PessoaResponse>> execute() {
        List<PessoaResponse> response = listarPessoasService.listPessoas();
        return new ResponseEntity(response, HttpStatus.OK);


    }
}
