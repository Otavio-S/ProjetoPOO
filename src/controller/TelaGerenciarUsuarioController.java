/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.CoordenadorDAO;
import dao.UsuarioDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaGerenciarUsuarioController implements Initializable {

    @FXML
    private Button btnListarID;
    @FXML
    private TableColumn<Usuario, String> columnID;
    @FXML
    private TableColumn<Usuario, String> columnNome;
    @FXML
    private TableColumn<Usuario, String> columnCPF;
    @FXML
    private TableColumn<Usuario, String> columnDataNascimento;
    @FXML
    private TableColumn<Usuario, String> columnSenha;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnListarNome;
    @FXML
    private Button btnListarTodos;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnInserir;
    @FXML
    private TextField edtID;
    @FXML
    private TextField edtNome;
    @FXML
    private TextField edtCPF;
    @FXML
    private DatePicker edtDataNascimento;
    @FXML
    private TextField edtSenha;
    @FXML
    private TableView<Usuario> tableUsuarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList lista;
    
        this.columnID.setCellValueFactory(new PropertyValueFactory<>("Idusuario"));
        this.columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        this.columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimentoString"));
        this.columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.columnSenha.setCellValueFactory(new PropertyValueFactory<>("SenhaAcesso"));
        this.columnID.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.carregaTabela();
    }
    
    private void carregaTabela() {
        try {
            this.tableUsuarios.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(UsuarioDAO.listarUsuarios());
        this.tableUsuarios.setItems(observableList);
        
        this.clearAll();
    }
    
    private void clearAll() {
        this.edtID.clear();
        this.edtCPF.clear();
        this.edtNome.clear();
        this.edtDataNascimento.setValue(null);
        this.edtSenha.clear();
    }

    @FXML
    private void btnInserirClick(ActionEvent event) {
        if(this.edtCPF.getText().isEmpty() ||
                this.edtDataNascimento.getValue() == null ||
                this.edtID.getText().isEmpty() ||
                this.edtNome.getText().isEmpty() ||
                this.edtSenha.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        boolean res = UsuarioDAO.inserirUsuario(this.edtID.getText(),
                this.edtNome.getText(),
                this.edtCPF.getText(),
                this.edtDataNascimento.getValue().getDayOfMonth(),
                this.edtDataNascimento.getValue().getMonthValue(),
                this.edtDataNascimento.getValue().getYear(),
                this.edtSenha.getText());
        if(res) System.out.println("Sucessso Cadastro Usuario!");
        else return;
        
        this.carregaTabela();
    }
    
    @FXML
    private void btnAtualizarClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um ID!");
            errorAlert.showAndWait();
            return;
        }
        
        if(this.edtSenha.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite o nova senha!");
            errorAlert.showAndWait();
            return;
        }
        
        UsuarioDAO.atualizarSenhaUsuario(this.edtID.getText(), this.edtSenha.getText());
        
        this.carregaTabela();
    }

    @FXML
    private void btnExcluirClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um ID!");
            errorAlert.showAndWait();
            return;
        }
        
        UsuarioDAO.removerUsuario(this.edtID.getText());
        
        this.carregaTabela();
    }

    @FXML
    private void btnListarTodosClick(ActionEvent event) {
        this.carregaTabela();
    }
    
    @FXML
    private void btnListarIDClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um ID!");
            errorAlert.showAndWait();
            return;
        }
        
        try {
            this.tableUsuarios.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(UsuarioDAO.pesquisaID(this.edtID.getText()));
        this.tableUsuarios.setItems(observable);
        
    }

    @FXML
    private void btnListarNomeClick(ActionEvent event) {
        if(this.edtNome.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um nome!");
            errorAlert.showAndWait();
            return;
        }
        
        try {
            this.tableUsuarios.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(UsuarioDAO.pesquisa(this.edtNome.getText()));
        this.tableUsuarios.setItems(observable);
        
    }

    @FXML
    private void tableUsuariosClick(MouseEvent event) {
        Usuario user = this.tableUsuarios.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableUsuarios.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtCPF.setText(user.getCPF());
            this.edtDataNascimento.setValue(LocalDate.of(user.getDataNascimento().getAno(),
                    user.getDataNascimento().getMes(),
                    user.getDataNascimento().getDia()));
            this.edtID.setText(user.getIdusuario());
            this.edtNome.setText(user.getNome());
            this.edtSenha.setText(user.getSenhaAcesso());
        }
    }    

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialGerente");
    }

}
