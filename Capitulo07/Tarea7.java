/*
 * Tarea 7. Gestión de diccionarios
 */
package tarea7;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarea7 {
  
  static ArrayList<Diccionario> lexico = new ArrayList<>();
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    cargaDatos(); // carga el contenido inicial del léxico
    
    System.out.println("Bienvenido al programa de gestión de léxico.");
    System.out.println("Para su comodidad se han precargado varios diccionarios con sus correspondientes términos.");
    System.out.println("Pulse [INTRO] para continuar.");
    s.nextLine();
    
    int opcion;
    int opcion2;

    // Menú
    do {
      System.out.println("\n\nGESTIÓN DE LÉXICO\n=================");
      System.out.println("1. Crear diccionario");
      System.out.println("2. Gestionar diccionarios");
      System.out.println("3. Listado de diccionarios");
      System.out.println("4. Borrar diccionario");
      System.out.println("5. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = Integer.parseInt(s.nextLine());
      
      switch (opcion) {

        case 1:
          creaDiccionario();
          break;
          
        case 2: // Gestionar diccionarios //////////////////////////////////////////////////////////
          System.out.println("\n\nGESTIONAR DICCIONARIOS\n======================");
          
          listaDiccionarios(); // Se listan primero los diccionarios existentes
          
          System.out.print("\nPor favor, introduzca el identificador del diccionario que quiere gestionar: ");
          int identificador = Integer.parseInt(s.nextLine());

          Diccionario diccionarioGestionado = (Diccionario) null;
          
          boolean existeDiccionario = false;
          
          for (Diccionario d : lexico) {
            if (d.getIdentificador() == identificador) {
              diccionarioGestionado = d;
              existeDiccionario = true;
            }
          }
          
          if (!existeDiccionario) {
            System.out.println("No se ha encontrado ningún diccionario con ese identificador.");
          } else {
            (new GestionDiccionario(diccionarioGestionado)).iniciaGestionDiccionario();
          }
          
          break;
        
        case 3:
          listaDiccionarios("\n\nLISTADO DE DICCIONARIOS\n=======================");
          break;
                    
        case 4: // Borrar diccionario
          borraDiccionario();
          break;
              
        default:

      } // switch    
    } while (opcion != 5);
  } // main ///////////////////////////////////////////////////////////////////
  
  
  /**
   * Carga el léxico con diccionarios que, a su vez, contienen términos.
   */
  public static void cargaDatos() {
    // Diccionario de español
    Diccionario d1 = new Diccionario("Diccionario de español");
    d1.agregaTermino(new Termino("perros", "perro", "animal de compañía que protege la casa"));
    d1.agregaTermino(new Termino("perruno", "perro", "relativo al perro"));
    d1.agregaTermino(new Termino("solar", "sol", "astro rey"));
    d1.agregaTermino(new Termino("comeré", "comer", "en el futuro ingeriré alimentos"));
    d1.agregaTermino(new Termino("caras", "cara", "es el espejo del alma"));
    lexico.add(d1);
    
    // Diccionario de inglés
    Diccionario d2 = new Diccionario("Diccionario de inglés");
    d2.agregaTermino(new Termino("to come", "come", "venir"));
    d2.agregaTermino(new Termino("cars", "car", "coche"));
    lexico.add(d2);    
  }
  
  /**
   * Crea un nuevo diccionario. El identificador se establece de forma automática.
   * Opcionalmente, el usuario puede dar una descripción para el diccionario.
   */
  public static void creaDiccionario() {
    System.out.println("\n\nCREAR DICCIONARIO\n=============");
    System.out.println("De forma opcional puede introducir una descripción para el nuevo ");
    System.out.println("diccionario, por ej. \"Vocabulario básico de alemán\".");
    System.out.println("Si no quiere una descripción, simplemente pulse [INTRO]");
    System.out.print("Descripción: ");
    String descripcion = s.nextLine();
    lexico.add(new Diccionario(descripcion));
  }
  
  /**
   * Muestra un listado con todos los diccionarios que hay en el lexico.
   */
  public static void listaDiccionarios() {
    
    for (Diccionario d : lexico) {
      System.out.println(d);
    }
  }
  
   /**
   * Muestra un listado de diccionarios con un título.
   * 
   * @param titulo título que se muestra antes del listado 
   */
  public static void listaDiccionarios(String titulo) {
    System.out.println(titulo);
    listaDiccionarios();
  }
  
  /**
   * Borra un diccionario pidiendo su identificador.
   * Si el usuario introduce un identificado que no existe, muestra un mensaje de error.
   */
  public static void borraDiccionario() {
    System.out.println("\n\nBORRAR DICCIONARIO\n===========================");

    System.out.print("\nPor favor, introduzca el identificador del diccionario: ");
    int identificador = Integer.parseInt(s.nextLine());

    int posicion = -1;

    for (int i = 0; i < lexico.size(); i++) {
      if (lexico.get(i).getIdentificador() == identificador) {
        posicion = i;
      }
    }

    if (posicion == -1) {
      System.out.println("No se ha encontrado ningún diccionario con ese identificador.");
    } else {
      lexico.remove(posicion);
      System.out.println("Diccionario borrado correctamente.");
    }
  }
  
          
}
