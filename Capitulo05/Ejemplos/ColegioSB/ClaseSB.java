/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/ClaseSB.java                   *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de alumnos de una clase           *
 * @version B                                *
 * @author Jose F. Quesada                   */

class ClaseSB {
  public static void main (String args[]) {
    System.out.println
        ("Sistema Clase S.B.: Control de Alumnos");

    int operacion;
    do {
       System.out.println();
       System.out.println();
       System.out.println("[1] Crear un alumno nuevo");
       System.out.println("[2] Poner o modificar una nota");
       System.out.println("[3] Borrar un alumno");
       System.out.println("[4] Listado de la clase");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) ||
		  (operacion > 4));
         System.out.println();
         System.out.println();
         if (operacion == 1)
            crearAlumno();
         else if (operacion == 2)
            ponerNota();
         else if (operacion == 3)
            borrarAlumno();
         else if (operacion == 4)
            AlumnoSB.listarClase();
      } while (operacion != 0);
   }

  private static void crearAlumno() {
    System.out.println("CREACION DE UN NUEVO ALUMNO:");

    int numero;
    do {
      numero    = Terminal.leeEntero("NUMERO ?: ");
    } while ((numero <= 0) ||
             (AlumnoSB.buscarAlumno(numero) != null)); 
      
    String nombre = Terminal.leeCadena("NOMBRE?: ");

    new AlumnoSB(numero,nombre);
  }

  private static void ponerNota() {
    System.out.println("PONER UNA NOTA A UN ALUMNO");

    int numero;
    AlumnoSB alumno;

    do {
      numero    = Terminal.leeEntero("NUMERO ?: ");
    } while ((numero <= 0) ||
             ((alumno = AlumnoSB.buscarAlumno(numero)) == null)); 
      
    double nota = Terminal.leeReal("NOTA?: ");

    alumno.ponerNota(nota);
  }

  private static void borrarAlumno() {
    System.out.println("BORRAR UN ALUMNO");

    int numero;

    do {
      numero    = Terminal.leeEntero("NUMERO ?: ");
    } while ((numero <= 0) ||
             (AlumnoSB.buscarAlumno(numero) == null)); 
      
    AlumnoSB.borrarAlumno(numero);
  }
}

/******** Fin de ClaseSB.java ****************/
