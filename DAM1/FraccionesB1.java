import java.io.IOException;

public class FraccionesB1 {
    int num;
    int den;
    FraccionesB1(int num, int den){
        this.num = num;
        this.den = den;
    }

    FraccionesB1(){}

    void mostrar (){
        System.out.println(num+"/"+den);
    }

    FraccionesB1 multiplicar(FraccionesB1 fraccion){
        FraccionesB1 fResMul = new FraccionesB1();
        fResMul.num = this.num*fraccion.num;
        fResMul.den = this.den*fraccion.den;
        return fResMul;
    }

    void multiplicar2num(FraccionesB1 fraccion1, FraccionesB1 fraccion2){
        this.num = fraccion1.num * fraccion2.num;
        this.den = fraccion1.den * fraccion2.den;
    }

    FraccionesB1 dividir(FraccionesB1 fraccion){
        FraccionesB1 fResDiv = new FraccionesB1();
        fResDiv.num = num * fraccion.num;
        fResDiv.den = den * fraccion.den;
        return fResDiv;
    }

    void dividr2num(FraccionesB1 fraccion1, FraccionesB1 fraccion2) {
        this.num = fraccion1.num * fraccion2.den;
        this.den = fraccion1.den * fraccion2.num;
    }

    FraccionesB1 suma(FraccionesB1 fraccion){
        FraccionesB1 fResSum = new FraccionesB1();
        fResSum.num = (num * fraccion.den) + (fraccion.num * den);
        fResSum.den = den * fraccion.den;
        return fResSum;
    }

    void sumar2num(FraccionesB1 fraccion1, FraccionesB1 fraccion2){
        num = (fraccion1.num * fraccion2.den) + (fraccion2.num * fraccion1.den);
        den = fraccion1.den * fraccion2.den;
    }

    FraccionesB1 resta(FraccionesB1 fraccion){
        FraccionesB1 fResRest = new FraccionesB1();
        fResRest.num = (num * fraccion.den) - (fraccion.num * den);
        fResRest.den = den * fraccion.den;
        return fResRest;
    }

    void restar2num(FraccionesB1 fraccion1, FraccionesB1 fraccion2){
        num = (fraccion1.num * fraccion2.den) - (fraccion2.num * fraccion1.den);
        den = fraccion1.den * fraccion2.den;
    }

    FraccionesB1 esMayorQue(FraccionesB1 fraccion) {
        int num1 = num;
        int num2 = fraccion.num;

        num1 *= fraccion.den;
        num2 *= den;

        if (num1 > num2) {
            return this;
        }
        return fraccion;
    }

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce los datos de la primera fraccion:");
        System.out.print("Numerador = ");
        int n1 = t.leerInt();
        System.out.print("Denominador = ");
        int d1 = t.leerInt();
        FraccionesB1 f1 = new FraccionesB1(n1,d1);
        f1.mostrar();
        System.out.println("-------------------------------------------");

        System.out.println("Introduce los datos de la segunda fraccion:");
        System.out.print("Numerador = ");
        int n2 = t.leerInt();
        System.out.print("Denominador = ");
        int d2 = t.leerInt();
        FraccionesB1 f2 = new FraccionesB1(n2,d2);
        f2.mostrar();
        System.out.println("-------------------------------------------");

        FraccionesB1 fmul = f1.multiplicar(f2);
        fmul.mostrar();

        FraccionesB1 fdiv = new FraccionesB1();
        fdiv.dividr2num(f1,f2);
        fdiv.mostrar();

        FraccionesB1 fsum = f1.suma(f2);
        fsum.mostrar();

        FraccionesB1 frest = new FraccionesB1();
        frest.restar2num(f1,f2);
        frest.mostrar();

        System.out.println("\nf1: ");
        f1.mostrar();
        System.out.println("f2: ");
        f2.mostrar();
        System.out.println("El mas grande es: ");
        (f1.esMayorQue(f2)).mostrar();
    }
}
