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
public class Usuario {
    private int idusuario;
    private String nome;
    private Data dataNascimento;

    public Usuario(int idusuario, String nome, Data dataNascimento) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getNome() {
        return nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }
    
    
    
}
