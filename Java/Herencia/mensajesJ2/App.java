package DAM1.Herencia.mensajesJ2;

import DAM1.Herencia.mensajesJ2.usuarios.*;

public class App implements  IApp{
     public static void main(String[] args) {
         Usuario[] usuariosBase = {
                 new Normal("Jacinto", 3898),
                 new Normal("Segismundo", 434),
                 new Normal("Jaromil", 3422),
                 new Normal("Moreira", 4231313),
         };

         App app1 = new App(usuariosBase, new Admin());
         app1.iniciar();

     }

     private Usuario[] usuarios;
    private Admin usuAdmin;
    private Usuario usuarioActivo;

    public App(Usuario[] usuarios, Admin usuAdmin) {
        this.usuarios = usuarios;
        this.usuAdmin = usuAdmin;
    }

    public void iniciar() {
        for (Usuario u: usuarios) {
            u.setApp(this);
        }

        usuAdmin.setApp(this);

        volverAlAdmin();

        usuarioActivo.menu();
    }

     @Override
     public void volverAlAdmin() {
         usuAdmin.entrar();
         // Todo procurar mantener estado
     }

    public Usuario[] getUsuarios() {
        return usuarios;
    }


     public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Admin getUsuAdmin() {
        return usuAdmin;
    }

    public void setUsuAdmin(Admin usuAdmin) {
        this.usuAdmin = usuAdmin;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}

