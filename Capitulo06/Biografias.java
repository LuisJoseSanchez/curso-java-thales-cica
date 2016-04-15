/**
 * Tarea 6: Fichas biográficas
 *
 * @author Luis José Sánchez
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Biografias {
  public static void main(String[] args) {

    ArrayList<Persona> bio = new ArrayList<>();

    // Personas precargadas
    bio.add(new Persona("Albert Einstein", 1879, 1955, "Física"));
    bio.add(new Persona("Isaac Newton", 1642, 1726, "Física"));
    bio.add(new Persona("Blas Cabrera y Felipe", 1878, 1945, "Física"));
    bio.add(new Persona("Santiago Ramón y Cajal", 1852, 1934, "Medicina"));
    bio.add(new Persona("Miguel de Cervantes Saavedra", 1547, 1616, "Literatura"));
    bio.add(new Persona("Federico García Lorca", 1898, 1936, "Literatura"));
    bio.add(new Persona("Salvador Dalí", 1904, 1989, "Pintura"));
    bio.add(new Persona("Pablo Ruiz Picasso", 1881, 1973, "Pintura"));
    bio.add(new Persona("Grigori Perelmán", 1966, 0, "Matemáticas"));
    bio.add(new Persona("Terence Tao", 1975, 0, "Matemáticas"));
    
    System.out.println("Bienvenido al programa de gestión de fichas biográficas.");
    System.out.println("Para su comodidad se han precargado los datos de 10 personas.");
    System.out.println("Pulse [INTRO] para continuar.");
    
    Scanner s = new Scanner(System.in);
    s.nextLine();
    
    String nombre;
    int nacimiento;
    int defuncion;
    String conocimiento;

    int opcion;
    int i;

    // Menú
    do {
      System.out.println("\n\nFICHAS BIOGRÁFICAS");
      System.out.println("==================");
      System.out.println("1. Nueva persona");
      System.out.println("2. Borrar persona");
      System.out.println("3. Listado completo");
      System.out.println("4. Listado por área de conocimiento");
      System.out.println("5. Listado de personas coetáneas a una dada");
      System.out.println("6. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = Integer.parseInt(s.nextLine());
      
      switch (opcion) {

        case 1: // Nueva persona
          System.out.println("\n\nNUEVA PERSONA\n=============");
          System.out.println("Por favor, introduzca los datos de la persona.");
          System.out.print("Nombre completo: ");
          nombre = s.nextLine();        
          System.out.print("Año de nacimiento: ");
          nacimiento = Integer.parseInt(s.nextLine());      
          System.out.print("Año de defunción (0 si la persona está viva): ");
          defuncion = Integer.parseInt(s.nextLine());      
          System.out.print("Área de conocimiento: ");
          conocimiento = s.nextLine();

          bio.add(new Persona(nombre, nacimiento, defuncion, conocimiento));
          break;
          
        case 2: // Borrar persona
          System.out.println("\n\nBORRAR PERSONA\n==============");

          for (i = 0; i < bio.size(); i++) {
            System.out.println((i + 1) + " " + bio.get(i));
          }

          System.out.print("\nPor favor, introduzca el número de la persona que desea borrar: ");
          i = Integer.parseInt(s.nextLine());

          bio.remove(i - 1);
          break;
        
        case 3: // Listado completo
          System.out.println("\n\nLISTADO COMPLETO\n================");
             
          for (Persona p : bio) {
            System.out.println(p);
          }

          break;
                    
        case 4: // Listado por área de conocimiento
          System.out.println("\n\nLISTADO POR ÁREA DE CONOCIMIENTO\n================================");
          
          // Obtiene todas las áreas de conocimiento
          ArrayList<String> listaConocimiento = new ArrayList<>();
          
          for (Persona p : bio) {
            if (!listaConocimiento.contains(p.getConocimiento())) {
              listaConocimiento.add(p.getConocimiento());
            }
          }
          
          // Pide el área de conocimiento 
          for (i = 0; i < listaConocimiento.size(); i++) {
            System.out.println((i + 1) + " " + listaConocimiento.get(i));
          }

          System.out.print("\nPor favor, introduzca el número del área de conocimiento: ");
          i = Integer.parseInt(s.nextLine());
          
          // Listado
          for (Persona p : bio) {
            if (p.getConocimiento().equals(listaConocimiento.get(i - 1))) {
              System.out.println(p);
            }
          }
          
          break;
              
        case 5: // Listado de personas coetáneas a una dada
          
          System.out.println("\n\nLISTADO DE PERSONAS COETÁNEAS A UNA DADA");
          System.out.println("========================================");
          // Obtiene todos los nombres
          ArrayList<String> listaNombre = new ArrayList<>();
          
          for (Persona p : bio) {
            listaNombre.add(p.getNombre());
          }
          
          // Pide el área de conocimiento 
          for (i = 0; i < listaNombre.size(); i++) {
            System.out.println((i + 1) + " " + listaNombre.get(i));
          }
          System.out.print("\nPor favor, introduzca el número de persona de la que quiere saber los coetáneos: ");
          i = Integer.parseInt(s.nextLine());
          
          Persona personaAux = bio.get(i - 1);
          
          // Listado
          System.out.println("\nLos coetáneos de " + personaAux.getNombre() + " son: ");
          for (Persona p : bio) {
            if (p.esCoetaneoDe(personaAux)) {
              System.out.println(p);
            }
          }
          break;
  
        default:

      } // switch    
    } while (opcion != 6);
  }
}
