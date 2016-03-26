/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/ColegioSC.java                 *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de clases de un colegio           *
 * @version C                                *
 * @author Jose F. Quesada                   */

class ColegioSC {
  public static void main (String args[]) {
    System.out.println
        ("Sistema Colegio S.C.");

    int operacion;
    do {
       System.out.println();
       System.out.println("[1] Crear una clase nueva");
       System.out.println("[2] Gestión de una clase");
       System.out.println("[3] Borrar una clase");
       System.out.println("[4] Listado de las clases creadas");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) ||
		  (operacion > 4));
         System.out.println();
         if (operacion == 1)
            crearClase();
         else if (operacion == 2)
            gestionClase();
         else if (operacion == 3)
            borrarClase();
         else if (operacion == 4)
            ClaseSC.listarClases();
      } while (operacion != 0);
   }

  private static void crearClase() {
    System.out.println("CREACION DE UNA CLASE:");

    int codigo;
    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             (ClaseSC.buscarClase(codigo) != null)); 
      
    String nombre = Terminal.leeCadena("NOMBRE?: ");

    new ClaseSC(codigo,nombre);
  }

  private static void gestionClase() {
    System.out.println("ACCESO A LA GESTION DE UNA CLASE");

    int codigo;
    ClaseSC clase;

    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             ((clase = ClaseSC.buscarClase(codigo)) == null)); 
      
    clase.gestionClase();
  }

  private static void borrarClase() {
    System.out.println("BORRAR UN CLASE");

    int codigo;

    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             (ClaseSC.buscarClase(codigo) == null)); 
      
    ClaseSC.borrarClase(codigo);
  }
}

/******** Fin de ColegioSC.java ****************/
