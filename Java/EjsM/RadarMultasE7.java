package damClase.EjsM;

public class RadarMultasE7 {
    private TramoE7 tramo = new TramoE7(120, 10);
    private Object[][] sanciones = new Object[20][4];
    private final static int[] MULTAS = {100,300,400,500,600};
    private final static int[] PUNTOS = {0,2,4,6,6};
    private int sancionesCounter = 0;

    private Object[][] calcularSanciones(RadarE7 rad1, RadarE7 rad2) {
        String m1;
        String m2;
        long vel;
        long tiempo;

        for (int i = 0; i < rad1.getVehiculos().length; i++) {
            m1 = rad1.getVehiculos()[i].getMatricula();
            for (int j = 0; j < rad2.getVehiculos().length; j++) {
                m2 = rad2.getVehiculos()[j].getMatricula();
                if (m1.equals(m2)) {
                    tiempo = rad2.getVehiculos()[j].getTiempoPaso() - rad1.getVehiculos()[i].getTiempoPaso();
                    vel = tramo.getDistancia()/tiempo;

                    if (vel > tramo.getVelMax()) {
                        int[] multaAndPtos = calcularMultaAndPuntos(vel, tramo.getVelMax());
                        int multa = multaAndPtos[0];
                        int ptos = multaAndPtos[1];
                        addSancion(new Object[]{m1,vel,ptos,multa});
                    }
                }
            }
        }

        return sanciones;
    }

    private int[] calcularMultaAndPuntos(long vel, int velMax) {
        int[] multaAndPtos = new int[2];

        if (velMax >= 60) {
            if (velMax + 30 <= vel) {
                multaAndPtos[0] = MULTAS[0];
                multaAndPtos[1] = PUNTOS[0];
            }else if (velMax + 50 <= vel) {
                multaAndPtos[0] = MULTAS[1];
                multaAndPtos[1] = PUNTOS[1];
            }else if (velMax + 60 <= vel) {
                multaAndPtos[0] = MULTAS[2];
                multaAndPtos[1] = PUNTOS[2];
            }else if (velMax + 70 <= vel) {
                multaAndPtos[0] = MULTAS[3];
                multaAndPtos[1] = PUNTOS[3];
            }else if (vel > velMax + 70) {
                multaAndPtos[0] = MULTAS[4];
                multaAndPtos[1] = PUNTOS[4];
            }
        }
        return multaAndPtos;
    }


    public void addSancion(Object[] o) {
        sanciones[sancionesCounter]=o;
    }

    public TramoE7 getTramo() {
        return tramo;
    }

    public static void main(String[] args) throws InterruptedException {
        RadarMultasE7 rme7 = new RadarMultasE7();
        TramoE7 t1 = rme7.getTramo();

        VehiculoE7 v1 = new VehiculoE7("11111111");
        VehiculoE7 v2 = new VehiculoE7("2222222");
        VehiculoE7 v3 = new VehiculoE7("33333");
        VehiculoE7 v4 = new VehiculoE7("44444444");
        VehiculoE7 v5 = new VehiculoE7("55555555");

        t1.getRadar1().addVehiculo(v1);
        t1.getRadar1().addVehiculo(v2);
        t1.getRadar1().addVehiculo(v3);
        t1.getRadar1().addVehiculo(v4);
        t1.getRadar1().addVehiculo(v5);

        System.out.println(System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println(System.currentTimeMillis());

        t1.getRadar2().addVehiculo(v2);
        t1.getRadar2().addVehiculo(v3);
        t1.getRadar2().addVehiculo(v4);

        Object[][] sanciones = rme7.calcularSanciones(t1.getRadar1(), t1.getRadar2());
        String sancionesStr = "";

        for (int i = 0; i < sanciones.length; i++) {
            for (int j = 0; j < sanciones[i].length; j++) {
                sancionesStr += sanciones[i][j];
            }
        }

        System.out.println(sancionesStr);
    }
}

class TramoE7 {
    private RadarE7 radar1 = new RadarE7();
    private RadarE7 radar2 = new RadarE7();
    private int velMax;
    private int distancia;

    public TramoE7(int velMax, int distancia) {
        this.velMax = velMax;
        this.distancia = distancia;
    }

    public RadarE7 getRadar1() {
        return radar1;
    }

    public RadarE7 getRadar2() {
        return radar2;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getVelMax() {
        return velMax;
    }
}

class RadarE7 {
    private VehiculoE7[] vehiculos = new VehiculoE7[0];

    public void addVehiculo(VehiculoE7 v) {
        v.updateTiempoPaso();

        if (vehiculos.length > 0) {
            VehiculoE7[] vehiculosCopia = new VehiculoE7[vehiculos.length];
            for (int i = 0; i < vehiculos.length; i++) {
                vehiculosCopia[i] = vehiculos[i];
            }

            vehiculos = new VehiculoE7[vehiculos.length + 1];

            for (int i = 0; i < vehiculosCopia.length; i++) {
                vehiculos[i] = vehiculosCopia[i];
            }
            vehiculos[vehiculos.length - 1] = v;
        } else {
            vehiculos = new VehiculoE7[vehiculos.length + 1];
            vehiculos[0] = v;
        }
    }

    public VehiculoE7[] getVehiculos() {
        return vehiculos;
    }
}

class VehiculoE7 {
    private String matricula;
    private long tiempoPaso = (System.currentTimeMillis());

    public VehiculoE7(String matricula) {
        this.matricula = matricula;
    }

    void updateTiempoPaso() {
        tiempoPaso = (System.currentTimeMillis());
    }

    public String getMatricula() {
        return matricula;
    }

    public long getTiempoPaso() {
        return tiempoPaso;
    }
}