package Proyecto;

import java.util.Scanner;

/**
 * Clase que controla los datos que ingresa y ve el usuario cuando está en el menú principal.
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 * @version 2.0
 */

public class VistaCliente {

    private Scanner lectura = new Scanner(System.in);

    /**
     * Este método es el que muestra las opciones del menú principal.
     * @return El número que corresponde a la opción que desea seleccionar el usuario.
     */

    public String menuPrincipal(){
        
        String menu ="\t\t=MENÚ PRINCIPAL=\n";
        menu += "\n[1] Registrarme en Librería Rayo. ";
        menu += "\n[2] Ver la información de mi cuenta en Librería Rayo. "; //Desplegar información del cliente.
        menu += "\n[3] Modificar información de mi cuenta en Librería Rayo."; //Modificar información del cliente.
        menu += "\n[4] Eliminar mi cuenta de Librería Rayo."; //Eliminar cliente.
        menu += "\n[5] Comprar."; //Comprar. 
        menu += "\n[6] Salir."; //Salir. 
        return menu;
    }

    //Para la opción 1: Registrarme en Librería Rayo.

    /**
     * Método que lee el nombre cuando un usuario se registra.
     * @return Nombre que el usuario ingresa.
     */

    public String leerNombre(){
        System.out.println("\n\n=Registrarme en Librería Rayo=");

        System.out.println("\nEscriba su nombre: ");
        
        return lectura.next();
    }

    /**
     * Método que lee el apellido cuando un usuario se registra.
     * @return Apellido que el usuario ingresa.
     */

    public String leerApellido(){
        System.out.println("\nEscriba su apellido: ");
        
        return lectura.next();
    }

    /**
     * Método que imprime el identificador correspondiente a la cuenta del usuario registrado.
     * @param identificadorC El párametro identificadorC es el identificador asociado a la cuenta del usuario.
     */

    public void imprimirIdentificador(Integer identificadorC){
        System.out.println("\nEl identificador de su cuenta es el número: " + identificadorC); 
    }

    //Método para encontrar un cliente.

    /**
     * Método que lee el identificador de la cuenta de un cliente.
     * @return El identificador ingresado por el usuario.
     */

    public Integer encontrarCliente(){
        System.out.println("\nEscriba el identificador de su cuenta: ");

        return lectura.nextInt();
    }

    //Método para avisar si se encontró el cliente.

    /**
     * Método que recibe un dato tipo Cliente e imprime un mensaje para avisar al usuario si se encontró o no un cliente con cierto identificador.
     * @param cliente El parámetro cliente se evalúa para saber si esta vacío o no. 
     */

    public void saberClienteEncontrar(Cliente cliente){ 
 
        if (cliente == null) { 
                System.out.println("\nError. No existe un cliente con ese identificador. Intente de nuevo.\n\n");
        }
    }

    //Para la opción 2: Ver la información de mi cuenta en Librería Rayo.

    /**
     * Método que imprime la información de un cliente, si es que lo hay. 
     * @param cliente El parámetro cliente es al que se evalúa si está vacío o no.
     */

    public void imprimirInfoCliente(Cliente cliente){ 
 
        if (cliente != null) { 
            System.out.println("\n\n.:| Cliente con identificador " + cliente.getIdentificador() + " |:.");
            System.out.println("\nNombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Puntos Trueno: " + cliente.getPuntosTr());
         } 
  
        else
           {
              System.out.println("\nError. No existe un cliente con ese identificador.\n\n");
           }
  
    }

    //Para la opción 3: Modificar información de mi cuenta en Librería Rayo. 

    /**
     * Menú que despliega los atributos que sí pueden ser modificados por el usuario.
     * @return El número que corresponde al atributo que el usuario desea cambiar.
     */

    public Integer menuModificarCliente(){
        System.out.println("\n\nDeseo modificar...");
        System.out.println("\n[1] Nombre.");
        System.out.println("[2] Apellido.");

        return lectura.nextInt();
    }

    /**
     * Lee el nombre con el que se reemplazará el antiguo.
     * @return El nuevo nombre ingresado por el usuario.
     */
    public String pedirNombre(){
        System.out.println("\nEscriba el nuevo nombre: ");

        return lectura.next();
    }

    /**
     * Lee el apellido con el que se reemplazará el antiguo.
     * @return El nuevo apellido ingresado por el usuario.
     */

    public String pedirApellido(){
        System.out.println("\nEscriba el nuevo apellido: ");

        return lectura.next();

    }

    //Para la opción 4: Eliminar mi cuenta de Librería Rayo.

    /**
     * Lee el identificador del cliente del que se desee "borrar su cuenta".
     * @return El identificador del cliente al que se desea eliminar.
     */

    public Integer identificarClientetEli(){
        System.out.println("\n\n=Eliminar mi cuenta de Librería Rayo=");
        System.out.println("\nEscriba el identificador de su cuenta: ");

        return lectura.nextInt();
    }

    //Para hacer saber al cliente.

    /**
     * Método que permite saber si se logró cierta acción o no.
     * @param estado Es el que se evalúa para saber si la acción fue lograda.
     */
    public void enviarRespuesta(boolean estado){
        if(estado==true){
            System.out.println("\nAcción realizada con éxito.\n");
        }
        else{
            System.out.println("\nError. No existe una cuenta que corresponda al identificador ingresado.\n");
        }
    }

    //El nombre habla por sí solo.

    /**
     * Método que despliega un mensaje de despedida. 
     */
    public void mensajeDespedida(){
        System.out.println("\n\n¡Hasta luego! Nunca olvides que los libros son el mejor regalo. ;)");
    }
}
