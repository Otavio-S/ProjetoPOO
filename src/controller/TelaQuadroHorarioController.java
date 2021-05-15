/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.GerenteDAO;
import dao.QuadroHorario;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import model.Colaborador;
import model.DiaSemana;
import model.ItemQuadroHorario;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Otavio
 */
public class TelaQuadroHorarioController implements Initializable {

    boolean flag = true;
    
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
    private TableColumn<ItemQuadroHorario, String> columnUsuarios;
    @FXML
    private TableColumn<ItemQuadroHorario, String> columnColaboradores;
    @FXML
    private TableView<ItemQuadroHorario> tableQuadroHorario;
    @FXML
    private AnchorPane viewQuadro;
    @FXML
    private TextField edtID;
    @FXML
    private TextField edtNome;
    @FXML
    private TextArea edtDesc;
    @FXML
    private TextField edtDuracao;
    @FXML
    private ChoiceBox<Usuario> cbUsuarios;
    @FXML
    private TextField edtHora;
    @FXML
    private Button btnListarNome;
    @FXML
    private Button btnListarTodos;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnInserirUsuario;
    @FXML
    private Button btnInserir;
    @FXML
    private ChoiceBox<Colaborador> cbColaboradores;
    @FXML
    private ChoiceBox<DiaSemana> cbDia;

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
        this.columnColaboradores.setCellValueFactory(new PropertyValueFactory<>("ColaboradoresIDString"));
        
        this.carregaTabela();
    }

    private void carregaTabela() {
        try {
            this.tableQuadroHorario.getItems().clear();
        } catch (Exception erro) {
        }
        
        ObservableList observableList = FXCollections.observableArrayList(QuadroHorario.visualizarQuadroHorario());
        this.tableQuadroHorario.setItems(observableList);
        
        this.clearAll();
    }
    
    private void clearAll() {
        this.edtID.clear();
        this.edtDesc.clear();
        this.edtNome.clear();
        this.cbDia.setValue(null);
        this.edtDuracao.clear();
        this.edtHora.clear();
        this.cbUsuarios.setValue(null);
        this.cbColaboradores.setValue(null);
    }
    
    private void carregar() {        
        this.cbDia.getItems().setAll(DiaSemana.values());
        this.cbDia.setConverter(new StringConverter<DiaSemana>() {
            @Override
            public String toString(DiaSemana d) {
                return d.toString();
            }

            @Override
            public DiaSemana fromString(String string) {
                return null;
            }
        });
        
        this.cbUsuarios.getItems().setAll(UsuarioDAO.listarUsuarios());
        this.cbUsuarios.setConverter(new StringConverter<Usuario>() {
            @Override
            public String toString(Usuario u) {
                return u.getNome();
            }

            @Override
            public Usuario fromString(String string) {
                return null;
            }
        });
                
        this.cbColaboradores.getItems().setAll(ColaboradorDAO.listarColaboradores());
        this.cbColaboradores.setConverter(new StringConverter<Colaborador>() {
            @Override
            public String toString(Colaborador c) {
                return c.getNome();
            }

            @Override
            public Colaborador fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    private void btnInserirClick(ActionEvent event) {        
        if(this.edtNome.getText().isEmpty() ||
                this.edtHora.getText().isEmpty() ||
                this.cbDia.getValue() == null ||
                this.edtDuracao.getText().isEmpty() ||
                this.cbColaboradores.getValue() == null ||
                this.edtDesc.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha os campos obrigatórios!");
            errorAlert.setContentText("Campos Obrigatórios: Nome, Hora, Dia, Duracao, Colaborador, Descrição");
            errorAlert.showAndWait();
            return;
        }
        
        if(this.edtHora.getText().charAt(0)>=48 && this.edtHora.getText().charAt(0)<=57 &&
                this.edtHora.getText().charAt(1)>=48 && this.edtHora.getText().charAt(1)<=57 &&
                this.edtHora.getText().charAt(3)>=48 && this.edtHora.getText().charAt(3)<=57 &&
                this.edtHora.getText().charAt(4)>=48 && this.edtHora.getText().charAt(4)<=57 &&
                this.edtHora.getText().charAt(2)==':') {
            ;
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Formato incorreto");
            errorAlert.setHeaderText("O campo HORA deve ser formatado assim -> 00:00");
            errorAlert.showAndWait();
            return;
        }
        
        if(this.edtDuracao.getText().charAt(0)>=48 && this.edtDuracao.getText().charAt(0)<=57 &&
                this.edtDuracao.getText().charAt(1)>=48 && this.edtDuracao.getText().charAt(1)<=57 &&
                this.edtDuracao.getText().charAt(3)>=48 && this.edtDuracao.getText().charAt(3)<=57 &&
                this.edtDuracao.getText().charAt(4)>=48 && this.edtDuracao.getText().charAt(4)<=57 &&
                this.edtDuracao.getText().charAt(2)==':') {
            ;
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Formato incorreto");
            errorAlert.setHeaderText("O campo DURAÇÂO deve ser formatado assim -> 00:00");
            errorAlert.showAndWait();
            return;
        }
        
        String h = this.edtHora.getText().charAt(0) + "" + this.edtHora.getText().charAt(1);
        int hora = Integer.parseInt(h);
        String m = this.edtHora.getText().charAt(3) + "" + this.edtHora.getText().charAt(4);
        int minuto = Integer.parseInt(m);
        
        String hd = this.edtDuracao.getText().charAt(0) + "" + this.edtDuracao.getText().charAt(1);
        int hDuracao = Integer.parseInt(hd);
        String md = this.edtDuracao.getText().charAt(3) + "" + this.edtDuracao.getText().charAt(4);
        int mDuracao = Integer.parseInt(md);
        
        if(this.cbUsuarios.getValue() != null) {
            QuadroHorario.inserirItem(this.edtNome.getText(),
                this.edtDesc.getText(),
                hora,
                minuto,
                hDuracao,
                mDuracao,
                this.cbDia.getValue(),
                this.cbUsuarios.getValue().getIdusuario(),
                this.cbColaboradores.getValue().getId());
        } else {
            QuadroHorario.inserirItem(this.edtNome.getText(),
                this.edtDesc.getText(),
                hora,
                minuto,
                hDuracao,
                mDuracao,
                this.cbDia.getValue(),
                this.cbColaboradores.getValue().getId());
        }
        
        this.carregaTabela();
        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setTitle("Sucesso ao Cadastrar");
        errorAlert.setHeaderText("Evento Inserido com Sucesso!");
        errorAlert.showAndWait();
    }

    @FXML
    private void btnInserirUsuarioClick(ActionEvent event) {
        if(this.cbUsuarios.getValue() == null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha os campos obrigatórios!");
            errorAlert.setContentText("Selecione um usuário para inserir!");
            errorAlert.showAndWait();
            return;
        }
        
        if(this.edtID.getText().isEmpty() ||
                this.cbUsuarios.getValue() == null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Preencha os campos obrigatórios!");
            errorAlert.setContentText("Selecione um evento que esse usuário não esteja cadastrado!");
            errorAlert.showAndWait();
            return;
        }
        
        boolean res = QuadroHorario.inserirUsuario(Integer.valueOf(this.edtID.getText()), this.cbUsuarios.getValue().getIdusuario());
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Sucesso ao Inserir Usuário");
            errorAlert.setHeaderText("Usuário Inserido com Sucesso no evento!");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro ao Inserir");
            errorAlert.setHeaderText("Usuário já cadastrado nesse evento!");
            errorAlert.showAndWait();
        }
        
        this.carregaTabela();
    }

    @FXML
    private void btnExcluirClick(ActionEvent event) {
        if(this.edtID.getText().equals("")) {
            this.clearAll();
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Campo Vazio");
            errorAlert.setHeaderText("Selecione um evento para excluir!");
            errorAlert.showAndWait();
            return;
        }
        
        boolean res = QuadroHorario.removerItem(Integer.valueOf(this.edtID.getText()));
        
        if(res) {
            Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
            errorAlert.setTitle("Evento Removido");
            errorAlert.setHeaderText("Evento Excluído com Sucesso!");
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro ao Excluir");
            errorAlert.setHeaderText("Evento não foi excluído!");
            errorAlert.setContentText("O ID informado não existe.");
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
            this.tableQuadroHorario.getItems().clear();
        } catch (Exception e) {
        }
        
        ObservableList observable = FXCollections.observableArrayList(QuadroHorario.pesquisar(this.edtNome.getText()));
        this.tableQuadroHorario.setItems(observable);
        this.clearAll();
    }

    @FXML
    private void tableQuadroHorarioClick(MouseEvent event) {
        ItemQuadroHorario item = this.tableQuadroHorario.getSelectionModel().getSelectedItem();
        int selectedIndex = this.tableQuadroHorario.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.edtID.setText(String.valueOf(item.getId()));
            this.edtNome.setText(item.getNome());
            this.edtDesc.setText(item.getDescricao());
            this.cbDia.setValue(item.getDia());
            this.edtHora.setText(item.getHorarioString());
            this.edtDuracao.setText(item.getDuracaoString());
            this.cbColaboradores.setValue(ColaboradorDAO.pesquisaID(item.getColaboradoresID()[0]));
        }
    }

    @FXML
    private void btnVoltarClick(ActionEvent event) {
        this.clearAll();
        this.flag = true;
        if(GerenteDAO.verGerente().getId().equals(TelaLoginController.verID())) ProjetoPOO.TrocaTela("inicialGerente");
        else ProjetoPOO.TrocaTela("inicialCoordenador");
    }

    @FXML
    private void viewQuadroEntered(MouseEvent event) {
        if(this.flag) {
            this.carregar();
            this.carregaTabela();
            this.flag = false;
        }
    }
    
}
