/*********************************************
 * Jose F. Quesada                           *
 *                Curso de Programación Java *
 * Capitulo03/Suma100.java                   *
 *********************************************/

/**
	Esta clase calcula la suma de los
	100 primeros números usando un
	algoritmo completamente ingenuo
	e ineficiente 
*/
class Suma100 {
	public static void main (String[] args) {
		/* Fase 1: Declaración de variables */
		int contador; // Variable contador
		int suma; // Suma de los numeros

		/* Fase 2: Asignamos 0 a suma, ya
		   que al tratarse de una variable
                   acumulativa es necesario asignar
                   un valor inicial */
		suma = 0;

		/* Fase 3: Iniciamos a continuacion un 
		   bucle para recorrer los 100 primeros 
		   numeros enteros */
		for (contador=1;contador<=100; contador++)
			suma += contador;
			/* Suma acumulativa
			   suma = suma + contador */

		/* Fase 4: Escribimos el  resultado */
		System.out.println("Suma 0-100 = " + suma);
	}
}

/******** Fin de Suma100.java ****************/

