/* Ejemplo de lo que hace:
    clean("my   Id") => "my___Id"
    clean("a-bc") => "aBc"
    clean("H3ll0 W0rld") => "Hello_World"
    clean("a 73s7") => "a_test"
    clean("a$#.b") => "ab" */

class SqueakyClean {
    static String clean(String identifier) {
        char[] asArray = identifier.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean isKebabCase = false;
        String strChar;
        char[] vocals = {'a', 'e', 'o', 'l', 't'};
        int[] modifiers = {4, 3, 0, 1, 7};
        int i = 0;
        boolean isNumber = false;
        String strM;

        for (char ch : asArray) {
            for (int m : modifiers) {
                strM = m + "";
                if (ch == strM.charAt(0)) {
                    isNumber = true;
                    break;
                } else {
                    isNumber = false;
                }
            }

            if (Character.isLetter(ch) || ch == ' ' || ch == '-' || isNumber) { // Task 4)
                if (ch == ' ') { // Task 1)
                    builder.append('_');
                } else if (ch == '-') {
                    isKebabCase = true;
                } else if (isKebabCase) {     // Task 2)
                    strChar = ch + "";
                    builder.append(strChar.toUpperCase());
                    isKebabCase = false;
                } else if (isNumber) {
                    for (int modifier : modifiers) { // Task 3)
                        strM = modifier + "";
                        if (ch == strM.charAt(0)) {
                            builder.append(vocals[i]);
                            break;
                        } else {
                            ++i;
                        }
                    }
                    i = 0;
                    isNumber = false;
                } else {
                    builder.append(ch);
                }
            }
        }
        return builder.toString();
    }
}
