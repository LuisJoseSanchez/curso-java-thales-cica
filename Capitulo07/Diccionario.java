/**
 * Tarea 7
 * 
 * Definición de la clase Diccionario.
 * Un diccionario tiene un identificador, una lista de términos y,
 * opcionalmente, una descripción.
 * 
 * Luis José Sánchez
 */
 
import java.util.ArrayList;

public class Diccionario {
  private int identificador;
  private String descripcion;
  private ArrayList<Termino> terminos = new ArrayList<>();
  private static int numeroDeDiccionarios = 0;

  public Diccionario(String descripcion) {
    this.identificador = ++numeroDeDiccionarios;
    this.descripcion = descripcion;
  }
  
  public ArrayList<Termino> getTerminos() {
    return terminos;
  }
  
  public int getIdentificador() {
    return identificador;
  }

  public String getDescripcion() {
    return descripcion;
  }

  @Override
  public String toString() {
    return "Identificador: " + identificador + ", Descripción: " + descripcion;
  }

  /**
   * Dos diccionarios son iguales si tienen el mismo identificador
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Diccionario other = (Diccionario) obj;
    if (this.identificador != other.identificador) {
      return false;
    }
    return true;
  }
  
  /**
  * Añade un término al diccionario
  * 
  * @param t término que se añade
  */
  public void agregaTermino(Termino t) {
    terminos.add(t);
  }
  
  /**
   * Elimina un término del diccionario
   * 
   * @param t término a borrar
   */
  public void borraTermino(Termino t) {
    terminos.remove(new Termino(t.getPalabra(), "", ""));
  }
  
  /**
   * Elimina un término del diccionario cuya palabra se pasa como parámetro
   * 
   * @param p palabra que contiene el término a borrar
   */
  public void borraTerminoPorPalabra(String p) {
    terminos.remove(new Termino(p, "", ""));
  }
  
  /**
   * Dice si un término está incluido o no en el diccionario
   * 
   * @param t término que se busca dentro del diccionario
   * @return <code>true</code> si un término concreto está incluido en el diccionario y
   *         <code>false</code> en caso contrario
   */
  public boolean contieneTermino(Termino t) {
    return terminos.contains(new Termino(t.getPalabra(), "", ""));
  }

  /**
  * Dice si una palabra está incluida o no en el diccionario
  * 
  * @param p palabra que se busca dentro del diccionario
  * @return <code>true</code> si la palabra existe en el diccionario y
  *         <code>false</code> en caso contrario
  */
  public boolean contienePalabra(String p) {
    return terminos.contains(new Termino(p, "", ""));
  }
}
