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
public abstract class Funcionario {
    private int id;
    private String nome;
    private String CPF;
    private float salario;
    private int cargaHoraria;
    private Data dataNascimento;

    public Funcionario(int idFuncionario, String nome, String CPF, float salario, int cargaHoraria, Data dataNascimento) {
        this.id = idFuncionario;
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.dataNascimento = dataNascimento;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public float getSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Data getDataNascimento() {
        return dataNascimento.clone();
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + id + 
                ", nome=" + nome + ", CPF=" + CPF + ", salario=" + salario + 
                ", cargaHoraria=" + cargaHoraria + ", dataNascimento=" + dataNascimento + '}';
    }
    
}
