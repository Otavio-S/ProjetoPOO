/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaGerenciarFuncionarioController implements Initializable {

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
    private ChoiceBox<String> cbTipo;
    @FXML
    private TextField edtLocal;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnListarTodos;
    @FXML
    private Button btnListarNome;
    @FXML
    private Button btnVoltar;
    @FXML
    private TableView<?> tableFuncionarios;
    @FXML
    private TableColumn<?, ?> columnID;
    @FXML
    private TableColumn<?, ?> columnNome;
    @FXML
    private TableColumn<?, ?> columnCPF;
    @FXML
    private TableColumn<?, ?> columnSalario;
    @FXML
    private TableColumn<?, ?> columnCargaHoraria;
    @FXML
    private TableColumn<?, ?> columnDataNascimento;
    @FXML
    private TableColumn<?, ?> columnTipo;
    @FXML
    private TableColumn<?, ?> columnLocal;
    @FXML
    private TableColumn<?, ?> columnSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList lista;
        List options = new ArrayList<>();
        options.add("Centro DIA");
        options.add("Casa Lar");
        lista = FXCollections.observableArrayList(options);
        cbTipo.setItems(lista);
    }    

    @FXML
    private void btnInserirClick(ActionEvent event) {
    }

    @FXML
    private void btnAtualizarClick(ActionEvent event) {
    }

    @FXML
    private void btnExcluirClick(ActionEvent event) {
    }

    @FXML
    private void btnListarTodosClick(ActionEvent event) {
    }

    @FXML
    private void btnListarNomeClick(ActionEvent event) {
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialGerente");
    }
    
}
