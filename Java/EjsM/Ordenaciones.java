package DAM1.EjsM;

public class Ordenaciones {
    public static void main(String[] args) {
        int[] arr = {3,6,9,1,5,556, -6};
        Ordenaciones o1 = new Ordenaciones();
        o1.mostrarArr(arr);
        System.out.println();
        o1.ordenarBuscarMinimo(arr);
    }


    void ordenarBuscarMinimo(int[] v) {
        int numMenor;
        int posNumMenor = 0;
        int numAux;

        for (int j = 0; j < v.length - 1; j++) {
            System.out.println("Vuelta j: " + j);
            mostrarArr(v);

            numMenor = v[j];
            posNumMenor = j;

            //Buscar numMenor
            for (int i = j; i < v.length; i++) {
                if (numMenor > v[i]) {
                    numMenor = v[i];
                    posNumMenor = i;
                }
            }

            //Colocar numMenor
            numAux = v[j];
            v[j] = numMenor;
            v[posNumMenor] = numAux;
        }
        System.out.println("\nRESPUESTA:");
        mostrarArr(v);
    }

    void mostrarArr(int[] v) {
        String res = "ArrayStr -> [";
        for (int i = 0; i < v.length; i++) {
            if (i==v.length-1) {
                res += v[i] + "]";
            } else {
                res += v[i] + ",";
            }
        }
        System.out.println(res);
    }
}
