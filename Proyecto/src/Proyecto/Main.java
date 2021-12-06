/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Edwin Martín
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("VistaMenuPrincipal.fxml"));
            Pane ventana = (Pane) loader.load();
            VistaCliente vista = new VistaCliente();
            VistaLibro vistaL = new VistaLibro();
            ControladorLibro Libro = new ControladorLibro(vistaL);
            ControladorCliente Cliente = new ControladorCliente(vista, Libro);
            
            VistaMenuPrincipalController control = loader.getController();
            control.Inicializar(Cliente);
            
            Scene scene = new Scene (ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
                        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
