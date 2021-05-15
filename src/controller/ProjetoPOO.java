/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Otavio
 */
public class ProjetoPOO extends Application {
    
    private static Stage stage;
    private static Scene cenaPrincipal;
    
    private static Scene cenaCadastroGerente;
    private static Scene cenaInicialGerente;
    private static Scene cenaGerenciarFuncionarios;
    private static Scene cenaGerenciarUsuarios;
    private static Scene cenaGerenciarRelatorios;
    
    private static Scene cenaInicialCoordenador;
    private static Scene cenaRequerimento;
    private static Scene cenaVisualizarRelatorio;
    private static Scene cenaQuadroHorario;
    
    private static Scene cenaInicialColaborador;
    private static Scene cenaEscreverRelatorio;
    private static Scene cenaVisualizarQuadroHorario;
    
    private static Scene cenaInicialUsuario;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {        
        stage = primaryStage;
        primaryStage.setTitle("Assistência Social - APAE");
        
        Parent raiz;
        raiz = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
        cenaPrincipal = new Scene(raiz);
        
        Parent telaCadastroGerente;
        telaCadastroGerente = FXMLLoader.load(getClass().getResource("/view/TelaCadastroGerente.fxml"));
        cenaCadastroGerente = new Scene(telaCadastroGerente);
        
        Parent telaInicialGerente;
        telaInicialGerente = FXMLLoader.load(getClass().getResource("/view/TelaGerente.fxml"));
        cenaInicialGerente = new Scene(telaInicialGerente);
        
        Parent telaGerenciarFuncionarios;
        telaGerenciarFuncionarios = FXMLLoader.load(getClass().getResource("/view/TelaGerenciarFuncionario.fxml"));
        cenaGerenciarFuncionarios = new Scene(telaGerenciarFuncionarios);
        
        Parent telaGerenciarUsuarios;
        telaGerenciarUsuarios = FXMLLoader.load(getClass().getResource("/view/TelaGerenciarUsuario.fxml"));
        cenaGerenciarUsuarios = new Scene(telaGerenciarUsuarios);
        
        Parent telaGerenciarRelatorios;
        telaGerenciarRelatorios = FXMLLoader.load(getClass().getResource("/view/TelaGerenciarRelatorio.fxml"));
        cenaGerenciarRelatorios = new Scene(telaGerenciarRelatorios);
        
        Parent telaInicialCoordenador;
        telaInicialCoordenador = FXMLLoader.load(getClass().getResource("/view/TelaCoordenador.fxml"));
        cenaInicialCoordenador = new Scene(telaInicialCoordenador);
        
        Parent telaRequerimento;
        telaRequerimento = FXMLLoader.load(getClass().getResource("/view/TelaRequerimento.fxml"));
        cenaRequerimento = new Scene(telaRequerimento);
        
        Parent telaVisualizarRelatorio;
        telaVisualizarRelatorio = FXMLLoader.load(getClass().getResource("/view/TelaVisualizarRelatorio.fxml"));
        cenaVisualizarRelatorio = new Scene(telaVisualizarRelatorio);
        
        Parent telaQuadroHorario;
        telaQuadroHorario = FXMLLoader.load(getClass().getResource("/view/TelaQuadroHorario.fxml"));
        cenaQuadroHorario = new Scene(telaQuadroHorario);
        
        Parent telaInicialColaborador;
        telaInicialColaborador = FXMLLoader.load(getClass().getResource("/view/TelaColaborador.fxml"));
        cenaInicialColaborador = new Scene(telaInicialColaborador);
        
        Parent telaEscreverRelatorio;
        telaEscreverRelatorio = FXMLLoader.load(getClass().getResource("/view/TelaEscreverRelatorio.fxml"));
        cenaEscreverRelatorio = new Scene(telaEscreverRelatorio);
        
        Parent telaVisualizar;
        telaVisualizar = FXMLLoader.load(getClass().getResource("/view/TelaVisualizarQuadroHorario.fxml"));
        cenaVisualizarQuadroHorario = new Scene(telaVisualizar);
        
        Parent telaInicialUsuario;
        telaInicialUsuario = FXMLLoader.load(getClass().getResource("/view/TelaUsuario.fxml"));
        cenaInicialUsuario = new Scene(telaInicialUsuario);
        
        primaryStage.setScene(cenaCadastroGerente);
        primaryStage.show();
    }
    
    public static void TrocaTela(String nomeCena) {
        switch (nomeCena) {
            case "login":
                stage.setScene(cenaPrincipal);
                stage.centerOnScreen();
                break;
            case "cadastroGerente":
                stage.setScene(cenaCadastroGerente);
                stage.centerOnScreen();
                break;
            case "inicialGerente":
                stage.setScene(cenaInicialGerente);
                stage.centerOnScreen();
                break;
            case "gerenciarFuncionarios":
                stage.setScene(cenaGerenciarFuncionarios);
                stage.centerOnScreen();
                break;
            case "gerenciarUsuarios":
                stage.setScene(cenaGerenciarUsuarios);
                stage.centerOnScreen();
                break;
            case "gerenciarRelatorios":
                stage.setScene(cenaGerenciarRelatorios);
                stage.centerOnScreen();
                break;
            case "inicialCoordenador":
                stage.setScene(cenaInicialCoordenador);
                stage.centerOnScreen();
                break;
            case "requerimento":
                stage.setScene(cenaRequerimento);
                stage.centerOnScreen();
                break;
            case "visualizarRelatorio":
                stage.setScene(cenaVisualizarRelatorio);
                stage.centerOnScreen();
                break;
            case "quadroHorario":
                stage.setScene(cenaQuadroHorario);
                stage.centerOnScreen();
                break;
            case "inicialColaborador":
                stage.setScene(cenaInicialColaborador);
                stage.centerOnScreen();
                break;
            case "escreverRelatorio":
                stage.setScene(cenaEscreverRelatorio);
                stage.centerOnScreen();
                break;
            case "visualizarQuadro":
                stage.setScene(cenaVisualizarQuadroHorario);
                stage.centerOnScreen();
                break;
            case "inicialUsuario":
                stage.setScene(cenaInicialUsuario);
                stage.centerOnScreen();
                break;   
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
