package com.desafioexperian.demo.adapter.web.CriarPessoaController;

import com.desafioexperian.demo.adapter.in.response.PessoaResponse;
import com.desafioexperian.demo.adapter.in.web.BuscarPessoaPorIdController;
import com.desafioexperian.demo.application.port.in.BuscarPessoaService;
import com.desafioexperian.demo.domain.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BuscarPessoaPorIdController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BuscarPessoaPorIdControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarPessoaService buscarPessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveBuscaPessoa() throws Exception{


        PessoaResponse response = new PessoaResponse("teste",
                                                     "teste",
                                                     "teste",
                                                     "teste");

        given(buscarPessoaService.buscarPessoaPorId(anyLong())).willReturn(response);


        MvcResult result =
                mockMvc.perform(MockMvcRequestBuilders.get(
                        "/pessoa/{id}",1L)
                                     .header("Content-Type", "application/json"))
                                     .andExpect(status().isOk())
                                     .andReturn();

        then(buscarPessoaService).should().buscarPessoaPorId(anyLong());

        final String expected = objectMapper.writeValueAsString(response);

       assertThat(result.getResponse().getContentAsString()).isEqualTo(expected);

    }

}