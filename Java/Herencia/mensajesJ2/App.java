package DAM1.Herencia.mensajesJ2;


import DAM1.Herencia.mensajesJ2.usuarios.*;

public class App implements  IApp{
    private Usuario[] usuarios;
    private IAdmin usuAdmin;
    private IUsuario usuarioActivo;

    public App(Usuario[] usuarios, IAdmin usuAdmin) {
        this.usuarios = usuarios;
        this.usuAdmin = usuAdmin;
    }

    public void iniciar() {
        usuAdmin.entrar();
    }

    public static void main(String[] args) {
        Usuario[] usuariosBase = {
                new Normal(),
                new Normal(),
                new Normal(),
                new Normal(),
        };

        App a = new App(usuariosBase, new Admin());
        a.iniciar();

        a.usuAdmin.listarUsuaros(a.getUsuarios());
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }
}

