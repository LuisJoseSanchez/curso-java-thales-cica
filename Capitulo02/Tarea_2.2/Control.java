/******************************************************************************
 * Tarea 2.2                                                                  *
 * Curso de Programación en Java                                              *
 *                                                                            *
 * Añadimos al menú la opción de limpiar un contenedor.                       *
 *                                                                            *
 * El método limpiarContenedor() se define al final de la clase Contenedor.   *
 ******************************************************************************/

 /**
 * Esta clase lleva a cabo el control de todo
 * el sistema 
 * @author Jose F. Quesada
 * @author Luis José Sánchez
 * @version 27 de febrero de 2016
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
         System.out.println("[3] Limpiar");
         System.out.println("[0] Salir");
         do {
            operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) ||
		  (operacion > 3));
         if (operacion == 1)
            contenedor.llenarContenedor();
         else if (operacion == 2)
            contenedor.vaciarContenedor();
         else if (operacion == 3)
            contenedor.limpiarContenedor();
      } while (operacion != 0);
   }
}

/******** Fin de Control.java ****************/
