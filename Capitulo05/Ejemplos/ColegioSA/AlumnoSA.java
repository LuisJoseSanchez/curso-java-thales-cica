/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/AlumnoSA.java                  *
 *********************************************/

 /**
 * Esta clase representa estructuras de tipo
 * alumno utilizando un modelo estático
 *
 * Cada objeto de esta clase contendrá las
 * siguientes variables:
 * 	- Nombre del alumno (tipo String)
 *	- Nota del alumno (tipo real)
 *
 * Los métodos soportados por esta clase son:
 *   * Constructores
 *	- AlumnoSA (nombre)
 *	- AlumnoSA (nombre,nota)
 *   * Acceso a campos
 *	- nombreAlumno
 *	- notaAlumno
 *   * Operaciones sobre el objeto
 *	- ponerNota
 *
 * @version A 
 * @author Jose F. Quesada
 */

class AlumnoSA {  
   private String nombreAlumno;
   private double  notaAlumno;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *    un nombre                */
   public AlumnoSA(String nombre) {
      nombreAlumno = nombre;
      notaAlumno   = 0;
   }

      /** Constructor auxiliar        *
        *  - Permite la asignacion    *
        *    de una nota inicial      */

      /** Constructor general con argumentos para 
	    * la inicialización del objeto */
   public AlumnoSA(String nombre, 
                   int nota)  {
      nombreAlumno = nombre;
      notaAlumno   = nota;
   }

      /** Funciones de acceso a los   *
        * campos privados de la clase */ 

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
	    * de un objeto de tipo AlumnoSA */
   public String toString() {
      String imprime = nombreAlumno + relleno(this,40) + " ==> "
		+ notaAlumno;
      return imprime;
   }

   public static String relleno(AlumnoSA alumno,
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

}

/******** Fin de AlumnoSA.java ***************/
