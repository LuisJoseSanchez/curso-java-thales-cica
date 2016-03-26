/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/ClaseSA.java                   *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de alumnos de una clase           *
 * @version A                                *
 * @author Jose F. Quesada                   */

class ClaseSA {
  private static AlumnoSA alumno1, alumno2, alumno3;

  public static void main (String args[]) {
    System.out.println
        ("Sistema Clase S.A.: Control de Alumnos");
    System.out.println("Creando alumnos");

       
    alumno1 = new AlumnoSA(
		"Pedro Rubio Mateos");
    alumno2 = new AlumnoSA(
		"Luisa Lozano Rosales");
    alumno3 = new AlumnoSA(
		"Carmen del Pozo Ochoa");

    gestionClase();
  }

  private static void gestionClase() {
    System.out.println("CLASE SA:");
    int operacion;
    do {
       System.out.println();
       System.out.println();
       System.out.println("[1] Poner notas");
       System.out.println("[2] Listar alumnos");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) || 
		  (operacion > 2));
         System.out.println();
         System.out.println();
         if (operacion == 1)
            ponerNotas();
         else if (operacion == 2)
            listarAlumnos();
      } while (operacion != 0);
   }

  private static void listarAlumnos() {
    System.out.println("LISTADO DE ALUMNOS DE LA CLASE");
    System.out.println(alumno1);
    System.out.println(alumno2);
    System.out.println(alumno3);
  }

  private static void ponerNotas() {
    System.out.println("PONER NOTAS:");
    int alumno;

    alumno = seleccionAlumno();
    if (alumno == 0)
      return;

    double nota = Terminal.leeReal
                   ("Nota: ");
    if (alumno == 1)
       alumno1.ponerNota(nota);
    else if (alumno == 2)
       alumno2.ponerNota(nota);
    else if (alumno == 3)
       alumno3.ponerNota(nota);
  }

  private static int seleccionAlumno() {
    System.out.println("ALUMNO?:");
    int alumno;
    do {
       alumno = Terminal.leeEntero
		("Indique un alumno (1,2,3,0): ");
    } while ((alumno < 0) || (alumno > 3));
    return alumno;
   }
}

/******** Fin de ClaseSA.java ****************/
