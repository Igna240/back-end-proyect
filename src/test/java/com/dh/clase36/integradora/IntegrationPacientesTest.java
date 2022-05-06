package com.dh.clase36.integradora;

import com.dh.clase36.integradora.entities.Domicilio;
import com.dh.clase36.integradora.entities.Paciente;
import com.dh.clase36.integradora.service.DomicilioService;
import com.dh.clase36.integradora.service.PacienteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationPacientesTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;
    @Autowired
    private MockMvc mockMvc;

    public void cargarDatosEnBD(){
        //cargar un turno
        //odontologo y un paciente junto con la fecha
        domicilioService.registrarDomicilio(new Domicilio("Av aguero",842,"Crespo","Entre Rios"));
        pacienteService.guardar(new Paciente("Brezan","Ignacio","ib@gmail.com",45741, LocalDate.of(2022,04,15),domicilioService.buscar(1L).get()));
    }
    @Test
    public void listarPacientes() throws Exception {
        //cargarDatosEnBD();
        MvcResult resultado= mockMvc.perform(MockMvcRequestBuilders.get("/pacientes").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse(resultado.getResponse().getContentAsString().isEmpty());
    }
}
