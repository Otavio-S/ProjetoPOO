/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.CoordenadorDAO;
import dao.GerenteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaLoginController implements Initializable {

    @FXML
    private TextField edtID;
    @FXML
    private PasswordField edtSenha;
    @FXML
    private Button btnEntrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void clearAll() {
        this.edtID.clear();
        this.edtSenha.clear();
    }

    @FXML
    private void btnEntrarClick(ActionEvent event) {
        
        if(this.edtID.getText().isEmpty() || this.edtSenha.getText().isEmpty()) {
            Alert errorAlert = new Alert(AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha ambos os campos!");
            errorAlert.setContentText("Digite seu ID e sua senha.");
            errorAlert.showAndWait();
            return;
        }
        
        if(GerenteDAO.verificarAcesso(this.edtID.getText(),
                this.edtSenha.getText())) {
            System.out.println("Sucesso Gerente!");
            ProjetoPOO.TrocaTela("inicialGerente");
            this.clearAll();
            return;
        }
        
        if(CoordenadorDAO.verificarAcesso(this.edtID.getText(),
                this.edtSenha.getText())) {
            System.out.println("Sucesso Coordenador!");
            ProjetoPOO.TrocaTela("inicialCoordenador");
            this.clearAll();
            return;
        }
        
        if(ColaboradorDAO.verificarAcesso(this.edtID.getText(),
                this.edtSenha.getText())) {
            System.out.println("Sucesso Colaborador!");
            ProjetoPOO.TrocaTela("inicialColaborador");
            this.clearAll();
            return;
        }
        
        System.out.println("Erro ou Usuário não cadastrado!");
        
    }

    private void lblCadastroClick(MouseEvent event) {      
        this.clearAll();
        ProjetoPOO.TrocaTela("cadastroGerente");
    }
    
}
