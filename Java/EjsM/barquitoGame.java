package DAM1.EjsM;

public class barquitoGame {
    public static void main(String[] args) {
        barquitoGame juego = new barquitoGame();
        juego.mostrarTablero();
        juego.reiniciarTablero();
        juego.mostrarTablero();
        juego.crearBarco(new int[]{8, 5}, "W");
        juego.crearBarco(new int[]{1, 10}, "S");
        juego.crearBarco(new int[]{10, 3}, "N");
        //TODO El eje x va del 0 al 9 (el 10 considera fuera de tabla) y el Y del 1 al 10 (el 0 da error)
        juego.mostrarTablero();
    }

    String[][] tablero = new String[10][10];

    void reiniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = "-";
            }
        }
    }

    void mostrarTablero() {
        String matrix = "";

        for (int i = 0; i < tablero.length; i++) {
            if (i == 0) {
                matrix += 10 - i + ": ";
            } else {
                matrix += 10 - i + ":  ";
            }
            for (int j = 0; j < tablero[i].length; j++) {
                matrix += tablero[i][j] + "  ";
            }
            matrix += "\n";
        }
        System.out.println(matrix);
    }

    void crearBarco(int[] pos, String or) {
        String[] barco = tipoBarco();
        int[] dir = calcularDireccion(or);

        if (esPosCorrecta() && esOrCorrecta()) {
            if (entraEnTablero(barco.length, pos, dir)) {
                if (hayEspacio()) {
                    meterBarco(barco, pos, dir);
                } else {
                    System.out.println("El barco no tiene espacio");
                }
            } else {
                System.out.println("El barco supera el tamano del tablero");
            }
        } else {
            System.out.println("La posicion correcta o la orientacion no es correcta.");
        }
    }

    int[] calcularDireccion(String or) {
        int dirX = 0;
        int dirY = 0;

        switch (or) {
            case ("S") -> dirY = 1;
            case ("N") -> dirY = -1;
            case ("W") -> dirX = -1;
            case ("E") -> dirX = 1;
        }
        return new int[]{dirX, dirY};
    }

    String[] tipoBarco() {
        return new String[]{"O", "O", "O"}; //TODO
    }

    boolean esPosCorrecta() {
        return true; //TODO
    }

    boolean esOrCorrecta() {
        return true; //TODO
    }

    boolean hayEspacio() {
        return true; //TODO
    }

    void meterBarco(String[] barco, int[] pos, int[] dir) {
        for (int i = 0; i < barco.length; i++) {
            tablero[tablero.length - pos[1] + (i * dir[1])][pos[0] + (i * dir[0])] = barco[i];
        }
    }

    boolean entraEnTablero(int size, int[] pos, int[] dir) {
        boolean res = true;
        for (int i = 0; i < size; i++) {
            res = (tablero.length - pos[1] + (i * dir[1])) >= 0
                    && (tablero.length - pos[1] + (i * dir[1])) <= 9
                    && (pos[0] + (i * dir[0])) <= 9
                    && (pos[0] + (i * dir[0])) >= 0;
        }
        return res;
    }
}
