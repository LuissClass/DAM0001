package DAM1;
import java.io.IOException;

public class mediaNumsB6 {
    Teclado t = new Teclado();
    int num;
    int media;
    int counter = -1;

    void calcularMedia() throws IOException {
        do {
            System.out.println("Escribe un numero: ");
            num = t.leerInt();
            media = num >= 0? media + num : media;
            counter++;
        } while (num >= 0);
        media = media / counter;
    }

    void mostrarMedia() {
        System.out.println(media);
    }

    public static void main(String[] args) throws IOException {
        mediaNumsB6 media1 = new mediaNumsB6();
        media1.calcularMedia();
        media1.mostrarMedia();
    }
}
