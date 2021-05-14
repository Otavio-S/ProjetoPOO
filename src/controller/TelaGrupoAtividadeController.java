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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Isabella
 */
public class TelaGrupoAtividadeController implements Initializable {

    @FXML
    private TextField edtID;
    @FXML
    private TextField edtNome;
    @FXML
    private TextField edtDuracao;
    @FXML
    private TextField edtHoraInicio;
    @FXML
    private TextField edtIDColaborador;
    @FXML
    private ChoiceBox<?> cbDiaSemana;
    @FXML
    private TextField edtDescricao;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnExcluir;
    @FXML
    private TableView<?> tableGrupoAtividades;
    @FXML
    private TableColumn<?, ?> columnIDCol;
    @FXML
    private TableColumn<?, ?> columnNomeCol;
    @FXML
    private TableColumn<?, ?> columnCPFCol;
    @FXML
    private TableColumn<?, ?> columnSalarioCol;
    @FXML
    private TableColumn<?, ?> columnCargaHorariaCol;
    @FXML
    private TableColumn<?, ?> columnDataNascimentoCol;
    @FXML
    private TableColumn<?, ?> columnTipoCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void tableColaboradoresClick(MouseEvent event) {
    }
    
}
