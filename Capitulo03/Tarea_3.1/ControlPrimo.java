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
public class ControlPrimo {

  public static void main (String args[]) {
    
    int x = Terminal.leeEntero("Por favor, introduzca un número entero positivo: ");
    Numero num = new Numero(x);
    
    if (num.esPrimo()) {
      Terminal.imprimeMensaje("El número introducido es primo.\n");
    } else {
      Terminal.imprimeMensaje("El número introducido no es primo.\n");
    }
  }
}
