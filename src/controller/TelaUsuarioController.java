/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuadroHorario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.ItemQuadroHorario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaUsuarioController implements Initializable {

    private boolean flag = true;
    
    @FXML
    private Button btnDeslogar;
    @FXML
    private TableView<ItemQuadroHorario> tableHorarios;
    @FXML
    private TableColumn<ItemQuadroHorario, Integer> columnID;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnNome;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnDia;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnHorario;
    @FXML
    private TableColumn<ItemQuadroHorario, Integer> columnDuracao;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnDescricao;
    @FXML
    private AnchorPane viewUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList lista;
    
        this.columnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.columnDia.setCellValueFactory(new PropertyValueFactory<>("Dia"));
        this.columnHorario.setCellValueFactory(new PropertyValueFactory<>("Horario"));
        this.columnDuracao.setCellValueFactory(new PropertyValueFactory<>("Duracao"));
        this.columnDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        
        this.carregaTabela();
    }
    
    private void carregaTabela() {
        try {
            this.tableHorarios.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(QuadroHorario.visualizarQuadroHorario(TelaLoginController.verID()));
        this.tableHorarios.setItems(observableList);
    }
    
    @FXML
    private void btnDeslogarClick(ActionEvent event) {
        this.flag = true;
        ProjetoPOO.TrocaTela("login");
    }

    @FXML
    private void viewUsuarioEntered(MouseEvent event) {
        if(this.flag) {
            this.carregaTabela();
            this.flag = false;
        }
    }
    
}
