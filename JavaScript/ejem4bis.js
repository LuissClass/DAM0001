//ejecutar con node nomfich.js en la pestaña Terminal de VSC
//Importamos el módulo readline
const readline = require('readline');
//Creamos una instancia de readline.Interface que se encargará de leer la entrada del usuario y escribir la salida
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
//muestra la pregunta al usuario en la consola y espera una respuesta. Cuando el usuario presiona Enter, se ejecuta la función de callback que recibe la respuesta como argumento.
rl.question('¿Cuál es tu nombre?(introducelo aunque aparezca fin)', (nombre) => {
  console.log(`Hola, ${nombre}!`); 
  //Cerramos la interfaz para que el programa termine
  rl.close();
});
//La llamada r1.question es asíncrona así que el programa sigue ejecutando sin esperar la respuesta del usuario. Solución: recursividad, cerrar la interfaz en la función de callback, promesas,...
console.log("\nFin del programa");










