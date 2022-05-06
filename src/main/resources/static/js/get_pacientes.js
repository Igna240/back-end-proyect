function consultarPacientes() {
    // const token = ...

    const settings = {
        method: 'GET'
        // headers: {
        //     authorization: token
        // }
    };

    fetch("/pacientes", settings)
      .then(response => response.json())
      .then(pacientes => {
        console.log(pacientes);
        renderizar(pacientes);
    })
    .catch(error => console.log(error));

}

const renderizar = (pacientes)=>{
    pacientes.forEach(paciente => {
        const table = document.getElementById("pacienteTable").insertRow();
        table.innerHTML += `
                        <tr>
                            <td class="td_nombre">${paciente.nombre}</td>
                            <td class="td_apellido">${paciente.apellido}</td>
                            <td class="td_email">${paciente.email}</td>
                            <td class="td_doc">${paciente.dni}</td>
                        </tr>
        `
    });
}

consultarPacientes();  // La hago correr una vez para traer los pacientes