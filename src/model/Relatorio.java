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
    private String idRelatorio;
    private String idUsuario;
    private Data data;
    private String descricao;

    public Relatorio(String idRelatorio, String idUsuario, Data data, String descricao) {
        this.idRelatorio = idRelatorio;
        this.idUsuario = idUsuario;
        this.data = data;
        this.descricao = descricao;
    }

    public String getIdRelatorio() {
        return idRelatorio;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public Data getData() {
        return data.clone();
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void alterarDescricao(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "idRelatorio=" + idRelatorio + ", idUsuario=" + idUsuario + ", data=" + data + ", descricao=" + descricao + '}';
    }
    
}
