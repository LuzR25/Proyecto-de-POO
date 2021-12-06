package Proyecto;

/**
 *Clase de la que heredarán las clases Cliente y Libro los atributos que tienen
 * en común.
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 */
public class Comun {
    private String nombre;
    private Integer identificador;

    Comun(){}
    
    public Comun(String n, Integer id){
        this.nombre = n;
        this.identificador = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
}
