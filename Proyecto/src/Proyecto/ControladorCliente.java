package Proyecto;

import java.util.ArrayList;
import java.io.*;

/**
 * La clase ControladorCliente gestiona toda la información de los objetos tipo Cliente, recibiendo 
 * y pasando información de la clase VistaCliente. 
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 * @version 2.0
 */

public class ControladorCliente implements MetodoComun {

    private ArrayList <Cliente> clienteLista; 

    VistaCliente vista;
    ControladorLibro controladorL;
    boolean regreso;

    /**
     * Con este método se podrá acceder a la información de esta clase desde la clase App.
     * @param vista Corresponde al nombre dado en esta clase a la clase VistaCliente.
     * @param controladorL Corresponde al nombre dado en esta clase a la clase ControladorLibro.
     * @param vistaL Corresponde al nombre dado en esta clase a la clase VistaLibro.
     */

    ControladorCliente(VistaCliente vista, ControladorLibro controladorL/*, ArrayList<Cliente> clienteLista*/){
        clienteLista = new ArrayList<Cliente>();
        this.vista = vista;
        this.controladorL = controladorL;
        //this.clienteLista = clienteLista;
    }

     /**
      * Método para encontrar un cliente en el ArrayList clienteLista.
      * @param listaClientes En este método no tiene utilidad alguna, pero forma parte de 
      los parámetros del método porque este es un método "heredado" de la interfaz MetodoComun que 
      también se implementó en la clase ControladorLibro, donde sí se usa el ArrayList.
      * @param id Es el identificador que se usa para comparar con todos los clientes en el ArrayList.
      * @return El cliente al que corresponda el identificador, de lo contrario, devuelve null.
      */

    public Cliente obtCliente(ArrayList<Cliente> listaClientes, Integer id){ //Encontrar cliente.
        for(int i=0; i < clienteLista.size(); i++){
            if(clienteLista.get(i).getIdentificador() == id){
                return clienteLista.get(i);
            }
        }

        return null;
    }

    /**
     * Método que añade a un cliente al ArrayList clienteLista. Contiene un ciclo
     * que evita que existan dos clientes con un mismo identificador.
     * @return El identificador asignado al cliente añadido.
     */

    public Integer agregarCliente(){ //Añadir cliente. 
        Integer idCliente;

        idCliente = clienteLista.size();

        for(int i=0; i<clienteLista.size(); i++){
            while(idCliente == clienteLista.get(i).getIdentificador() ){
                idCliente = idCliente + 1;
            }
        }

        clienteLista.add(0, new Cliente(vista.leerNombre(), vista.leerApellido(), idCliente, 0));

        return idCliente;
    }

    /**
     * Método que permite modificar la información de un cliente.
     * @return Un integer que indica si el cliente al que se desea modificar la información fue encontrado
     * o no por el método obtCliente. 
     */

    public Integer modificarCliente(){  //Modificar información de un cliente. 
        Cliente cliente;
        Integer encontrado=0;

        cliente = obtCliente(clienteLista, vista.encontrarCliente());

        if(cliente != null){
            encontrado=1;

            switch(vista.menuModificarCliente()){
                    
                case 1: 
                cliente.setNombre(vista.pedirNombre());
                break;

                case 2: 
                cliente.setApellido(vista.pedirApellido());
                break;
            }
        }

        return encontrado;
    }

    /**
     * Método que elimina a un cliente del ArrayList clienteLista.
     * @return Un integer que indica si el cliente que se desea eliminar fue encontrado
     * o no por el método obtCliente. 
     */

    public Integer eliminarCliente(){ //Eliminar cliente.
        Cliente cliente;

        cliente = obtCliente(clienteLista, vista.identificarClientetEli());

        if (cliente != null) {
            clienteLista.remove(cliente);

            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Método que envia un booleano (que después es recibido por un método en VistaCliente) para saber si 
     * cierta acción fue realizada o no.
     * @param validar Parámetro que se evalúa para saber si la acción se realizó o no.
     * @return El booleano ya mencionado.
     */

    public boolean conocerEstadoProceso(Integer validar){ //Para saber si se logró el proceso. 
        if(validar==1){
            regreso = true;
        }
        else{
            regreso = false;
        }

        return regreso;
    }

    /**
     * Método que genera el archivo txt. llamado listaClientes, en donde se declara
     * un ArrayList de tipo Cliente que contiene la información de 10 clientes distintos.
     */

    public void crearListaClientes(){
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        listaCliente.add(new Cliente("Ana", "Velásquez", 1, 1000));
        listaCliente.add(new Cliente("José", "Moran", 2, 5000));
        listaCliente.add(new Cliente("Coral", "Nuñez", 3, 1500));
        listaCliente.add(new Cliente("Paulina", "Corales", 4, 2000));
        listaCliente.add(new Cliente("Beatriz", "Campos", 5, 10000));
        listaCliente.add(new Cliente("Aldemir", "García", 6, 50000));
        listaCliente.add(new Cliente("Eva", "Desens", 7, 10000));
        listaCliente.add(new Cliente("Soël", "García", 8, 50));
        listaCliente.add(new Cliente("Candelaria", "Peña", 8, 500));
        listaCliente.add(new Cliente("André", "Mijangos", 9, 9530));

        try (FileOutputStream salida = new FileOutputStream("listaClientes.txt")){
           
            ObjectOutputStream lista = new ObjectOutputStream(salida);
            lista.writeObject(listaCliente);
            lista.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Método que manipula la información recibida del método menuPrincipal en VistaCliente y realiza las acciones
     * necesarias para cumplir con las opciones del método menuPrincipal.
     * @param opcion Opción escogida por el cliente.
     */

    public void MenuPrincipal(int opcion){
        crearListaClientes();
            switch(opcion){

                case 1: vista.imprimirIdentificador(agregarCliente()); //Agregar cliente.
                        
                        break;
                
                case 2: vista.imprimirInfoCliente(obtCliente(clienteLista, vista.encontrarCliente())); //Desplegar información de un cliente.
                        break;

                case 3: vista.enviarRespuesta(conocerEstadoProceso(modificarCliente())); //Modificar información de un cliente.
                        break;

                case 4: vista.enviarRespuesta(conocerEstadoProceso(eliminarCliente())); //Eliminar cliente.
                        break;

                case 5: controladorL.menuCompras(clienteLista); //Comprar. 
                        break;

                case 6: vista.mensajeDespedida();
                        opcion = 1; //Salir. 
                        break;
                
            }
    }

    public VistaCliente getVista() {
        return vista;
    }
    
    
}