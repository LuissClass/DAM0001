package DAM1.Herencia.supermercado1;

/*
* Realizar una aplicación para poder comprar productos de un supermercado.

Habrá clientes normales y preferentes y productos normales y con caducidad.

De los clientes se almacena su nombre y su contraseña de acceso y las compras que ha realizado.
* Los usuarios preferentes tienen la posibilidad de recibir descuentos

La aplicación tendrá usuario administrador que podrá añadir productos y obtener diferentes listados
(productos a los que les queda menos de 1 semana para caducar (usar LocalDateTime)), poner productos en ofertas, etc.

Para los clientes normales acceden a la aplicación para ver los productos y pueden añadirlos a un carrito de la compra
* para luego poder realizar la compra completa.

Los productos tienen precio original, precio en oferta, fin del tiempo de oferta y cantidad en stock.
Los caducables tienen, además, fecha de caducidad.


Guardar los datos en ficheros y son persistentes.
*
* */

import java.io.*;
import java.util.Arrays;

import static DAM1.Herencia.supermercado1.Principal.*;

public class Principal {


    static String leerFich(File fich) throws IOException {
        String s;
        String allFich = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fich))) {
            while (br.ready()) {
                s = br.readLine();
                allFich += s;
            }
        }
        System.out.println(">>FIN");

        return  allFich;
    }

    // Devuelve el  name, clientes y productos
    static  String[] separarNomCliProd(String data) {
        String name;
        String clientes;
        String productos;
        String[] res = new String[3];

        int posIni = 0;
        int posFin = 0;

        // Substraer name
        if (data.indexOf(":", posIni) != -1) {
            posIni = data.indexOf(":");
        }
        if (data.indexOf(",", posIni) != -1) {
            posFin = data.indexOf(",");
        }

        name = data.substring(posIni+2, posFin-1);

        // Substraer productos
        if (data.indexOf("[", posIni) != -1) {
            posIni = data.indexOf("[");
        }

        if (data.indexOf("]", posIni) != -1) {
            posFin = data.indexOf("]");
        }

        productos = data.substring(posIni + 1, posFin);

        // Substraer clientes
        if (data.indexOf("[", posFin) != -1) {
            posIni = data.indexOf("[", posFin);
        }

        for (int i = posIni; i < data.length(); i++) {
            if (data.indexOf("]", posFin + 1) != -1) {
                posFin = data.indexOf("]", posFin + 1);
            } else {
                break;
            }
        }


        clientes = data.substring(posIni + 1, posFin);

        res[0] = name;
        res[1] = productos;
        res[2] = clientes;

        return  res;
    }
    // Devuelve los clientes
    static  String[][] separarCli(String[] data) {
        String clientes = data[2];
        String[][] res = new String[50][5];
        int cliCont = 0;

        String cliActual;

        int posIni = 0;
        int posFin = 0;

        boolean finalizar = false;

        for (int i = 0; i < clientes.length() && !finalizar; i++) {
            // Substraer cliente actual
            if (clientes.indexOf("\"id\":\"Cli", posFin) != -1) {
                posIni = clientes.indexOf("\"id\":\"Cli", posFin);
            }

            if (clientes.indexOf("\"id\":\"Cli", posIni + 1) != -1) {
                posFin = clientes.indexOf("\"id\":\"Cli", posIni + 1);
            } else {
                posFin = clientes.length() - 1;
                finalizar = true;
            }

            if (!finalizar) {
                cliActual = clientes.substring(posIni, posFin - 3);
            } else {
                cliActual = clientes.substring(posIni, posFin);
            }


            // Substraer datos de cliente act.
            String[] keys = {"id","name","passw","esPreferente","tieneCompras"};

            int posIni2 = 0;
            int posFin2 = 0;

            String valorActual;

            int aumentoIni2;
            int aumentoFin2;

            for (int j = 0; j < 5; j++) {
                if (j < 3) {
                    aumentoIni2 = 4;
                    aumentoFin2 = -1;
                } else {
                    aumentoIni2 = 3;
                    aumentoFin2 = 0;
                }


                if (cliActual.indexOf("\"" + keys[j] + "\"", posFin2) != -1) {
                    posIni2 = cliActual.indexOf("\"" + keys[j] + "\":", posFin2) + keys[j].length();
                }

                if (cliActual.indexOf(",", posFin2 + 1) != -1) {
                    posFin2 = cliActual.indexOf(",", posFin2 + 1);
                } else {
                    posFin2 = cliActual.length();
                }

                valorActual = cliActual.substring(posIni2 + aumentoIni2, posFin2 + aumentoFin2);


                // Poner a true si tiene productos
                if (j == 4 && !valorActual.equals("false")) {
                    valorActual = "true";
                }

                // Meter los datos del c.a. en res
                res[cliCont][j] = valorActual;
            }
            cliCont++;
        }

        return  res;
    }
    // Devuelve los productos de los clientes
    static  String[][] separarProd(String[] data) {
        String[][] res = new String[0][];



        return  res;
    }


    public static void main(String[] args) throws IOException, InterruptedException {

    }
}

class SupermercadoH1 {
    public static void main(String[] args) throws IOException {
        SupermercadoH1 sm = new SupermercadoH1();
        sm.updateFromData();
        System.out.println();
    }

    ClienteH1[] clientes = new ClienteH1[50];
    ProductoH1[] productos = new ProductoH1[100];

    int contClie = 0;
    int contProds = 0;

    void addProducto(ProductoH1 p) {
        productos[contProds] = p;
        contProds++;
    }

    void updateFromData() throws IOException {
        File data = new File("DAM1\\Herencia\\supermercado1\\datos.json");
        String dataInStr;

        dataInStr = leerFich(data);

        System.out.println("Fichero data en una linea: " + dataInStr);

        dataInStr = dataInStr.replaceAll("\\s+", "");

        System.out.println("Fichero data en una linea: " + dataInStr);

        String[] nombreClientesProductos = Principal.separarNomCliProd(dataInStr);

        String[][] clientesData = separarCli(nombreClientesProductos);

        String[][] productosData = separarProd(nombreClientesProductos);

        for (int i = 0; i < clientesData.length; i++) {
            clientes[contClie] = new ClienteH1(clientesData[i][0], clientesData[i][1], clientesData[i][2], false);
            contClie++;
        }
    }


    public ClienteH1[] getClientes() {
        return clientes;
    }

    public ProductoH1[] getProductos() {
        return productos;
    }

    public int getContClie() {
        return contClie;
    }

    public int getContProds() {
        return contProds;
    }
}

class ClienteH1  extends UsuarioH1{
    private String name;
    private String password;
    private ProductoH1[] compras = new ProductoH1[100];
    private boolean esPreferente;
    private ProductoH1[] carrito = new ProductoH1[10];
    private String id;

    private int contCarrito = 0;
    private int contCompras = 0;

    public ClienteH1(String id, String name, String password, boolean esPreferente) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.esPreferente = esPreferente;
    }

    void addProductoAlCarrito(ProductoH1 p) {
        carrito[contCarrito] = p;
        contCarrito++;
    }

    void realizarCompra() {
        for (int i = 0; i < contCarrito; i++) {
            compras[contCompras] = carrito[i];
            contCompras++;
        }

        Arrays.fill(carrito, null);
        contCarrito = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEsPreferente(boolean esPreferente) {
        this.esPreferente = esPreferente;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class UsuarioH1 {
    SupermercadoH1 sm;

    void listarProductos() {
        int cont = sm.getContProds();
        ProductoH1[] prods = sm.getProductos();

        for (int i = 0; i < cont; i++) {
            System.out.println(prods[i]);
        }
    }
}

class AdminH1 extends UsuarioH1{
    public AdminH1(SupermercadoH1 sm) {
    }

    void addProducto(ProductoH1 p) {
        sm.addProducto(p);
    }

    void listarProductos(int semanasParaCaducar) {

    }

    void poderOferta(ProductoH1 p) {

    }

}

class CliNormalH1 extends ClienteH1 {

    public CliNormalH1(SupermercadoH1 sm, String id, String name, String password, boolean esPreferente) {
        super(id, name, password, esPreferente);
    }
}

class CliPreferenteH1 extends  ClienteH1 {
    public CliPreferenteH1(SupermercadoH1 sm, String id, String name, String password, boolean esPreferente) {
        super(id, name, password, esPreferente);
    }
    //Puede recibir descuento = true
}

class ProductoH1 {
    int precioOriginal;
    int precioOferta;
    int finDiasOferta;
    int stock;
    String nombre;
    String id;
}

class ProNormalH1 {

}

class ProCaducado {
    int diasCaducidad;
}

