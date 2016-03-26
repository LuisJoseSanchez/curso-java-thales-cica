/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/OpAritmeticas2.java            *
 *********************************************/

class OpAritmeticas2 {
  public static void main (String[] args) {
    int numA, numB;

    int suma;
    int resta;
    int producto;
    int division;
    int resto;

    numA = Terminal.leeEntero("Primer  número: ");
    numB = Terminal.leeEntero("Segundo número: ");

    System.out.println("numA     = " + numA);
    System.out.println("numB     = " + numB);

    suma = numA + numB;
    System.out.println("Suma     = " + suma);

    resta = numA - numB;
    System.out.println("Resta    = " + resta);

    producto = numA * numB;
    System.out.println("Producto = " + producto);

    division = numA / numB;
    System.out.println("División = " + division);

    resto = numA % numB;
    System.out.println("Resto    = " + resto);
  }
}

/******** Fin de OpAritmeticas2.java **********/

