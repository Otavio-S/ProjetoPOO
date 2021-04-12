/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Otavio
 */
public class Prontuario {
    private int idProntuario;
    private int idUsuario;
    private Data data;
    private String descricao;

    public Prontuario(int idProntuario, int idUsuario, Data data, String descricao) {
        this.idProntuario = idProntuario;
        this.idUsuario = idUsuario;
        this.data = data;
        this.descricao = descricao;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Data getData() {
        return data.clone();
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Prontuario{" + "idProntuario=" + idProntuario + 
                ", idUsuario=" + idUsuario + ", data=" + data + 
                ", descricao=" + descricao + '}';
    }    
    
    
}
