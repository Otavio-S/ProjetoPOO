/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Otavio
 */
public class Coordenador extends Funcionario {
    
    private String tipo;
    private List<Colaborador> colaboradores;
    
    //private QuadroHorario quadroHorario;
    
    public Coordenador(int idFuncionario, String nome, String CPF, float salario, int cargaHoraria, Data dataNascimento, String tipo, String senha) {
        super(idFuncionario, nome, CPF, salario, cargaHoraria, dataNascimento, senha);
        this.tipo = tipo;
    }
    
    public boolean novoColaborador(Colaborador c) {
        if(this.isUnique(c.getId())) {
            this.colaboradores.add(c);
            return true;
        }
        return false;
    }
    
    private boolean isUnique(int id) {
        for(Colaborador c : this.colaboradores) {
            if(c.getId() == id) {
                return false;
            }
        }
        return true;
    }
    
    public void verQuadroHorario() {
        
    }
    
    public void editarQuadroHorario() {
        
    }
    
    
}
