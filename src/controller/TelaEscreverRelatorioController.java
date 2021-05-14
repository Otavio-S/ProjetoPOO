/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RelatoriosDAO;
import dao.RequerimentosDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Requerimento;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaEscreverRelatorioController implements Initializable {

    private boolean flag = true;
    private Requerimento r;
    
    @FXML
    private Button btnVoltar;
    @FXML
    private TextArea edtDesc;
    @FXML
    private TextField edtIDUsuario;
    @FXML
    private Button btnSubmeter;
    @FXML
    private TableColumn<Requerimento, Integer> columnReq;
    @FXML
    private TableColumn<Requerimento, String> columnCoord;
    @FXML
    private TableColumn<Requerimento, String> ColumnUser;
    @FXML
    private TableView<Requerimento> tableRequerimento;
    @FXML
    private AnchorPane viewEscrever;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList lista;
    
        this.columnReq.setCellValueFactory(new PropertyValueFactory<>("IdRequerimento"));
        this.columnCoord.setCellValueFactory(new PropertyValueFactory<>("IdCoordenador"));
        this.ColumnUser.setCellValueFactory(new PropertyValueFactory<>("IdUsuario"));
        
        this.carregaTabela();
    }
    
    private void clearAll() {
        this.edtIDUsuario.clear();
        this.edtDesc.clear();
    }
    
    private void carregaTabela() {
        try {
            this.tableRequerimento.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(RequerimentosDAO.listarRequerimentos(TelaLoginController.verID()));
        this.tableRequerimento.setItems(observableList);
        
    }

    @FXML
    private void btnSubmeterClick(ActionEvent event) {
        if(this.edtIDUsuario.getText().isEmpty() ||
                this.edtDesc.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        
        boolean res;
        res = RequerimentosDAO.alteraStatus(this.r.getIdRequerimento());
        if(res) {
            RelatoriosDAO.novoRelatorio(this.edtIDUsuario.getText(), this.edtDesc.getText());
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Sucesso ao Enviar Relatório");
            errorAlert.setHeaderText("Relatório Enviado com Sucesso!");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro ao Enviar");
            errorAlert.setHeaderText("Erro ao Enviar Relatório!");
            errorAlert.setContentText("Selecione o Requerimento a ser respondido.");
            errorAlert.showAndWait();
            return;
        }
        this.clearAll();
        this.carregaTabela();
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        this.clearAll();
        try {
            this.tableRequerimento.getItems().clear();
        } catch (Exception erro) {
        }
        this.flag = true;
        ProjetoPOO.TrocaTela("inicialColaborador");
    }

    @FXML
    private void viewEscreverEntered(MouseEvent event) {
        if(flag) {
            this.carregaTabela();
            flag = false;
        }
    }

    @FXML
    private void tableRequerimentoClick(MouseEvent event) {
        this.r = this.tableRequerimento.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableRequerimento.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtIDUsuario.setText(this.r.getIdUsuario());
        }
    }
    
}
