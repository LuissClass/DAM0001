package DAM1.Herencia.mensajesJ2.usuarios;

/* TODO Mas adelante tendran contraseñas y se podra iniciar sesion? */

public interface IUsuario {
    void listarContactos();
    void enviarMensaje();
    void verMsgsEnviados();
    void verMsgsRecibidos();

    void entrar();
    void salir(); /* Es para salir de un Usuario y entrar al Admin. Si se intenta salir del Admin se acaba el programa*/
}
