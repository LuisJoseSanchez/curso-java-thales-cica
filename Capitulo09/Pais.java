/*
 * Tarea 9: Total de teléfonos móviles por país (ordenados)
 *
 * Luis José Sánchez
 *
 * Datos sobre móviles de un país
 */

public class Pais implements Comparable<Pais> {
  
  private static long totalPoblacion = 0;
  private static long totalMoviles = 0;
  
  private String nombre;
  private String codigo;
  private long poblacion;
  private double porcentajeMoviles;
  private Long moviles; // utilizo el wrapper Long para poder implementar el compareTo()

  public Pais(String nombre, String codigo, long poblacion, double porcentajeMoviles) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.poblacion = poblacion;
    this.porcentajeMoviles = porcentajeMoviles;
    this.moviles = (long) (poblacion * porcentajeMoviles / 100);
    totalPoblacion += poblacion;
    totalMoviles += moviles;
  }

  public static long getTotalPoblacion() {
    return totalPoblacion;
  }

  public static long getTotalMoviles() {
    return totalMoviles;
  }
  
  @Override
  public String toString() {
    String linea = String.format("%-40s %12d %12d", nombre, poblacion, moviles);
    return linea;
  }
  
  @Override
  public int compareTo(Pais p) {
    return (p.moviles).compareTo(this.moviles);
  }
}

