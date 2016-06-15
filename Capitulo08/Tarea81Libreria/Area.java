/**
 * Tarea 8.1: Librería
 *
 * Luis José Sánchez
 *
 * Este ejercicio está basado en el ejemplo ColegioSD de Jose F. Quesada,
 * en concreto, la clase "Area" está basada en la clase "ClaseSD".
 */

import java.io.*;
import Sistema.*;

class Area {

  private static Area areaInicial = null;

  private int codigoArea;
  private String descripcionArea;
  private String ubicacionArea;
  private Area siguienteArea;
  private int totalLibros;
  private Libro libroInicial;


  public Area(int codigo, String descripcion, String ubicacion) {
    codigoArea = codigo;
    descripcionArea = descripcion;
    ubicacionArea = ubicacion;
    totalLibros = 0;
    siguienteArea = null;
    libroInicial = null;

    if (areaInicial == null) {
      areaInicial = this;
    } else if (areaInicial.codigoArea > codigo) {
      this.siguienteArea = areaInicial;
      areaInicial = this;
    } else {
      Area areaAux = areaInicial;
      while (areaAux.siguienteArea != null) {
        if (areaAux.siguienteArea.codigoArea > codigo) {
          this.siguienteArea = areaAux.siguienteArea;
          areaAux.siguienteArea = this;
          return;
        }
        areaAux = areaAux.siguienteArea;
      }
      areaAux.siguienteArea = this;
    }
  }

  public void gestionArea() {
    System.out.println("Control de Libros");

    int operacion;
    do {
      System.out.println();
      System.out.println("Area: " + codigoArea + "  " + descripcionArea + "  " + ubicacionArea);
      System.out.println();
      System.out.println("1. Dar de alta un libro");
      System.out.println("2. Dar de baja un libro");
      System.out.println("3. Consultar un libro (por código)");
      System.out.println("4. Listar todos los libros del area");
      System.out.println("5. Listar los libros de un autor");
      System.out.println("6. Listar los libros de un período ");
      System.out.println("0. Salir");
      do {
        operacion = Terminal.leeEntero("Indique una operacion: ");
      } while ((operacion < 0) || (operacion > 6));
      System.out.println();
      switch (operacion) {
        case 1:
          crearLibro();
          break;
        case 2:
          borrarLibro();
          break;
        case 3:
          consultarLibro();
          break;
        case 4:
          listarLibros();
          break;
        case 5:
          listarLibrosPorAutor();
          break;
        case 6:
          listarLibrosPorPeriodo();
          break;
        default:
          break;
      }
    } while (operacion != 0);
  }

  public static Area buscarArea(int codigo) {
    Area areaAux = areaInicial;

    while (areaAux != null) {
      if (areaAux.codigoArea == codigo) {
        return areaAux;
      }
      areaAux = areaAux.siguienteArea;
    }
    return null;
  }

  public static void borrarArea(int codigo) {
    if (areaInicial.codigoArea == codigo) {
      areaInicial = areaInicial.siguienteArea;
    } else {
      Area areaAux = areaInicial;
      while (areaAux.siguienteArea != null) {
        if (areaAux.siguienteArea.codigoArea == codigo) {
          areaAux.siguienteArea
                  = areaAux.siguienteArea.siguienteArea;
          break;
        }
        areaAux = areaAux.siguienteArea;
      }
    }
  }

  public static void listarAreas() {
    Area areaAux = areaInicial;

    while (areaAux != null) {
      System.out.println(areaAux);
      areaAux = areaAux.siguienteArea;
    }
  }

  
  public static void listarAreasYLibros() {
    Area areaAux = areaInicial;

    while (areaAux != null) {
      //System.out.println(areaAux);
      areaAux.listarLibros();
      System.out.println();
      areaAux = areaAux.siguienteArea;
    }
  }
  
  public static int totalAreas() {
    Area areaAux = areaInicial;

    int total = 0;

    while (areaAux != null) {
      total++;
      areaAux = areaAux.siguienteArea;
    }

    return total;
  }

  public static void grabarAreas(FileOutputStream canalFichero) {
    Area areaAux = areaInicial;

    while (areaAux != null) {
      System.out.println("Grabando area: " + areaAux.codigoArea + " " + areaAux.descripcionArea);
      Fichero.graba(canalFichero, "CODARE:" + areaAux.codigoArea + "\n");
      Fichero.graba(canalFichero, "DESARE:" + areaAux.descripcionArea + "\n");
      Fichero.graba(canalFichero, "UBIARE:" + areaAux.ubicacionArea + "\n");
      Fichero.graba(canalFichero, "TOTLIB:" + areaAux.totalLibros + "\n");

      Libro.grabarLibros(canalFichero, areaAux.libroInicial);

      areaAux = areaAux.siguienteArea;
    }
  }

  public static void iniciaAreas() {
    areaInicial = null;
  }

  public static void recuperarAreas(FileInputStream canalFichero) {
    int codArea = Fichero.leeInt(canalFichero, "CODARE:");
    String nomArea = Fichero.leeString(canalFichero, "DESARE:");
    String ubiArea = Fichero.leeString(canalFichero, "UBIARE:");
    int totLib = Fichero.leeInt(canalFichero, "TOTLIB:");

    Area narea = new Area(codArea, nomArea, ubiArea);

    for (int libro = 1; libro <= totLib; libro++) {
      int numLib = Fichero.leeInt(canalFichero, "NUMLIB:");
      String autLib = Fichero.leeString(canalFichero, "AUTLIB:");
      String titLib = Fichero.leeString(canalFichero, "TITLIB:");
      String ediLib = Fichero.leeString(canalFichero, "EDILIB:");
      int pubLib = Fichero.leeInt(canalFichero, "PUBLIB:");
      String lugLib = Fichero.leeString(canalFichero, "LUGLIB:");

      Libro nlibro = new Libro(numLib, autLib, titLib, ediLib, pubLib, lugLib);

      if (narea.libroInicial == null) {
        narea.libroInicial = nlibro;
      } else {
        narea.libroInicial = Libro.insertaLibro(narea.libroInicial, nlibro);
      }

      narea.totalLibros++;
    }

  }


  @Override
  public String toString() {
    String imprime = "AREA: " + "   "
            + codigoArea + "   "
            + descripcionArea  + "   "
            + ubicacionArea + "  (Libros: "
            + totalLibros + ")";
    return imprime;
  }

  private void crearLibro() {
    System.out.println("CREACION DE UN NUEVO LIBRO:");

    int numero;
    do {
      numero = Terminal.leeEntero("Código: ");
    } while ((numero < 0) || (Libro.buscarLibro(libroInicial, numero) != null));

    if (numero == 0) {
      return;
    }

    String autor = Terminal.leeCadena("Autor: ");
    String titulo = Terminal.leeCadena("Título: ");
    String editorial = Terminal.leeCadena("Editorial: ");
    int publicacion = Terminal.leeEntero("Año de publicación: ");
    String lugar = Terminal.leeCadena("Lugar de publicación: ");

    Libro libro = new Libro(numero, autor, titulo, editorial, publicacion, lugar);

    if (libroInicial == null) {
      libroInicial = libro;
    } else {
      libroInicial = Libro.insertaLibro(libroInicial, libro);
    }

    totalLibros++;
  }


  public void listarLibros() {
    System.out.println(this);
    Libro.listarLibros(libroInicial);
  }
  
  
  public void listarLibrosPorAutor() {
    Libro.listarLibrosPorAutor(libroInicial);
  }
  
  public void listarLibrosPorPeriodo() {
    Libro.listarLibrosPorPeriodo(libroInicial);
  }
  
  private void borrarLibro() {
    System.out.println("BORRAR UN LIBRO");

    int numero;

    do {
      numero = Terminal.leeEntero("Código: ");

      if (numero == 0) {
        return;
      }
    } while ((numero < 0) || (Libro.buscarLibro(libroInicial, numero) == null));

    libroInicial = Libro.borrarLibro(libroInicial, numero);
    totalLibros--;
  }
  
  
    private void consultarLibro() {
    System.out.println("CONSULTAR UN LIBRO");

    int numero;

    do {
      numero = Terminal.leeEntero("Código: ");

      if (numero == 0) {
        return;
      }
    } while ((numero < 0) || (Libro.buscarLibro(libroInicial, numero) == null));

    System.out.println(Libro.buscarLibro(libroInicial, numero));
  }

}
