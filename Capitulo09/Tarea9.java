/*
 * Tarea 9: Total de teléfonos móviles por país (ordenados)
 *
 *  Luis José Sánchez
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tarea9 {

  public static void main(String[] args) {
    ArrayList<Pais> listaPaises = new ArrayList<>();

    try {
      Scanner input = new Scanner(new File("DatosMundiales.csv"));

      while (input.hasNext()) {
        String entrada = input.nextLine();
        StringTokenizer tokens = new StringTokenizer(entrada, ",");

        listaPaises.add(
          new Pais(
            tokens.nextToken(), // nombre
            tokens.nextToken(), // código
            Long.parseLong(tokens.nextToken()), // población
            Double.parseDouble(tokens.nextToken()) // porcentaje móviles
          )
        );
      }

      Collections.sort(listaPaises);

      for (Pais p : listaPaises) {
        System.out.println(p);
      }

      System.out.format("\nTotal poblacion mundial:                 %12d\n", Pais.getTotalPoblacion());
      System.out.format("Total telefonos móviles a nivel mundial: %12d\n", Pais.getTotalMoviles());

    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

}
