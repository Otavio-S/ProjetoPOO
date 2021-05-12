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
public class Requerimento {
    private int idRequerimento;
    private String idCoordenador;
    private String idColaborador;
    private String idUsuario;
    private int status;

    public Requerimento(int idRequerimento, String idCoordenador, String idColaborador, String idUsuario) {
        this.idRequerimento = idRequerimento;
        this.idCoordenador = idCoordenador;
        this.idColaborador = idColaborador;
        this.idUsuario = idUsuario;
        this.status = 1;
    }

    public int getIdRequerimento() {
        return idRequerimento;
    }

    public String getIdCoordenador() {
        return idCoordenador;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
