/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/MediaAritmetica.java           *
 *********************************************/

class MediaAritmetica {
  public static void main (String[] args) {
    double dato;
    int    contador = 0;
    double suma = 0;

    while ( (dato = Terminal.leeReal("Dato: ") ) >= 0) {
      suma += dato;
      contador ++;
    }

    if (contador == 0)
      System.out.println("No se han introducido datos");
    else {
      double media = suma / contador;
      System.out.println("Media = " + media);
    }
  }
}

/******** Fin de MediaAritmetica.java *********/

