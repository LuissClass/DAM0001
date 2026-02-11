package DAM1.Herencia.mensajesJ2.usuarios;

/* Usuario por defecto */

public interface IAdmin extends IUsuario{
    void verMsgEnviadosDeUser(int tlf);
    void verMsgRecibidosDeUser(int tlf);

    void listarUsuaros(Usuario[] us);
    void elegirUsuario(Usuario[] us);
    void crearUsuario();
}
