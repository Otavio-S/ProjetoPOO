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
import javafx.scene.input.MouseEvent;
import model.DiaSemana;
import model.ItemQuadroHorario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaQuadroHorarioController implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TableColumn<ItemQuadroHorario, Integer> columnID;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnNome;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnDescricao;
    @FXML
    private TableColumn<ItemQuadroHorario, Integer> columnHora;
    @FXML
    private TableColumn<ItemQuadroHorario, DiaSemana> columnDIa;
    @FXML
    private TableColumn<ItemQuadroHorario, Integer> columnDuracao;
    @FXML
    private TableColumn<ItemQuadroHorario, ?> columnUsuarios;
    @FXML
    private TableColumn<ItemQuadroHorario, ?> columnColaboradores;
    @FXML
    private TableView<ItemQuadroHorario> tableQuadroHorario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.carregaTabela();
    }    

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("");
    }

    @FXML
    private void tableCoordenadoresClick(MouseEvent event) {
    }
        
    private void carregaTabela() {
        try {
            this.tableQuadroHorario.getItems().clear();
            this.tableQuadroHorario.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(QuadroHorario.visualizarQuadroHorario());
        this.tableQuadroHorario.setItems(observableList);
        ObservableList observableList2 = FXCollections.observableArrayList(QuadroHorario.visualizarQuadroHorario());
        this.tableQuadroHorario.setItems(observableList2);
    }
}
