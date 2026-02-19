package DAM1.Herencia.mensajesJ2.mensajes;

public class SMS extends Mensaje{
    String texto;

    public SMS(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "SMS {" +
                "\n\tRemitente: " + tlfRemitente
                +"\n\tDestinatario: " + tlfDestinatario
                +"\n\tTexto: " + texto
                + "\n\t}";
    }
}
