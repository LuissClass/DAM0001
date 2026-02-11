package DAM1.Herencia.mensajesJ2.usuarios;

public class Admin extends Usuario implements  IAdmin{


    @Override
    public void verMsgEnviadosDeUser(int tlf) {

    }

    @Override
    public void verMsgRecibidosDeUser(int tlf) {

    }

    @Override
    public void listarUsuaros(Usuario[] us) {
        for (int i = 0; i < us.length; i++) {
            System.out.println(us[i]);
        }
    }

    @Override
    public void elegirUsuario(Usuario[] us) {

    }

    @Override
    public void crearUsuario() {

    }

    @Override
    public void listarContactos() {

    }

    @Override
    public void enviarMensaje() {

    }

    @Override
    public void verMsgsEnviados() {

    }

    @Override
    public void verMsgsRecibidos() {

    }

    @Override
    public void entrar() {

    }

    @Override
    public void salir() {

    }
}
