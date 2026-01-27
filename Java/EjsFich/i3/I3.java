package DAM1.EjsFich.i3;

    import java.io.File;
import java.io.IOException;

public class I3 {
    final static String rutaBase = "DAM1\\EjsFich\\i3\\";

    public static void main(String[] args) {
        I3 i3 = new I3();

        File origen = new File(rutaBase+"\\origen\\");
        File copia = new File(rutaBase+"\\copia\\");

        i3.crearDir(origen);
        i3.crearDir(copia);

        File f1 = new File(rutaBase+"origen\\f1");
        File f2 = new File(rutaBase+"origen\\f2");

        i3.crearFich(f1);
        i3.crearFich(f2);

        i3.moverFichToRuta(f1, rutaBase + copia.getName());
        i3.moverFichToRuta(f2, rutaBase + copia.getName());
    }

    void crearDir(File f) {
        System.out.println(f.getName() + " CREADO");
        f.mkdir();
    }

    void crearFich(File f) {
        try {
            System.out.println("Fichero '" + f.getName() + "' CREADO");
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void moverFichToRuta(File f, String nuevaRuta) {
        f.renameTo(new File(nuevaRuta + "\\" +  f.getName()));
        System.out.println("Fichero '" + f.getName() + "' movido a " + nuevaRuta);
    }
}
