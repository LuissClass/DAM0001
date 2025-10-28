package DAM1;

public class ActividadB5 {
    private int suma(int num1, int num2) {
        int suma = 0;
        boolean esPositivo = true;
        int numeroMayor = num1 > num2 ? num1 : num2;
        int numeroMenor = num1 < num2 ? num1 : num2;
        int counter = numeroMenor + 1;

        if (counter < 0) {
            esPositivo = false;
        }

        while (counter > numeroMenor && counter < numeroMayor) {
            if (counter % 5 == 0 && counter % 10 != 0) {
                suma += counter;
            } else {
                if (esPositivo) {
                    if ((counter - 3) % 10 == 0) {
                        suma += counter;
                    }
                } else {
                    if ((counter + 3) % 10 == 0) {
                        suma += counter;
                    }
                }
            }
            ++counter;
        }
        return suma;
    }

    public static void main(String[] args) {
        ActividadB5 obj = new ActividadB5();
        System.out.println(obj.suma(13, 28));
    }

}
