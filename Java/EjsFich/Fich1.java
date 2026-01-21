package DAM1.EjsFich;

import java.io.File;
import java.io.IOException;

public class Fich1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f1 = new File("E.puml");
        imprimirCaracteristicas(f1);

        System.out.println();
        File fileSafe = new File("DAM1\\Rec"+File.separator+"R1.java");

        imprimirCaracteristicas(fileSafe);

        File f2 = new File("DAM1\\Rec"+File.separator+"algo1");


        System.out.println();

        if (f2.exists()) {
            System.out.println();
            System.out.println("ELIMINANDO FICHERO algo1");
            f2.delete();
        } else {
            System.out.println("CREANDO FICHERO algo1");
            try {
                f2.createNewFile();
            } catch (IOException ioe) {
                System.out.println("Error al crear fich. ERROR: " + ioe);
            }
        }

        if (false) {
            acariciarUnDir("D:\\USERS_NO_BORRAR\\levg51\\Desktop\\UwU");
        }
    }

    static void imprimirCaracteristicas(File file) {
        System.out.println("Existe fileSafe? " + file.exists() + "\nPath absoluto: " + file.getAbsolutePath()
                + "\nNombre: " + file.getName()
                + "\nSize: " + file.length());
    }


    static void acariciarUnDir(String rutaBase) throws IOException {
        int i = 0;

        while (true) {
            File f = new File(rutaBase + "\\uwu" + i);
            f.createNewFile();
            i++;
        }
    }
}
