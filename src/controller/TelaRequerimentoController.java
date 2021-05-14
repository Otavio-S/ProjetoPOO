/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.CoordenadorDAO;
import dao.RequerimentosDAO;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import model.Colaborador;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaRequerimentoController implements Initializable {

    private int flag=0;
    
    @FXML
    private ChoiceBox<Colaborador> cbColaborador;
    @FXML
    private ChoiceBox<Usuario> cbUsuario;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnVoltar;
    @FXML
    private AnchorPane viewRequerimento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void carregar() {        
        this.cbColaborador.getItems().setAll(ColaboradorDAO.listarColaboradores());
        this.cbColaborador.setConverter(new StringConverter<Colaborador>() {
            @Override
            public String toString(Colaborador c) {
                return c.getNome();
            }

            @Override
            public Colaborador fromString(String string) {
                return null;
            }
        });
        
        this.cbUsuario.getItems().setAll(UsuarioDAO.listarUsuarios());
        this.cbUsuario.setConverter(new StringConverter<Usuario>() {
            @Override
            public String toString(Usuario u) {
                return u.getNome();
            }

            @Override
            public Usuario fromString(String string) {
                return null;
            }
        });
    }
    
    private void clearAll() {
        this.cbColaborador.setValue(null);
        this.cbUsuario.setValue(null);
    }
    
    @FXML
    private void btnOkClick(ActionEvent event) {
        
        if(this.cbColaborador.getValue() == null ||
                this.cbUsuario.getValue() == null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        
        RequerimentosDAO.novoRequerimento(CoordenadorDAO.pesquisaID(TelaLoginController.verID()).getId(),
                this.cbColaborador.getValue().getId(), 
                this.cbUsuario.getValue().getIdusuario());
        
        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setTitle("Sucesso");
        errorAlert.setHeaderText("Requerimento Inserido com Sucesso!");
        errorAlert.showAndWait();
        
        this.clearAll();
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        this.clearAll();
        this.flag = 0;
        ProjetoPOO.TrocaTela("inicialCoordenador");
    }

    @FXML
    private void viewEntered(MouseEvent event) {
        if(flag==0) {
            this.carregar();
            flag++;
        }
    }
    
}
