package DAM1;

public class CuadadoTrianguloB13 {

    void crearCuadrado(int n) {
        String linea = "";
        for (int i = 1; i < n + 1; i++) {
            linea += i + " ";
        }
        for (int i = 0; i < n; i++) {
            System.out.println(linea);
        }
    }

    void crearTriangulo(int n) {
        String linea = "";
        String espacios = "*";
        String numeros = "";
        int nAux = n - 1;

        for (int i = 1; i < n + 1; i++) {
            numeros += i;
            espacios = "";
            for (int j = nAux; j > 0; j--) {
                espacios += "*";
            }
            linea = (espacios + numeros);
            nAux--;
            System.out.println(linea);
        }
    }

    public static void main(String[] args) {
        CuadadoTrianguloB13 ct1 = new CuadadoTrianguloB13();
        System.out.println("-CUADRADO-");
        ct1.crearCuadrado(4);
        System.out.println("-TRIANGULO-");
        ct1.crearTriangulo(4);

    }
}
