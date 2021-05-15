/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.DiaSemana;
import model.ItemQuadroHorario;

/**
 *
 * @author Otavio
 */
public class QuadroHorario {
    
    private static List<ItemQuadroHorario> quadro = new ArrayList<>();
    
    public void novoQuadroHorario() {
        quadro = new ArrayList<>();
    }
    
    public static void inserirItem(String nome, String descricao, int hora, int minuto, int hDuracao, int mDuracao, DiaSemana dia, String idColaborador) {
        ItemQuadroHorario item = new ItemQuadroHorario(QuadroHorario.getMaiorID()+1, nome, descricao, hora, minuto, hDuracao, mDuracao, dia, idColaborador);
        // if(QuadroHorario.checarConflito(item)) return false;
        quadro.add(item);
        Collections.sort(quadro);
    }
    
    public static void inserirItem(String nome, String descricao, int hora, int minuto, int hDuracao, int mDuracao, DiaSemana dia, String idUsuario, String idColaborador) {
        ItemQuadroHorario item = new ItemQuadroHorario(QuadroHorario.getMaiorID()+1, nome, descricao, hora, minuto, hDuracao, mDuracao, dia, idColaborador);
        item.inserirUsuario(idUsuario);
        // if(QuadroHorario.checarConflito(item)) return false;
        quadro.add(item);
        Collections.sort(quadro);
    }
    
    private static boolean checarConflito(ItemQuadroHorario item) {
        for(ItemQuadroHorario i : quadro) {
            if(ItemQuadroHorario.hasConflict(i, item)) {
                return true;
            }
        }
        return false;
    }
    
    private static int getMaiorID() {
        int id=0;
        for(ItemQuadroHorario i : quadro) {
            if(i.getId()>id) {
                id = i.getId();
            }
        }
        return id;
    }
    
    public static boolean inserirUsuario(int idItem, String idUsuario) {
        for(ItemQuadroHorario i : quadro) {
            if(i.getId() == idItem) {
                boolean res = i.inserirUsuario(idUsuario);
                return res;
            }
        }
        return false;
    }
    
    public static List<ItemQuadroHorario> pesquisar(String nome) {
        List horarioNome = new ArrayList<>();
        for(ItemQuadroHorario i : quadro) {
            if(i.getNome().equals(nome)) {
                horarioNome.add(i);
            }
        }
        return horarioNome;
    }
    
    public static boolean removerItem(int id) {
        for(ItemQuadroHorario i : quadro) {
            if(i.getId() == id) {
                quadro.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public static List<ItemQuadroHorario> visualizarQuadroHorarioColaborador(String id) {
        List horarioColaborador = new ArrayList<>();
        
        for(ItemQuadroHorario i : quadro) {
            for(String idC : i.getColaboradoresID()) {
                if(idC.equals(id)) {
                    horarioColaborador.add(i);
                    break;
                }
            }
        }
        return horarioColaborador;
    }
    
    public static List<ItemQuadroHorario> visualizarQuadroHorario(String id) {
        List horarioUsuario = new ArrayList<>();
        
        for(ItemQuadroHorario i : quadro) {
            for(String idU : i.getUsuariosID()) {
                if(idU.equals(id)) {
                    horarioUsuario.add(i);
                    break;
                }
            }
        }
        return horarioUsuario;
    }
    
    public static List<ItemQuadroHorario> visualizarQuadroHorario() {
        return quadro;
    }
    
}
