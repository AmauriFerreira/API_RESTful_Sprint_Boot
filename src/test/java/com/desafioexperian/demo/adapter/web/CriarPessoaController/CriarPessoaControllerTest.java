package com.desafioexperian.demo.adapter.web.CriarPessoaController;

import com.desafioexperian.demo.adapter.in.request.PessoaRequest;
import com.desafioexperian.demo.adapter.in.web.CriarPessoaController;
import com.desafioexperian.demo.application.port.in.CriarPessoaService;
import com.desafioexperian.demo.application.service.CriarPessoaUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = CriarPessoaController.class)
@AutoConfigureMockMvc(addFilters = false)
class CriarPessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CriarPessoaService criarPessoaService;

    @Autowired
    private ObjectMapper mapper;



    @Test
    public void deveCriarPessoa() throws Exception{

       PessoaRequest request = new PessoaRequest("teste",
                                                 "99 99999-9999",
                                                 12,
                                                 "teste",
                                                 "SP",
                                                 1000);


        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                                              .header("Content-Type", "application/json")
                                              .accept("application/json")
                                              .content(mapper.writeValueAsString(request)))
               .andExpect(status().isCreated());

        then(criarPessoaService).should().createPessoa(request);

    }


}

