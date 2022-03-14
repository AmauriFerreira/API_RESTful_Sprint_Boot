package com.desafioexperian.demo.adapter.web.CriarPessoaController;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;
import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.adapter.in.web.CriarPessoaController;
import com.desafioexperian.demo.adapter.in.web.ListarPessoasController;
import com.desafioexperian.demo.application.port.in.CriarPessoaService;
import com.desafioexperian.demo.application.port.in.ListarPessoasService;
import com.desafioexperian.demo.domain.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ListarPessoasController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ListarPessoasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListarPessoasService listarPessoaService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void deveRetornaListaDePessoaVazia() throws Exception{

        String baseUrl = "/pessoas";

        given(listarPessoaService.listPessoas()).willReturn(Collections.emptyList());

        MvcResult result = mockMvc.perform(get(baseUrl)
                                   .header("Content-Type", "application/json"))
                                  .andExpect(status().isOk())
                                  .andReturn();

        then(listarPessoaService).should().listPessoas();

        assertThat(result.getResponse().getContentAsString()).isEqualTo("[]");

    }
    @Test
    public void deveRetornaListaDePessoas() throws Exception{

        String baseUrl = "/pessoas";

        PessoaResponse response = new PessoaResponse("teste",
                                                     "teste",
                                                     "teste",
                                                     "teste");

        List<PessoaResponse> responses = new ArrayList<>();
        responses.add(response);

        given(listarPessoaService.listPessoas()).willReturn(responses);

        MvcResult result = mockMvc.perform(get(baseUrl)
                                                   .header("Content-Type", "application/json"))
                                  .andExpect(status().isOk())
                                  .andReturn();

        then(listarPessoaService).should().listPessoas();


        assertThat(result.getResponse()
                         .getContentAsString()).isNotEqualTo(Collections.emptyList());

    }
}