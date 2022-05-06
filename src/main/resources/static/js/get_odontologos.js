function consultarOdontologos() {
  // const token = ...

  const settings = {
      method: 'GET'
      // headers: {
      //     authorization: token
      // }
  };

  fetch("/odontologos", settings)
    .then(response => response.json())
    .then(odontologos => {
      console.log(odontologos);
      renderizar(odontologos);
  })
  .catch(error => console.log(error));

}

const renderizar = (odontologos)=>{
  odontologos.forEach(odontologo => {
      const table = document.getElementById("odontologoTable").insertRow();
      table.innerHTML += `
                      <tr>
                          <td class="td_nombre">${odontologo.nombre}</td>
                          <td class="td_apellido">${odontologo.apellido}</td>
                      </tr>
      `
  });
}

consultarOdontologos();  // La hago correr una vez para traer los odontologos