package DAM1.EjsFich;

import java.io.*;
import java.util.SortedMap;

public class Fich2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ruta = "D:\\USERS_NO_BORRAR\\levg51\\Desktop\\UwU\\hola11.txt";
        File fich = new File(ruta);

        Fich2 f2 = new Fich2();

        f2.leerFich(ruta);
    }

    void leerFich(String fich) throws IOException, InterruptedException {
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader(fich))) {
            while (br.ready()) {
                s = br.readLine();
                Thread.sleep(300);
                System.out.println(s);
            }
        }
        System.out.println(">>FIN");
    }
}
