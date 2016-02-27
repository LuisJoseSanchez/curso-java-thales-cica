/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo02/Control.java                   *
 *********************************************/

 /**
 * Esta clase lleva a cabo el control de todo
 * el sistema 
 * @author Jose F. Quesada
 */

class Control {
   public static void main (String args[]) {
      Contenedor contenedor = new 
		Contenedor("Contenedor Numero 1",
			   1000,
			   0,
			   "");
      int operacion = 0;

      System.out.println("ESTADO INICIAL:");
      System.out.println(contenedor);
      System.out.println("MODULO DE OPERACION:");
      do {
         System.out.print("  Contenedor: \n" + 
			contenedor);
         System.out.println("[1] Llenar");
         System.out.println("[2] Vaciar");
         System.out.println("[0] Salir");
         do {
            operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) ||
		  (operacion > 2));
         if (operacion == 1)
            contenedor.llenarContenedor();
         else if (operacion == 2)
            contenedor.vaciarContenedor();
      } while (operacion != 0);
   }
}

/******** Fin de Control.java ****************/
