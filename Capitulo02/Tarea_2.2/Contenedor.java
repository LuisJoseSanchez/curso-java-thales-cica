/******************************************************************************
 * Tarea 2.2                                                                  *
 * Curso de Programación en Java                                              *
 *                                                                            *
 * Modificar el sistema de control de contenedores estudiado en el capítulo e *
 * introducir un método nuevo que se llame “Limpiar”. Este método debe dar    *
 * error si el contenedor ya está vaciado (limpio). En caso contrario, debe   *
 * eliminar todo el contenido del contenedor (sea el que sea, tanto en tipo   *
 * como en contenido), y debe dejar listo el contenedor disponible para poder *
 * ser llenado con cualquier otro tipo de líquido. Se deberá modificar        *
 * coherentemente tanto la clase Contenedor como la de Control.               *
 *                                                                            *
 * El método limpiarContenedor() se ha añadido al final de la clase.          *
 ******************************************************************************/

 /**
 * Esta clase se utiliza para representar objetos 
 * de tipo Contenedor. Para ello la clase asociará 
 * a cada objeto creado, cuatro variables o campos 
 * que identificarán el estado del objeto en cada
 * momento (nombreContenedor, capacidadContenedor,
 * llenoContenedor, contenidoContenedor).
 * @author Jose F. Quesada
 * @author Luis José Sánchez
 * @version 27 de febrero de 2016
 */

class Contenedor {  // Definición de la clase contenedor
      /** Nombre o identificador del contenedor */
   private String nombreContenedor;
      /** Capacidad o volumen máximo */
   private int    capacidadContenedor;
      /** Volumen ocupado en cada momento */
   private int    llenoContenedor;
      /** Si el volumen ocupado (lleno) es mayor 
        * que 0, entonces contenidoContenedor 
	* indicará el material que contiene */
   private String contenidoContenedor;

      /** Constructor básico */
   public Contenedor() {
      nombreContenedor     = "sinNombre";
      capacidadContenedor  = 100;
      llenoContenedor      = 0;
      contenidoContenedor  = "";
   }

      /** Constructor general con argumentos para 
	* la inicialización del objeto */
   public Contenedor(String nombre, int capacidad,
                   int lleno, String contenido) {
      nombreContenedor     = nombre;
      capacidadContenedor  = capacidad;
      llenoContenedor      = lleno;
      contenidoContenedor  = contenido;
   }

      /** Conversor por defecto de la estructura 
	* de un objeto de tipo Contenedor a formato 
	* String para su impresión */
   public String toString() {
      String imprime = "   #>CONTENEDOR: " + 
			nombreContenedor;
      imprime += "[Cap: " + capacidadContenedor;
      if (llenoContenedor != 0) 
         imprime += ", contiene " + 
		llenoContenedor +
		" de " + contenidoContenedor;
      imprime += "]\n";
      return imprime;
   }

      /** Función lógica que indica  si el 
	* Contenedor está o no vacío */
   public boolean vacioContenedor() {
      if (llenoContenedor == 0)
         return true;
      else
         return false;
   }
   
   public int llenarContenedor(int volumen) {
      if (llenoContenedor + volumen <= 
			capacidadContenedor)
         llenoContenedor += volumen;
      else {
         System.err.print("ERROR: ");
         System.err.println("Capacidad insuficiente");
      }
      return llenoContenedor;
   }

   public int llenarContenedor() {
      System.out.println("-----");
      System.out.println("Op: Llenar Contenedor");

      if (llenoContenedor == capacidadContenedor) {
         System.out.println
            ("ERROR: El contenedor ya está lleno");
         return llenoContenedor;
      }

      String contenido;
      int    lleno;

      contenido = Terminal.leeCadena("Material: ");
      if (!vacioContenedor() && 
          (contenido.compareTo(contenidoContenedor) 
                                          != 0)) {
         System.out.println
                   ("ERROR: Mezcla de materiales");
         return 0;
      } else {
         lleno = Terminal.leeEntero("Cantidad: ");
         contenidoContenedor = contenido;
         return llenarContenedor(lleno);
      }
   }

   public int vaciarContenedor(int volumen) {
      if (llenoContenedor - volumen >= 0)
         llenoContenedor -= volumen;
      else {
         System.err.print("ERROR: ");
         System.err.println("Contenido insuficiente");
      }
      return llenoContenedor;
   }

   public int vaciarContenedor() {
      System.out.println("-----");
      System.out.println("Op: Vaciar Contenedor");
      if (vacioContenedor()) {
         System.out.println("ERROR: Contenedor vacío");
         return 0;
      }

      String contenido;
      int    vaciar;

      vaciar = Terminal.leeEntero("Cantidad: ");
      return vaciarContenedor(vaciar);
   }

   /**
    * Elimina todo el contenido del contenedor.
    * Da error en caso de que el contenedor esté vacío.
    */
   public int limpiarContenedor() {
      System.out.println("-----");
      System.out.println("Op: Limpiar Contenedor");
      if (vacioContenedor()) {
         System.out.println("ERROR: Contenedor vacío");
         return 0;
      }

      contenidoContenedor  = "";
      return vaciarContenedor(llenoContenedor);
   }
}

/******** Fin de Contenedor.java *************/
