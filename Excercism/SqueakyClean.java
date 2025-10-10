/* Ejemplo de lo que hace:
    clean("my   Id") => "my___Id"
    clean("a-bc") => "aBc"
    clean("H3ll0 W0rld") => "Hello_World"
    clean("a 73s7") => "a_test"
    clean("a$#.b") => "ab" */

import java.util.Map;

class SqueakyClean {
    static String clean(String identifier) {
        char[] idAsArray = identifier.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean isKebabCase = false;
        String strChar;
        Map<Character, Character> modifiers = Map.of('4', 'a', '3', 'e', '0', 'o', '1', 'l', '7', 't');

        for (char ch : idAsArray) {
            if (ch == ' ') {
                builder.append('_');

                // Si hay un guion, el siguiente char se pondra en mayuscula
            } else if (ch == '-') {
                isKebabCase = true;
            } else if (isKebabCase) {
                strChar = ch + "";
                builder.append(strChar.toUpperCase());
                isKebabCase = false;

                // Cambia los numeros acorde al mapeo de modifiers
            } else if (Character.isDigit(ch)) {
                if (modifiers.containsKey(ch)) {
                    builder.append(modifiers.get(ch));
                }
            } else if (Character.isLetter(ch)) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
