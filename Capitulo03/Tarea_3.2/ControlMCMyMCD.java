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
public class ControlMCMyMCD {

  public static void main (String args[]) {
    
    int x = Terminal.leeEntero("\nPor favor, introduzca un número entero positivo: ");
    int y = Terminal.leeEntero("\nIntroduzca otro número: ");
   
    Terminal.imprimeMensaje("El mínimo común múltiplo es " + MCMyMCD.mcm(x, y) + "\n");
    Terminal.imprimeMensaje("El máximo común divisor es " + MCMyMCD.mcd(x, y) + "\n");
  }
}