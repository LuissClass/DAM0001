package DAM1.Herencia.mensajesJ2.usuarios;

import java.util.Vector;

public class Admin extends Usuario {

    public Admin() {
        super("El admin", 777);
        tipo = TipoUsuario.ADMIN;
    }

    public void verMsgEnviadosDeUser() {
        System.out.println("Telf: ");
        int tlf = Integer.parseInt(input.nextLine());

        Usuario usu = buscarUsu(tlf);
        usu.verMsgsEnviados();
    }

    public void verMsgRecibidosDeUser() {
        System.out.println("Telf: ");
        int tlf = Integer.parseInt(input.nextLine());

        Usuario usu = buscarUsu(tlf);
        usu.verMsgsRecibidos();
    }

    public void listarUsuaros() {
        Vector<Usuario> usus = app.getUsuarios();

        for (int i = 0; i < usus.size(); i++) {
            System.out.println(usus.get(i));
        }
    }

    public void entrarEnUser() {
        System.out.println("Telf: ");
        int tlf = Integer.parseInt(input.nextLine());

        Usuario usu = buscarUsu(tlf);

        app.setUsuarioActivo(usu);
    }

    String pedirName() {
        String name;
        System.out.println("Name: ");
        name = input.nextLine();

        return name;
    }

    int pedirTelf() {
        int telf;
        System.out.println("Telf: ");
        telf = Integer.parseInt(input.nextLine());
        return telf;
    }

    public void crearUsuario() {
        String name = pedirName();
        int telf = pedirTelf();

        app.crearUsuario(name, telf);
    }
}
