package tarea7;

import java.util.ArrayList;

public class Diccionario {
  private int identificador;
  private String descripcion;
  private static ArrayList<Termino> terminos = new ArrayList<>();
  private static int numeroDeDiccionarios = 0;

  public Diccionario(String descripcion) {
    this.identificador = ++numeroDeDiccionarios;
    this.descripcion = descripcion;
  }
  
  public void agregaTermino(Termino t) {
    terminos.add(t);
  }
  
  public void borraTermino(Termino t) {
    /*int posicion = -1;
          
    for (int i = 0; i < terminos.size(); i++) {
      if (terminos.get(i).getIdentificador() == t.getIdentificador()) {
        posicion = i;
      }
    }
          
    if (posicion == -1) {
      System.out.println("No se ha encontrado ningún diccionario con ese código.");
    } else {
      terminos.remove(posicion);
      System.out.println("Diccionario borrado correctamente.");
    }*/
  }

  public int getIdentificador() {
    return identificador;
  }

  public String getDescripcion() {
    return descripcion;
  }

  @Override
  public String toString() {
    return "Identificador: " + identificador + ", Descripción: " + descripcion + "\n";
  }
  
}
