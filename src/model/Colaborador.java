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
public class Colaborador extends Funcionario {
    
    public Colaborador(int idFuncionario, String nome, String CPF, float salario, int cargaHoraria, Data dataNascimento) {
        super(idFuncionario, nome, CPF, salario, cargaHoraria, dataNascimento);
    }
    
}
