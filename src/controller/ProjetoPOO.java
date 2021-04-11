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
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {        
        stage = primaryStage;
        primaryStage.setTitle("Assistência Social - APAE");
        
        Parent raiz;
        raiz = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
        cenaPrincipal = new Scene(raiz);
        
        primaryStage.setScene(cenaPrincipal);
        primaryStage.show();
    }
    
    public static void TrocaTela(String nomeCena) {
        switch (nomeCena) {
            case "login":
                stage.setScene(cenaPrincipal);
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
