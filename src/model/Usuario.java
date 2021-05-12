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
    private String idusuario;
    private String nome;
    private String CPF;
    private Data dataNascimento;
    private String senhaAcesso;

    public Usuario(String idusuario, String nome, String CPF, Data dataNascimento, String senhaAcesso) {
        this.idusuario = "U"+idusuario;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.senhaAcesso = senhaAcesso;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }
    
    public String getDataNascimentoString() {
        return dataNascimento.clone().toString();
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }
    
    public void alterarSenha(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    @Override
    public String toString() {
        return "idusuario=" + idusuario + ", nome=" + nome + ", CPF=" + CPF + ", dataNascimento=" + dataNascimento + ", senhaAcesso=" + senhaAcesso;
    }
    
    
}
