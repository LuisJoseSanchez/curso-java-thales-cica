/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/Raices.java                    *
 *********************************************/

class Raices {
  public static void main (String[] args) {
    double a, b, c;

    a = Terminal.leeReal("Coeficiente a: ");
    b = Terminal.leeReal("Coeficiente b: ");
    c = Terminal.leeReal("Coeficiente c: ");

    if (a == 0) {
      System.out.println("a igual a 0");
      double x = -c / b;
      System.out.println("x = " + x);
    } else {
      double d = b*b - 4*a*c;
      System.out.println("Discriminante = " + d);
      if (d > 0) {
        double raiz = Math.sqrt(d);
        double s1 = (-b + raiz) / (2 * a);
        double s2 = (-b - raiz) / (2 * a);
        System.out.println("Solución 1 = " + s1);
        System.out.println("Solución 2 = " + s2);
      } else if (d == 0) {
        double s = -b / (2 * a);
        System.out.println("Solución = " + s);
      } else
        System.out.println("Sin soluciones reales");
    }
  }
}

/******** Fin de Raices.java ******************/

