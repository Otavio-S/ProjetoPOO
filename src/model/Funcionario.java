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
public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String CPF;
    private float salario;
    private int cargaHoraria;
    private String cargo;
    private Data dataNascimento;

    public Funcionario(int idFuncionario, String nome, String CPF, float salario, int cargaHoraria, String cargo, Data dataNascimento) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
    }
    
    public int getId() {
        return idFuncionario;
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

    public String getCargo() {
        return cargo;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

}
