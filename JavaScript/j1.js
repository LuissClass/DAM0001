function bienvenido(name) {
    let x = "alo"
    x = x+1
    console.log(x)

    const y = "Soy const. Senior " + name 

    console.log(y)

    // No se recomienda definir variables automaticamente
    e = "eeee"
    E = "Khek heh heh heh"

    console.log("'" + e + "' es hermano de '" + E + "'")

    
    return 0;
}

// Llamando a una funcion (sin tilde)
console.log(">>Retorna " + bienvenido(" Highler"))

{
    // Aislados y agrupados
    let a = "Soy A", b = "Soy B", c = "Soy c";
    // Pero este no, es universal
    var khek = "Khek heh heh heh heehk"
}

console.log(khek)

let p = "Papirus"

{
    let p = "Sans"
    console.log(p)
}

console.log(p)

//Arrays
console.log("\nY ahora arrays: ")
const cars =  ["Saab", "Volvo", "BMW"];
cars[0] = "Toyota"
cars.push("Audi")
console.log(cars)

// Un dict
const car = {type:"Fiat", model:"500", color:"white"};
console.log(car)

// Esto es posible: 
let xxx = 888
{
    const x = 777

    // Esto no es posible: const x = 666
}

console.log("\n\nAhora condicionales")
function edadAdecuada(edad) {
    let text = "Nada"
    if (edad < 18) {
        text = "Muy menor"
    } else { 
        text = "Demasiado mayor"
    }
    console.log(text)
}
edadAdecuada(22)