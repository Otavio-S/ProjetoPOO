/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GerenteDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    @FXML
    private Button btnCarregar;
    @FXML
    private Label lblTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.btnCarregar.setVisible(false);
        this.btnVoltar.setVisible(false);
    }
    
    private void clearAll() {
        this.edtID.clear();
        this.edtNome.clear();
        this.edtCPF.clear();
        this.edtSalario.clear();
        this.edtCargaHoraria.clear();
        this.edtDataNascimento.setValue(null);
        this.edtSenha.clear();
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
        
        GerenteDAO.inserirGerente(this.edtID.getText(), 
                this.edtNome.getText(),
                this.edtCPF.getText(),
                Float.parseFloat(this.edtSalario.getText()),
                Integer.parseInt(this.edtCargaHoraria.getText()), 
                this.edtDataNascimento.getValue().getDayOfMonth(), 
                this.edtDataNascimento.getValue().getMonth().getValue()+1,
                this.edtDataNascimento.getValue().getYear(),
                this.edtSenha.getText());
        
        this.btnCadastrar.setText("Atualizar");
        this.btnCarregar.setVisible(true);
        this.btnVoltar.setVisible(true);
        this.lblTitulo.setText("Dados Gerente");
        this.clearAll();
        ProjetoPOO.TrocaTela("login");
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        this.clearAll();
        ProjetoPOO.TrocaTela("inicialGerente");
    }

    @FXML
    private void btnCarregarClick(ActionEvent event) {
        this.edtCPF.setText(GerenteDAO.verGerente().getCPF());
        this.edtCargaHoraria.setText(String.valueOf(GerenteDAO.verGerente().getCargaHoraria()));
        this.edtID.setText(String.valueOf(GerenteDAO.verGerente().getId()));
        this.edtNome.setText(GerenteDAO.verGerente().getNome());
        this.edtSalario.setText(String.valueOf(GerenteDAO.verGerente().getSalario()));
        this.edtSenha.setText(GerenteDAO.verGerente().getSenhaAcesso());
        this.edtDataNascimento.setValue(LocalDate.of(
                GerenteDAO.verGerente().getDataNascimento().getAno(), 
                GerenteDAO.verGerente().getDataNascimento().getMes()-1,
                GerenteDAO.verGerente().getDataNascimento().getDia()));
        
    }
    
}
