/*
 * ConstanteDeKaprekar.java
 * 
 * Copyright 2016 Luis José Sánchez
 * 
 * Reto 5.3: Constante de Kaprekar
 * 
 * La definición y explicación de este fenómeno matemático se encuentra en:
 * http://es.wikipedia.org/wiki/Constante_de_Kaprekar
 * Este reto utiliza el modelo de la página:
 * https://www.aceptaelreto.com/problem/statement.php?id=100
 */

public class ConstanteDeKaprekar {
  
  public static void main (String args[]) {

    // Como se supone que todavía no hemos visto los arrays, voy mostrando el resultado a medida
    // que se van introduciendo los números.
    
    int numeroDeElementos = Terminal.leeEntero("¿Cuántos números va a introducir?");
    int numero;
    
    for (int i = 0; i < numeroDeElementos; i++) {
      numero = Terminal.leeEntero("Introduzca un número de 4 dígitos como máximo: ");
      System.out.println(kaprekar(numero));
    }
  }
  
  public static int kaprekar(int n) {

    if (n == 6174) {
      return 0;
    }
    
    int menor = ordenadoAsc(n);
    int mayor = ordenadoDesc(n);

    if (mayor == menor) {
      return 8;
    }
    
    int iteraciones = 0;
    int diferencia;
    
    do {
      diferencia = mayor - menor;
      mayor = ordenadoDesc(diferencia);
      menor = ordenadoAsc(diferencia);
      iteraciones++;
    } while (diferencia != 6174);
    
    return iteraciones;
  }
  
  // Al no usar arrays, hay que crear varias funciones para poder formar los números ordenados
  // de forma ascendente y de forma descendente.

  public static int ordenadoAsc(int n) {
    int d1 = digitoMenor(n, 4);
    n = quitaDigito(n, d1);
    int d2 = digitoMenor(n, 3);
    n = quitaDigito(n, d2);
    int d3 = digitoMenor(n, 2);
    n = quitaDigito(n, d3);
    int d4 = n;
    
    return d1 * 1000 + d2 * 100 + d3 * 10 + d4;
  }
  
  public static int ordenadoDesc(int n) {
    int d1 = digitoMayor(n, 4);
    n = quitaDigito(n, d1);
    int d2 = digitoMayor(n, 3);
    n = quitaDigito(n, d2);
    int d3 = digitoMayor(n, 2);
    n = quitaDigito(n, d3);
    int d4 = n;
    
    return d1 * 1000 + d2 * 100 + d3 * 10 + d4;
  }

  public static int digitoMayor(int n, int longitud) {
    
    int d1 = n / 1000;
    int d2 = (n / 100) % 10;
    int d3 = (n / 10) % 10;
    int d4 = n % 10;
  
    int mayor;
    
    switch(longitud) {
      case 4:
        mayor = d1;
        mayor = (d2 > mayor) ? d2 : mayor;
        mayor = (d3 > mayor) ? d3 : mayor;
        mayor = (d4 > mayor) ? d4 : mayor;
        return mayor;
      case 3:
        mayor = d2;
        mayor = (d3 > mayor) ? d3 : mayor;
        mayor = (d4 > mayor) ? d4 : mayor;
        return mayor;
      case 2:
        return (d3 > d4) ? d3 : d4;
      default:
        return -1; 
    }
  }

  public static int digitoMenor(int n, int longitud) {
    
    int d1 = n / 1000;
    int d2 = (n / 100) % 10;
    int d3 = (n / 10) % 10;
    int d4 = n % 10;
  
    int menor;
    
    switch(longitud) {
      case 4:
        menor = d1;
        menor = (d2 < menor) ? d2 : menor;
        menor = (d3 < menor) ? d3 : menor;
        menor = (d4 < menor) ? d4 : menor;
        return menor;
      case 3:
        menor = d2;
        menor = (d3 < menor) ? d3 : menor;
        menor = (d4 < menor) ? d4 : menor;
        return menor;
      case 2:
        return (d3 < d4) ? d3 : d4;
      default:
        return -1; 
    }
  }
  
  public static int quitaDigito(int n, int d) {
      
    boolean quitado = false;
    int resultado = 0;
    
    do {
      if ((n % 10 != d) || quitado) {
        resultado = resultado * 10 + (n % 10);
      } else {
        quitado = true;
      }
      n /= 10;
    } while (n > 0);
  
    return resultado;
  }
}

