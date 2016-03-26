/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo05/Notas.java                     *
 *********************************************/

class Notas {
  public static void main (String[] args) {
    int nota;

    nota = Terminal.leeEntero("Nota: ");

    switch (nota) {
      case 0:
      case 1:
      case 2:
         System.out.println("Muy deficiente");
         break;
      case 3:
      case 4:
         System.out.println("Deficiente");
         break;
      case 5:
         System.out.println("Aprobado");
         break;
      case 6:
         System.out.println("Bien");
         break;
      case 7:
      case 8:
         System.out.println("Notable");
         break;
      case 9:
         System.out.println("Sobresaliente");
         break;
      case 10:
         System.out.println("Matrícula de Honor");
         break;
      default:
         System.out.println("Nota errónea");
    }
  }
}

/******** Fin de Notas.java *******************/

