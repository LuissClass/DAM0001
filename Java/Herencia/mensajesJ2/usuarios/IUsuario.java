package DAM1.Herencia.mensajesJ2.usuarios;

/* TODO Mas adelante tendran contraseñas y se podra iniciar sesion? */

import DAM1.Herencia.mensajesJ2.mensajes.Mensaje;

public interface IUsuario {
    void listarContactos();
    void enviarMensaje();
    void verMsgsEnviados();
    void verMsgsRecibidos();
    void addMensaje(Mensaje msg);
    void menu();
    void entrar();
    void salir(); /* Es para salir de un Usuario y entrar al Admin. Si se intenta salir del Admin se acaba el programa*/
}
