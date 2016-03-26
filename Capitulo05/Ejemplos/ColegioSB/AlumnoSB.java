/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/AlumnoSB.java                  *
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
 *	- AlumnoSB (nombre)
 *	- AlumnoSB (nombre,nota)
 *   * Acceso a campos
 *	- nombreAlumno
 *	- notaAlumno
 *   * Operaciones sobre el objeto
 *	- ponerNota
 *
 * @version B 
 * @author Jose F. Quesada
 */

class AlumnoSB {  
   private static AlumnoSB alumnoInicial = null;

   private int      numeroAlumno;
   private String   nombreAlumno;
   private double   notaAlumno;
   private AlumnoSB siguienteAlumno;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *    un numero y un nombre    */
   public AlumnoSB(int numero,String nombre) {
      numeroAlumno = numero;
      nombreAlumno = nombre;
      notaAlumno   = 0;

      if (alumnoInicial == null)
         alumnoInicial = this;
      else {
         AlumnoSB alumnoAux = alumnoInicial;
         while (alumnoAux.siguienteAlumno != null)
            alumnoAux = alumnoAux.siguienteAlumno;
         alumnoAux.siguienteAlumno = this;
      }

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

      /** Método toString para la       *
        * impresión del contenido de    *
	    * de un objeto de tipo AlumnoSB */
   public String toString() {
      String imprime = numeroAlumno + "   "
                 + nombreAlumno + relleno(this,40) 
                 + " ==> " + notaAlumno;
      return imprime;
   }

   public static String relleno(AlumnoSB alumno,
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

   public static void listarClase() {
      System.out.println("LISTADO DE ALUMNOS DE LA CLASE");
      AlumnoSB alumnoAux = alumnoInicial;

      while (alumnoAux != null) {
         System.out.println(alumnoAux);
         alumnoAux = alumnoAux.siguienteAlumno;
      }
   }

   public static AlumnoSB buscarAlumno(int numero) {
      AlumnoSB alumnoAux = alumnoInicial;

      while (alumnoAux != null) {
         if (alumnoAux.numeroAlumno == numero)
           return alumnoAux;
         alumnoAux = alumnoAux.siguienteAlumno;
      }

      return null;
   }

   public static void borrarAlumno(int numero) {
      if (numero == alumnoInicial.numeroAlumno) {
         alumnoInicial = alumnoInicial.siguienteAlumno;
      } else {
         AlumnoSB alumnoAux = alumnoInicial;
         while (alumnoAux != null) {
            if (alumnoAux.siguienteAlumno.numeroAlumno == numero) {
               alumnoAux.siguienteAlumno =
                            alumnoAux.siguienteAlumno.siguienteAlumno;
               break;
            }
            alumnoAux = alumnoAux.siguienteAlumno;
         }
      }
   }
}

/******** Fin de AlumnoSB.java ***************/
