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

public class Principal {
    static void updateFromData() throws IOException {
        File data = new File("DAM1\\Herencia\\supermercado1\\datos.json");
        String dataInStr;

        dataInStr = leerFich(data);

        System.out.println("Fichero data en una linea: " + dataInStr);

        dataInStr = dataInStr.replaceAll("\\s+", "");

        System.out.println("Fichero data en una linea: " + dataInStr);

        String[] dataProfundidad1 = new String[3]; //Nombres, clientes y productos


    }

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

    static String[] separarData() {

    }

    static  String[] separarDataProf1() {}
    static  String[] separarDataProf2() {}
    static  String[] separarDataProf3() {}


    public static void main(String[] args) throws IOException, InterruptedException {
        updateFromData();
    }
}

class SupermercadoH1 {
    ClienteH1[] clientes = new ClienteH1[50];
    ProductoH1[] productos = new ProductoH1[100];

    int contClie = 0;
    int contProds = 0;

    void addProducto(ProductoH1 p) {
        productos[contProds] = p;
        contProds++;
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

    public ClienteH1(SupermercadoH1 sm) {
        super(sm);
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
}

class UsuarioH1 {
    SupermercadoH1 sm;

    public UsuarioH1(SupermercadoH1 sm) {
        this.sm = sm;
    }

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
        super(sm);
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
    public CliNormalH1(SupermercadoH1 sm) {
        super(sm);
    }
}

class CliPreferenteH1 extends  ClienteH1 {
    public CliPreferenteH1(SupermercadoH1 sm) {
        super(sm);
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

