/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Data;
import model.Relatorio;

/**
 *
 * @author Otavio
 */
public class RelatoriosDAO {
    
    private static List<Relatorio> relatorios = new ArrayList<>();
    
    public static void novoRelatorio(String idUsuario, String descricao) {
        LocalDate d = java.time.LocalDate.now();
        Data data = new Data(d.getDayOfMonth(), d.getMonth().ordinal()+1, d.getYear());
        Relatorio r = new Relatorio(String.valueOf(RelatoriosDAO.getMaiorID()+1), idUsuario, data, descricao);
        relatorios.add(r);
    }
    
    public static void atualizarRelatorio(String idRelatorio, String desc) {
        for(Relatorio r : relatorios) {
            if(r.getIdRelatorio().equals(idRelatorio)) {
                r.alterarDescricao(desc);
            }
        }
    }
    
    private static int getMaiorID() {
        int id=0;
        for(Relatorio r : relatorios) {
            if(Integer.valueOf(r.getIdRelatorio()) > id) {
                id = Integer.valueOf(r.getIdRelatorio());
            }
        }
        return id;
    }
    
    public static Relatorio pesquisaID(String id) {
        for(Relatorio r : relatorios) {
            if(r.getIdRelatorio().equals(id)) {
                return r;
            }
        }
        return null;
    }
    
    public static List<Relatorio> listarRelatorios() {
        return relatorios;
    }
}
