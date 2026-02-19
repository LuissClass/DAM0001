package DAM1.Collecciones;

import java.util.Vector;

public class LLavesK1 {
    public static void main(String[] args) {
        String[] expresiones = {
                "(5+(3-6) - 5",
                "(5+(3*6+(5-array[2]) + 2 ) -5 )",
                "( 5 - (3 + a[5+2 )] )"
        };

        verificarExpresiones(expresiones[1]);
    }

    static void verificarExpresiones(String expresion) {
        Vector<String> expVerificada = new Vector<>();
        char[] exp = expresion.toCharArray();

        for (int i = 0; i < expresion.length(); i++) {
            if (!String.valueOf(exp[i]).equals(" ")) {
                expVerificada.add(String.valueOf(exp[i]));
            }
        }

        if (hayLlavesEquivalentes(expVerificada) && todasLasLLavesCoinciden(expVerificada)) {
            System.out.println("TODO CORRECTO");
        } else {
            System.out.println("ESTÁ MAL");
        }
    }

    static boolean hayLlavesEquivalentes(Vector<String> exp) {
        boolean res;
        int numLlavesA = 0;
        int numLlavesC = 0;

        for (String c : exp) {
            if (c.equals("(") || c.equals("[")) {
                numLlavesA++;
            } else if (c.equals(")") || c.equals("]")) {
                numLlavesC++;
            }
        }

        res = numLlavesA == numLlavesC;

        return res;
    }

    static boolean todasLasLLavesCoinciden(Vector<String> exp) {
        boolean res = true;
        Vector<Integer> posLlavesA = new Vector<>();
        Vector<Integer> posLlavesC = new Vector<>();

        for (int i = 0; i < exp.size(); i++) {
            String c = exp.get(i);

            if (c.equals("(") || c.equals("[")) {
                posLlavesA.add(i);
            } else if (c.equals(")") || c.equals("]")) {
                posLlavesC.add(i);
            }
        }

        int posC;
        int difAC;
        boolean llaveTieneCierre;

        for (int i = posLlavesA.size() - 1; i >= 0; i--) {
            difAC = -100000; // Un numero muy bajo
            posC = 0;
            llaveTieneCierre = false;

            for (int j = 0; j < posLlavesC.size(); j++) {
                if (posLlavesA.get(i) - posLlavesC.get(j) < 0 && posLlavesA.get(i) - posLlavesC.get(j) > difAC) {
                    difAC = posLlavesA.get(i) - posLlavesC.get(j);
                    if (sonLlavesAdecuadas(exp.get(posLlavesA.get(i)), exp.get(posLlavesC.get(j)))) {
                        posC = j;
                        llaveTieneCierre = true;
                    }
                }
            }

            if (!llaveTieneCierre) {
                res = false;
                break;
            } else {
                posLlavesC.remove(posC);
            }
        }

        return res;
    }

    static boolean sonLlavesAdecuadas(String apertura, String cierre) {
        boolean res = false;

        if (apertura.equals("(") && cierre.equals(")")) {
            res = true;
        } else if (apertura.equals("[") && cierre.equals("]")) {
            res = true;
        }

        return res;
    }
}
