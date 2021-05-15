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
import model.Prontuario;

/**
 *
 * @author Otavio
 */
public class ProntuarioDAO {
    
    private static List<Prontuario> prontuarios = new ArrayList<>();
    
    public static void novoProntuario(String idUsuario, String descricao) {
        LocalDate d = java.time.LocalDate.now();
        Data data = new Data(d.getDayOfMonth(), d.getMonth().ordinal()+1, d.getYear());
        Prontuario p = new Prontuario(String.valueOf(RelatoriosDAO.getMaiorID()+1), idUsuario, data, descricao);
        prontuarios.add(p);
    }
    
    public static void atualizarProntuario(String idRelatorio, String desc) {
        for(Prontuario p : prontuarios) {
            if(p.getIdProntuario().equals(idRelatorio)) {
                p.alterarDescricao(desc);
            }
        }
    }
    
    static int getMaiorID() {
        int id=0;
        for(Prontuario p : prontuarios) {
            if(Integer.valueOf(p.getIdProntuario()) > id) {
                id = Integer.valueOf(p.getIdProntuario());
            }
        }
        return id;
    }
    
    public static Prontuario pesquisaID(String id) {
        for(Prontuario p : prontuarios) {
            if(p.getIdProntuario().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    public static List<Prontuario> listarProntuarios() {
        return prontuarios;
    }
}
