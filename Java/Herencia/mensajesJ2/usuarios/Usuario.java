package DAM1.Herencia.mensajesJ2.usuarios;

import DAM1.Herencia.mensajesJ2.App;
import DAM1.Herencia.mensajesJ2.mensajes.MMS;
import DAM1.Herencia.mensajesJ2.mensajes.Mensaje;
import DAM1.Herencia.mensajesJ2.mensajes.SMS;

import java.util.Scanner;

public class Usuario implements IUsuario{
    int telefono;
    String name;
    Usuario[] contactos;
    App app;
    TipoUsuario tipo;
    Mensaje[] msgEnviados;
    Mensaje[] msgRecibidos;

    Scanner input = new Scanner(System.in);

    public Usuario(String name, int telefono) {
        this.name = name;
        this.telefono = telefono;
    }

    public void menu() {
        String res;
        String vistaMenu = """
                
                (1) Enviar mensajes\
                
                (2) Ver mensajes recibidos\
                
                (3) Ver mensajes enviados\
                
                (4) Ver mensajes recibidos de tlf\
                
                (5) Listar contactos\
                
                (0) Salir""";

        do {
            System.out.println();
            System.out.println(vistaMenu);
            res = input.nextLine();
            switch (res) {
                case "1" -> enviarMensaje();
                case "2" -> verMsgsRecibidos();
                case "3" -> verMsgsEnviados();
                case "4" -> verMsgsRecibidos();
                case "5" -> verMsgsRecibidos();
            }
        } while (!res.equals("0"));

    }

    @Override
    public void listarContactos() {
        String vistaContactos = "";
        for(Usuario c: contactos) {
            vistaContactos += c + "\n";
        }
        System.out.println(vistaContactos);
    }

    Usuario buscarUsu(int tlf) {
        Usuario usu = null;

        for(Usuario u : app.getUsuarios()) {
            if (u.getTelefono() == tlf) {
                usu = u;
            }
        }

        if (usu == null) {
            System.out.println("El usuario con ese telefono no existe.");
        }

        return usu;
    }

    @Override
    public void enviarMensaje() {
        String res;
        Mensaje msg;
        int tlfDestino = Integer.parseInt(input.nextLine());
        Usuario usu = buscarUsu(tlfDestino);

        if (usu != null) {
            System.out.println("(1) Enviar texto\n(2) Enviar foto");
            res = input.nextLine();

            if (res.equals("1")) {
                String txt = "";

                System.out.println("Mensaje: ");
                res = input.nextLine();
                System.out.println("Mensaje: " + res);
                msg = new SMS(res);

                usu.addMensaje(msg);
                System.out.println("[ENVIADO]");
            } else if (res.equals("2")) {
                String rutaImg = "";

                System.out.println("Ruta imagen: ");
                res = input.nextLine();
                System.out.println("Ruta imagen: " + res);
                msg = new MMS(res);

                usu.addMensaje(msg);
                System.out.println("[ENVIADO]");
            }
        }
    }


    @Override
    public void verMsgsEnviados() {
        String vista = "";
        for(Mensaje m: msgEnviados) {
            vista += m + "\n";
        }
        System.out.println(vista);
    }

    @Override
    public void verMsgsRecibidos() {
        String vista = "";
        for(Mensaje m: msgRecibidos) {
            vista += m + "\n";
        }
        System.out.println(vista);
    }

    @Override
    public void addMensaje(Mensaje msg) {
        Mensaje[] copiaMsgsRecibidos = msgRecibidos.clone();
        msgRecibidos = new Mensaje[msgRecibidos.length + 1];

        for (int i = 0; i < msgRecibidos.length; i++) {
            msgRecibidos[i] = copiaMsgsRecibidos[i];
        }

        msgRecibidos[msgRecibidos.length - 1] = msg;
    }

    @Override
    public void entrar() {
        app.setUsuarioActivo(this);
    }

    @Override
    public void salir() {
        if (tipo == TipoUsuario.ADMIN) {
            app.iniciar();
        } else if (tipo == TipoUsuario.NORMAL) {
            // TODO FINALIZAR PROGRAMA
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " Tlf: " + telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usuario[] getContactos() {
        return contactos;
    }

    public void setContactos(Usuario[] contactos) {
        this.contactos = contactos;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
