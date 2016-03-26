class Dato {  
  private static Dato datoInicial = null;
  private static int totalNumeros = 0;

  private int numero;
  private int repeticiones;
  private Dato siguienteDato;

  public Dato(int n) {
    numero = n;
    repeticiones = 1;
    totalNumeros++;

    if (datoInicial == null) {
      datoInicial = this;
    } else {
      Dato datoAux = datoInicial;
      while (datoAux.siguienteDato != null) {
        datoAux = datoAux.siguienteDato;
      }
      datoAux.siguienteDato = this;
    }
  }

  public void incrementaRepeticiones() {
    repeticiones++;
    totalNumeros++;
  }

  public static Dato buscarDato(int numero) {
    Dato datoAux = datoInicial;

    while (datoAux != null) {
      if (datoAux.numero == numero) {
        return datoAux;
      }
      datoAux = datoAux.siguienteDato;
    }

    return null;
  }

  public static void borrarDato(int numero) {
    if (numero == datoInicial.numero) {
      datoInicial = datoInicial.siguienteDato;
      totalNumeros--;
    } else {
      Dato datoAux = datoInicial;
      while (datoAux != null) {
        if (datoAux.siguienteDato.numero == numero) {
          datoAux.siguienteDato = datoAux.siguienteDato.siguienteDato;
          totalNumeros--;
          break;
        }
        datoAux = datoAux.siguienteDato;
      }
    }
  }

  public static void listarDatos() {

    Dato datoAux = datoInicial;

    int moda = -1;
    int repeticionesModa = -1;

    while (datoAux != null) {
      System.out.println(datoAux.numero + " - " + datoAux.repeticiones + " - "
                          + (datoAux.repeticiones * 100) / totalNumeros + "%");

      if (datoAux.repeticiones > repeticionesModa) {
        moda = datoAux.numero;
        repeticionesModa = datoAux.repeticiones;
      }
      
      datoAux = datoAux.siguienteDato;
    }
    System.out.println("\nModa: " + moda);
  }
}
