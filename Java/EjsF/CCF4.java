package DAM1.EjsF;

import java.util.Locale;

public class CCF4 {
    public static void main(String[] args) {
        CCF4 f4 = new CCF4();
        String texto = "Algo";
        String textoCifrado = f4.cipher(4, texto);
        String textoDescifrado = f4.decipher(4, textoCifrado);
        System.out.println("Original: " + texto + "\nCifrado: " + textoCifrado + "\nDescifrado: " + textoDescifrado);
        System.out.println();
    }

    char[] abecedario = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    String cipher(int pos, String textoSinFormato) {
        String text = textoSinFormato.toLowerCase();
        String cipheredText = "";
        char ch;
        int nuevaPos;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            for (int j = 0; j < abecedario.length; j++) {
                if (ch == abecedario[j]) {
                    nuevaPos = (j+pos) % abecedario.length;
                    cipheredText += String.valueOf(abecedario[nuevaPos]);
                }
            }
        }
        return cipheredText;
    }

    String decipher(int pos, String textoSinFormato) {
        String text = textoSinFormato.toLowerCase();
        String decipheredText = "";
        char ch;
        int nuevaPos;

        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            for (int j = 0; j < abecedario.length; j++) {
                if (ch == abecedario[j]) {
                    nuevaPos = (j-pos+abecedario.length) % abecedario.length;
                    decipheredText += String.valueOf(abecedario[nuevaPos]);
                }
            }
        }
        return decipheredText;
    }
}
