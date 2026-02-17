package DAM1.Herencia.mensajesJ2.usuarios;

public class Normal extends Usuario {


    public Normal(String name, int tlf) {
        super(name, tlf);
        tipo = TipoUsuario.NORMAL;
    }
}
