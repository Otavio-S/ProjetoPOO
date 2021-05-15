/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class ItemQuadroHorario implements Comparable< ItemQuadroHorario > {
    private int id;
    private String nome;
    private String descricao;
    private Hora horario;
    private DiaSemana dia;
    private Hora duracao;
    private List<String> usuariosID;
    private List<String> colaboradoresID;

    public ItemQuadroHorario(int id, String nome, String descricao, int hora, int minuto, int hDuracao, int mDuracao, DiaSemana dia, String idColab) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        Hora h = new Hora(hora, minuto);
        this.horario = h;
        this.dia = dia;
        Hora hD = new Hora(hDuracao, mDuracao);
        this.duracao = hD;
        usuariosID = new ArrayList<>();
        colaboradoresID = new ArrayList<>();
        this.colaboradoresID.add(idColab);
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Hora getHorario() {
        return horario;
    }
    
    public String getHorarioString() {
        return horario.toString();
    }

    public DiaSemana getDia() {
        return dia;
    }

    public String getDiaString() {
        return dia.toString();
    }

    public Hora getDuracao() {
        return duracao;
    }
    
    public String getDuracaoString() {
        return duracao.toString();
    }

    public String[] getUsuariosID() {
        String[] u = new String[this.usuariosID.size()];
        int i = 0;
        for(String n : this.usuariosID) {
            u[i] = n;
            ++i;
        }
        return u;
    }
    
    public String getUsuariosIDString() {
        String u = "";
        int len = this.usuariosID.size();
        for(int i = 0; i< len; i++) {
            u += this.usuariosID.get(i);
            if(i!=len-1) u += " - ";
        }
        return u;
    }

    public String[] getColaboradoresID() {
        String[] c = new String[this.colaboradoresID.size()];
        int i = 0;
        for(String n : this.colaboradoresID) {
            c[i] = n;
            ++i;
        }
        return c;
    }
    
    public String getColaboradoresIDString() {
        String c = "";
        int len = this.colaboradoresID.size();
        for(int i = 0; i< len; i++) {
            c += this.colaboradoresID.get(i);
            if(i!=len-1) c += " - ";
        }
        return c;
    }
    
    public boolean inserirUsuario(String id) {
        for(String n : this.usuariosID) {
            if(n.equals(id)) {
                return false;
            }
        }
        this.usuariosID.add(id);
        return true;
    }
    
    public void inserirColaborador(String id) {
        this.colaboradoresID.add(id);
    }

    @Override
    public String toString() {
        return "ItemQuadroHorario{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", horario=" + horario + ", dia=" + dia + ", duracao=" + duracao + '}';
    }
    
    @Override
    public int compareTo(ItemQuadroHorario i) {
        return this.getHorario().compareTo(i.getHorario());
    }
    
    public static boolean hasConflict(ItemQuadroHorario item1, ItemQuadroHorario item2) {
        if(Hora.isEqual(item1.getHorario(), item2.getHorario())) return true;
        
        int hi1 = item1.getHorario().toMinute();
        int hi2 = item2.getHorario().toMinute();
        int hf1 = item1.getHorario().toMinute() + item1.getDuracao().toMinute();
        int hf2 = item2.getHorario().toMinute() + item2.getDuracao().toMinute();
        
        if((hi1>=hi2 && hi1<=hf2) || (hf1>=hi2 && hf1<=hf2)) return true;
        if((hi2>=hi1 && hi2<=hf1) || (hf2>=hi1 && hf2<=hf1)) return true;
        
        return false;
    }
    
}
