package DAM1.Collecciones;


/*
Apdo A- Crear una clase Cola genérica con los métodos de meter, sacar y está vacía.

Apdo B- Crear una clase ColaPrioridad con genéricos que tendrá los métodos de añadir (T elemento, prioridad), T sacar() y boolean estaVacia()

Cuando se cree la cola de prioridad se indicará el número de niveles. Internamente la cola de prioridad será un array de Colas, con tantas Colas como niveles de prioridad se hayan indicado. En la Cola de prioridad se tendrá un contador para saber cuántos elementos hay en la cola de prioridad.

Apdo C- En las urgencias de un hospital se desea atender a los pacientes en función
de la prioridad que se define al llegar al hospital (en el triaje)

Se desea realizar una aplicación que permita:

Cuando llega el paciente guardar su nombre y su nivel de prioridad
Atender al paciente más urgente de los que están en espera.

Se tendrá un menú con las opciones anteriores.
*/

import java.util.Scanner;
import java.util.Stack;

public class ListaEsperaK2 {
    public static void main(String[] args) {
        String opcion;
        Scanner input = new Scanner(System.in);
        ColaPrioridad pacientes = new ColaPrioridad(3);
        String menu = "(1) Add paciente\n(2) Atender paciente\n(3) Salir";

        do {
            System.out.println(menu);
            opcion = input.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Nombre: ");
                    String name = input.nextLine();
                    System.out.println("Nivel: ");
                    String nivel = input.nextLine();
                    pacientes.add(name, Integer.parseInt(nivel) - 1);
                    break;
                case "2":
                    pacientes.atender();
                    break;
                case "3":
                    System.out.println("Adios");
                    break;
            }
        } while (!opcion.equals("3"));
    }
}

class Cola <T>{
    Stack<T> cola = new Stack<>();

    void add(T o) {
        cola.push(o);
    }

    T remove() {
        return cola.remove(0);
    }

    boolean isEmpty() {
        return cola.isEmpty();
    }
}

class ColaPrioridad <T> {
    int niveles;
    Cola[] colaPrioridad;
    int cont = 0;

    ColaPrioridad(int niveles) {
        this.niveles = niveles;
        colaPrioridad = new Cola[niveles];
        for (int i = 0; i < niveles; i++) {
            colaPrioridad[i] = new Cola();
        }
    }

    void add(T elemento, int prioridad) {
        colaPrioridad[prioridad].add(elemento);
        cont++;
    }

    T atender() {
        T obj = null;

        for (Cola nivel: colaPrioridad) {
            if (!nivel.isEmpty()) {
                obj = (T) nivel.remove();
                break;
            }
        }

        if (obj != null) {
            System.out.println("El siguiente en ser atendido es " + obj);
        } else {
            System.out.println("No hay pacientes");
        }
        return obj;
    }
}
