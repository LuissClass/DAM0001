package DAM1.EjsM;

public class M1 {
    public static void main(String[] args) {
        M1 arrs = new M1();
        System.out.println("==ARRAY BIANAL==");
        int[][] arrBi = new int[4][4];
        arrBi[0][1] = 3;
        arrBi[3][3] = 4;
        System.out.println(arrs.matrixBi(arrBi));
        System.out.println(">>RELLENO");
        arrs.rellenarArr(arrBi, 9);
        System.out.println(arrs.matrixBi(arrBi));
        System.out.println(">>CAMBIADO");
        arrBi[3][2] = 8;
        arrBi[2][1] = 1;
        arrBi[1][3] = 4;
        arrBi[0][0] = 2;
        System.out.println(arrs.matrixBi(arrBi));
        System.out.println(">>Media del array");
        double media1 = arrs.mediaNums(arrBi);
        System.out.println(media1);
        System.out.println();
        System.out.println(">>Posicion de los nums mayores a la media");
        int[][] p = arrs.posDeNumsMayorMedia(arrBi);
        System.out.println(arrs.matrixBi(p));
        System.out.println(">>Nums mayores a la media");
        int[] n = arrs.numsMayoresMedia(arrBi);
        arrs.mostrarArr(n);
    }

    String matrixBi(int[][] arrBi) {
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


    void mostrarArr(int[] arr) {
        String res = "";
        for (int i=0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println(res);
    }

    String matrixTri() {
        int[][][] datos = new int[4][3][2];
        String matrix = "";
        datos[0][1][1] = 2;
        datos[2][2][0] = 2;

        for (int i=0; i < datos.length; i++) {
            matrix += "row" + i + ": \t";
            for (int j=0; j < datos[i].length; j++) {
                matrix += "row" + i + "." + j + ": ";
                for (int k=0; k < datos[i][j].length; k++) {
                    matrix += datos[i][j][k] + "  ";
                }
            }
            matrix += "\n";
        }
        return  matrix;
    }

    String matrixTetra() {
        int[][][][] datos = new int[4][3][2][10];
        String matrix = "";
        datos[0][1][1][2] = 2;
        datos[3][2][0][4] = 2;

        for (int i=0; i < datos.length; i++) {
            matrix += "row" + i + ": \t";
            for (int j=0; j < datos[i].length; j++) {
                matrix += "row" + i + "." + j + ": ";
                for (int k=0; k < datos[i][j].length; k++) {
                    matrix += "row" + i + "." + j + "." + k + ": ";
                    for (int z = 0; z < datos[i][j][k].length; z++) {
                        matrix += datos[i][j][k][z] + "  ";
                    }
                }
                matrix += "\n";
            }
            matrix += "\n";
        }
        return  matrix;
    }

    int[][] rellenarArr(int[][] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num;
            }
        }
        return arr;
    }

    double mediaNums(int[][] arr) {
        double mediaRow = 0;
        double media = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                mediaRow+=arr[i][j];
            }
            media = mediaRow / arr[i].length;
        }
        media = media / arr.length;
        return media;
    }

    int[] numsMayoresMedia(int[][] arr) {
        int[][] pos = posDeNumsMayorMedia(arr);
        int[] res = new int[pos.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = arr[pos[i][0]][pos[i][1]];
        }
        return res;
    }

    int[][] posDeNumsMayorMedia(int[][] arr) {
        double media = mediaNums(arr);
        int[][] posNumsMayoresMedia;
        int cantidadNums = 0;
        int posNumsRow = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > media) {
                    cantidadNums++;
                }
            }
        }

        posNumsMayoresMedia = new int[cantidadNums][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > media) {
                    posNumsMayoresMedia[posNumsRow][0] = i;
                    posNumsMayoresMedia[posNumsRow][1] = j;
                    posNumsRow++;
                }
            }
        }
        return  posNumsMayoresMedia;
    }





}
