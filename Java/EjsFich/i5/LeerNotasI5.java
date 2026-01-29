package DAM1.EjsFich.i5;

import java.io.*;
import java.util.Scanner;

public class LeerNotasI5 {
    int numAlumnos;
    int[][] notas;
    String[] nombresAlumnos;

    public static void main(String[] args) throws IOException, InterruptedException {
        LeerNotasI5 lni5 = new LeerNotasI5();

        lni5.mostrarAlumnoConMejorNotaMedia();
        lni5.escribirNotas(new File("DAM1\\EjsFich\\i5\\notasAlumnos.csv"));
    }

    void mostrarAlumnoConMejorNotaMedia() throws IOException {
        leerFich("DAM1\\EjsFich\\i5\\notasMediasAlumnos.txt");

        mostrarAlumno(calcularAlumnoConMejorNotaMedia());
    }

    void guardarNumAlumnos(int n) {
        numAlumnos = n;
        notas = new int[n][];
        nombresAlumnos = new String[n];
    }

    void mostrarAlumno(int alumno) {
        System.out.println(nombresAlumnos[alumno] + " tiene la nota media más alta: " + calcuarNotaMedia(alumno)+"");
    }

    double calcuarNotaMedia(int alumno) {
        double notaMediaAlumno = 0.0;

        for (int i = 0; i < notas[alumno].length; i++) {
            notaMediaAlumno += notas[alumno][i];
        }

        notaMediaAlumno /= notas[alumno].length;

        return notaMediaAlumno;
    }

    int calcularAlumnoConMejorNotaMedia() {
        int res = -1;
        double mejorNotaMedia = 0;

        for (int i = 0; i < numAlumnos; i++) {
            if (calcuarNotaMedia(i) > mejorNotaMedia) {
                mejorNotaMedia = calcuarNotaMedia(i);
                res = i;
            }
        }
        return res;
    }

    void leerFich(String fich) throws IOException {
        String s;
        int contLinea = 0;
        String[] lineas = new String[100];

        try (BufferedReader br = new BufferedReader(new FileReader(fich))) {
            while (br.ready()) {
                s = br.readLine();
                lineas[contLinea] = s;
                contLinea++;
            }
        }

        guardarNumAlumnos(contLinea-1);

        for (int i = 1; i < contLinea; i++) {
            String[] linea = lineas[i].split(";");
            int[] notaActual = new int[linea.length-1];

            nombresAlumnos[i-1] = linea[0];

            for (int j = 1; j < linea.length; j++) {
                notaActual[j-1] = Integer.valueOf(linea[j]);
            }
            notas[i-1] = notaActual;
        }
    }

    void escribirNotas(File f) throws IOException {
        int cont = 0;

        f.createNewFile();

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

        for (int i = 0; i < numAlumnos; i++) {
            bw.write(nombresAlumnos[i]+":"+calcuarNotaMedia(i));
            bw.newLine();
            cont++;
        }

        bw.flush();
        bw.close();

        System.out.println(">>Numeros escritos: " + cont);
    }
}
