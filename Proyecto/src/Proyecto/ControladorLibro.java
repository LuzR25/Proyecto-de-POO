package Proyecto;

import java.util.ArrayList;

/**
 * La clase ControladorLibro controla toda la información de los objetos tipo Libro, recibiendo y pasando
 * información de la clase VistaLibro.
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 * @version 2.0
 */

public class ControladorLibro implements MetodoComun{
    
    private ArrayList <Libro> listaLibros;
    private ArrayList <Libro> carritoDeCompra;

    VistaLibro vista;
    VistaCliente vistaC;
    ControladorCliente controladorC;
    boolean regreso;


    ControladorLibro(VistaLibro vista){
        listaLibros = new ArrayList<Libro>();
        carritoDeCompra =  new ArrayList<Libro>();
        this.vista = vista;
    }

    /**
     * Método en el que se declaran los libros disponibles en la librería.
     */

    public void declararLibros(){ 
        listaLibros.add(0, new Libro("Besar a un ángel", "Susan Elizabeth Phillips", 0, 432.0, 30));
        listaLibros.add(1, new Libro("Damián", "Álex Mírez", 1, 312.0, 30));
        listaLibros.add(2, new Libro("Orgullo y prejuicio", "Jane Austen", 2, 327.0, 30));
        listaLibros.add(3, new Libro("Bajo la misma estrella", "John Green", 3, 314.0, 30));
        listaLibros.add(4, new Libro("Llámame por tu nombre", "André Aciman", 4, 319.0, 30));
        listaLibros.add(5, new Libro("El psicoanalista", "John Katzenbach", 5, 389.0, 30));
        listaLibros.add(6, new Libro("Agua", "Claudio Hernández", 6, 300.0, 30));
        listaLibros.add(7, new Libro("Uno de nosotros miente", "Karen M. McManus", 7, 339.0, 30));
        listaLibros.add(8, new Libro("Perdida", "Gillian Flynn", 8, 316.0, 30));
        listaLibros.add(9, new Libro("La chica del tren", "Paula Hawkins", 9, 378.0, 30));
        listaLibros.add(10, new Libro("Dune", "Frank Herbert", 10, 419.0, 30));
        listaLibros.add(11, new Libro("Un mundo feliz", "Aldous Huxley", 11, 249.0, 30));
        listaLibros.add(12, new Libro("Neuromante", "William Gibson", 12, 289.0, 30));
        listaLibros.add(13, new Libro("Fundación", "Isaac Asimov", 13, 289.0, 30));
        listaLibros.add(14, new Libro("El marciano", "Andy Weir", 14, 378.0, 30));
        listaLibros.add(15, new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling", 15, 299.0, 30));
        listaLibros.add(16, new Libro("El Hobbit", "J. R. R. Tolkien", 16, 312.0, 30));
        listaLibros.add(17, new Libro("Juego de tronos", "George R. R. Martin", 17, 395.0, 30));
        listaLibros.add(17, new Libro("Caraval", "Stephanie Garber", 18, 350.0, 30));
        listaLibros.add(19, new Libro("Lore", "Alexandra Bracken", 19, 370.0, 30));
        listaLibros.add(20, new Libro("Mobby Dick", "Herman Melville", 20, 229.0, 30));
        listaLibros.add(21, new Libro("Jane Eyre", "Charlotte Brönte", 21, 329.0, 30));
        listaLibros.add(22, new Libro("La Ilíada", "Homero", 22, 229.0, 30));
        listaLibros.add(23, new Libro("La Celestina", "Fernando de Rojas", 23, 189.0, 30));
        listaLibros.add(24, new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 24, 229.0, 30));
    }

    /**
     * Método que imprime la información de todos los libros disponibles. 
     */

    public void desplegarListaLibros(){ //Desplegar lista de libros disponibles. 
        
        vista.imprimirEncabezadoVerListaLibros();
        vista.imprimirEncabezadoLibrosRomance();
        
        for(int i=0; i<5; i++){
            vista.imprimirInfoLibro(listaLibros.get(i));
        }

        vista.imprimirEncabezadoLibrosSuspenso();

        for(int i=5; i<10; i++){
            vista.imprimirInfoLibro(listaLibros.get(i));
        }

        vista.imprimirEncabezadoLibrosCienciaFic();

        for(int i=10; i<15; i++){
            vista.imprimirInfoLibro(listaLibros.get(i));
        }

        vista.imprimirEncabezadoLibrosFantasia();

        for(int i=15; i<20; i++){
            vista.imprimirInfoLibro(listaLibros.get(i));
        }

        vista.imprimirEncabezadoLibrosClasicos();

        for(int i=20; i<listaLibros.size(); i++){
            vista.imprimirInfoLibro(listaLibros.get(i));
        }
    }

     /**
      * Método para encontrar un libro con un identificador proporcionado por el usuario.
      * @param id Se recibe de VistaLibro el identificador de un libro que luego se compara con los libros dentro un ArrayList ya declarado.
      * @return Regresa un objeto tipo Libro si haya una coincidencia en la lista de libros declarada. 
      */

    public Libro obtLibro(Integer id){ //Encontrar libro.
        for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getIdentificador() == id){
                return listaLibros.get(i);
            }
        }

        return null;
    }

    /**
     * Método para agregar un libro al ArrayList carritoDeCompra.
     * @return Se regresa un Integer para saber si se encontró el libro de identificador ingresado por el usuario en un método de VistaLibro.
     */

    public Integer agregarLibroCarritoDeCompra(){ //Agregar libro al carrito de compra.
        Libro libro;
        Integer stock;

        libro = obtLibro(vista.agregarLibro());

        if(libro != null){
            carritoDeCompra.add(libro);
            stock = libro.getStock() - 1;
            libro.setStock(stock);
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * Método que permite regresar una variable booleana con base a un parámetro recibido de otros métodos.
     * @param validar El parámetro validar permite saber si una acción hecha por un método específico se realizó con éxito.
     * @return Regresa una variable booleana que será recibida por un método en VistaLibro.
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
     * Método que permite eliminar un libro del ArrayList carritoDeCompra.
     * @return Se regresa un Integer para saber si se encontró el libro de identificador ingresado por el usuario en método de VistaLibro.
     */

    public Integer eliminarLibroCarritoDeCompra(){ //Eliminar libro del carrito de compra. 
        Libro libro;

        libro = obtLibro(vista.identificarLibrotEli());

        if(libro != null){
            carritoDeCompra.remove(libro);

            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * Método que obtiene el total a pagar con base en los precios de los libros agregados a carritoDeCompra.
     * @return Total a pagar calculado con el método. 
     */

    public double sacarTotalPagoCarritoCompra(){ //Para la opción "Ver Carrito de Compra".
        double totalPagar=0;

        for(int i=0; i<carritoDeCompra.size(); i++){
            totalPagar = totalPagar + carritoDeCompra.get(i).getPrecio();
        }

        return totalPagar;
    }

    /**
     * Método que genera un número aleatorio en un rango de 1 a 10. Si el número es mayor a 5, entonces es Lunes.
     * @return Un booleano que me permite saber si es lunes (cuando es igual a true) o no (cuando es igual a false).
     */

    public boolean saberLunes(){ //Saber si es lunes o no.
        int numero;
        
        numero = (int)(Math.random()*10+1);

        if(numero>5){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Método que obtiene el total a pagar cuando es lunes. 
     * @param listaClientes ArrayList que se pasa al método descontarPuntosTrEnCuentaLunes, 
     * el cual es usado en este método.
     */

    public void obtenerTotalPagarSiLunes(ArrayList<Cliente> listaClientes){
        double descuento, totalPagarDes, totalPagar;
        Integer puntosT;

        totalPagar = sacarTotalPagoCarritoCompra();

        descuento = totalPagar * 0.2;

        totalPagarDes = totalPagar - descuento;

        vista.imprimirTotalSiLunes(totalPagarDes, totalPagar, descuento);

        vista.informarPuntosTruenoSiLunes();

        puntosT = descontarPuntosTrEnCuentaLunes(listaClientes, totalPagarDes);

        descuento = descuento + puntosT;

        totalPagarDes = totalPagar - descuento;

        vista.imprimirTotalConDescuento(totalPagar, descuento, totalPagarDes);
    }

    /**
     * Método que obtiene el total a pagar cuando no es lunes. 
     * @param listaClientes ArrayList que se pasa al método descontarPuntosTrEnCuentaNoLunes, 
     * el cual es usado en este método.
     */

    public void obtenerTotalPagarNoLunes(ArrayList<Cliente> listaClientes){
        Double descuento, totalPagarDes, totalPagar;
        Integer puntosT;

        totalPagar = sacarTotalPagoCarritoCompra();

        descuento = 0.0;

        totalPagarDes = totalPagar - descuento;

        vista.imprimirTotalNoLunes(totalPagar);

        vista.informarPuntosTruenoNoLunes();

        puntosT = descontarPuntosTrEnCuentaNoLunes(listaClientes, totalPagarDes);

        descuento = descuento + puntosT;

        totalPagarDes = totalPagar - descuento;

        vista.imprimirTotalConDescuento(totalPagar, descuento, totalPagarDes);
    }


    /**
     * Método que encuentra a un cliente usando su identificador, y que pide la cantidad de 
     * Puntos Trueno que el cliente desee usar, siempre que esté dentro de los límites de su cuenta
     * y el rango de puntos de los que puede hacer uso teniendo en cuenta que es lunes.
     * @param listaClientes Lista en la que se busca al cliente.
     * @return La cantidad de Puntos Trueno que el cliente desea usar para poder descontarlos
     * de su total a pagar usando otro método. 
     */

    public Integer descontarPuntosTrEnCuentaLunes(ArrayList<Cliente> listaClientes, Double TAP){
        Integer id, puntosT = 0, puntosTC, PTC, PTT;
        Cliente cliente = null;

        /* PTC = Puntos Trueno del Cliente
        PTT = Puntos Trueno Totales */

        do{
            id = vista.pedirID();
            cliente = obtCliente(listaClientes, id);

            if(cliente == null){
                vista.enviarRespuestaNoCliente();
            }
        }while(cliente == null);

        if(cliente.getPuntosTr() == 0){
            vista.imprimirMensajeNoPT();
        }
        else{
            puntosT = vista.saberPuntosTruenoSiLunes();

            if(puntosT>cliente.getPuntosTr()){
                do{
                    puntosT = vista.saberPuntosTruenoSiLunes();
                }while(puntosT>cliente.getPuntosTr());
            }
        }
        
        if(puntosT == 0){
            int value = TAP.intValue(); //Cast Double to Integer. 

            PTC = ((value - (value % 100)) / 100) * 10;//Se calcula el aumento de puntos.

            PTT = cliente.getPuntosTr() + PTC; //Se realiza el aumento de puntos.

            cliente.setPuntosTr(PTT); //Se guarda el aumento de puntos en la cuenta del cliente.
        }
        else{
            puntosTC = cliente.getPuntosTr() - puntosT;

            cliente.setPuntosTr(puntosTC);
        }

        return puntosT;
    }

    /**
     * Método que encuentra a un cliente usando su identificador, y que pide la cantidad de 
     * Puntos Trueno que el cliente desee usar, siempre que esté dentro de los límites de su cuenta
     * y el rango de puntos de los que puede hacer uso teniendo en cuenta que no es lunes.
     * @param listaClientes Lista en la que se busca al cliente.
     * @return La cantidad de Puntos Trueno que el cliente desea usar para poder descontarlos
     * de su total a pagar usando otro método. 
     */

    public Integer descontarPuntosTrEnCuentaNoLunes(ArrayList<Cliente> listaClientes, Double TAP){
        Integer id, puntosT = 0, puntosTC, PTT, PTC;
        Cliente cliente = null;

        /* PTC = Puntos Trueno del Cliente
        PTT = Puntos Trueno Totales */

        do{
            id = vista.pedirID();
            cliente = obtCliente(listaClientes, id);

            if(cliente == null){
                vista.enviarRespuestaNoCliente();
            }
        }while(cliente == null);

        if(cliente.getPuntosTr() == 0){
            vista.imprimirMensajeNoPT();
        }
        else{
            puntosT = vista.saberPuntosTruenoNoLunes();

            if(puntosT>cliente.getPuntosTr()){
                do{
                    puntosT = vista.saberPuntosTruenoNoLunes();
                }while(puntosT>cliente.getPuntosTr());
            }
        }

        if(puntosT == 0){
            int value = TAP.intValue(); //Cast Double to Integer. 

            PTC = ((value - (value % 100)) / 100) * 10;//Se calcula el aumento de puntos.

            PTT = cliente.getPuntosTr() + PTC; //Se realiza el aumento de puntos.

            cliente.setPuntosTr(PTT); //Se guarda el aumento de puntos en la cuenta del cliente.
        }
        else{
            puntosTC = cliente.getPuntosTr() - puntosT;

            cliente.setPuntosTr(puntosTC);
        }

        return puntosT;
    }

    /**
     * Método que invoca a los métodos para obtener el total a pagar teniendo en cuenta
     * si es lunes o no. 
     * @param listaClientes ArrayList que se pasa a los métodos para que estos, a su vez, 
     * se la pasen a otro método que se encarga de encontrar a un cliente usando su identificador
     * para acceder a sus Puntos Trueno. 
     */

    public void encontrarTotalPaLunesONoLunes(ArrayList<Cliente> listaClientes){
        boolean lunes = saberLunes();

        if(lunes == true){
            obtenerTotalPagarSiLunes(listaClientes);
        }
        else{
            obtenerTotalPagarNoLunes(listaClientes);
        }
    }

     /**
      * Método que sirve para que el usuario "pague". 
      * @param pago Es el comando de "pagar" para el usuario; cuando éste es igual a 0, 
      se envía un mensaje de despedida. 
      */

    public void pagar(Integer pago){
        if(pago == 0){
            vista.mensajeDespedida();
        }
    }

    /**
     * Método para encontrar un cliente. 
     * @param listaClientes Lista donde se busca al cliente; se obtiene de la clase ControladorCliente.
     * @param id Identificador del cliente que se debe encontrar.
     * @return El cliente encontrado, o null, si el cliente no existe. 
     */

    public Cliente obtCliente(ArrayList<Cliente> listaClientes, Integer id){
        for(int i=0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getIdentificador() == id){
                return listaClientes.get(i);
            }
        }

        return null;
    }

    /**
     * Método que manipula la información recibida del método menuDeCompras en VistaLibro y realiza las acciones
     * necesarias para cumplir con las opciones del método menuDeCompras.
     * @param listaClientes Lista de clientes recibida del método MenuPrincipal en ControladorCliente.
     */

    public void menuCompras(ArrayList<Cliente> listaClientes){
        Integer opcion=0;

        declararLibros();

        while(opcion != 3){
            switch(vista.menuDeCompras()){

                case 1: desplegarListaLibros(); //Ver libros disponibles.
                        break;
                
                case 2: vista.enviarRespuesta(conocerEstadoProceso(agregarLibroCarritoDeCompra())); //Agregar libro al carrito de compra.
                        break;

                case 3: eliminarLibroCarritoDeCompra(); //Eliminar libro del carrito de compra.
                        break;

                case 4: vista.verCarritoCompra(sacarTotalPagoCarritoCompra(), carritoDeCompra); //Ver carrito de compra.
                        break;

                case 5: encontrarTotalPaLunesONoLunes(listaClientes); //Comprar. 
                        pagar(vista.pagar());
                        carritoDeCompra.removeAll(carritoDeCompra.subList(0, carritoDeCompra.size())); 
                        break;

                case 6: vista.mensajeDespedida(); //Salir. 
                        carritoDeCompra.removeAll(carritoDeCompra.subList(0, carritoDeCompra.size()));
                        opcion = 3; 
                        break;
            }
        }
    }
}
