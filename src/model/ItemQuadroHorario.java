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
    private int duracao;
    private List<String> usuariosID;
    private List<String> colaboradoresID;

    public ItemQuadroHorario(int id, String nome, String descricao, int hora, int minuto, int duracao, DiaSemana dia) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        Hora h = new Hora(hora, minuto);
        this.horario = h;
        this.dia = dia;
        this.duracao = duracao;
        usuariosID = new ArrayList<>();
        colaboradoresID = new ArrayList<>();
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

    public int getDuracao() {
        return duracao;
    }

    public DiaSemana getDia() {
        return dia;
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

    public List getColaboradoresID() {
        return colaboradoresID;
    }
    
    public void inserirUsuario(String id) {
        this.usuariosID.add(id);
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
        int hf1 = item1.getHorario().toMinute() + item1.getDuracao();
        int hf2 = item2.getHorario().toMinute() + item2.getDuracao();
        
        if((hi1>=hi2 && hi1<=hf2) || (hf1>=hi2 && hf1<=hf2)) return true;
        if((hi2>=hi1 && hi2<=hf1) || (hf2>=hi1 && hf2<=hf1)) return true;
        
        return false;
    }
    
}
