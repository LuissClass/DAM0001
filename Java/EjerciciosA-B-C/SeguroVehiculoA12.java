/*
Se tiene una clase Vehículo que tiene como atributos, la matrícula, el número de kilómetros recorridos y el propietario (una Persona), y una clase Persona, que tiene como atributos el nombre y la edad.
En la clase Seguro se almacena como atributo, un vehículo y el coste del seguro.
Realizar un metodo, en la clase Seguro, que muestre por pantalla la matrícula del vehículo, sus km y la edad del propietario
Realizar un metodo que subirPorKm() que suba el coste del seguro un 10% si el vehículo tiene más de 150.000 km y un 12% si tiene más de 200.000km
Realizar un metodo que subirPorEdad() que suba el coste del seguro un 15% si la persona asociada al vehículo tiene menos de 23 años y un 5% si tiene más de 65 años.
Realizar un programa principal que pruebe el uso de los métodos anteriores, creando, al menos 3 seguros. */

public class SeguroVehiculoA12 {
    VehiculoA12 vehiculo;
    double coste;

    public SeguroVehiculoA12(VehiculoA12 vehiculo, double coste) {
        this.vehiculo = vehiculo;
        this.coste = coste;
    }

    void imprimirDatosVehiculo() {
        System.out.println(vehiculo);
    }

    void subirPorKm() {
        coste = vehiculo.getKilometros() >= 200000? (coste + coste*0.12): coste;
        coste = vehiculo.getKilometros() >= 150000? (coste + coste*0.1): coste;
    }

    void subirPorEdad() {
        coste = vehiculo.getPropietario().getEdad() < 23? (coste + coste*0.15): coste;
        coste = vehiculo.getKilometros() > 65? (coste + coste*0.05): coste;
    }

    public double getCoste() {
        return coste;
    }

    public static void main(String[] args) {
        VehiculoA12 v1 = new VehiculoA12("WALTUH", 160000, new PersonaA12("Mike Waso", 1024));
        SeguroVehiculoA12 s1 = new SeguroVehiculoA12(v1, 100);
        s1.imprimirDatosVehiculo();
        s1.subirPorKm();
        System.out.println(s1.getCoste());
        s1.subirPorEdad();
        System.out.println(s1.getCoste());

        //TODO 2 seguros mas
    }
}

class VehiculoA12 {
    String matricula;
    int kilometros;
    PersonaA12 propietario;

    public VehiculoA12(String matricula, int kilometros, PersonaA12 propietario) {
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.propietario = propietario;
    }

    public int getKilometros() {
        return kilometros;
    }

    public PersonaA12 getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\nKilometros: " + kilometros + "\nEdad propietario: " + propietario.getEdad();
    }
}

class PersonaA12{
    String nombre;
    int edad;

    public PersonaA12(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}
