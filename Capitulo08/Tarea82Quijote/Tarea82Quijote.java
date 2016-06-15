/**
 * Tarea 8.2: La palabra más larga del Quijote
 *
 * Luis José Sánchez
 *
 * Busca la palabra más larga contenida en "El Quijote" (fichero Quijote.txt)
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tarea82Quijote {

  public static void main(String[] args) {
    try {     
      BufferedReader bf = new BufferedReader(new FileReader("Quijote.txt"));
      
      String linea = "";
      String palabraMasLarga = "";
      int longitudPalabraMasLarga = 0;
      String[] palabras = {};
      
      System.out.println("Analizando fichero...");
      
      while (linea != null) {
        //System.out.println(linea);
        linea = bf.readLine();
        
        if (linea != null) {
          // convierte los signos de puntuación en espacios
          linea = linea.replaceAll(",", " ");
          linea = linea.replaceAll(";", " ");
          linea = linea.replaceAll("\\.", " ");
      
          linea = linea.replaceAll("\\s+"," "); // quita los espacios sobrantes

          palabras = linea.split(" "); // separa la línea en palabras
        }

        // busca la palabra más larga
        for (String palabra : palabras) {
          if (palabra.length() > longitudPalabraMasLarga) {
            palabraMasLarga = palabra;
            longitudPalabraMasLarga = palabra.length();
          }
        }
      }
    
      bf.close();
      
      System.out.println("La palabra más larga encontrada es " + palabraMasLarga + " con " + longitudPalabraMasLarga + " caracteres.");
      
    } catch (FileNotFoundException e) { // qué hacer si no se encuentra el fichero
      System.out.println("No se encuentra el fichero Quijote.txt");
    } catch (IOException e) { // qué hacer si hay un error en la lectura del fichero
      System.out.println("No se puede leer el fichero Quijote.txt");
    }
  }
  
}
