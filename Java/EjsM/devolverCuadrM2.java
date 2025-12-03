package DAM1.EjsM;

public class devolverCuadrM2 {
    final static int LADOS_DE_UN_CUADRILATERO = 4;

    public static void main(String[] args) {
        devolverCuadrM2 ob = new devolverCuadrM2();

        float[][] matrix = {
                {7, 3, 5, 2},
                {8, 4, 8, 4},
                {3, 3, 3, 3},
                {5, 2, 2, 6}
        };
        float[][] arrCuadrConLadosIguales = ob.devolverCuadrilConDosLadosIguales(matrix);
        String res = ob.matrixBi(arrCuadrConLadosIguales);
        System.out.println(res);
    }

    float[][] devolverCuadrilConDosLadosIguales(float[][] matrix) {
        int contadorCuadr = 0;
        float[][] res;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == matrix[i][2] && matrix[i][1] == matrix[i][3]) {
                contadorCuadr++;
            }
        }

        res = new float[contadorCuadr][LADOS_DE_UN_CUADRILATERO];
        contadorCuadr = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == matrix[i][2] && matrix[i][1] == matrix[i][3]) {
                res[contadorCuadr] = matrix[i];
                contadorCuadr++;
            }
        }
        return res;
    }

    String matrixBi(float[][] arrBi) {
        String matrix = "";

        for (int i=0; i < arrBi.length; i++) {
            matrix += "row" + i + ": ";
            for (int j=0; j < arrBi[i].length; j++) {
                matrix += arrBi[i][j] +"  ";
            }
            matrix += "\n";
        }
        return  matrix;
    }
}
