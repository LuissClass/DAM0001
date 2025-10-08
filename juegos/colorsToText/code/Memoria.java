package juegos.colorsToText.code;

/**
 * Clase que almacena todas las variables necesarias
 * para el proceso de cifrado y descifrado.
 * <p>
 * Todas las variables se inicializan aqui
 * </p>
 */

public class Memoria {
    /** El abecedario */
    final static char abc[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    final static int FIRST_POS = 65;
    static String textDec = "";
    static int asciiCounter = FIRST_POS;


    public final static int binaryConversor[] = {64, 16, 8, 4, 2, 1};
    public static String textBin = "";
    public static int borradorBinario = 0;
    public static int binaryCounter = 100000;
    static int tempNum = 0;


    static String textHex = "";

    static String colors = "";
}
