package com.desafioexperian.demo.adapter.in.web;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;
import com.desafioexperian.demo.application.port.in.CriarPessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CriarPessoaController {

    private final CriarPessoaService pessoaService;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Inclusão realizada com sucesso")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pessoa")
    public void execute(@RequestBody PessoaRequest request) throws Exception {
        pessoaService.createPessoa(request);
    }
}