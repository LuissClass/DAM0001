package DAM1.EjsM;

/*
*
(dif 5) Realizar una aplicación para gestionar una biblioteca.

En la biblioteca se dispone de libros (no más de 2000), de los que se tiene almacenado el código (int entre 0 y 1999) y el título. La biblioteca tiene usuarios. Cada usuario está identificado por un identificador (int) y puede tener prestados un máximo de 5 libros, también se almacena el usuario asociado a cada libro.  Se supondrá que no hay más de 100 usuarios.
La aplicación debe mostrar un menú que permita realizar las siguientes operaciones :
1.- Alta de libros. Se pedirá el código y el título y se guardará como almacenado
2.- Alta de usuarios. Se pedirá el nombre del mismo y se le asignará un identificador (entre 0 y 99 ) de entre los disponibles (no asignado a otro usuario)
3.- Baja de usuarios. Se pedirá el identificador y, si no tiene libros en préstamo, se le dará de baja. Si tiene libros en préstamo no se le podrá dar de baja y se mostrará un mensaje indicándolo.
4.- Préstamo de libros. Se pedirá por teclado el identificador del usuario y el código del libro y si el libro está disponible (se supone que sólo hay un ejemplar de cada libro) se le prestará al usuario.
5.- Devolución de libro. Se pedirá por teclado el identificador del usuario y el código del libro que devuelve y, si lo tenía en préstamo, se considerará devuelto.
6.- Consulta de libro. Se pedirá por teclado el código de un libro y se indicará si está o no en préstamo y en caso de estar prestado el código y nombre del usuario que lo tiene.
7.- Listado de usuarios. Se mostrarán en pantalla los identificadores y  nombres de usuarios y los títulos de los libros que posee cada usuario.
8.- Listado de libros no prestados: Se mostrará en pantalla los códigos y títulos de todos los libros no prestados.
 0.- Fin de la aplicación.
Se deberá realizar cada opción en un método diferente.
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BibliotecaE4 {
    public static void main(String[] args) {
        BibliotecaE4 b = new BibliotecaE4();
        b.abrirMenu();
    }


    Scanner input = new Scanner(System.in);
    UsuarioE4[] usuarios = new UsuarioE4[100];
    LibroE4[] libros = new LibroE4[2000];

    void abrirMenu() {
        int res;

        do {
            System.out.println("¿Qué deseas hacer?");
            res = input.nextInt();

            switch (res) {
                case (1) -> altaDeLibros();
                case (2) -> altaDeUsuarios();
                case (3) -> bajaDeUsuarios();
                case (4) -> prestamoDeLibros();
                case (5) -> devolucionDeLibro();
                case (6) -> consultaDeLibro();
                case (7) -> listadoDeUsuarios();
                case (8) -> listadoDeLibrosNoPrestados();
                case(9) -> listadoOrdenadoUsuariosPorNumLibros();
                case(10) -> listadoOrdenadoPorNombre();
                case(69) -> crearPlantilla();
                case (0) -> System.out.println("\n\t>>>Finalizando aplicacion...");
            }
        } while (res != 0);

    }

    // 1)
    void altaDeLibros() {
        System.out.println("Codigo: ");
        int code = input.nextInt();
        input.nextLine();
        System.out.println("Titulo: ");
        String title = input.nextLine();

        if (codigoCorrecto(code)) {
            meterNuevoLibro(code, title);
        } else {
            System.out.println("Ya hay un libro llamado '" + libros[code].getTitle() + "' con del codigo " + libros[code].getCode());
        }
    }

    void meterNuevoLibro(int code, String title) {
        libros[code] = new LibroE4(code, title);
    }

    boolean codigoCorrecto(int code) {
        return libros[code] == null;
    }

    // 2)
    void altaDeUsuarios() {
        input.nextLine();
        System.out.println("Nombre del usuario: ");
        String name = input.nextLine();

        meterNuvoUser(name);
    }

    void meterNuvoUser(String name) {
        int id = idDisponible();
        usuarios[id] = new UsuarioE4(id, name);
    }

    int idDisponible() {
        int id = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                id = i;
                break;
            }
        }

        return id;
    }

    // 3)
    void bajaDeUsuarios() {
        System.out.println("Id del usuario: ");
        int id = input.nextInt();

        if (esUsuarioSinLibros(id)) {
            removerUser(id);
        } else {
            System.out.println("No se puede remover ese usuario, tiene libros prestados.");
        }
    }

    boolean esUsuarioSinLibros(int id) {
        return usuarios[id].getLibrosPrestados().length == 0;
    }

    void removerUser(int id) {
        usuarios[id] = null;
    }

    // 4)
    void prestamoDeLibros() {
        System.out.println("Codigo libro: ");
        int codeLibro = input.nextInt();
        System.out.println("Id usuario: ");
        int idUser = input.nextInt();

        if (libroDisponible(codeLibro)) {
            prestarLibroToUser(codeLibro, idUser);
        } else {
            System.out.println("Ese libro no esta disponible");
        }
    }

    boolean libroDisponible(int codeLibro) {
        return !libros[codeLibro].isPrestado();
    }

    void prestarLibroToUser(int codeLibro, int idUser) {
        if (userTieneEspacio(idUser)) {
            meterLibroToUser(codeLibro, idUser);
            libros[codeLibro].setPrestado(true);
            libros[codeLibro].setUsuario(usuarios[idUser]);
        } else {
            System.out.println("El usuario no puede tener más de 5 libros prestados");
        }

    }

    boolean userTieneEspacio(int idUser) {
        boolean res = false;
        for (int i = 0; i < usuarios[idUser].getLibrosPrestados().length; i++) {
            if (usuarios[idUser].getLibrosPrestados()[i] == null) {
                res = true;
                break;
            }
        }
        return res;
    }

    void meterLibroToUser(int codeLibro, int idUser) {
        for (int i = 0; i < usuarios[idUser].getLibrosPrestados().length; i++) {
            if (usuarios[idUser].getLibrosPrestados()[i] == null) {
                usuarios[idUser].getLibrosPrestados()[i] = libros[codeLibro];
                break;
            }
        }
    }

    // 5)
    void devolucionDeLibro() {
        System.out.println("Codigo libro: ");
        int codeLibro = input.nextInt();
        System.out.println("Id usuario: ");
        int idUser = input.nextInt();

        if (userTieneLibro(codeLibro, idUser)) {
            devolverLibro(codeLibro, idUser);
            libros[codeLibro].setPrestado(false);
            libros[codeLibro].setUsuario(null);
        } else {
            System.out.println("Ese no tiene ese libro prestado");
        }
    }

    boolean userTieneLibro(int codeLibro, int idUser) {
        return libros[codeLibro].getUsuario().getId() == idUser;
    }

    void devolverLibro(int codeLibro, int idUser) {
        for (int i = 0; i < usuarios[idUser].getLibrosPrestados().length; i++) {
            if (usuarios[idUser].getLibrosPrestados()[i].getCode() == codeLibro) {
                usuarios[idUser].getLibrosPrestados()[i] = null;
            }
        }
    }

    // 6)
    void consultaDeLibro() {
        System.out.println("Codigo libro: ");
        int codeLibro = input.nextInt();

        if (!libroDisponible(codeLibro)) {
            System.out.println("\tUsuario con el libro: ");
            System.out.println("\t\tId: " + libros[codeLibro].getUsuario().getId());
            System.out.println("\t\tNombre: " + libros[codeLibro].getUsuario().getName());
        } else {
            System.out.println("\tEste libro esta disponible para ser prestado");
        }
    }

    // 7)
    void listadoDeUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println("Usuario " + usuarios[i].getId() + ": " + usuarios[i].getName());
                System.out.println("\tLibros prestados: ");
                for (int j = 0; j < usuarios[i].getLibrosPrestados().length; j++) {
                    if (usuarios[i].getLibrosPrestados()[j] != null) {
                        System.out.println("\t\t" + usuarios[i].getLibrosPrestados()[j].getTitle() + " - Codigo: " + usuarios[i].getLibrosPrestados()[j].getCode());
                    }
                }
            }
        }
    }

    // 8)
    void listadoDeLibrosNoPrestados() {
        System.out.println("\n\tLibros NO prestados: ");
        for (int j = 0; j < libros.length; j++) {
            if (libros[j] != null && libroDisponible(libros[j].getCode())) {
                System.out.println("\t\t" +  libros[j].getTitle() + " - Codigo: " + libros[j].getCode());
            }
        }
    }

    // 9)
    void listadoOrdenadoUsuariosPorNumLibros() {
        UsuarioE4 usuAux;
        int numUsuarios = devolverNumUsuarios();

        // Usar burbuja
        for (int i = 0; i < numUsuarios; i++) {
            for (int j = 0; j < numUsuarios-j-1; j++) {
                if (usuarios[j+1] != null) {
                    if (usuarios[j].devolverSoloLibrosPrestados().length < usuarios[j + 1].devolverSoloLibrosPrestados().length) {
                        usuAux = usuarios[j];
                        usuarios[j] = usuarios[j + 1];
                        usuarios[j + 1] = usuAux;
                    }
                }
            }
        }
    }

    int devolverNumUsuarios() {
        int num = 0;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                num++;
            }
        }
        return num;
    }

    // 10)
    void listadoOrdenadoPorNombre() {
        ordenarLibrosEnUsuarios();

        Arrays.sort(usuarios, 0, devolverNumUsuarios(), Comparator.comparing(UsuarioE4::getName));
    }

    void ordenarLibrosEnUsuarios() {
        for (int i = 0; i < devolverNumUsuarios(); i++) {
            usuarios[i].ordenarLibrosPorCodigo();
        }
    }

    // 69)
    void crearPlantilla() {
        usuarios[0] = new UsuarioE4(0, "Zack");
        usuarios[1] = new UsuarioE4(1, "Pepe Prime");
        usuarios[2] = new UsuarioE4(2, "Pepe Super Sayan");

        libros[40] = new LibroE4(40, "Le prince");
        libros[23] = new LibroE4(23, "La princeso");
        libros[4] = new LibroE4(4, "Elle prince");
        libros[7] = new LibroE4(7, "nose1");
        libros[98] = new LibroE4(98, "nose2");
        libros[3] = new LibroE4(3, "nose3");

        meterLibroToUser(40, 0);
        meterLibroToUser(23,1);
        meterLibroToUser(4,1);
        meterLibroToUser(7,1);
    }
}

class LibroE4 {
    private final int code;
    private final String title;
    boolean prestado = false;
    UsuarioE4 usuario;

    public LibroE4(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public UsuarioE4 getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioE4 usuario) {
        this.usuario = usuario;
    }
}

class UsuarioE4 {
    private final int id;
    private final String name;
    private final LibroE4[] librosPrestados = new LibroE4[5];

    UsuarioE4(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void ordenarLibrosPorCodigo() {
        LibroE4[] librosSinNull = devolverSoloLibrosPrestados();

        Arrays.sort(librosSinNull, Comparator.comparingInt(LibroE4::getCode));

        Arrays.fill(librosPrestados, null);

        for (int i = 0; i < librosSinNull.length; i++) {
            librosPrestados[i] = librosSinNull[i];
        }
    }


    public LibroE4[] devolverSoloLibrosPrestados() {
        LibroE4[] res;
        int counter = 0;

        for (int i = 0; i < librosPrestados.length; i++) {
            if (librosPrestados[i] != null) {
                counter++;
            }
        }

        res = new LibroE4[counter];
        counter = 0;

        for (int i = 0; i < librosPrestados.length; i++) {
            if (librosPrestados[i] != null) {
                res[counter] = librosPrestados[i];
                counter++;
            }
        }

        return res;
    }

    public LibroE4[] getLibrosPrestados() {
        return librosPrestados;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}


