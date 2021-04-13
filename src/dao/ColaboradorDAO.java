/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Colaborador;

/**
 *
 * @author Otavio
 */
public class ColaboradorDAO {
    
    private static List<Colaborador> colaboradores = new ArrayList<>();
    
    public static boolean inserirColaborador(Colaborador c) {
        if(idExists(c.getId())) return false;
        colaboradores.add(c);
        return true;
    }
    
    private static boolean idExists(int id) {
        for(Colaborador c : colaboradores) {
            if(c.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public static void atualizarSalarioColaborador(int idColaborador, float salario) {
        for(Colaborador c : colaboradores) {
            if(c.getId() == idColaborador) {
                c.atualizarSalario(salario);
            }
        }
    }
    
    public static Colaborador pesquisa(String nome) {
        for(Colaborador c : colaboradores) {
            if(c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }
    
    private static boolean removerColaborador(int idColaborador) {
        for(Colaborador c : colaboradores) {
            if(c.getId() == idColaborador) {
                colaboradores.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarAcesso(int id, String senha) {
        if(ColaboradorDAO.idExists(id)) {
            for(Colaborador c : colaboradores) {
                if(c.getSenhaAcesso().equals(senha)) {
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
