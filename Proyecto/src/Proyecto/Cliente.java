package Proyecto;

import java.io.Serializable;

/**
 * La clase Cliente contiene el constructor y los getters y setters para acceder a los datos
 * de un objeto tipo Cliente.
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 */

public class Cliente extends Comun implements Serializable {
    private String apellido;
    private Integer puntostr;

    Cliente(){}

    /**
     * Constructor para crear un objeto de tipo Cliente.
     * @param n Nombre (atributo heredado de la clase Comun).
     * @param ap Apellido.
     * @param idc Identificador del cliente (atributo heredado de la clase Comun).
     * @param pt Puntos Trueno.
     */

    public Cliente(String n, String ap, Integer idc, Integer pt){
        super(n, idc);
        this.apellido = ap;
        this.puntostr = pt;
    }
    
    /** Setter del atributo apellido.
     * @param apellido Corresponde al atributo apellido.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    /** Getter del atributo apellido.
     * @return String
     */
    public String getApellido() {
        return apellido;
    }
    
    /** Setter del atributo puntostr.
     * @param puntostr Corresponde al atributo puntostr.
     */
    public void setPuntosTr(Integer puntostr) {
        this.puntostr = puntostr;
    }

    
    /** Getter del atributo puntostr.
     * @return Integer
     */
    public Integer getPuntosTr() {
        return puntostr;
    }
}