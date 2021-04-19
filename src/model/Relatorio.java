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

public class Relatorio {
    private int idRelatorio;
    private int idUsuario;
    private Data data;
    private String descricao;

    public Relatorio(int idRelatorio, int idUsuario, Data data, String descricao) {
        this.idRelatorio = idRelatorio;
        this.idUsuario = idUsuario;
        this.data = data;
        this.descricao = descricao;
    }

    public int getIdRelatorio() {
        return idRelatorio;
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
        return "Relatorio{" + "idRelatorio=" + idRelatorio + ", idUsuario=" + idUsuario + ", data=" + data + ", descricao=" + descricao + '}';
    }
    
}
