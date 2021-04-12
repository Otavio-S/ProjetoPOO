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
public class Gerente extends Funcionario {
    
    private List<Coordenador> coordenadores;
    
    public Gerente(int idGerente, String nome, String CPF, float salario, int cargaHoraria, Data dataNascimento) {
        super(idGerente, nome, CPF, salario, cargaHoraria, dataNascimento);
    }
    
    public boolean novoCoordenador(Coordenador c) {
        if(this.isUnique(c.getId())) {
            this.coordenadores.add(c);
            return true;
        }
        return false;
    }
    
    private boolean isUnique(int id) {
        for(Coordenador c : this.coordenadores) {
            if(c.getId() == id) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Gerente{" + "coordenadores=" + coordenadores + '}';
    }
    
}
