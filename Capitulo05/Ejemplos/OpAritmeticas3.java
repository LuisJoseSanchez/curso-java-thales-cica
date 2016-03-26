/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/OpAritmeticas3.java            *
 *********************************************/

class OpAritmeticas3 {
  public static void main (String[] args) {
    int numA, numB;

    int suma;
    int resta;
    int producto;
    int division;
    int resto;

    numA = Terminal.leeEntero("Primer  número: ");
    numB = Terminal.leeEntero("Segundo número: ");

    suma = numA + numB;
    resta = numA - numB;
    producto = numA * numB;
    division = numA / numB;
    resto = numA % numB;

    System.out.println("numA     = " + numA);
    System.out.println("numB     = " + numB);
    System.out.println("Suma     = " + suma);
    System.out.println("Resta    = " + resta);
    System.out.println("Producto = " + producto);
    System.out.println("División = " + division);
    System.out.println("Resto    = " + resto);
  }
}

/******** Fin de OpAritmeticas3.java **********/

