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
import javafx.util.StringConverter;
import model.Colaborador;
import model.Coordenador;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaRequerimentoController implements Initializable {

    @FXML
    private ChoiceBox<Coordenador> cbCoordenador;
    @FXML
    private ChoiceBox<Colaborador> cbColaborador;
    @FXML
    private ChoiceBox<Usuario> cbUsuario;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCarregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void clearAll() {
        this.cbColaborador.setValue(null);
        this.cbCoordenador.setValue(null);
        this.cbUsuario.setValue(null);
    }

    @FXML
    private void btnCarregarClick(ActionEvent event) {
        this.cbCoordenador.getItems().setAll(CoordenadorDAO.listarCoordenadores());
        this.cbCoordenador.setConverter(new StringConverter<Coordenador>() {
            @Override
            public String toString(Coordenador c) {
                return c.getNome();
            }

            @Override
            public Coordenador fromString(String string) {
                return null;
            }
        });
        
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
    
    @FXML
    private void btnOkClick(ActionEvent event) {
        
        if(this.cbColaborador.getValue() == null ||
                this.cbCoordenador.getValue() == null ||
                this.cbUsuario.getValue() == null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        
        RequerimentosDAO.novoRequerimento(this.cbCoordenador.getValue().getId(),
                this.cbColaborador.getValue().getId(), 
                this.cbUsuario.getValue().getIdusuario());
        this.clearAll();
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialCoordenador");
        this.clearAll();
        System.out.println("HEY");
    }
    
}
