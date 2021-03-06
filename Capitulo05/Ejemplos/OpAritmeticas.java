/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/OpAritmeticas.java             *
 *********************************************/

class OpAritmeticas {
  public static void main (String[] args) {
    int numA, numB;

    numA = Terminal.leeEntero("Primer  número: ");
    numB = Terminal.leeEntero("Segundo número: ");

    System.out.println("numA     = " + numA);
    System.out.println("numB     = " + numB);

    int suma = numA + numB;
    System.out.println("Suma     = " + suma);

    int resta = numA - numB;
    System.out.println("Resta    = " + resta);

    int producto = numA * numB;
    System.out.println("Producto = " + producto);

    int division = numA / numB;
    System.out.println("División = " + division);

    int resto = numA % numB;
    System.out.println("Resto    = " + resto);
  }
}

/******** Fin de OpAritmeticas.java ***********/

