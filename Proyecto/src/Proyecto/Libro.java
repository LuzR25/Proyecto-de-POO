package Proyecto;

/**
 * En la clase Libro se declararon el constructor y los getters y setters para acceder a los datos
 * de los objetos de tipo Libro.
 */

public class Libro extends Comun{
    private String autor;
    private Double precio;
    private Integer stock;

    /**
     * Constructor para crear un objeto de tipo Libro. 
     * @param n Nombre (atributo heredado de la clase Comun).
     * @param na Nombre del autor.
     * @param idl Identificador del libro (atributo heredado de la clase Comun).
     * @param pl Precio del libro.
     * @param stock Stock. 
     */

    public Libro(String n, String na, Integer idl, Double pl, Integer stock){
        super(n, idl);
        this.autor = na;
        this.precio = pl;
        this.stock = stock;
    }
    
    /** Setter del atributo autor.
     * @param autor Nombre asociado al atributo autor.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    /** Getter del atributo autor.
     * @return autor
     */
    public String getAutor() {
        return autor;
    }
    
    /** Setter del atributo precio.
     * @param precio Nombre asociado al atributo precio.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
    /** Getter del atributo precio.
     * @return precio
     */
    public Double getPrecio() {
        return precio;
    }

    
    /** Setter del atributo stock.
     * @param stock Nombre asociado al atributo stock.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    
    /** Getter del atributo stock.
     * @return stock.
     */
    public Integer getStock() {
        return stock;
    }   
}
