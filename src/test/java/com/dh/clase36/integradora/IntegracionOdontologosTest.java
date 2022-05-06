package com.dh.clase36.integradora;

import com.dh.clase36.integradora.entities.Odontologo;
import com.dh.clase36.integradora.service.OdontologoService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionOdontologosTest {
    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private MockMvc mockMvc;

    public void cargarDatosEnBD(){
        //cargar un odontologo
        odontologoService.registrarOdontologo(new Odontologo("Nacho","Brezan",52410));
    }
    @Test
    public void listarOdontologos() throws Exception {
        //cargarDatosEnBD();
        MvcResult resultado= mockMvc.perform(MockMvcRequestBuilders.get("/odontologos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse(resultado.getResponse().getContentAsString().isEmpty());
    }

}
