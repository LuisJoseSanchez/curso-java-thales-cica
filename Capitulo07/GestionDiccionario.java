/*
 *
 */
package tarea7;

import java.util.Scanner;

public class GestionDiccionario {
  
  static Diccionario diccionario;

  public GestionDiccionario(Diccionario d) {
    diccionario = d;
  }
  
  public static void iniciaGestionDiccionario() {
    int opcion;
    
    do {
      System.out.print("\n\nGESTIÓN DEL DICCIONARIO " + diccionario.getIdentificador());
      System.out.println(" (" + diccionario.getDescripcion() + ")");
      System.out.println("1. Añadir un término");
      System.out.println("2. Borrar un término");
      System.out.println("3. Consultar un término");
      System.out.println("4. Listar todos los términos");
      System.out.println("5. Salir de la gestión del diccionario");
      System.out.print("Introduzca una opción: ");
      Scanner s = new Scanner(System.in);
      opcion = Integer.parseInt(s.nextLine());

      switch (opcion) {
        case 1:
          agregaTermino();
          break;
        
        case 3:
          consultaTermino();
          break;
          
        case 2:
          borraTermino();
          break;
          
        case 4:
          listaTerminos();
          break;

        default:

      }
    } while (opcion != 5);
  } // iniciaGestionDiccionario
    
  private static void agregaTermino() {
    System.out.println("\nAÑADIR UN TÉRMINO\n=================");
    Scanner s = new Scanner(System.in);
    System.out.print("Palabra: ");
    String palabra = s.nextLine();
    if (diccionario.contienePalabra(palabra)) {
      System.out.println("Esa palabra ya existe en el diccionario.");
    } else {
      System.out.print("Raiz: ");
      String raiz = s.nextLine();
      System.out.print("Descripción: ");
      String descripcion = s.nextLine();
      diccionario.agregaTermino(new Termino(palabra, raiz, descripcion));
    }
  }
  
  private static void borraTermino() {
    System.out.println("\nBORRAR UN TÉRMINO\n=================");
    Scanner s = new Scanner(System.in);
    System.out.print("Palabra del término que quiere borrar: ");
    String palabra = s.nextLine();
    if (!diccionario.contienePalabra(palabra)) {
      System.out.println("Esa palabra no existe en el diccionario.");
    } else {
      diccionario.borraTerminoPorPalabra(palabra);
      System.out.print("Término borrado correctamente.");
    }
  }
  
  private static void listaTerminos() {
    System.out.println();
    System.out.println(diccionario);
    for (Termino t : diccionario.getTerminos()) {
      System.out.println(t);
    }
  }
  
  private static void consultaTermino() {
    System.out.println("\nCONSULTAR UN TÉRMINO\n====================");
    Scanner s = new Scanner(System.in);
    System.out.print("Introduzca la palabra que quiere consultar: ");
    String palabra = s.nextLine();
    if (!diccionario.contienePalabra(palabra)) {
      System.out.println("Esa palabra no existe en el diccionario.");
    } else {
      System.out.print(diccionario.getTerminos().get(diccionario.getTerminos().indexOf(new Termino(palabra, "", ""))));
    }
  }
}
