/**
 * Tarea 7
 * 
 * Definición de la clase Termino.
 * Un término tiene consta de una palabra, una raiz y una definición.
 * 
 * Luis José Sánchez
 */

import java.util.Objects;

public class Termino {
  private String palabra;
  private String raiz;
  private String definicion;

  public Termino(String palabra, String raiz, String definicion) {
    this.palabra = palabra;
    this.raiz = raiz;
    this.definicion = definicion;
  }

  public String getPalabra() {
    return palabra;
  }

  @Override
  public String toString() {
    return "--------\nPalabra: " + palabra + "\nRaiz: " + raiz + "\nDefinición: " + definicion;
  }

  /**
   * Dos términos son iguales si <code>palabra</code> es la misma en ambos.
   * 
   * @param obj
   * @return <code>true</code> si los términos son iguales y <code>false</code> si son distintos
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
    final Termino other = (Termino) obj;
    if (!Objects.equals(this.palabra, other.palabra)) {
      return false;
    }
    return true;
  }
  
}
