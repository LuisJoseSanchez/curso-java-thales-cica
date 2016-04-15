
public class Persona {
  private String nombre; // nombre completo
  private int nacimiento; // año de nacimiento
  private int defuncion; // año de defunción (0 si la persona está viva)
  private String conocimiento; // área de conocimiento

  public Persona(String nombre, int nacimiento, int defuncion, String conocimiento) {
    this.nombre = nombre;
    this.nacimiento = nacimiento;
    this.defuncion = defuncion;
    this.conocimiento = conocimiento;
  }

  public String getConocimiento() {
    return conocimiento;
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    return this.nombre
           + " ("
           + this.nacimiento
           + (this.defuncion == 0 ? "" : " - " + this.defuncion)
           + "), "
           + this.conocimiento;
  }
  
  public boolean esCoetaneoDe(Persona p) {
    if (this.nombre.equals(p.getNombre())) { // una persona no es coetánea de sí misma
      return false;
    }
    
    return ((this.nacimiento <= (p.defuncion == 0 ? Integer.MAX_VALUE : p.defuncion))
         && (p.nacimiento <= (this.defuncion == 0 ? Integer.MAX_VALUE : this.defuncion)));
  }
}
