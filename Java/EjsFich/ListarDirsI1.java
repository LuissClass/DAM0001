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
        long totalSize = contenidoDir(d1, null, 0);
        System.out.println("\n>>>Tamaño verificado: " + realSize + " - Tamaño calculado: " + totalSize + " Bytes");
    }

    static public int realSize = 0;

    static long contenidoDir(File dir, File[] rDirs, long totalSize) {
        System.out.println("\n./" + dir.getName() + ":");
        String[] list = dir.list();
        File file;
        String tab = "\t";
        int cols = 0;
        String ficheros = "";

        File[] dirs;
        int dirs_cont = 0;

        for (int i = 0; i < list.length; i++) {
            file = new File(dir + "\\" +  list[i]);

                if (cols >= 2) {
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

                    dirs_cont++;
                } else { ficheros += "' ";}

                cols++;
                totalSize += file.length();
                realSize += file.length();
                ficheros += " (" + file.length() + "B) ";
        }
        System.out.println(ficheros);

        dirs = new File[dirs_cont];

        int pos = 0;
        for (int i = 0; i < list.length; i++) {
            file = new File(dir + "\\" +  list[i]);

            if (file.isDirectory()) {
                dirs[pos] = file;
                pos++;
            }
        }
        if (dirs.length >= 1) {
            for (int i = 0; i < dirs.length; i++) {
                totalSize = contenidoDir(dirs[i], dirs, totalSize);
            }
        }

        return totalSize;
    }
}
