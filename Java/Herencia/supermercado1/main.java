package DAM1.Herencia.supermercado1;

/*
* Realizar una aplicación para poder comprar productos de un supermercado.

Habrá clientes normales y preferentes y productos normales y con caducidad.

De los clientes se almacena su nombre y su contraseña de acceso y las compras que ha realizado.
* Los usuarios preferentes tienen la posibilidad de recibir descuentos

La aplicación tendrá usuario administrador que podrá añadir productos y obtener diferentes listados
* (productos a los que les queda menos de 1 semana para caducar (usar LocalDateTime)), poner productos en ofertas, etc.

Para los clientes normales acceden a la aplicación para ver los productos y pueden añadirlos a un carrito de la compra
* para luego poder realizar la compra completa.

Los productos tienen precio original, precio en oferta, fin del tiempo de oferta y cantidad en stock.
Los caducables tienen, además, fecha de caducidad.
*
* */

public class main {

}

class SupermercadoH1 {

}

class ClienteH1  extends UsuarioH1{
    private String name;
    private String password;
    private int numCompras;
    private boolean puedeRecibirDescuento;

    void addProducto(ProductoH1 p) {

    }

    void realizarCompra() {

    }
}

class UsuarioH1 {
    void listarProductos() {

    }
}

class AdminH1 extends UsuarioH1{

    void addProducto() {

    }

    void listarProductos(int semanasParaCaducar) {

    }

    void poderOferta(ProductoH1 p) {

    }

}

class CliNormalH1 extends ClienteH1 {

}

class CliPreferenteH1 extends  ClienteH1 {
    //Puede recibir descuento = true
}

class ProductoH1 {

}

class ProNormalH1 {

}

class ProCaducado {

}

