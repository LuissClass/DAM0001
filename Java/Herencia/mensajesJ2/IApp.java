package DAM1.Herencia.mensajesJ2;


/*
 * Se trata de una App en el que aparece una lista de usuarios a los cuales podemos acceder para enviar mensajes.
 * Además de las funcionalidades dentro de cada Usuario una de las funciones FUERA DEL USUARIO es crear uno nuevo.
 * El Usuario default e inicial es Admin
 * */


public interface IApp {
    void iniciar();
    void volverAlAdmin();
    void crearUsuario(String name, int tlf);
}
