package DAM1.EjsF;

import java.util.StringTokenizer;

public class MediaDatosF5 {
    void calcularMedia(String datos) {
        int nota;
        int notaMedia = 0;
        StringTokenizer datosSeparados = new StringTokenizer(datos, ":");
        int totalNotas = datosSeparados.countTokens()/2;

        while (datosSeparados.hasMoreTokens()) {
            datosSeparados.nextToken();
            nota = Integer.valueOf(datosSeparados.nextToken());
            notaMedia += nota;
        }
        notaMedia /= totalNotas;
        System.out.println("Media: " + notaMedia);
    }

    public static void main(String[] args) {
        MediaDatosF5 mdf5 = new MediaDatosF5();
        String ejemplo = "Juan:7:Ana Maria:8:Pedro:9"; // Debe quedar nombreAlumno1:Nota:NombreAlumno2:Nota...

        mdf5.calcularMedia(ejemplo);
    }
}
