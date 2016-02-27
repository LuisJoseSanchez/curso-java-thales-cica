/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo04/Bytes.java                     *
 *********************************************/

class Bytes {
  public static void main (String[] args) {
    byte valorA = 15;
    byte valorB = 60;

    System.out.println("valorA: " + valorA);
    System.out.println("valorB: " + valorB);
    System.out.println("~valorA: " + ~valorA);
    System.out.println("valorA & valorB: " + (valorA&valorB));
    System.out.println("valorA | valorB: " + (valorA|valorB));
    System.out.println("valorA ^ valorB: " + (valorA^valorB));
    System.out.println("valorA >> 2: " + (valorA>>2));
    System.out.println("valorA << 2: " + (valorA<<2));
  }
}

/******** Fin de Bytes.java ********/

