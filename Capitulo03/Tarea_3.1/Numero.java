/**
 * Tarea 3.1: Primo
 * 
 * Implementar una clase que permita recibir un número y determine si el número
 * es primo o no. Analizar cuál es el modelo más adecuado de implementación a
 * nivel de clase y métodos.
 * 
 * @author Luis José Sánchez
 * @version 27 de febrero de 2016
 */
public class Numero {
  
  private int n;

  public Numero() {
    n = 0;
  }

  public Numero(int inicial) {
    n = inicial;
  }
  
  /**
   * Comprueba si un número entero positivo es primo o no.
   * Un número es primo cuando únicamente es divisible entre
   * él mismo y la unidad.
   * 
   * @return  <code>true</code> si el número es primo
   * @return  <code>false</code> en caso contrario
   */
  public boolean esPrimo() {
    
    for (int i = 2; i < n / 2; i++) {
      if ((n % i) == 0) {
        return false;
      }
    }
    
    return true;
  }
}
