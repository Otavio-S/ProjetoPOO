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
public class Gerente extends Funcionario {
    
    public Gerente(int idGerente, String nome, String CPF, float salario, int cargaHoraria, String cargo, Data dataNascimento) {
        super(idGerente, nome, CPF, salario, cargaHoraria, cargo, dataNascimento);
    }
    
}
