function consultarTurnos() {
    // const token = ...

    const settings = {
        method: 'GET'
        // headers: {
        //     authorization: token
        // }
    };

    fetch("/turnos", settings)
      .then(response => response.json())
      .then(pacientes => {
        console.log(pacientes);
        renderizar(pacientes);
    })
    .catch(error => console.log(error));

}

const renderizar = (turnos)=>{
    turnos.forEach(turno => {
        const table = document.getElementById("turnosTable").insertRow();
        table.innerHTML += `
                        <tr>
                            <td class="td_paciente">${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                            <td class="td_odontologo">${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                            <td class="td_fecha">${turno.fecha}</td>
                        </tr>
        `
    });
}

consultarTurnos();  // La hago correr una vez para traer los pacientes