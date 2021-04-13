/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CoordenadorDAO;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class Gerente extends Funcionario {
        
    public Gerente(int idGerente, String nome, String CPF, float salario, int cargaHoraria, Data dataNascimento, String senha) {
        super(idGerente, nome, CPF, salario, cargaHoraria, dataNascimento, senha);
    }
    
    public boolean novoCoordenador(Coordenador c) {
        if(this.isUnique(c.getId())) {
            CoordenadorDAO.inserirCoordenador(c);
            return true;
        }
        return false;
    }
    
    private boolean isUnique(int id) {
        for(Coordenador c : CoordenadorDAO.listarCoordenadores()) {
            if(c.getId() == id) {
                return false;
            }
        }
        return true;
    }
    
}
