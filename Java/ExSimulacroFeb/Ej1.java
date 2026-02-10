package ExSimulacroFeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) throws IOException {
        Ej1 e = new Ej1();

        String[] a = e.leerFich(new File("src\\ExSimulacroFeb\\productos.txt"));
        e.verificarProds(a);
    }


    String[] leerFich(File fich) throws IOException {
        String s;
        String[] allFich = new String[1000];
        int cont = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fich))) {
            while (br.ready()) {
                s = br.readLine();
                allFich[cont] = s;
                cont++;
            }
        }
        System.out.println(">>FIN");

        String[] res = new String[cont];

        for (int i = 0; i < cont; i++) {
            res[i] = allFich[i];
        }

        return res;
    }

    void verificarProds(String[] prods) {
        String[] prodAcual;
        boolean ErrA;
        boolean ErrB;
        String msg;
        double precioMedio = 0;
        int preciosValidos = 0;

        for (int i = 0; i < prods.length; i++) {
            prodAcual = prods[i].split(";");
            msg = "";
            ErrA = false;
            ErrB = false;
            preciosValidos = 0;
            precioMedio = 0;


            if (prodAcual.length > 1) {
                ErrA = true;

                for (int j = 1; j < prodAcual.length; j++) {
                    try {
                        precioMedio +=  Double.parseDouble(prodAcual[j]);
                        preciosValidos++;
                        ErrA = false;
                    } catch (NumberFormatException e) {
                        ErrB = true;
                    }
                }
            } else {
                ErrA = true;
            }

            try {
                Integer.parseInt(prodAcual[0]);
            } catch (NumberFormatException nfe) {
                ErrB = true;
            }

            if (ErrA || ErrB) {
                msg = "linea " + (i+1) + ":Error ";

                if (ErrA) {
                    msg += "A";
                }

                if (ErrB) {
                    msg += "B";
                }

                msg += " -> " + prods[i];
            }

            if (ErrA && ErrB) {
                msg = "linea " + (i+1) + ":Error B Error A ->" + prods[i];
            }

            if (!ErrA && !ErrB) {
                msg += "Producto: " + prodAcual[0] + " " + precioMedio/preciosValidos;
            }

            System.out.println(msg);
        }
    }
}
