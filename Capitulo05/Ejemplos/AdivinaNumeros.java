/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/AdivinaNumeros.java            *
 *********************************************/

class AdivinaNumeros {
  public static void main (String[] args) {
    int minimo = 1;
    int maximo = 1000;
    int solucion;
    int respuesta;
    int intentos = 0;

    System.out.println("Juego AdivinaNumeros");
    System.out.println();
    System.out.println("Piensa un número entre " +
                       minimo + " y " + maximo);

    do {
      intentos ++;
      if (minimo > maximo) {
        System.out.println("No vale hacer trampas");
        return;
      }
      solucion = (minimo + maximo) / 2;
      System.out.println("Es el " + solucion + "?");
      System.out.println("  0->igual");
      System.out.println("  1->el tuyo es mayor");
      System.out.println(" -1->el tuyo es menor");

      do
        respuesta = Terminal.leeEntero("Respuesta: ");
      while (respuesta > 1 || respuesta < -1);

      switch (respuesta) {
        case 1:
          minimo = solucion+1;
          break;
        case -1:
          maximo = solucion-1;
          break;
      }
    } while (respuesta != 0);
    System.out.println("Lo adiviné en " + intentos +
                      " intentos");
  }
}

/******** Fin de AdivinaNumeros.java **********/

