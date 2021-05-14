/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.CoordenadorDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import model.Colaborador;
import model.Coordenador;

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
    private TableColumn<Coordenador, String> columnID;
    @FXML
    private TableColumn<Coordenador, String> columnNome;
    @FXML
    private TableColumn<Coordenador, String> columnCPF;
    @FXML
    private TableColumn<Coordenador, Float> columnSalario;
    @FXML
    private TableColumn<Coordenador, Integer> columnCargaHoraria;
    @FXML
    private TableColumn<Coordenador, String> columnDataNascimento;
    @FXML
    private TableColumn<Coordenador, String> columnTipo;
    @FXML
    private TableColumn<Coordenador, String> columnLocal;
    @FXML
    private TableColumn<Coordenador, String> columnSenha;
    @FXML
    private TableView<Coordenador> tableCoordenadores;
    @FXML
    private TableView<Colaborador> tableColaboradores;
    @FXML
    private TableColumn<Colaborador, String> columnIDCol;
    @FXML
    private TableColumn<Colaborador, String> columnNomeCol;
    @FXML
    private TableColumn<Colaborador, String> columnCPFCol;
    @FXML
    private TableColumn<Colaborador, Float> columnSalarioCol;
    @FXML
    private TableColumn<Colaborador, Integer> columnCargaHorariaCol;
    @FXML
    private TableColumn<Colaborador, String> columnDataNascimentoCol;
    @FXML
    private TableColumn<Colaborador, String> columnTipoCol;
    @FXML
    private TableColumn<Colaborador, String> columnLocalCol;
    @FXML
    private TableColumn<Colaborador, String> columnSenhaCol;
    @FXML
    private Button btnListarID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList lista;
        List options = new ArrayList<>();
        options.add("Coordenador");
        options.add("Colaborador");
        lista = FXCollections.observableArrayList(options);
        cbTipo.setItems(lista);
    
        this.columnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        this.columnCargaHoraria.setCellValueFactory(new PropertyValueFactory<>("CargaHoraria"));
        this.columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimentoString"));
        this.columnLocal.setCellValueFactory(new PropertyValueFactory<>("Local"));
        this.columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.columnSalario.setCellValueFactory(new PropertyValueFactory<>("Salario"));
        this.columnSenha.setCellValueFactory(new PropertyValueFactory<>("SenhaAcesso"));
        this.columnTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        this.columnID.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.columnIDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.columnCPFCol.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        this.columnCargaHorariaCol.setCellValueFactory(new PropertyValueFactory<>("CargaHoraria"));
        this.columnDataNascimentoCol.setCellValueFactory(new PropertyValueFactory<>("DataNascimentoString"));
        this.columnLocalCol.setCellValueFactory(new PropertyValueFactory<>("Local"));
        this.columnNomeCol.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.columnSalarioCol.setCellValueFactory(new PropertyValueFactory<>("Salario"));
        this.columnSenhaCol.setCellValueFactory(new PropertyValueFactory<>("SenhaAcesso"));
        this.columnTipoCol.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        this.columnIDCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.carregaTabela();
    }
    
    private void carregaTabela() {
        try {
            this.tableColaboradores.getItems().clear();
            this.tableCoordenadores.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(CoordenadorDAO.listarCoordenadores());
        this.tableCoordenadores.setItems(observableList);
        ObservableList observableList2 = FXCollections.observableArrayList(ColaboradorDAO.listarColaboradores());
        this.tableColaboradores.setItems(observableList2);
        this.clearAll();
    }

    private void clearAll() {
        this.edtID.clear();
        this.edtCPF.clear();
        this.edtNome.clear();
        this.edtCargaHoraria.clear();
        this.edtDataNascimento.setValue(null);
        this.edtLocal.clear();
        this.edtSalario.clear();
        this.edtSenha.clear();
        this.cbTipo.setValue(null);
    }
    
    @FXML
    private void btnInserirClick(ActionEvent event) {
        if(this.edtCPF.getText().isEmpty() ||
                this.edtCargaHoraria.getText().isEmpty() ||
                this.edtDataNascimento.getValue() == null ||
                this.edtID.getText().isEmpty() ||
                this.edtLocal.getText().isEmpty() ||
                this.edtNome.getText().isEmpty() ||
                this.edtSalario.getText().isEmpty() ||
                this.edtSenha.getText().isEmpty() ||
                this.cbTipo.getValue() == null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha todos os campos!");
            errorAlert.showAndWait();
            return;
        }
        
        if(this.cbTipo.getValue().equals("Colaborador")) {
            boolean res = ColaboradorDAO.inserirColaborador(this.edtID.getText(),
                    this.edtNome.getText(),
                    this.edtCPF.getText(),
                    Float.valueOf(this.edtSalario.getText()),
                    Integer.valueOf(this.edtCargaHoraria.getText()),
                    this.edtDataNascimento.getValue().getDayOfMonth(),
                    this.edtDataNascimento.getValue().getMonthValue(),
                    this.edtDataNascimento.getValue().getYear(),
                    this.edtLocal.getText(),
                    this.edtSenha.getText(),
                    this.cbTipo.getValue());
            if(res) {
                Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                errorAlert.setTitle("Sucesso ao Cadastrar");
                errorAlert.setHeaderText("Colaborador Inserido com Sucesso!");
                errorAlert.showAndWait();
                System.out.println("Sucessso Cadastro Colaborador!");
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erro ao Cadastrar");
                errorAlert.setHeaderText("Colaborador não foi cadastrado!");
                errorAlert.setContentText("O ID informado já existe.");
                errorAlert.showAndWait();
                return;
            }
        } else if(this.cbTipo.getValue().equals("Coordenador")) {
            boolean res = CoordenadorDAO.inserirCoordenador(this.edtID.getText(),
                    this.edtNome.getText(),
                    this.edtCPF.getText(),
                    Float.valueOf(this.edtSalario.getText()),
                    Integer.valueOf(this.edtCargaHoraria.getText()),
                    this.edtDataNascimento.getValue().getDayOfMonth(),
                    this.edtDataNascimento.getValue().getMonthValue(),
                    this.edtDataNascimento.getValue().getYear(),
                    this.edtLocal.getText(),
                    this.edtSenha.getText(),
                    this.cbTipo.getValue());
            if(res) {
                Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                errorAlert.setTitle("Sucesso ao Cadastrar");
                errorAlert.setHeaderText("Coordenador Inserido com Sucesso!");
                errorAlert.showAndWait();
                System.out.println("Sucessso Cadastro Coordenador!");
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erro ao Cadastrar");
                errorAlert.setHeaderText("Coordenador não foi cadastrado!");
                errorAlert.setContentText("O ID informado já existe.");
                errorAlert.showAndWait();
                return;
            }
        }
        this.carregaTabela();
    }

    @FXML
    private void btnAtualizarClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um ID!");
            errorAlert.showAndWait();
            return;
        }
        if(this.edtSalario.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite o novo salário!");
            errorAlert.showAndWait();
            return;
        }
        
        boolean res;
        res = CoordenadorDAO.atualizarSalarioCoordenador(this.edtID.getText(), Float.valueOf(this.edtSalario.getText()));
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Sucesso ao Atualizar Salário");
            errorAlert.setHeaderText("Salário do Coordenador foi atualizado com Sucesso!");
            errorAlert.showAndWait();
            this.carregaTabela();
            return;
        }
        
        res = ColaboradorDAO.atualizarSalarioColaborador(this.edtID.getText(), Float.valueOf(this.edtSalario.getText()));
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Sucesso ao Atualizar Salário");
            errorAlert.setHeaderText("Salário do Colaborador foi atualizado com Sucesso!");
            errorAlert.showAndWait();
        } else if(!res) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro ao Atualizar Salário");
            errorAlert.setHeaderText("Salário não foi atualizado!");
            errorAlert.setContentText("ID informado não existe.");
            errorAlert.showAndWait();
            return;
        }
        
        this.carregaTabela();
    }

    @FXML
    private void btnExcluirClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um ID!");
            errorAlert.showAndWait();
            return;
        }
        
        boolean res;
        res = ColaboradorDAO.removerColaborador(this.edtID.getText());
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Colaborador Removido");
            errorAlert.setHeaderText("Colaborador Excluído com Sucesso!");
            errorAlert.showAndWait();
            this.carregaTabela();
            return;
        }
        
        CoordenadorDAO.removerCoordenador(this.edtID.getText());
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Coordenador Removido");
            errorAlert.setHeaderText("Coordenador Excluído com Sucesso!");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro ao Remover");
            errorAlert.setHeaderText("Funcionário não foi removido!");
            errorAlert.setContentText("ID informado não existe.");
            errorAlert.showAndWait();
            return;
        }
        
        this.carregaTabela();
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
        
        try {
            this.tableColaboradores.getItems().clear();
            this.tableCoordenadores.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(ColaboradorDAO.pesquisaID(this.edtID.getText()));
        this.tableColaboradores.setItems(observable);
        observable = FXCollections.observableArrayList(CoordenadorDAO.pesquisaID(this.edtID.getText()));
        this.tableCoordenadores.setItems(observable);
        
    }

    @FXML
    private void btnListarNomeClick(ActionEvent event) {
        if(this.edtNome.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Digite um nome!");
            errorAlert.showAndWait();
            return;
        }
        
        try {
            this.tableColaboradores.getItems().clear();
            this.tableCoordenadores.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(ColaboradorDAO.pesquisa(this.edtNome.getText()));
        this.tableColaboradores.setItems(observable);
        observable = FXCollections.observableArrayList(CoordenadorDAO.pesquisa(this.edtNome.getText()));
        this.tableCoordenadores.setItems(observable);
        
    }

    @FXML
    private void tableCoordenadoresClick(MouseEvent event) {
        Coordenador coord = this.tableCoordenadores.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableCoordenadores.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtCPF.setText(coord.getCPF());
            this.edtCargaHoraria.setText(String.valueOf(coord.getCargaHoraria()));
            this.edtDataNascimento.setValue(LocalDate.of(coord.getDataNascimento().getAno(),
                    coord.getDataNascimento().getMes(),
                    coord.getDataNascimento().getDia()));
            this.edtID.setText(coord.getId());
            this.edtLocal.setText(coord.getLocal());
            this.edtNome.setText(coord.getNome());
            this.edtSalario.setText(String.valueOf(coord.getSalario()));
            this.edtSenha.setText(coord.getSenhaAcesso());
            this.cbTipo.setValue(coord.getTipo());
        }
    }

    @FXML
    private void tableColaboradoresClick(MouseEvent event) {
        Colaborador colab = this.tableColaboradores.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableColaboradores.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtCPF.setText(colab.getCPF());
            this.edtCargaHoraria.setText(String.valueOf(colab.getCargaHoraria()));
            this.edtDataNascimento.setValue(LocalDate.of(colab.getDataNascimento().getAno(),
                    colab.getDataNascimento().getMes(),
                    colab.getDataNascimento().getDia()));
            this.edtID.setText(colab.getId());
            this.edtLocal.setText(colab.getLocal());
            this.edtNome.setText(colab.getNome());
            this.edtSalario.setText(String.valueOf(colab.getSalario()));
            this.edtSenha.setText(colab.getSenhaAcesso());       
            this.cbTipo.setValue(colab.getTipo());    
        }
    }
    
    @FXML
    private void btnVoltarClick(ActionEvent event) {
        ProjetoPOO.TrocaTela("inicialGerente");
    }

}
