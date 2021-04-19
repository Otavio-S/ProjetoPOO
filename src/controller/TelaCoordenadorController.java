/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaCoordenadorController implements Initializable {

    @FXML
    private Button btnDeslogar;
    @FXML
    private Button btnRequerer;
    @FXML
    private Button btnGerenciarHorarios;
    @FXML
    private Button btnVisualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void btnRequererClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("requerimento");
    }

    @FXML
    private void btnGerenciarHorariosClick(ActionEvent event) {
        
    }

    @FXML
    private void btnVisualizarClick(ActionEvent event) {
        
    }
    
    @FXML
    private void btnDeslogarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("login");
    }
    
}
