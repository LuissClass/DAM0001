package juegos.colorsToText.code;
import static juegos.colorsToText.code.Memoria.*;

public class TextToColors {
    static TextToColors ttc = new TextToColors();




    //De Texto a Color
    //TODO Documentacion
    /**
     * */

    // Esta funcion toma como parametro textAscii (String) y devuelve textDec (String)
    // Primero se inicializa textDec, porque vamos a contcatenar la respuesta ahi
    // El primer for recorre todos los caracteres de textAscii
    // El segundo for recorre por cada letra del abecedario, que estan guardados en el array abc[]
    // Entonces, por cada letra en textAscii, el if va a comparar si esta coincide con alguna del abecedario
    // Cada vez que el segundo for itera, se suma 1 a asciiCounter, que es el valor que tiene cada letra del abecedario si lo enumeramos
    // asciiCounter inicia en 65 porque en la tabla ASCII la letra "A" inicia con ese numero decimal
    // Cada vez que el primer for itera, asciiCounter se restablece a 65
    // Cada vez que se entra en el if se concatena el Integer de asciiCounter en textDec
    // Finalmente, cuando ya no hay mas caracteres en textAscii, se retorna textDec como Integer
    // textDec se restablece al inicio de la funcion porque es una variable static**/

    /**
     *
     * @param textAscii
     * @return
     */
    private String asciiToDec(String textAscii) { // TODO, cuidado cuando se le ponga de parametro algo que no sea una letra
        textDec = "";
        for (int i = 0; i < textAscii.length(); ++i) {
            for (char letter : abc) {
                if (textAscii.toUpperCase().charAt(i) == letter) {
                    textDec += asciiCounter;
                }
                ++asciiCounter;
            }
            asciiCounter = FIRST_POS;
        }
        return textDec;
    }


    // ESTO DEVUELVE UN STRING BINARIO SIN EL CERO DE 2^5, QUE EN DECIMAL (Y SIN QUE FALTE ESE CERO) ES EL NUMERO ORIGINAL RESTANDOLE 32. Y en hexa es el numero pero -2 al digito izquierdo.
    private String decToBin(String textDec) {
        numStr = "";
        textBin = "";


        for (int i = 0; i < textDec.length(); ++i) {
            numStr += textDec.charAt(i);


            if (numStr.length() == 2) {
                numInt = Integer.parseInt(numStr);
                for (int j = 0; j < binaryConversor.length; ++j) {
                    if ((tempNum + binaryConversor[j]) <= numInt) {
                        tempNum += binaryConversor[j];
                        borradorBinario += binaryCounter;
                    }
                    if (tempNum == numInt) {
                        break;
                    }
                    if (binaryCounter != 1) {
                        binaryCounter /= 10;
                    }
                }
                textBin += borradorBinario;
                borradorBinario = 0;
                tempNum = 0;
                binaryCounter = 100000;
                numStr = "";
            }
        }
        return textBin;
    }


    //Solo se le deben pasar string de multiplos de 6 chars
    private String binToHex(String textBin) {
        String binStr = "";
        int numInt = 0;
        char numChar = ' ';
        textHex = "";


        if (!(textBin.length() % 4 == 0)) {
            textBin = "00" + textBin;
        }


        for (int i = 0; i < textBin.length(); ++i) {
            binStr += textBin.charAt(i);


            if (binStr.length() == 4) {
                for (int j = 1; j < 5; ++j) {
                    if (binStr.charAt(binStr.length() - j) == '1') {
                        numInt += binaryConversor[binaryConversor.length - j];
                    }
                }
                if (numInt > 9) {
                    switch (numInt) {
                        case 10:
                            numChar = 'A';
                            break;
                        case 11:
                            numChar = 'B';
                            break;
                        case 12:
                            numChar = 'C';
                            break;
                        case 13:
                            numChar = 'D';
                            break;
                        case 14:
                            numChar = 'E';
                            break;
                        case 15:
                            numChar = 'F';
                            break;
                    }
                } else {
                    numChar = String.valueOf(numInt).charAt(0);
                }
                textHex += numChar;
                numChar = ' ';
                numInt = 0;
                binStr = "";
            }
        }
        return textHex;
    }

    private String hexToColor(String textHex) {
        colors = "";
        String hex = textHex;

        while (hex.length() % 6 != 0) {
            hex = "0" + hex;
        }


        for (int i = 0; i < hex.length(); ++i) {
            if (i == 0 || colors.length() % 7 == 0) {
                colors += "#";
            }
            colors += hex.charAt(i);
        }
        return colors;
    }

    public static void textToColor(String Text) {
        ttc.hexToColor(ttc.binToHex(ttc.decToBin(ttc.asciiToDec(Text))));
    }

    public static String getColors() {
        return colors;
    }
}


