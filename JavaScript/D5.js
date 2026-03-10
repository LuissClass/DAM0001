// 1. Seleccionamos todos los elementos que tengan la clase 'pelicula' O 'serie'
        const elementos = document.querySelectorAll('.pelicula, .serie');

        // 2. Usamos un bucle para recorrer la lista obtenida
        for (let i = 0; i < elementos.length; i++) {
            // 3. Mostramos el contenido de texto en la consola
            console.log(elementos[i]);
        }