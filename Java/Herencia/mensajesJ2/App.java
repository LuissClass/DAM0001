package DAM1.Herencia.mensajesJ2;

import DAM1.Herencia.mensajesJ2.usuarios.*;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class App implements  IApp{
     public static void main(String[] args) {
         Vector<Usuario> usuariosBase = new Vector<>(List.of(
                 new Normal("Jacinto", 3898),
                 new Normal("Segismundo", 434),
                 new Normal("Jaromil", 3422),
                 new Normal("Moreira", 4231313)
         ));

         App app1 = new App(usuariosBase, new Admin());

         app1.iniciar();
     }

     private Vector<Usuario> usuarios;
    private Admin usuAdmin;
    private Usuario usuarioActivo;
    Scanner input = new Scanner(System.in);

    MenuAdmin menuAdmin;

    public App(Vector<Usuario> usuarios, Admin usuAdmin) {
        this.usuarios = usuarios;
        this.usuAdmin = usuAdmin;
        menuAdmin = new MenuAdmin(usuAdmin);
    }

    public void updateMenu() {
        String res;

        if (usuarioActivo instanceof Admin) {
            menuAdmin.mostrarOpciones();
            res = input.nextLine();
            menuAdmin.elegirOpcion(res);
        } else {
            usuarioActivo.menu();
        }
    }

    public void iniciar() {
        for (Usuario u: usuarios) {
            u.setApp(this);
        }

        usuAdmin.setApp(this);
        usuAdmin.entrar();

        updateMenu();
    }

     @Override
     public void volverAlAdmin() {
         usuAdmin.entrar();
     }

    @Override
    public void crearUsuario(String name, int telf) {
        usuarios.add(new Usuario(name, telf));
    }


    public Vector<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Vector<Usuario> usuarios) {
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
        updateMenu();
    }
}

