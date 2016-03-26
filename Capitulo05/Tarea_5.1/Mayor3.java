/*
 * Mayor3.java
 * 
 * Copyright 2016 Luis José Sánchez
 * 
 * Tarea 5.1: Mayor3
 * 
 * Se debe construir una clase denominada mayor3 en un fichero de nombre: mayor3.java que lea tres
 * números enteros y a continuación escriba el mayor, utilizando la construcción if.
 */

public class Mayor3 {
  
  public static void main (String args[]) {
    
    int aux;
        
    System.out.println("Este programa ordena tres números introducidos por teclado.");
    System.out.println("Por favor, vaya introduciendo los tres números y pulsando INTRO:");
    int a = Terminal.leeEntero("");
    int b = Terminal.leeEntero("");
    int c = Terminal.leeEntero("");

    // ordenación de los dos primeros números
    if (a > b) {
      aux = a;
      a = b;
      b = aux;
    }
    
    // ordenación de los dos últimos números
    if (b > c) {
      aux = b;
      b = c;
      c = aux;
    }
    
    // se vuelven a ordenar los dos primeros
    if (a > b) {
      aux = a;
      a = b;
      b = aux;
    }
        
    System.out.println("Los números introducidos ordenados de menor a mayor son " + a + ", " + b + " y " + c + ".");
  }
}

