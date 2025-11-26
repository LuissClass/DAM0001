package DAM1;
import java.io.IOException;

public class FraccionC2 {
  int num;
  int den;
  FraccionC2(int num, int den){
    this.num = num;
    this.den = den;
  }

  FraccionC2(){}

    void mostrar (){
    System.out.println(num+"/"+den);
  }

  FraccionC2 multiplicar(FraccionC2 fraccion){
    FraccionC2 fResMul = new FraccionC2();
    fResMul.num = this.num*fraccion.num;
    fResMul.den = this.den*fraccion.den;
    return fResMul;
  }

  void multiplicar2num(FraccionC2 fraccion1, FraccionC2 fraccion2){
      this.num = fraccion1.num * fraccion2.num;
      this.den = fraccion1.den * fraccion2.den;
  }

  FraccionC2 dividir(FraccionC2 fraccion){
      FraccionC2 fResDiv = new FraccionC2();
      fResDiv.num = num * fraccion.num;
      fResDiv.den = den * fraccion.den;
      return fResDiv;
  }

  void dividr2num(FraccionC2 fraccion1, FraccionC2 fraccion2) {
      this.num = fraccion1.num * fraccion2.den;
      this.den = fraccion1.den * fraccion2.num;
  }

  FraccionC2 suma(FraccionC2 fraccion){
      FraccionC2 fResSum = new FraccionC2();
      fResSum.num = (num * fraccion.den) + (fraccion.num * den);
      fResSum.den = den * fraccion.den;
      return fResSum;
  }

  void sumar2num(FraccionC2 fraccion1, FraccionC2 fraccion2){
      num = (fraccion1.num * fraccion2.den) + (fraccion2.num * fraccion1.den);
      den = fraccion1.den * fraccion2.den;
  }

    FraccionC2 resta(FraccionC2 fraccion){
        FraccionC2 fResRest = new FraccionC2();
        fResRest.num = (num * fraccion.den) - (fraccion.num * den);
        fResRest.den = den * fraccion.den;
        return fResRest;
    }

    void restar2num(FraccionC2 fraccion1, FraccionC2 fraccion2){
        num = (fraccion1.num * fraccion2.den) - (fraccion2.num * fraccion1.den);
        den = fraccion1.den * fraccion2.den;
    }

    FraccionC2 reducir() {
      int counter = 2;

      do {
          if (num % counter == 0 && den % counter == 0) {
              num /= counter;
              den /= counter;
              counter = 2;
          } else {
              counter++;
          }
      } while (num > counter || den > counter);
      return new FraccionC2(num, den);
    }

  public static void main(String[] args) throws IOException {
    // METODO REDUCCION
    FraccionC2 fraccionPro = new FraccionC2(2,10);
      System.out.println("REDUCCION DE FRACCION: ");
      fraccionPro.reducir().mostrar();
  }
}
