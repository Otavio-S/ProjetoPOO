/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class Colaborador extends Funcionario {
    
    private String local;
    private String tipo;
    //private QuadroHorario quadroHorario;
    private List<Relatorio> relatorios;
    
    public Colaborador(String idFuncionario, String nome, 
            String CPF, float salario, int cargaHoraria, 
            Data dataNascimento, String local, String senha, String tipo) {
        super(idFuncionario, nome, CPF, salario, cargaHoraria, dataNascimento, senha);
        this.local = local;
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void novoRelatorio(int idUsuario, String descricao) {
        LocalDate d = LocalDate.now();
        Data data = new Data(d.getDayOfMonth(), d.getMonthValue(), d.getYear());

        Relatorio r = new Relatorio(this.getMaiorID()+1, idUsuario, data, descricao);
        this.relatorios.add(r);        
    }
    
    private int getMaiorID() {
        int id=0;
        for(Relatorio r : this.relatorios) {
            if(r.getIdRelatorio()>id) {
                id = r.getIdRelatorio();
            }
        }
        return id;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Colaborador{" + "local=" + local + ", tipo=" + tipo + '}';
    }
    
}
