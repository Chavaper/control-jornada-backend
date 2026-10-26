package cl.bennu.controljornadabackend;

import cl.bennu.controljornadabackend.controller.CountryController;
import cl.bennu.controljornadabackend.controller.base.RecursoNoEncontradoException;
import cl.bennu.controljornadabackend.model.Country;
import cl.bennu.controljornadabackend.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CountryService countryService;

    @Test
    void buscarPorId_CuandoExiste_DebeRetornar200() throws Exception {
        // Arrange: simular un country existente
        Country country = new Country();
        country.setId(1);
        country.setName("Chile");
        country.setNationality("Chilena");

        when(countryService.findById(country.getId())).thenReturn(country);

        mockMvc.perform(get("/api/country/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Chile"))
                .andExpect(jsonPath("$.nationality").value("Chilena"));
    }

    @Test
    void buscarPorId_CuandoNoExiste_DebeRetornar404() throws Exception {
        // Arrange: simular que no existe el empleado
        when(countryService.findById(999))
                .thenThrow(new RecursoNoEncontradoException("Country with id 999 not found"));

        // Act + Assert: comprobar que la respuesta sea 404
        mockMvc.perform(get("/api/country/999"))
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    Exception excepcion = result.getResolvedException();
                    System.out.println("Excepción: " + excepcion);
                    System.out.println("Mensaje: " + excepcion.getMessage());

                    assertThat(result.getResolvedException())
                            .isInstanceOf(RecursoNoEncontradoException.class)
                            .hasMessage("Country with id 999 not found");
                });
    }

}