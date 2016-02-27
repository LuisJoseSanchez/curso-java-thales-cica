/**
 * Tarea 3.2: MCM y MCD
 * 
 * Implementar una clase que al ser invocada (método main), nos pida por pantalla
 * dos números (enteros), y a continuación calcule y escriba el mínimo común
 * múltiplo y el máximo común divisor.
 * 
 * @author Luis José Sánchez
 * @version 27 de febrero de 2016
 */
public class MCMyMCD {

  /**
   * Calcula el mínimo común múltiplo de dos números
   * 
   * @param  x, y números enteros
   * @return      mínimo común múltiplo de x e y
   */
  public static int mcm(int x, int y) {
    int mayor = Math.max(x, y);
    
    do {
      if ((mayor % x == 0) && (mayor % y == 0)) {
        return mayor;
      }
      mayor++;
    } while (true);
  }

  /**
   * Calcula el máximo común divisor de dos números
   * 
   * @param  x, y números enteros
   * @return      máximo común divisor de x e y
   */
  public static int mcd(int x, int y) {
    int menor = Math.min(x, y);
    
    do {
      if ((x % menor == 0) && (y % menor == 0)) {
        return menor;
      }
      menor--;
    } while (true);
  }
}
