/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/ClaseSC.java                   *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de alumnos de una clase           *
 * @version C                                *
 * @author Jose F. Quesada                   */

class ClaseSC {
  private static ClaseSC claseInicial = null;

  private int      codigoClase;
  private String   nombreClase;
  private ClaseSC  siguienteClase;
  private int      totalAlumnos;
  private AlumnoSC alumnoInicial;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *    un codigo y un nombre    */
   public ClaseSC(int codigo,String nombre) {
      codigoClase = codigo;
      nombreClase = nombre;
      totalAlumnos = 0;
      siguienteClase = null;
      alumnoInicial = null;

      if (claseInicial == null)
         claseInicial = this;
      else if (claseInicial.codigoClase > codigo) {
         this.siguienteClase = claseInicial;
         claseInicial = this;
      } else {
         ClaseSC claseAux = claseInicial;
         while (claseAux.siguienteClase != null) {
            if (claseAux.siguienteClase.codigoClase > codigo) {
              this.siguienteClase = claseAux.siguienteClase;
              claseAux.siguienteClase = this;
              return;
            }
            claseAux = claseAux.siguienteClase;
         }
         claseAux.siguienteClase = this;
      }
   }


  public void gestionClase () {
    System.out.println
        ("Sistema Clase S.C.: Control de Alumnos");

    int operacion;
    do {
       System.out.println();
       System.out.println("Clase: " + codigoClase + "  " 
                          + nombreClase);
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
         if (operacion == 1)
            crearAlumno();
         else if (operacion == 2)
            ponerNota();
         else if (operacion == 3)
            borrarAlumno();
         else if (operacion == 4)
            listarAlumnos();
      } while (operacion != 0);
   }

  public static ClaseSC buscarClase(int codigo) {
    ClaseSC claseAux = claseInicial;

    while (claseAux != null) {
      if (claseAux.codigoClase == codigo)
        return claseAux;
      claseAux = claseAux.siguienteClase;
    }
    return null;
  }

  public static void borrarClase(int codigo) {
    if (claseInicial.codigoClase == codigo) {
      claseInicial = claseInicial.siguienteClase;
    } else {
      ClaseSC claseAux = claseInicial;
      while (claseAux.siguienteClase != null) {
        if (claseAux.siguienteClase.codigoClase == codigo) {
          claseAux.siguienteClase = 
                     claseAux.siguienteClase.siguienteClase;
          break;
        }
        claseAux = claseAux.siguienteClase;
      }
    }
  }

  public static void listarClases() {
    ClaseSC claseAux = claseInicial;

    while (claseAux != null) {
      System.out.println(claseAux);
      claseAux = claseAux.siguienteClase;
    }
  }

      /** Método toString para la       *
        * impresión del contenido de    *
        * de un objeto de tipo ClaseSC  */
   public String toString() {
      String imprime = "CLASE: " +  "   "
                 + codigoClase + "   " 
                 + nombreClase + "  (Alumnos: " 
                 + totalAlumnos + ")";
      return imprime;
   }

  private void crearAlumno() {
    System.out.println("CREACION DE UN NUEVO ALUMNO:");

    int numero;
    do {
      numero    = Terminal.leeEntero("CODIGO ?: ");
    } while ((numero <= 0) ||
             (AlumnoSC.buscarAlumno(alumnoInicial,numero) != null)); 
      
    String nombre = Terminal.leeCadena("NOMBRE?: ");

    AlumnoSC alumno = new AlumnoSC(numero,nombre);

    if (alumnoInicial == null)
       alumnoInicial = alumno;
    else
       alumnoInicial = AlumnoSC.insertaAlumno(alumnoInicial,alumno);

    totalAlumnos++;
  }

  private void ponerNota() {
    System.out.println("PONER UNA NOTA A UN ALUMNO");

    int numero;
    AlumnoSC alumno;

    do {
      numero    = Terminal.leeEntero("CODIGO ?: ");
    } while ((numero <= 0) ||
             ((alumno = AlumnoSC.buscarAlumno(alumnoInicial,
                                              numero)) 
               == null)); 
      
    double nota = Terminal.leeReal("NOTA?: ");

    alumno.ponerNota(nota);
  }

  public void listarAlumnos() {
    System.out.println(this);
    AlumnoSC.listarAlumnos(alumnoInicial);
  }

  private void borrarAlumno() {
    System.out.println("BORRAR UN ALUMNO");

    int numero;

    do {
      numero    = Terminal.leeEntero("NUMERO ?: ");
    } while ((numero <= 0) ||
             (AlumnoSC.buscarAlumno(alumnoInicial,numero) == null)); 
      
    alumnoInicial = AlumnoSC.borrarAlumno(alumnoInicial,numero);
  }

}

/******** Fin de ClaseSC.java ****************/
