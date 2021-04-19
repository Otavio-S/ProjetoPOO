/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CoordenadorDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;
import model.Coordenador;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaRequerimentoController implements Initializable {

    @FXML
    private ChoiceBox<Coordenador> cbCoordenador;
    @FXML
    private ChoiceBox<String> cbColaborador;
    @FXML
    private ChoiceBox<String> cbUsuario;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnOkClick(ActionEvent event) {
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
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialCoordenador");
    }
    
}
