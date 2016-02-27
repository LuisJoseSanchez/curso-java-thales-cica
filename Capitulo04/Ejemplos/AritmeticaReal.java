/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo04/AritmeticaReal.java            *
 *********************************************/

class AritmeticaReal {
  public static void main (String[] args) {
    double infp = Double.POSITIVE_INFINITY;
    double infn = Double.NEGATIVE_INFINITY;
    double numa = 123.456;
    double numb = -65.432;

    System.out.println("Aritmética real - Ejemplos");
    System.out.println("  Suma:");
    System.out.println("    numa + numb = " + (numa + numb));
    System.out.println("    numa + infp = " + (numa + infp));
    System.out.println("    numa + infn = " + (numa + infn));
    System.out.println("    infp + infn = " + (infp + infn));
    System.out.println("  Suma: (operador unario)");
    System.out.println("    +numa = " + +numa);
    System.out.println("  Resta: (operador binario)");
    System.out.println("    numa - numb = " + (numa - numb));
    System.out.println("    numa - infp = " + (numa - infp));
    System.out.println("    numa - infn = " + (numa - infn));
    System.out.println("    infp - infn = " + (infp - infn));
    System.out.println("  Resta: (operador unario)");
    System.out.println("    -numa = " + -numa);
    System.out.println("  Multiplicación");
    System.out.println("    numa * numb = " + (numa * numb));
    System.out.println("    numa * infp = " + (numa * infp));
    System.out.println("    numa * infn = " + (numa * infn));
    System.out.println("    infp * infp = " + (infp * infp));
    System.out.println("    infn * infn = " + (infn * infn));
    System.out.println("    infp * infn = " + (infp * infn));
    System.out.println("    numa * 0 = " + (numa * 0));
    System.out.println("    infp * 0 = " + (infp * 0));
    System.out.println("    infn * 0 = " + (infn * 0));
    System.out.println("  División");
    System.out.println("    11.0 / 2 = " + (11.0 / 2));
    System.out.println("    11.0 / 3 = " + (11.0 / 3));
    System.out.println("    11.0 / 4 = " + (11.0 / 4));
    System.out.println("    11.0 / 5 = " + (11.0 / 5));
    System.out.println("    11.0 / 6 = " + (11.0 / 6));
    System.out.println("    numa / numb = " + (numa / numb));
    System.out.println("    numa / infp = " + (numa / infp));
    System.out.println("    numa / infn = " + (numa / infn));
    System.out.println("    infp / infp = " + (infp / infp));
    System.out.println("    infn / infn = " + (infn / infn));
    System.out.println("    infp / infn = " + (infp / infn));
    System.out.println("    0 / numa = " + (0 / numa));
    System.out.println("    0 / infp = " + (0 / infp));
    System.out.println("    0 / infn = " + (0 / infn));
  }
}

/******** Fin de AritmeticaReal.java ********/

