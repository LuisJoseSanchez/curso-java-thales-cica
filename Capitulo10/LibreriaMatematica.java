/*
 * Tarea 10: Librería matemática funcional
 *
 *  Luis José Sánchez
 */


public class LibreriaMatematica {
  
  public static NumeroEntero esPrimo = (n) -> {
    for (int i = 2; i < n / 2; i++) {
      if ((n % i) == 0) {
        return false;
      }
    }
    return true;
  };

  public static NumeroReal raizCuadrada = (n) -> {
    final double ERROR_MAXIMO = 0.000000001;
    double raiz = n / 2;
    double incremento = raiz / 2;
    
    while (Math.abs((raiz * raiz) - n) > ERROR_MAXIMO) {
      if ((raiz * raiz) > n) { // me paso
        raiz -= incremento;
      } else { // no llego
        raiz += incremento;
      }
      incremento = incremento / 2;
    }
    
    return raiz;
  };
}
