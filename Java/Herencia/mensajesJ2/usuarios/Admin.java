package DAM1.Herencia.mensajesJ2.usuarios;

public class Admin extends Usuario {

    public Admin() {
        super("El fukin admin", 777);
        tipo = TipoUsuario.ADMIN;
    }

    public void menu() {
        String res;
        String vistaMenu = """
                (1) Entrar en usuario\
                
                (2) Listar Usuarios\
                
                (3) Ver mensajes recibidos de tlf\
                
                (4) Ver mensajes enviados de tlf\
                
                (0) Salir""";

        do {
            System.out.println();
            System.out.println(vistaMenu);
            res = input.nextLine();
            switch (res) {
                case "1" -> entrarEnUser();
                case "2" -> listarUsuaros();
                case "3" -> verMsgRecibidosDeUser();
                case "4" -> verMsgEnviadosDeUser();
            }
        } while (!res.equals("0"));
    }

    public void verMsgEnviadosDeUser() {
        int tlf = Integer.parseInt(input.nextLine());

        Usuario usu = buscarUsu(tlf);
        usu.verMsgsEnviados();
    }

    public void verMsgRecibidosDeUser() {
        int tlf = Integer.parseInt(input.nextLine());

        Usuario usu = buscarUsu(tlf);
        usu.verMsgsRecibidos();
    }


    public void listarUsuaros() {
        Usuario[] usus = app.getUsuarios();

        for (int i = 0; i < usus.length; i++) {
            System.out.println(usus[i]);
        }
    }

    public void entrarEnUser() {
    }


    public void crearUsuario() {
        // TODO
    }
}
