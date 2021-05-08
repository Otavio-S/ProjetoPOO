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
public class TelaGerenteController implements Initializable {

    @FXML
    private Button btnQuadro;
    @FXML
    private Button btnGerenciarRelatorios;
    @FXML
    private Button btnGerenciarFunconarios;
    @FXML
    private Button btnTransferir;
    @FXML
    private Button btnDeslogar;
    @FXML
    private Button btnGerenciarUsuarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnQuadroClick(ActionEvent event) {
    }

    @FXML
    private void btnGerenciarRelatoriosClick(ActionEvent event) {
    }

    @FXML
    private void btnGerenciarFuncionariosClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("gerenciarFuncionarios");
    }

    @FXML
    private void btnTransferirClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("cadastroGerente");
    }

    @FXML
    private void btnDeslogarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("login");
    }

    @FXML
    private void btnGerenciarUsuariosClick(ActionEvent event) {
    }
    
}
