package DAM1.Herencia.mensajesJ2;

import DAM1.Herencia.mensajesJ2.usuarios.Admin;

public class MenuAdmin {
    Admin logica;

    MenuAdmin(Admin admin) {
        logica = admin;
    }

    public void mostrarOpciones() {
        String vistaMenu = """
                ===USUARIO: Admin del admin===\
                
                (1) Entrar en usuario\
                
                (2) Listar usuarios\
                
                (3) Ver mensajes recibidos de tlf\
                
                (4) Ver mensajes enviados de tlf\
                
                (5) Crear Nuevo Usuario\
                
                (0) Salir""";

        System.out.println(vistaMenu);
    }

    public void elegirOpcion(String op) {
        System.out.println();
        switch (op) {
            case "1" -> logica.entrarEnUser();
            case "2" -> logica.listarUsuaros();
            case "3" -> logica.verMsgRecibidosDeUser();
            case "4" -> logica.verMsgEnviadosDeUser();
            case "5" -> logica.crearUsuario();
            case "0" -> logica.salir();
        }
    }

}
