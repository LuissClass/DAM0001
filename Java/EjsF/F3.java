package damClase.EjsF;

public class F3 {
    public static void main(String[] args) {
        F3 f3 = new F3();
        System.out.println(f3.buscarStr2EnStr1("Penelope Penderson", "en"));
    }

    int buscarStr2EnStr1(String str1, String str2) {
        int contadorDeApariciones = 0;
        int indexAnterior = 0;

        while(str1.indexOf(str2, indexAnterior) >= 0) {
            indexAnterior = str1.indexOf(str2, indexAnterior) + 1;
            contadorDeApariciones++;
        }
        return contadorDeApariciones;
    }
}
