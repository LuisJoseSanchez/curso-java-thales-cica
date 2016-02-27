/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo04/BancoSB.java                   *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de cuentas de un banco            *
 * @version 1.00                             *
 * @author Jose F. Quesada                   */

class BancoSB {
  private static CuentaSB cuenta1, cuenta2, cuenta3;

  public static void main (String args[]) {
    System.out.println
        ("Sistema Banco S.B.: Control de Cuentas");

    System.out.println("VENTANILLA:");
    int operacion;
    do {
       System.out.println("[1] Imposicion");
       System.out.println("[2] Reintegro");
       System.out.println("[3] Estado de Cuentas");
       System.out.println("[4] Crear cuenta");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
			("Indique una operacion: ");
         } while ((operacion < 0) ||
		  (operacion > 4));
         if (operacion == 1)
            gestionImposicion();
         else if (operacion == 2)
            gestionReintegro();
         else if (operacion == 3)
            CuentaSB.listadoCuentasSB();
         else if (operacion == 4)
            creaCuenta();
      } while (operacion != 0);
   }

  private static void gestionImposicion() {
    System.out.println("IMPOSICION:");
    int codigo;

    System.out.println("CUENTA?:");
    codigo = Terminal.leeEntero
		("Indique un codigo: ");
    if (codigo == 0)
      return;

    CuentaSB cuentaSB = CuentaSB.buscaCuentaSB(codigo);
    if (cuentaSB == null) {
      System.out.println("Cuenta inexistente");
      return;
    }

    int cantidad = Terminal.leeEntero
                   ("Cantidad: ");
    boolean resImp = false;
    resImp = cuentaSB.Imposicion(cantidad);

    if (resImp) 
      System.out.println
        ("Operación finalizada correctamente");
    else
      System.out.println
        ("Operación finalizada erróneamente");
  }

  private static void gestionReintegro() {
    System.out.println("REINTEGRO:");

    int codigo;

    System.out.println("CUENTA?:");
    codigo = Terminal.leeEntero
		("Indique un codigo: ");
    if (codigo == 0)
      return;

    CuentaSB cuentaSB = CuentaSB.buscaCuentaSB(codigo);
    if (cuentaSB == null) {
      System.out.println("Cuenta inexistente");
      return;
    }

    int cantidad = Terminal.leeEntero
                   ("Cantidad: ");
    boolean resImp = false;
    resImp = cuentaSB.Reintegro(cantidad);

    if (resImp) 
      System.out.println
        ("Operación finalizada correctamente");
    else
      System.out.println
        ("Operación finalizada erróneamente");
  }

  private static void creaCuenta() {
    System.out.println("CREACION DE CUENTAS:");

    int codigo     = Terminal.leeEntero("CODIGO ?: ");
    String titular = Terminal.leeCadena("TITULAR?: ");

    new CuentaSB(codigo,titular);
  }

}

/******** Fin de BancoSB.java ****************/
