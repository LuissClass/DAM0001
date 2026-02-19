package DAM1.Collecciones;

import java.util.Stack;

public class K1_ver2 {
    public static void main(String[] args) {
        String[] expresiones = {
                "(5+(3-6) - 5",                     // Mal
                "(5+(3*6+(5-array[2]) + 2 ) -5 )",  // Bien
                "( 5 - (3 + a[5+2 )] )",            // Mal (cierre incorrecto)
                "()(()())(())",                     // Bien
                ")("                                // Mal
        };

        for (String exp : expresiones) {
            System.out.println(exp + "\s\s\s --> " + (esValida(exp) ? "CORRECTO" : "MAL"));
        }
    }

    static boolean esValida(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            // Si abre, lo apilamos
            if (c == '(' || c == '[') {
                pila.push(c);
            }
            // Si cierra, comprobamos el último de la pila
            else if (c == ')' || c == ']') {
                if (pila.isEmpty()) return false; // Cierre sin apertura previa

                char ultimoApertura = pila.pop();
                if (!sonPareja(ultimoApertura, c)) return false; // No coinciden los tipos
            }
        }

        // Si al final la pila está vacía, es que todo se cerró correctamente
        return pila.isEmpty();
    }

    static boolean sonPareja(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']');
    }
}
