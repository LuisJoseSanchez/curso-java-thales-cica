/*
 * Tarea 7. Gestión de diccionarios
 */
package tarea7;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarea7 {

  public static void main(String[] args) {
    ArrayList<Diccionario> lexico = new ArrayList<>();

    // Precarga del léxico con diccionarios que, a su vez, contienen términos
    
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
    
    System.out.println("Bienvenido al programa de gestión de léxico.");
    System.out.println("Para su comodidad se han precargado varios diccionarios con sus correspondientes términos.");
    System.out.println("Pulse [INTRO] para continuar.");
    
    Scanner s = new Scanner(System.in);
    s.nextLine();
    
    int identificador;
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

        case 1: // Crear diccionario ///////////////////////////////////////////////////////////////
          System.out.println("\n\nCREAR DICCIONARIO\n=============");
          System.out.println("De forma opcional puede introducir una descripción para el nuevo ");
          System.out.println("diccionario, por ej. \"Vocabulario básico de alemán\".");
          System.out.println("Si no quiere una descripción, simplemente pulse [INTRO]");
          System.out.print("Descripción: ");
          String descripcion = s.nextLine();
          lexico.add(new Diccionario(descripcion));
          break;
          
        case 2: // Gestionar diccionarios //////////////////////////////////////////////////////////
          System.out.println("\n\nGESTIONAR DICCIONARIOS\n================");

          System.out.print("\nPor favor, introduzca el identificador del diccionario que quiere gestionar: ");
          identificador = Integer.parseInt(s.nextLine());

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
            do {
              System.out.print("\n\nGESTIÓN DEL DICCIONARIO " + diccionarioGestionado.getIdentificador());
              System.out.println(" (" + diccionarioGestionado.getDescripcion() + ")");
              System.out.println("1. Añadir un término");
              System.out.println("2. Borrar un término");
              System.out.println("3. Consultar un término");
              System.out.println("4. Listar todos los términos");
              System.out.println("5. Salir de la gestión del diccionario");
              System.out.print("Introduzca una opción: ");
              opcion2 = Integer.parseInt(s.nextLine());

              switch (opcion2) {
                case 4:
                  break;
                  
                default:
                  
              }
            } while (opcion2 != 5);
          } // else
          
          break;
        
        case 3: // Listado de diccionarios
          System.out.println("\n\nLISTADO DE DICCIONARIOS\n=======================");
             
          for (Diccionario d : lexico) {
            System.out.println(d);
          }

          break;
                    
        case 4: // Borrar diccionario
          System.out.println("\n\nBORRAR DICCIONARIO\n===========================");
          
          System.out.print("\nPor favor, introduzca el identificador del diccionario: ");
          identificador = Integer.parseInt(s.nextLine());
          
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
          
          break;
              
        default:

      } // switch    
    } while (opcion != 5);
  }
  
}
