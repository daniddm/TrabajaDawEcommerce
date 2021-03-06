 $(document).ready(function(){
	 var perfilUsuario = $('#perfilUsuario').val();
	 if (perfilUsuario === ''){
		 $('#menuAdmin').css('display', 'none');
		 $('#menuCarrito').css('display', 'none'); 
	 }
	 if(perfilUsuario !== '' && perfilUsuario !== '1'){
		 $('#menuAdmin').css('display', 'none'); 
	 }
	 if(perfilUsuario !== '' && perfilUsuario !== '2'){
		 $('#menuCarrito').css('display', 'none'); 
	 }
	
 });
 
//la constante para empezar con la libreria murii en la que pillamos las clases grid, y manejat transiciones, permitiendo el filtro 
const grid = new Muuri('.grid', {
  layout: {//añadimos la option que necesitamos, que acomoda elementos
    rounding: false
  }//como queremos que mida los elementos
});

//CUANOD LA PAGINA CARGA CARGAMOS TODAS LAS FOTOS
window.addEventListener('load', () => {
  grid.refreshItems().layout();//refrescamos layout para adaptar imagenes y añadimos una clase imagenes-cargadas
  document.getElementById('grid').classList.add('imagenes-cargadas');

  //se agrega lisener para filtrar por categoria
  const enlaces = document.querySelectorAll('#categorias a');//pillamos la etiqueta de los enlaces y lo metemos en una contante
  enlaces.forEach( (elemento) => {//añadimos a los enlaces un eventlisener
    elemento.addEventListener('click', (evento) => {//introducimos el evento de click en los enlaces
      evento.preventDefault();//evitamos comportamiento por defecto del navegador
      enlaces.forEach((enlace) => enlace.classList.remove('activo'));//borramos la clase activo
      evento.target.classList.add('activo');//añdimos clase activo al enlace que damos click
     
      const categoria = evento.target.innerHTML;//añadimos varible categoria y guardamos el texto html que clicamos y lo transformamos a minuscula
      categoria === 'Todos' ? grid.filter('[data-categoria]') : grid.filter(`[data-categoria="${categoria}"]`);//if else en js
      //grid.filter es un elemento de la libreria que permite filtrar todos los elementos de una categoria
    });

  });
  //agregamos lisener para barra de busqueda
 
  document.querySelector('#barra-buscar').addEventListener('input', (evento) => {//accedemos a la barra de busqueda y le añadimos el evento
    const busqueda = evento.target.value;//cada vez que escribimos obtenemos el valor de lo que se escribe
    grid.filter((item) => item.getElement().dataset.etiquetas.includes(busqueda));//hacemos el filtrado accediendo a cada item y accedemos a dataset (cada elemento data)y accedemos al data etiqueta
  });//cada una de las imagenes accede a la imagen y al dataset y le incluimos la busqueda
});

