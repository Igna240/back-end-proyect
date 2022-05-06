package com.dh.clase36.integradora;

import com.dh.clase36.integradora.entities.Domicilio;
import com.dh.clase36.integradora.entities.Odontologo;
import com.dh.clase36.integradora.entities.Paciente;
import com.dh.clase36.integradora.entities.Turno;
import com.dh.clase36.integradora.service.DomicilioService;
import com.dh.clase36.integradora.service.OdontologoService;
import com.dh.clase36.integradora.service.PacienteService;
import com.dh.clase36.integradora.service.TurnoService;
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
public class IntegracionTurnosTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    @Autowired
    private MockMvc mockMvc;

    public void cargarDatosEnBD(){
        //cargar un turno
        //odontologo y un paciente junto con la fecha

        domicilioService.registrarDomicilio(new Domicilio("av dd",233,"er","er"));
        pacienteService.guardar(new Paciente("hernand","nacho","nb@gmail.com",2456,LocalDate.of(2022,04,15),domicilioService.buscar(1L).get()));
        odontologoService.registrarOdontologo(new Odontologo("carlos","hermandez",45376));
        turnoService.registrarTurno(new Turno(pacienteService.buscar(1L).get(),odontologoService.buscar(1L).get(), LocalDate.of(2022,04,01)));
    }
    @Test
    public void listarTodos() throws Exception {
        MvcResult resultado=mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse(resultado.getResponse().getContentAsString().isEmpty());
    }
}
