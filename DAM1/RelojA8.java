/* 
Crea una clase Hora que tenga como atributos la hora, el minuto y el segundo.
Añade un constructor que reciba como parámetros los 3 atributos.
Crea un método mostrar que imprima en pantalla la hora con el formato del siguiente ejemplo 15:32:2
Añade un método incrementarSegundo que añada un segundo al objeto hora (el recibido en this) teniendo en cuenta que los minutos tienen 60 segundos y las horas tienen 60 minutos. Después de las 23:59:29 la hora será la 0:0:0
Realiza una clase Reloj que tenga como atributo un objeto de tipo hora.
Codifica, en la clase Reloj, un método main que cree una hora, muestre en pantalla la misma, invoque al método incrementarSegundo y después vuelva a mostrar la hora. Haz la prueba con diferentes valores para comprobar que el método incrementarSegundo funciona adecuadamente.
Utiliza el operador ternario ( condición? valortrue:valorfalse )
No utilices la case Date ni ninguna similar. */


public class RelojA8 {
    public static void main(String[] args) {
        Hora hora1 = new Hora(23, 59, 57);
        hora1.mostrarHoraConFormato();
        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();
    }
}


class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    void mostrarHoraConFormato() {
        System.out.println(horas + ":" + minutos + ":" + segundos);
    }

    void incrementarSegundo() {
        boolean pasoSeg;
        boolean pasoMin;

        pasoSeg = segundos == 59;
        segundos = pasoSeg? 0 : segundos+1;

        minutos = pasoSeg? minutos+1 : minutos;
        pasoMin = minutos == 60;
        minutos = pasoSeg && pasoMin? 0 : minutos;

        horas = pasoMin? horas+1 : horas;
        horas = horas == 24? 0 : horas;
    }
}






