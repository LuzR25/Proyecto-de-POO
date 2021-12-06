package Proyecto;



 import java.util.ArrayList;

/**
 * Interfaz donde se declara el método obtCliente, usado en las clases ControladorCliente
 * y ControladorLibro.
 */
public interface MetodoComun {    
    /**
     * Método para que se usará para encontrar a un cliente dentro de un ArrayList, que
     * se usará en las Clases ControladorLibro y ControladorCliente.
     * @param listaClientes ArrayList que se usará cuando la clase ControladroLibro
     * implemente el método; es un parámetro inútil para la clase ControladorCliente, 
     * pero no le afecta, perjudica o depende de él. 
     * @param id Identificador del cliente; se usa para identificar al cliente dentro del
     * ArrayList.
     * @return Cliente encontrado, o null, si no hubo ninguna coincidencia.
     */
    public Cliente obtCliente (ArrayList<Cliente> listaClientes, Integer id);
}
