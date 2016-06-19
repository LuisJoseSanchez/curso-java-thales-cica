/*
 * Tarea 10: Librería matemática funcional
 *
 *  Luis José Sánchez
 */

import Sistema.Terminal;

public class Tarea10 {
  
  // saco la definición de lista fuera del main para que la vea la función que imprime dicha lista
  public static ListaNumerica<Integer> lista = new ListaNumerica<>();
  
  public static void main(String[] args) {
    int numero = Terminal.leeEntero("Introduzca un número: ");
    
    // primo
    if (LibreriaMatematica.esPrimo.calcula(numero)) {
      System.out.println("El " + numero + " es primo.");
    } else {
      System.out.println("El " + numero + " no es primo.");
    }
    
    // raiz cuadrada
    System.out.println("La raiz cuadrada de " + numero + " es " + LibreriaMatematica.raizCuadrada.calcula(numero));
    
    // lista numérica
    System.out.println("\nLista numérica");
    System.out.println("Se añaden los elementos 4, 6, 11, 20");
    lista.agrega(4);
    lista.agrega(6);
    lista.agrega(11);
    lista.agrega(20);
    muestraLista();
    System.out.println("Se inserta el 33 en la posición 0");
    lista.inserta(33, 0);
    muestraLista();
    System.out.println("Se inserta el 44 en la posición 3");
    lista.inserta(44, 3);
    muestraLista();
    System.out.println("Muestra el elemento de la posición 4");
    System.out.println(lista.elementoEn(4));
    System.out.println("Borra el elemento de la posición 2");
    lista.borra(2);
    muestraLista();
  }
  
  public static void muestraLista() {
    System.out.print("| Lista |> ");
    for (int elemento : lista) {
      System.out.print(" " + elemento);
    }
    System.out.println();
  }
}
