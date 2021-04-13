/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Data;
import model.Gerente;

/**
 *
 * @author Otavio
 */
public class GerenteDAO {
    
    private static Gerente gerente;
        
    public static void inserirGerente(String idGerente, String nome, String CPF, 
            float salario, int cargaHoraria, int dia, int mes, int ano, String senha) {
        
        Data d = new Data(dia, mes, ano);
        gerente = new Gerente(idGerente, nome, CPF, salario, cargaHoraria, d, senha);
        
    }
    
    public static void atualizarSalarioGerente(float salario) {
        gerente.atualizarSalario(salario);
    }
    
    public static boolean verificarAcesso(int id, String senha) {
        if(gerente == null) return false;
        if(gerente.getSenhaAcesso().equals(senha)) return true;
        return false;
    }
    
    public static Gerente verGerente() {
        return gerente;
    }
}
