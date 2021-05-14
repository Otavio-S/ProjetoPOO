/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Colaborador;
import model.Coordenador;
import model.Data;

/**
 *
 * @author Otavio
 */
public class ColaboradorDAO {
    
    private static List<Colaborador> colaboradores = new ArrayList<>();
    
    public static boolean inserirColaborador(String idFuncionario, String nome, 
            String CPF, float salario, int cargaHoraria, 
            int dia, int mes, int ano, String local, String senha, String tipo) {
        
        Data d = new Data(dia, mes, ano);
        Colaborador c = new Colaborador(idFuncionario, nome, CPF, salario, cargaHoraria, d, local, senha, tipo);
        
        if(idExists(c.getId())) return false;
        colaboradores.add(c);
        return true;
    }
    
    private static boolean idExists(String id) {
        for(Colaborador c : colaboradores) {
            if(c.getId().equals(id)) {
                return true;
            }
        }
        for(Coordenador c : CoordenadorDAO.listarCoordenadores()) {
            if(c.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean atualizarSalarioColaborador(String idColaborador, float salario) {
        for(Colaborador c : colaboradores) {
            if(c.getId().equals(idColaborador)) {
                c.atualizarSalario(salario);
                return true;
            }
        }
        return false;
    }
    
    public static Colaborador pesquisa(String nome) {
        for(Colaborador c : colaboradores) {
            if(c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }
    
    public static Colaborador pesquisaID(String id) {
        for(Colaborador c : colaboradores) {
            if(c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
    
    public static boolean removerColaborador(String idColaborador) {
        for(Colaborador c : colaboradores) {
            if(c.getId().equals(idColaborador)) {
                colaboradores.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarAcesso(String id, String senha) {
        if(ColaboradorDAO.idExists(id)) {
            for(Colaborador c : colaboradores) {
                if(c.getSenhaAcesso().equals(senha) && c.getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static List<Colaborador> listarColaboradores() {
        return colaboradores;
    }
    
}
