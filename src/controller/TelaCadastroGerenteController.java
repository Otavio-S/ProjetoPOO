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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaCadastroGerenteController implements Initializable {

    @FXML
    private TextField edtID;
    @FXML
    private TextField edtNome;
    @FXML
    private TextField edtCPF;
    @FXML
    private TextField edtSalario;
    @FXML
    private TextField edtCargaHoraria;
    @FXML
    private DatePicker edtDataNascimento;
    @FXML
    private TextField edtSenha;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCadastrarClick(ActionEvent event) {
        if(this.edtCPF.getText().isEmpty() || this.edtCargaHoraria.getText().isEmpty() || this.edtDataNascimento.getValue() == null ||
                this.edtID.getText().isEmpty() || this.edtNome.getText().isEmpty() || this.edtSalario.getText().isEmpty() || this.edtSenha.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        
        
        
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("login");
    }
    
}
