package juegos.colorsToText.code;

import static juegos.colorsToText.code.Memoria.*;
import static juegos.colorsToText.code.Memoria.textBin;

public class ColorsToText {
    static ColorsToText ctt = new ColorsToText();

    // De Color a Texto

    public void setColors(String colors) {
        Memoria.colors = colors;
    }

    private String colorToHex(String colors) {
        textHex = "";
        String hex = "";
        setColors(colors);

        for (int i = 0; i < colors.length(); ++i) {
            if (!(colors.charAt(i) == '#')) {
                hex += colors.charAt(i);
            }
        }

        for (int i = 0; i < hex.length(); ++i) { //TODO esto es super innecesario, es repetir el for anterior
            if (!(hex.charAt(i) == '0' && i < 6)) {
                textHex += hex.charAt(i);
            }
        }
        return textHex;
    }


    private String hexToBinary(String textHex) {
        textBin = "";
        numInt = 0;
        numStr = "";

        // 1)  Concatenamos i para cada char

        for (int i = 0; i < textHex.length(); ++i) {
            // 1.1) Convertir los chars a numeros
            switch (textHex.charAt(i)) {
                case 'A':
                    numInt = 10;
                    break;
                case 'B':
                    numInt = 11;
                    break;
                case 'C':
                    numInt = 12;
                    break;
                case 'D':
                    numInt = 13;
                    break;
                case 'E':
                    numInt = 14;
                    break;
                case 'F':
                    numInt = 15;
                    break;
                default:
                    try {
                        numInt = Integer.parseInt(String.valueOf(textHex.charAt(i)));
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("ERROR: El caracter \"" + textHex.charAt(i) + "\" no equivale a un valor en hexadecimal. DETALLES: " + nfe);
                        textAscii = null;
                    }
            }
            // 2) Para cada char concatenar otro for para los 4 ultimos elementos del binaryConversor
            for (int j = 0; j < binaryConversor.length; ++j) {
                // 3) ir sumando tempNum hasta que sea igual a num
                if ((tempNum + binaryConversor[j]) <= numInt) {
                    tempNum += binaryConversor[j];
                    // 4) Al mismo tiempo que el paso 3: Cada vez que se haga la suma, se ha de sumar binaryCounter a borradorBinario, sino, dividir binaryCounter
                    borradorBinario += binaryCounter;
                }

                numStr = String.valueOf(borradorBinario);
                if (tempNum == numInt && i != 0) {
                    while (numStr.length() < 4) {
                        numStr = "0" + numStr;
                    }
                    break;
                }
                if (binaryCounter != 1) {
                    binaryCounter /= 10;
                }
            }
            textBin += numStr;
            borradorBinario = 0;
            binaryCounter = 100000;
            numInt = 0;
            tempNum = 0;
        }
        return textBin;
    }


    private String binToDec(String textBin) {//TODO
        numStr = "";
        numInt = 0;
        textDec = "";
        // 1) Dividir el textBin de 6 en 6 (de derecha a izquierda)
        for (int i = textBin.length() - 1; i > -1; --i) {
            numStr = textBin.charAt(i) + numStr;

            if (numStr.length() % 6 == 0) {

                // 2) Para cada digito de un grupo ir iterando y buscando donde hay unos (1)
                for (int j = 0; j < numStr.length(); ++j) {
                    if (numStr.charAt(j) == '1') {
                        numInt += binaryConversor[j];
                    }
                }
                textDec = numInt + textDec;
                numStr = "";
                numInt = 0;
            }

        }

        // 3) usar la misma ubicacion de donde hay unos en el conversor de binario y supar para cada 1
        return textDec;
    }


    private String decToAscii(String textDec) {//TODO
        numStr = "";
        numInt = 0;
        textAscii = "";


        for (int i = 0; i < textDec.length(); ++i) {
            numStr += textDec.charAt(i);

            if (numStr.length() == 2) {
                try {
                    numInt = Integer.parseInt(numStr);
                    textAscii += abc[(numInt - 65) % 26];
                    numStr = "";
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("ERROR: Se ha introducido con anterioridad uno o varios caracteres incorrectos. DETALLES: " + aioobe);
                    textAscii = null;
                }
            }
        }
        return textAscii;
    }

    public static void colorToText(String Text) {
        ctt.decToAscii(ctt.binToDec(ctt.hexToBinary(ctt.colorToHex(Text))));
    }

    public static String getText() {
        return textAscii;
    }

    //De la tabla ascii solo se usaran los caracteres mayucculas

}
