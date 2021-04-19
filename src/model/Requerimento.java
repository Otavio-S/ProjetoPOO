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
    private int idCoordenador;
    private int idColaborador;
    private int idUsuario;
    private int status;

    public Requerimento(int idRequerimento, int idCoordenador, int idColaborador, int idUsuario) {
        this.idRequerimento = idRequerimento;
        this.idCoordenador = idCoordenador;
        this.idColaborador = idColaborador;
        this.idUsuario = idUsuario;
        this.status = 1;
    }

    public int getIdRequerimento() {
        return idRequerimento;
    }

    public int getIdCoordenador() {
        return idCoordenador;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
