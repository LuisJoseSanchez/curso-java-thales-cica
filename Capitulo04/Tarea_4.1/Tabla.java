/**
 * Tarea 4.1: Tabla de multiplicar
 * 
 * Se debe escribir un programa java denominado tabla.java
 * 
 * En este caso, el programa leerá un número (llamémosle N), y escribirá la tabla
 * de multiplicar de N.
 * 
 * Por ejemplo:
 * 
 * Tabla de multiplicar:
 * Indique un número: 2
 * 2 * 0 = 0
 * 2 * 1 = 2
 * 2 * 2 = 4
 * ...
 * 2 * 10 = 20
 * 
 * @author Luis José Sánchez
 * @version 28 de febrero de 2016
 */
public class Tabla {

  public static void main (String args[]) {

    int n = Terminal.leeEntero("\nTabla de multiplicar\nIndique un número:");
  
    for (int i = 0; i <= 10; i++) {
      Terminal.imprimeMensaje(n + " * " + i + " = " + n * i + "\n");
    }
  }
}
