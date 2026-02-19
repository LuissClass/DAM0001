package DAM1.Herencia.mensajesJ2.mensajes;

public class MMS extends  Mensaje{
    String ruta;
    int size;

    public MMS(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "MMS {" +
                "\n\tRemitente: " + tlfRemitente
                +"\n\tDestinatario: " + tlfDestinatario
                +"\n\tRuta: " + ruta
                + "\n\t}";
    }
}
