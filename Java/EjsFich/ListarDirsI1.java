package DAM1.EjsFich;

import java.io.File;

public class ListarDirsI1 {
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITA = "\u001B[1m";

    // Colores básicos
    public static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println();
        String pathName = "D:\\USERS_NO_BORRAR\\levg51\\Desktop\\UwU";
        File d1 = new File(pathName);
        contenidoDir(d1, 1);
    }

    static void contenidoDir(File dir, int profundidad) {
        System.out.println("EJECUCION. Dir:" + dir.getName() + " - Profundidad: " + profundidad);
        String[] list = dir.list();
        File file;
        String tab = "\t";
        int cols = 0;
        String ficheros = "";

        for (int i = 0; i < list.length; i++) {
            file = new File(dir + "\\" +  list[i]);

                if (cols >= 5) {
                    cols = 0;
                    ficheros += "\n";
                }
                if (file.isFile()) {
                    ficheros += "'";
                }

                if (file.isDirectory()) {
                    ficheros += AZUL + NEGRITA;
                }

                ficheros += file.getName();

                if (file.isDirectory()) {
                    ficheros += RESET;
                }

                if (file.isDirectory()) {
                    ficheros += "/ ";
                } else { ficheros += "' ";}

                cols++;
        }

        System.out.println(ficheros);
    }
}
