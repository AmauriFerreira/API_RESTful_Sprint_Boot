package com.desafioexperian.demo.adapter.in.web;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.application.port.in.BuscarPessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BuscarPessoaPorIdController {

    private final BuscarPessoaService buscarPessoaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 204, message = "Id não encontrada")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<PessoaResponse> executa(@PathVariable Long id) throws IllegalAccessException {
        PessoaResponse pessoaResponse = buscarPessoaService.buscarPessoaPorId(id);
        return new ResponseEntity(pessoaResponse,HttpStatus.OK);
    }
}
