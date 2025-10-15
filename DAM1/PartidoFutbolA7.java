public class PartidoFutbolA7 {

    private Equipo local;
    private Equipo visitante;
    private static final byte MAX_GOLES = 127;
    private final Equipo mayorPuntuacion = local.getPuntuacionLiga() > visitante.getPuntuacionLiga()? local : visitante;

    PartidoFutbolA7(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
    }

    public void mostrarGoles() {
        System.out.println("Resultados -> Local: " + local.getGolesMarcados() + " - Visitante: " + visitante.getGolesMarcados());
    }

    public void jugarPartido() {
        byte golesLocal = (byte) (Math.random()*MAX_GOLES);
        byte golesVisitante = (byte) (Math.random()*MAX_GOLES);

        local.setGolesMarcados(golesLocal);
        local.setGolesRecibidos(golesVisitante);
        visitante.setGolesMarcados(golesVisitante);
        visitante.setGolesRecibidos(golesLocal);
    }

    public void jugarPartidoPonderada() {
        // El que tiene mas puntos en la clasificacion tiene 50% mas de probabilidades de marcar mas goles (o sea, que el otro tiene 50% menos)
        byte maxGolesLocal = mayorPuntuacion == local? MAX_GOLES : MAX_GOLES/2;
        byte maxGolesVisitante = mayorPuntuacion == visitante? MAX_GOLES : MAX_GOLES/2;

        // El local tiene el doble de posibilidades de marcar mas goles
        byte golesLocal1 = (byte) (Math.random()*maxGolesLocal);
        byte golesLocal2 = (byte) (Math.random()*maxGolesLocal);
        byte golesLocal = golesLocal1 > golesLocal2? golesLocal1 : golesLocal2;

        byte golesVisitante = (byte) (Math.random()*maxGolesVisitante);


        local.setGolesMarcados(golesLocal);
        local.setGolesRecibidos(golesVisitante);
        visitante.setGolesMarcados(golesVisitante);
        visitante.setGolesRecibidos(golesLocal);
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }
}

class Equipo {
    private String nombre;
    private byte puntuacionLiga;
    private byte golesMarcados;
    private byte golesRecibidos;

    Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntuacionLiga(byte puntuacionLiga) {
        this.puntuacionLiga = puntuacionLiga;
    }

    public byte getPuntuacionLiga() {
        return puntuacionLiga;
    }

    public void setGolesMarcados(byte golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public byte getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesRecibidos(byte golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public byte getGolesRecibidos() {
        return golesRecibidos;
    }
}

class TestPartido {
    public static void main(String[] args) {
        Equipo local = new Equipo("Los Pepes");
        Equipo visitante = new Equipo("Pingones");
        PartidoFutbolA7 partido1 = new PartidoFutbolA7(local, visitante);
        partido1.jugarPartido();

    }
}
