/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RelatoriosDAO;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import model.Relatorio;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaGerenciarRelatorioController implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TextField edtID;
    @FXML
    private TextField edtIDUsuario;
    @FXML
    private DatePicker edtData;
    @FXML
    private TextArea edtDesc;
    @FXML
    private Button btnListarTodos;
    @FXML
    private TableView<Relatorio> tableRelatorios;
    @FXML
    private TableColumn<Relatorio, String> columnID;
    @FXML
    private TableColumn<Relatorio, String> columnIDUsuario;
    @FXML
    private TableColumn<Relatorio, String> columnData;
    @FXML
    private TableColumn<Relatorio, String> columnDesc;
    @FXML
    private Button btnListarID;
    @FXML
    private Button btnAlterar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList lista;
    
        this.columnID.setCellValueFactory(new PropertyValueFactory<>("IdRelatorio"));
        this.columnIDUsuario.setCellValueFactory(new PropertyValueFactory<>("IdUsuario"));
        this.columnData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        this.columnDesc.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        this.columnID.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.carregaTabela();
    }
    
    private void carregaTabela() {
        try {
            this.tableRelatorios.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(RelatoriosDAO.listarRelatorios());
        this.tableRelatorios.setItems(observableList);
        
        this.clearAll();
    }
    
    private void clearAll() {
        this.edtID.clear();
        this.edtIDUsuario.clear();
        this.edtData.setValue(null);
        this.edtDesc.clear();
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
        
        this.clearAll();
        try {
            this.tableRelatorios.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(RelatoriosDAO.pesquisaID(this.edtID.getText()));
        this.tableRelatorios.setItems(observable);
        
    }

    @FXML
    private void tableRelatoriosClick(MouseEvent event) {
        Relatorio r = this.tableRelatorios.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableRelatorios.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtData.setValue(LocalDate.of(r.getData().getAno(),
                    r.getData().getMes(),
                    r.getData().getDia()));
            this.edtID.setText(r.getIdRelatorio());
            this.edtIDUsuario.setText(r.getIdUsuario());
            this.edtDesc.setText(r.getDescricao());
        }
    }

    @FXML
    private void btnAlterarClick(ActionEvent event) {
        if(this.edtID.getText().equals("") ||
                this.edtDesc.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha o ID e a Descrição!");
            errorAlert.showAndWait();
            return;
        }
        RelatoriosDAO.atualizarRelatorio(this.edtID.getText(), this.edtDesc.getText());
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialGerente");
    }
    
}
