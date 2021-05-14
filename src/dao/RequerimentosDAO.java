/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Requerimento;

/**
 *
 * @author Otavio
 */
public class RequerimentosDAO {
    
    private static List<Requerimento> requerimentos = new ArrayList<>();
    
    public static void novoRequerimento(String idCoordenador, String idColaborador, String idUsuario) {
        Requerimento r = new Requerimento(RequerimentosDAO.getMaiorID()+1, idCoordenador, idColaborador, idUsuario);
        requerimentos.add(r);
    }
    
    private static int getMaiorID() {
        int id=0;
        for(Requerimento r : requerimentos) {
            if(r.getIdRequerimento()>id) {
                id = r.getIdRequerimento();
            }
        }
        return id;
    }
    
    public static boolean alteraStatus(int idRequerimento) {
       for(Requerimento r : requerimentos) {
            if(r.getIdRequerimento() == idRequerimento) {
                r.alterarStatus();
                return true;
            }
        }
       return false;
    }
    
    public static List<Requerimento> listarRequerimentos(String id) {
        List<Requerimento> reqs = new ArrayList<>();
        for(Requerimento r : requerimentos) {
            if(r.getIdColaborador().equals(id) && r.getStatus()) {
                reqs.add(r);
            }
        }
        return reqs;
    }
    
    public static List<Requerimento> listarRequerimentos() {
        return requerimentos;
    }
}
