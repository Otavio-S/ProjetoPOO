/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Requerimento;

/**
 *
 * @author Otavio
 */
public class RequerimentosDAO {
    
    private static List<Requerimento> requerimentos;
    
    public void novoRequerimento(int idCoordenador, int idColaborador, int idUsuario) {
        Requerimento r = new Requerimento(this.getMaiorID()+1, idCoordenador, idColaborador, idUsuario);
        requerimentos.add(r);
    }
    
    private int getMaiorID() {
        int id=0;
        for(Requerimento r : requerimentos) {
            if(r.getIdRequerimento()>id) {
                id = r.getIdRequerimento();
            }
        }
        return id;
    }
    
    public boolean alteraStatus(int idRequerimento) {
       for(Requerimento r : requerimentos) {
            if(r.getIdRequerimento() == idRequerimento) {
                r.setStatus(0);
                return true;
            }
        }
       return false;
    }
    
    public static List<Requerimento> listarRequerimentos() {
        return requerimentos;
    }
}
