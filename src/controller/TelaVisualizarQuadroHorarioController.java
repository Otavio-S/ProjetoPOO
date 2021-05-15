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
import model.DiaSemana;
import model.ItemQuadroHorario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaVisualizarQuadroHorarioController implements Initializable {

    private boolean flag = true;
    
    @FXML
    private AnchorPane viewQuadro;
    @FXML
    private TableView<ItemQuadroHorario> tableQuadroHorario;
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
    private TableColumn<ItemQuadroHorario, String> columnUsuarios;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList lista;
    
        this.columnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.columnDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        this.columnHora.setCellValueFactory(new PropertyValueFactory<>("HorarioString"));
        this.columnDIa.setCellValueFactory(new PropertyValueFactory<>("DiaString"));
        this.columnDuracao.setCellValueFactory(new PropertyValueFactory<>("DuracaoString"));
        this.columnUsuarios.setCellValueFactory(new PropertyValueFactory<>("UsuariosIDString"));
        
        this.carregaTabela();
    }

    private void carregaTabela() {
        try {
            this.tableQuadroHorario.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(QuadroHorario.visualizarQuadroHorarioColaborador(TelaLoginController.verID()));
        this.tableQuadroHorario.setItems(observableList);
        
    }
    
    @FXML
    private void btnVoltarClick(ActionEvent event) {
        this.flag = true;
        try {
            this.tableQuadroHorario.getItems().clear();
        } catch (Exception erro) {
        }
        ProjetoPOO.TrocaTela("inicialColaborador");  
    }

    @FXML
    private void viewQuadroEntered(MouseEvent event) {
        if(flag) {
            this.carregaTabela();
            this.flag = false;
        }
    }
    
}
