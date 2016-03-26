/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/AlumnoSC.java                  *
 *********************************************/

 /**
 * Esta clase representa estructuras de tipo
 * alumno utilizando un modelo dinámico
 *
 * Cada objeto de esta clase contendrá las
 * siguientes variables:
 * 	- Nombre del alumno (tipo String)
 *	- Nota del alumno (tipo real)
 *
 * Los métodos soportados por esta clase son:
 *   * Constructores
 *	- AlumnoSC (nombre)
 *	- AlumnoSC (nombre,nota)
 *   * Acceso a campos
 *	- nombreAlumno
 *	- notaAlumno
 *   * Operaciones sobre el objeto
 *	- ponerNota
 *
 * @version C 
 * @author Jose F. Quesada
 */

class AlumnoSC {  
   private int      numeroAlumno;
   private String   nombreAlumno;
   private double   notaAlumno;
   private AlumnoSC siguienteAlumno;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *    un numero y un nombre    */
   public AlumnoSC(int numero,String nombre) {
      numeroAlumno = numero;
      nombreAlumno = nombre;
      notaAlumno   = 0;
   }

      /** Funciones de acceso a los   *
        * campos privados de la clase */ 

      /** Devuelve el numero del alumno */
   public int numeroAlumno () {
      return numeroAlumno;
   }

      /** Devuelve el nombre del alumno */
   public String nombreAlumno () {
      return nombreAlumno;
   }

      /** Devuelve el valor de la nota  */
   public double notaAlumno () {
      return notaAlumno;
   }

      /** Funciones de modificacion de los   *
        * campos privados de la clase */ 

   public void ponerNota (double nota) {
      notaAlumno   = nota;
   }

   public static AlumnoSC insertaAlumno (AlumnoSC alumnoInicial,
                                         AlumnoSC alumnoNuevo) {
     if (alumnoNuevo.numeroAlumno < alumnoInicial.numeroAlumno) {
        alumnoNuevo.siguienteAlumno = alumnoInicial;
        return alumnoNuevo;
     } else {
        AlumnoSC alumnoAux = alumnoInicial;
        while (alumnoAux != null) {
           if (alumnoAux.siguienteAlumno == null) {
              alumnoAux.siguienteAlumno = alumnoNuevo;
              break;
           } else if (alumnoAux.siguienteAlumno.numeroAlumno >
                      alumnoNuevo.numeroAlumno) {
              alumnoNuevo.siguienteAlumno = alumnoAux.siguienteAlumno;
              alumnoAux.siguienteAlumno = alumnoNuevo;
              break;
           } else
              alumnoAux = alumnoAux.siguienteAlumno;
        }
     }
     return alumnoInicial;
  }



      /** Método toString para la       *
        * impresión del contenido de    *
	* de un objeto de tipo AlumnoSC */
   public String toString() {
      String imprime = numeroAlumno + "   "
                 + nombreAlumno + relleno(this,40) 
                 + " ==> " + notaAlumno;
      return imprime;
   }

   public static String relleno(AlumnoSC alumno,
                                int longitud)
   {
      String blanco = new String();
      int dif = longitud - alumno.nombreAlumno.length();

      while (dif > 0) {
         blanco = new String(blanco + " ");
         dif --;
      }

      return blanco;
   }

   public static AlumnoSC buscarAlumno(AlumnoSC alumnoInicial,
                                       int numero) {
      AlumnoSC alumnoAux = alumnoInicial;
      while (alumnoAux != null) {
         if (alumnoAux.numeroAlumno == numero)
           return alumnoAux;
         alumnoAux = alumnoAux.siguienteAlumno;
      }

      return null;
   }

   public static void listarAlumnos(AlumnoSC alumnoInicial) {
      System.out.println();
      System.out.println("LISTADO DE ALUMNOS");
      AlumnoSC alumnoAux = alumnoInicial;
      while (alumnoAux != null) {
         System.out.println(alumnoAux);
         alumnoAux = alumnoAux.siguienteAlumno;
      }
      System.out.println();
   }

   public static AlumnoSC borrarAlumno(AlumnoSC alumnoInicial,int numero) {
      if (numero == alumnoInicial.numeroAlumno) {
         alumnoInicial = alumnoInicial.siguienteAlumno;
      } else {
         AlumnoSC alumnoAux = alumnoInicial;
         while (alumnoAux != null) {
            if (alumnoAux.siguienteAlumno.numeroAlumno == numero) {
               alumnoAux.siguienteAlumno =
                            alumnoAux.siguienteAlumno.siguienteAlumno;
               break;
            }
            alumnoAux = alumnoAux.siguienteAlumno;
         }
      }
      return alumnoInicial;
   }
}

/******** Fin de AlumnoSC.java ***************/
