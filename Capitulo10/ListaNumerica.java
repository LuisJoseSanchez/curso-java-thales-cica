/*
 * Tarea 10: Librería matemática funcional
 *
 *  Luis José Sánchez
 */


import java.util.Arrays;
import java.util.Iterator;

class ListaNumerica<Item> implements Iterable<Item> {

  private Item[] elementos = (Item[]) new Object[1];
  private int posicion;

  public void resize(int longitud) {
    Item[] temporal = (Item[]) new Object[longitud];
    for (int i = 0; i < posicion; ++i) {
      temporal[i] = elementos[i];
    }
    elementos = temporal;
  }

  /**
   * Añade un elemento al final de la lista.
   * 
   * @param elemento 
   */
  public void agrega(Item elemento) {
    if (elementos.length == posicion) {
      resize(2 * elementos.length);
    }
    elementos[posicion] = elemento;
    posicion++;
  }

  /**
   * Inserta un elemento en una posición y desplaza el resto de elementos hacia el final.
   * Si la posición que se indica es 0 o negativa, se inserta por el principio.
   * Si la posición que se indica es mayor o igual al número de elementos, se inserta por el final.
   * 
   * @param elemento
   * @param i 
   */
  public void inserta(Item elemento, int i) {
    if (elementos.length == posicion) {
      resize(2 * elementos.length);
    }
    
    if ( i >= posicion ) { // añade el elemento al final
      elementos[posicion] = elemento;
    } else if (i <= 0) { // inserta el elemento al principio
      for (int j = posicion; j > 0; j--) {
        elementos[j] = elementos[j - 1];
      }
      elementos[0] = elemento;
    } else { // inserta el elemento por enmedio
      for (int j = posicion; j > i; j--) {
        elementos[j] = elementos[j - 1];
      }
      elementos[i] = elemento;
    }

    posicion++;
  }
  
  /**
   * Devuelve el elemento que se encuentra en la posición i de la lista
   * 
   * @param i
   * @return elemento de la posición i-ésima
   */
  public Item elementoEn(int i) {
    return elementos[i];
  }

  /**
   * Borra el elemento de la posición i
   * 
   * @param i 
   */
  public void borra(int i) {
      for (int j = i; j < posicion; j++) {
        elementos[j] = elementos[j + 1];
      }

    posicion--;
    
    if (posicion > 0 && posicion == posicion / 4) {
      resize(elementos.length / 2);
    }
  }

  public boolean isEmpty() {
    return posicion == 0;
  }

  public int size() {
    return posicion;
  }
  
  public void ordena() {
    Arrays.sort(elementos);
  }

  public Iterator<Item> iterator() {
    return new Iterador();
  }

  private class Iterador implements Iterator<Item> {

    private int iteraPosicion = 0;

    public boolean hasNext() {
      if (iteraPosicion < posicion) {
        return true;
      } else {
        return false;
      }
    }

    public Item next() {
      return elementos[iteraPosicion++];
    }

    public void remove() {
    }
  }
}
