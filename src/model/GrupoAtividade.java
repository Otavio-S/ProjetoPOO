
package model;

import dao.UsuarioDAO;

public class GrupoAtividade {
    private String nomeAtividade;
    private String duracao;
    private String horaInicio;
    private DiaSemana diaSemana;
    private String descricaoAtividade;
    private UsuarioDAO listaUsuarios;
    private Colaborador funcionarioResponsavel;
    
    public GrupoAtividade(String nomeAtividade, String duracao, String horaInicio, DiaSemana diaSemana,
                           String descricaoAtividade, UsuarioDAO listaUsuarios,
                            Colaborador funcionarioResponsavel){
        this.descricaoAtividade = descricaoAtividade;
        this.nomeAtividade = nomeAtividade;
        this.duracao = duracao;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.listaUsuarios = listaUsuarios;
        this.funcionarioResponsavel = funcionarioResponsavel;     
    }

    public String getNomeAtividade() {
        return this.nomeAtividade;
    }

    public String getDuracao() {
        return this.duracao;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public DiaSemana getDiaSemana() {
        return this.diaSemana;
    }

    public String getDescricaoAtividade() {
        return this.descricaoAtividade;
    }

    public UsuarioDAO getListaUsuarios() {
        return this.listaUsuarios;
    }

    public Colaborador getFuncionarioResponsavel() {
        return this.funcionarioResponsavel;
    }
    
    public void setDiaSemana(DiaSemana diaSemana){
        this.diaSemana = diaSemana;
    }
    
    public void setHoraInicio(String horaInicio){
        this.horaInicio = horaInicio;
    }
    
    public void setDuracao(String duracao){
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "GrupoAtividade{" + "nomeAtividade=" + nomeAtividade +
                ", duracao=" + duracao + ", horaInicio=" + horaInicio + 
                ", diaSemana=" + diaSemana + ", descricaoAtividade=" + 
                descricaoAtividade + ", listaUsuarios=" + listaUsuarios + 
                ", funcionarioResponsavel=" + funcionarioResponsavel + '}';
    }


    
    
}
