package damClase.EjsFich.i2;

import java.io.File;
import java.io.IOException;


public class I2 {
    public static void main(String[] args) {
        I2 o = new I2();
        String ruta = "src\\damClase\\EjsFich\\i2\\";
        o.crearFicheros(ruta);
    }

    void crearFicheros(String ruta) {
        File dir1 = new File(ruta+"dir1");
        File f1 = new File(ruta+dir1.getName()+"\\f1.txt");
        File f2 = new File(ruta+dir1.getName()+"\\f2.txt");
        File dir2 = new File(ruta+dir1.getName()+"\\dir2");
        File f1a = new File(ruta+dir1.getName()+"\\"+dir2.getName()+"\\f1a.txt");
        File f2a = new File(ruta+dir1.getName()+"\\"+dir2.getName()+"\\f2a.txt");

        if (!dir1.exists()) {
            System.out.println("Creando dir " + dir1.getName());
            dir1.mkdir();

            System.out.println("Creando ficheros");
            try {
                f1.createNewFile();
                f2.createNewFile();
            } catch (IOException e) {
                System.out.println("Error");
            }

            System.out.println("Creando dir " + dir2.getName());
            dir2.mkdir();

            System.out.println("Creando ficheros en dir2");
            try {
                f1a.createNewFile();
                f2a.createNewFile();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }

    }


}
