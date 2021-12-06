package Proyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Edwin Martín
 */
public class VistaMenuPrincipalController implements Initializable {

    @FXML
    private Button btnOpcion;
    @FXML
    private TextField txt_Opcion;
    @FXML
    private TextArea txt_Menu;
    
    private ControladorCliente control;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.txt_Menu.clear();
        this.txt_Opcion.clear();
    }    

    @FXML
    private void SeleccionarOpcion(ActionEvent event) {
        try {
            int opcion = Integer.parseInt(this.txt_Opcion.getText());
            control.MenuPrincipal(opcion);
        } catch (NumberFormatException numberFormatException) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Cuidado");
            alerta.setHeaderText("Aviso");
            alerta.setContentText("Escoja una opción válida\nNúmeros enteros sin letras ni caracteres especiales.");
            alerta.show();
        }
        
    }
    
    public void Inicializar(ControladorCliente control){
        this.control = control;
        this.txt_Menu.appendText(control.getVista().menuPrincipal());
    }
}
