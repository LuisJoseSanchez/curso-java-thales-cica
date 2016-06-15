/**
 * Tarea 8.1: Librería
 *
 * Luis José Sánchez
 *
 * Este ejercicio está basado en el ejemplo ColegioSD de Jose F. Quesada.
 */

import java.io.*;
import Sistema.*;

public class Tarea81Libreria {

  public static void main(String args[]) {
    System.out.println("GESTIÓN DE LIBRERÍA");

    int operacion;
    do {
      System.out.println();
      System.out.println("1. Crear un área nueva");
      System.out.println("2. Gestión de un área");
      System.out.println("3. Borrar un área");
      System.out.println("4. Listado de las áreas");
      System.out.println("5. Listado completo por áreas");
      System.out.println("6. Salvar en fichero");
      System.out.println("7. Recuperar desde fichero");
      System.out.println("0. Salir");
      do {
        operacion = Terminal.leeEntero("Indique una operacion: ");
      } while ((operacion < 0) || (operacion > 7));
      
      System.out.println();
      
      switch (operacion) {
        case 1:
          crearArea();
          break;
        case 2:
          gestionArea();
          break;
        case 3:
          borrarArea();
          break;
        case 4:
          Area.listarAreas();
          break;
        case 5:
          Area.listarAreasYLibros();
          break;
        case 6:
          salvarLibreria();
          break;
        case 7:
          recuperarLibreria();
          break;
        default:
          break;
      }
    } while (operacion != 0);
  }

  private static void crearArea() {
    System.out.println("CREACIÓN DE UN ÁREA:");

    int codigo;
    do {
      codigo = Terminal.leeEntero("Introduzca el código: ");
    } while ((codigo < 0) || (Area.buscarArea(codigo) != null));

    if (codigo == 0) {
      return;
    }

    String descripcion = Terminal.leeCadena("Descripción: ");
    String ubicacion = Terminal.leeCadena("Ubicación: ");

    new Area(codigo, descripcion, ubicacion);
  }

  private static void gestionArea() {
    System.out.println("ACCESO A LA GESTION DE UN ÁREA");

    int codigo;
    Area area;

    do {
      codigo = Terminal.leeEntero("Introduzca el código: ");
      if (codigo == 0) {
        return;
      }
    } while ((codigo < 0) || ((area = Area.buscarArea(codigo)) == null));

    area.gestionArea();
  }

  private static void borrarArea() {
    System.out.println("BORRAR UN CLASE");

    int codigo;

    do {
      codigo = Terminal.leeEntero("Introduzca el código: ");

      if (codigo == 0) {
        return;
      }
    } while ((codigo < 0)
            || (Area.buscarArea(codigo) == null));

    Area.borrarArea(codigo);
  }

  private static void salvarLibreria() {
    String nombreFichero;
    File accesoFichero;

    System.out.println("SALVAR LA INFORMACION DEL COLEGIO");
    nombreFichero = Terminal.leeCadena("Indique el nombre del fichero:");

    accesoFichero = new File(nombreFichero);

    if (accesoFichero.exists()) {
      System.out.println("El fichero " + nombreFichero + " existe. ¿Sobreescribir? ");
      String sobreEsc;
      do {
        sobreEsc = Terminal.leeCadena("Responda S/N: ");
      } while ((sobreEsc.compareToIgnoreCase("s") != 0) && (sobreEsc.compareToIgnoreCase("n") != 0));

      if (sobreEsc.compareToIgnoreCase("n") == 0) {
        return;
      }
    }

    try {
      FileOutputStream canalFichero = new FileOutputStream(accesoFichero);

      Fichero.graba(canalFichero, "TOTARE:" + Area.totalAreas() + "\n");
      Area.grabarAreas(canalFichero);

      canalFichero.close();
    } catch (IOException excepcion) {
      System.out.println("Error abriendo el fichero " + nombreFichero);
      excepcion.printStackTrace();
    }
  }

  private static void recuperarLibreria() {
    String nombreFichero;
    File accesoFichero;

    System.out.println("RECUPERAR LA INFORMACION DEL COLEGIO");

    System.out.println("La información actual se perderá ¿Desea continuar? ");
    String continuar;
    do {
      continuar = Terminal.leeCadena("Responda S/N: ");
    } while ((continuar.compareToIgnoreCase("s") != 0) && (continuar.compareToIgnoreCase("n") != 0));

    if (continuar.compareToIgnoreCase("n") == 0) {
      return;
    }

    do {
      nombreFichero = Terminal.leeCadena("Indique el nombre del fichero: ");
      accesoFichero = new File(nombreFichero);

      if (!accesoFichero.exists()) {
        System.out.println("El fichero " + nombreFichero + " no existe. ");
      }
    } while (!accesoFichero.exists());

    try {
      FileInputStream canalFichero = new FileInputStream(accesoFichero);

      Area.iniciaAreas();

      int totalAreas = Fichero.leeInt(canalFichero, "TOTARE:");

      for (int area = 1; area <= totalAreas; area++) {
        Area.recuperarAreas(canalFichero);
      }

      canalFichero.close();
    } catch (IOException excepcion) {
      System.out.println("Error abriendo el fichero " + nombreFichero);
      excepcion.printStackTrace();
    }
  }

}
