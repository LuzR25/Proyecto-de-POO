package Proyecto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que controla los datos que ingresa y ve el usuario cuando entra al menú de compras.
 * @author Luz García
 * @author Edwin Martín
 * @author Angel Ricalde
 * @version 2.0
 */

public class VistaLibro {
    private Scanner lectura;
    
    /** Menú que despliega las opciones disponibles para el menú de compras.
     * @return Número que representa la elección del usuario. 
     */
    public Integer menuDeCompras(){
        lectura = new Scanner(System.in);

        System.out.println("\n\n=Menú de compras=");
        System.out.println("\n[1] Ver libros disponibles."); //Desplegar lista de libros disponibles.
        System.out.println("[2] Agregar libro al carrito de compra."); //Añadir libro al carrito de compra.
        System.out.println("[3] Eliminar libro del carrito de compra."); //Eliminar libro del carrito de compra.
        System.out.println("[4] Ver carrito de compra."); //Ver los libros añadidos al carrito de compra.
        System.out.println("[5] Pagar."); //Pagar.
        System.out.println("[6] Salir del menú de compras y regresar a menú principal. "); //Cancelar compra. 
        System.out.println("\nOpción: ");

        return lectura.nextInt();
    }

    //Para opción 1: Ver libros disponibles.

    /**
     * Imprime el encabezado de la opción 1 en el Menú de compras.
     */
    public void imprimirEncabezadoVerListaLibros(){
        System.out.println("\n\n=Lista de libros disponibles=");
    }

    /**
     * Imprime el encabezado "=Libros de romance=".
     */

    public void imprimirEncabezadoLibrosRomance(){
        System.out.println("\n=Libros de romance=");
    }

    /**
     * Imprime el encabezado "=Libros de suspenso=".
     */

    public void imprimirEncabezadoLibrosSuspenso(){
        System.out.println("\n=Libros de suspenso=");
    }

    /**
     * Imprime el encabezado "=Libros de ciencia ficción=".
     */

    public void imprimirEncabezadoLibrosCienciaFic(){
        System.out.println("\n=Libros de ciencia ficción=");
    }

    /**
     * Imprime el encabezado "=Libros de fantasía=".
     */

    public void imprimirEncabezadoLibrosFantasia(){
        System.out.println("\n=Libros de fantasía=");
    }

    /**
     * Imprime el encabezado "=Libros clásicos=".
     */

    public void imprimirEncabezadoLibrosClasicos(){
        System.out.println("\n=Libros clásicos=");
    }

    /**
     * Imprime la información contenida en el parámetro libro de tipo Libro que recibe de otro método 
     * en ControladorCliente.
     * @param libro Parámetro mencionado antes.
     */

    public void imprimirInfoLibro(Libro libro){
        System.out.println("\n.:| Libro con identificador " + libro.getIdentificador() + " |:.");
        System.out.println("Nombre del libro: " + libro.getNombre());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Stock: " + libro.getStock());
        System.out.println("Precio: $" + libro.getPrecio());
    }

    //Para opción 2: Agregar libro al carrito de compras

    /**
     * Método que lee el identificador del libro que se desee agregar al carrito de compras.
     * @return El identificador del libro ingresado por el usuario.
     */

    public Integer agregarLibro(){
        System.out.println("\n\n=Agregar libro al carrito de compra=");
        System.out.println("\nEscriba el identificador del libro que desea agregar a su carrito de compras: ");

        return lectura.nextInt();
    }

    //Para opción 3: Eliminar libro del carrito de compra. 

    /**
     * Lee el identificador del libro que se desea quitar del carrito de compras.
     * @return El identificado del libro ingresado por el usuario.
     */

    public Integer identificarLibrotEli(){
        System.out.println("\n\n=Eliminar libro de mi carrito de compra=");
        System.out.println("\nEscriba el identificador del libro que desee eliminar: ");

        return lectura.nextInt();
    }    

    //Para opción 4: Ver carrito de compras.

    /**
     * Método que permite ver el carrito de compras (total a pagar, libros en él, cantidad de libros en él).
     * @param TA Total a pagar según la cantidad de libros en el carrito de compras.
     * @param LibrosEnCarrito ArrayList que contiene los libros agregados al carrito (es básicamente el carrito
     * de compras).
     */

    public void verCarritoCompra(Double TA, ArrayList<Libro> LibrosEnCarrito){
        if (LibrosEnCarrito.size() != 0) { 
            System.out.println("\n\n=Ver carrito de compras=");
            System.out.println("\nCantidad de libros en el carrito: " + LibrosEnCarrito.size());
            System.out.println("Total a pagar: $" + TA);
            System.out.println("\nLibros en el carrito:");

            for(int i=0; i<LibrosEnCarrito.size(); i++){
                System.out.println("\n.:| Libro con identificador " + LibrosEnCarrito.get(i).getIdentificador() + " |:.");
                System.out.println("Nombre del libro: " + LibrosEnCarrito.get(i).getNombre());
                System.out.println("Autor: " + LibrosEnCarrito.get(i).getAutor());
                System.out.println("Precio: $" + LibrosEnCarrito.get(i).getPrecio());
            }  
         } 
        else
           {
              System.out.println("\nSu carrito de compras está vacío.\n\n");
           }
    }

    //Para opción 5: Pagar.

    /**
     * Imprime el subtotal, total y descuento cuando no es lunes.
     * @param TA Es el total a pagar.
     */

    public void imprimirTotalNoLunes(Double TA){ //Imprimir el total a pagar cuando no es lunes.
        System.out.println("\n\n=Pagar=");
        System.out.println("\nSubtotal: $" + TA);
        System.out.println("Descuento: $0");
        System.out.println("Total: $" + TA);
    }

    /**
     * Contiene e imprime un mensaje de despedida que se usará cuando el usuario salga del Menú de compras.
     */

    public void mensajeDespedida(){ //El nombre habla por sí solo.
        System.out.println("\n\n¡Gracias por su compra!");
    }

    /**
     * Imprime el subtotal, total y descuento cuando es lunes.
     * @param TAD Es el total a pagar con descuento (el total final).
     * @param TA Es el total a pagar (el subtotal).
     * @param D Es el descuento realizado al totala pagar.
     */

    public void imprimirTotalSiLunes(Double TAD, Double TA, Double D){ //Imprimir el total a pagar cuando es lunes.
        System.out.println("\n¡Hoy es lunes relámpago! Eso significa que todos nuestros libros en Stock tienen un 20% de descuento. Eso también significa que sólo podrá hacer uso de 200 Puntos Trueno como máximo. ");
        System.out.println("\nSubtotal: $" + TA);
        System.out.println("Descuento: $" + D);
        System.out.println("Total: $" + TAD);
    }

    /**
     * Informa al usuario de que es lunes y el máximo de Puntos de Trueno que se pueden usar.
     */

    public void informarPuntosTruenoSiLunes(){ //Saber cuántos Puntos Trueno se usarán cuando es lunes.
        System.out.println("\nDebido a que hoy es lunes relámpago, la cantidad mínima de Puntos Trueno que puede usar son 0 y la máxima 200."); 
    }

    /**
     * Lee la cantidad de Puntos Trueno a usar cuando es lunes e incluye una excepción para que esa lectura se 
     * mantenga dentro de un rango establecido.
     * @return Cantidad de Puntos Trueno que desea usar el usuario.
     */

    public Integer saberPuntosTruenoSiLunes(){ //Saber cuántos Puntos Trueno se usarán cuando es lunes.
        Integer puntosTr=0;

        do{
            try {
                System.out.println("\nEscriba la cantidad de Puntos Trueno que desee usar: ");
                puntosTr = lectura.nextInt();
                errorSiLunes(puntosTr);
            } catch (Exception e) {
                System.out.println("\nLa cantidad de Puntos Trueno ingresado no está dentro del rango mencionado o supera su cantidad de puntos disponibles. Vuelva a intentarlo.");
            }
        }while(puntosTr<0 || puntosTr>200);

        return puntosTr;
    }

    /**
     * Informa al usuario el máximo de Puntos de Trueno que se pueden usar cuando no es lunes.
     */

    public void informarPuntosTruenoNoLunes(){ //Saber cuántos Puntos Trueno se usarán cuando no es lunes.
        System.out.println("\nHoy es un día normal, así que la cantidad mínima de Puntos Trueno que puede usar son 0 y la máxima 600."); 
    }

    /**
     * Lee la cantidad de Puntos Trueno a usar cuando es no lunes e incluye una excepción para que esa lectura se 
     * mantenga dentro de un rango establecido.
     * @return Cantidad de Puntos Trueno que desea usar el usuario.
     */

    public Integer saberPuntosTruenoNoLunes(){
        Integer puntosTr=0;

        do{
            try {
                System.out.println("\nEscriba la cantidad de Puntos Trueno que desee usar: ");
                puntosTr = lectura.nextInt();
                errorNoLunes(puntosTr);
            } catch (Exception e) {
                System.out.println("\nLa cantidad de Puntos Trueno ingresado no está dentro del rango mencionado o supera su cantidad de puntos disponibles. Vuelva a intentarlo.");
            }
        }while(puntosTr<0 || puntosTr>600);

        return puntosTr;
    }

    /**
     * Imprime el subtotal, total y descuento finales; estos se obtienen después de contabilizar el descuento
     * de los Puntos Trueno.
     * @param TA Es el total a pagar (el subtotal).
     * @param D Es el descuento realizado al totala pagar.
     * @param TPD Es el total a pagar con descuento (el total final).
     */

    public void imprimirTotalConDescuento(Double TA, Double D, Double TPD){ //Imprimir el total a pagar después de decir cuántos Puntos Trueno se usarían.
        System.out.println("\nDesgloce de totales:");
        System.out.println("\nSubtotal: $" + TA);
        System.out.println("Descuento: $" + D);
        System.out.println("Total: $" + TPD);
    }

    public void imprimirTotalConDescuentoNoLunes(Double TA, Double D, Double TPD){
        System.out.println("\nDespués de hacer el descuento con sus Puntos Trueno, este es su nuevo desgloce de totales:");
        System.out.println("\nSubtotal: $" + TA);
        System.out.println("Descuento: $" + D);
        System.out.println("Total: $" + TPD);
    }

    /**
     * Método que avisa al usuario que su pago no corresponde a la cantidad que debe.
     * @return El nuevo "pago" hecho por el usuario.
     */

    /*public double pagarIncorrecto(){
        System.out.println("\nEl pago ingresado no coincide con su total a pagar. Por favor, ingrese la cantidad correcta.");
        System.out.println("\nPagar: $");

        return lectura.nextDouble();
    }*/

    /**
     * Método que permite saber si el identificador ingresado corresponde a algún libro disponible.
     * @param estado Es el que se evalúa para saber si la acción fue lograda.
     */

    //Para hacer saber al cliente.
    public void enviarRespuesta(boolean estado){
        if(estado==true){
            System.out.println("\nAcción realizada con éxito.\n");
        }
        else{
            System.out.println("\nError. No existe un libro que corresponda al identificador ingresado.\n");
        }
    }

     /**
      * Excepción para mantener la cantidad de Puntos Trueno en el rango deseado cuando es lunes.
      * @param PT Puntos Trueno ingresados por el usuario.
      * @throws RangoExcepcion Se lanza cuando la cantidad de puntos Trueno ingresada por el usuario en otro
     * método no está dentro del rango establecido.
      */

    public void errorSiLunes(Integer PT) throws RangoExcepcion{
        if(PT<0 || PT>200){
            throw new RangoExcepcion();
        }
    }

    /**
     * Excepción para mantener la cantidad de Puntos Trueno en el rango deseado cuando es no lunes.
     * @param PT Puntos Trueno ingresados por el usuario.
     * @throws RangoExcepcion Se lanza cuando la cantidad de puntos Trueno ingresada por el usuario en otro
     * método no está dentro del rango establecido.
     */

    public void errorNoLunes(Integer PT) throws RangoExcepcion{
        if(PT<0 || PT>600){
            throw new RangoExcepcion();
        }
    }

    /**
     * Método que solicita al usuario que escriba el identificador de su cuenta para poder hayarla y 
     * conocer la cantidad de Puntos Trueno que tiene disponibles.
     * @return Identificador de la cuenta.
     */

    public Integer pedirID(){
        System.out.println("\nEscribe el identificador de su cuenta: ");

        return lectura.nextInt();
    }

    /**
     * Método que imprime un mensaje que le dice al usuario que no tiene ningún Punto Trueno.
     */
    
    public void imprimirMensajeNoPT(){
        System.out.println("\n¡Oh! Parece que aún no tiene ningún Punto Trueno, así que no tiene acceso a ese descuento.");
    }

    /**
     * Método que le dice al usuario que la cantidad de Puntos Trueno que intenta ingresar no está dentro de sus
     * puntos disponibles.
     */
    public void imprimirMensajePT(){
        System.out.println("\nLa cantidad de Puntos Trueno que intenta ingresar no está dentro de los límites de sus puntos disponibles.");
    }

    /**
     * Imprime un mensaje en pantalla que le informa al cliente que no existe un
     * cliente con el identificador ingresado.
     */

    public void enviarRespuestaNoCliente(){
        System.out.println("\nError. No existe una cuenta que corresponda al identificador ingresado.\n");
    }

    /**
     * Métodoq que lanza la excepción PagoExcepcion.
     * @param pago Este parámetro corresponde a la activación de "pago" que hace el cliente.
     * @throws PagoExcepcion Se lanza cuando pago es distinto de 0. 
     */

    public void errorPago(Integer pago) throws PagoExcepcion{
        if(pago != 0){
            throw new PagoExcepcion();
        }
    }

    /**
     * Permite "pagar" al usuario.
     * @return La letra "p" para confirmar que se realiza el pago. 
     */

    public Integer pagar(){
        Integer pago = 1;

        System.out.println("\nPara pagar, ingrese el número 0.");


        do{
            try {
                pago = lectura.nextInt();
                errorPago(pago);
            } catch (Exception e) {
                System.out.println("\nNo ha ingresado el número 0. Por favor, vuelva a intentarlo.\n");
            }
        }while(pago != 0);

        return pago;        
    }   
}
