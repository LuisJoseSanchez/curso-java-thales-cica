/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo04/Mayor.java                     *
 *********************************************/

class Mayor {
  public static void main (String[] args) {
    double valorA;
    double valorB;

    valorA = Terminal.leeReal("Primer  valor:");
    valorB = Terminal.leeReal("Segundo valor:");

    double mayor = (valorA > valorB) ? valorA : valorB;
    System.out.println("El mayor es: " + mayor);
  }
}

/******** Fin de Mayor.java ********/

