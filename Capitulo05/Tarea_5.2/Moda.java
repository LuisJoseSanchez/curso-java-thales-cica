/*
 * Moda.java
 * 
 * Copyright 2016 Luis José Sánchez
 * 
 * Tarea 5.2: Moda Estadística
 * 
 * Se define la moda estadística como el valor con una mayor frecuencia en una distribución de
 * datos.
 * 
 * Por ejemplo, dada la siguiente secuencia de datos:
 * 
 * 5, 2, 3, 5, 2, 1, 3, 5, 1, 5
 * 
 * Podemos observar que el 1 tiene una frecuencia absoluta de 2 (aparece dos veces en la serie), el
 * 2 tiene una frecuencia de 2, el 3 una frecuencia de 2 y el 5 una frecuencia de 4.
 * 
 * Por tanto la moda de esta distribución es el valor 5.
 * 
 * Se debe construir una clase en java denominada Moda (fichero moda.java), que permita leer una
 * cantidad variable de datos (la serie terminará al introducir un valor negativo  y dicho valor no
 * formará parte de la serie como tal). Como resultado deberá escribir la tabla de frecuencias
 * absolutas, relativas y la moda.
 * 
 * Por ejemplo, para el caso anterior, el resultado sería:
 * 
 * Valor - FA - FR
 * 
 * 1 - 2 - 20%
 * 2 - 2 - 20%
 * 3 - 2 - 20%
 * 5 - 4 - 40%
 * 
 * Moda: 5
 * 
 * (En este caso, las frecuencias relativas han sido fáciles de calcular ya que el total de datos
 * en la serie ha sido 10).
 */

public class Moda {
  
  public static void main (String args[]) {

    System.out.println("Este programa calcula la moda");
    System.out.println("Por favor, vaya introduciendo números y pulsando INTRO.");
    System.out.println("Para terminar, introduzca un número negativo.");
    
    int n;
    
    do {
      n = Terminal.leeEntero("");
      if (Dato.buscarDato(n) == null) { // si no existe el número, se crea
        new Dato(n);
      } else { // si ya existe, se incrementa la cuenta de repeticiones
        Dato.buscarDato(n).incrementaRepeticiones();
      }
    } while (n >= 0);
    
    // el último número no nos interesa, solo se usa para terminar la introducción de números
    Dato.borrarDato(n);

    System.out.println("Valor - FA - FR\n");
    
    Dato.listarDatos();
  }
}

