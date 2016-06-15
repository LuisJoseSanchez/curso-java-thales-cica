/**
 * Tarea 8.1: Librería
 *
 * Luis José Sánchez
 *
 * Este ejercicio está basado en el ejemplo ColegioSD de Jose F. Quesada,
 * en concreto, la clase "Libro" está basada en la clase "AlumnoSD".
 */

import java.io.*;
import Sistema.*;

class Libro {

  private int numeroLibro;
  private String autorLibro;
  private String tituloLibro;
  private String editorialLibro;
  private int publicacionLibro;
  private String lugarLibro;
  private Libro siguienteLibro;

  public Libro(int numeroLibro, String autorLibro, String tituloLibro, String editorialLibro, int publicacionLibro, String lugarLibro) {
    this.numeroLibro = numeroLibro;
    this.autorLibro = autorLibro;
    this.tituloLibro = tituloLibro;
    this.editorialLibro = editorialLibro;
    this.publicacionLibro = publicacionLibro;
    this.lugarLibro = lugarLibro;
  }

  public int getNumeroLibro() {
    return numeroLibro;
  }

  public String getAutorLibro() {
    return autorLibro;
  }

  public String getTituloLibro() {
    return tituloLibro;
  }

  public String getEditorialLibro() {
    return editorialLibro;
  }

  public int getPublicacionLibro() {
    return publicacionLibro;
  }

  public String getLugarLibro() {
    return lugarLibro;
  }

  public Libro getSiguienteLibro() {
    return siguienteLibro;
  }



  public static Libro insertaLibro(Libro libroInicial,
          Libro libroNuevo) {
    if (libroNuevo.numeroLibro
            < libroInicial.numeroLibro) {
      libroNuevo.siguienteLibro = libroInicial;
      return libroNuevo;
    } else {
      Libro libroAux = libroInicial;
      while (libroAux != null) {
        if (libroAux.siguienteLibro == null) {
          libroAux.siguienteLibro = libroNuevo;
          break;
        } else if (libroAux.siguienteLibro.numeroLibro
                > libroNuevo.numeroLibro) {
          libroNuevo.siguienteLibro
                  = libroAux.siguienteLibro;
          libroAux.siguienteLibro = libroNuevo;
          break;
        } else {
          libroAux = libroAux.siguienteLibro;
        }
      }
    }
    return libroInicial;
  }


  @Override
  public String toString() {
    String imprime = numeroLibro + "   " + autorLibro + "   " + tituloLibro + "   "
            + editorialLibro + "   " + publicacionLibro + "   " + lugarLibro;
    return imprime;
  }

  public static Libro buscarLibro(Libro libroInicial, int numero) {
    Libro libroAux = libroInicial;
    while (libroAux != null) {
      if (libroAux.numeroLibro == numero) {
        return libroAux;
      }
      libroAux = libroAux.siguienteLibro;
    }

    return null;
  }


  public static void listarLibros(Libro libroInicial) {
    System.out.println("LISTADO DE LIBROS");
    Libro libroAux = libroInicial;
    while (libroAux != null) {
      System.out.println(libroAux);
      libroAux = libroAux.siguienteLibro;
    }
    System.out.println();
  }

  public static void listarLibrosPorAutor(Libro libroInicial) {
    System.out.println("LISTADO DE LIBROS POR AUTOR");
    
    String autor = Terminal.leeCadena("Autor: ");
    
    Libro libroAux = libroInicial;
    while (libroAux != null) {
      if (libroAux.getAutorLibro().equals(autor)) {
        System.out.println(libroAux);
      }
      libroAux = libroAux.siguienteLibro;
    }
    System.out.println();
  }

  public static void listarLibrosPorPeriodo(Libro libroInicial) {
    System.out.println("LISTADO DE LIBROS DE UN PERIODO");
    
    int inicio = Terminal.leeEntero("Año inicial del período: ");
    int fin = Terminal.leeEntero("Año final del período: ");
    
    Libro libroAux = libroInicial;
    while (libroAux != null) {
      if ((libroAux.getPublicacionLibro() >= inicio) && (libroAux.getPublicacionLibro() <= fin)) {
        System.out.println(libroAux);
      }
      libroAux = libroAux.siguienteLibro;
    }
    System.out.println();
  }
    
  public static void grabarLibros(FileOutputStream canalFichero, Libro libroInicial) {
    Libro libroAux = libroInicial;
    while (libroAux != null) {
      Fichero.graba(canalFichero,"NUMLIB:" + libroAux.numeroLibro + "\n");
      Fichero.graba(canalFichero,"AUTLIB:" + libroAux.autorLibro + "\n");
      Fichero.graba(canalFichero,"TITLIB:" + libroAux.tituloLibro + "\n");
      Fichero.graba(canalFichero,"EDILIB:" + libroAux.editorialLibro + "\n");
      Fichero.graba(canalFichero,"PUBLIB:" + libroAux.publicacionLibro + "\n");
      Fichero.graba(canalFichero,"LUGLIB:" + libroAux.lugarLibro + "\n");
      libroAux = libroAux.siguienteLibro;
    }
  }


  public static Libro borrarLibro(Libro libroInicial, int numero) {
    if (numero == libroInicial.numeroLibro) {
      libroInicial = libroInicial.siguienteLibro;
    } else {
      Libro libroAux = libroInicial;
      while (libroAux != null) {
        if (libroAux.siguienteLibro.numeroLibro == numero) {
          libroAux.siguienteLibro = libroAux.siguienteLibro.siguienteLibro;
          break;
        }
        libroAux = libroAux.siguienteLibro;
      }
    }
    return libroInicial;
  }
}
