
package model;

import dao.UsuarioDAO;

public class GrupoAtividade {
    private int idGrupo;
    private String nomeGrupo;
    private String duracao;
    private String horaInicio;
    private DiaSemana diaSemana;
    private String descricaoGrupo;
    private UsuarioDAO listaUsuarios;
    private Colaborador funcionarioResponsavel;
    
    public GrupoAtividade(int idGrupo,String nomeAtividade, String duracao, String horaInicio, DiaSemana diaSemana,
                           String descricaoAtividade, UsuarioDAO listaUsuarios,
                            Colaborador funcionarioResponsavel){
        this.descricaoGrupo = descricaoAtividade;
        this.nomeGrupo = nomeAtividade;
        this.duracao = duracao;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.listaUsuarios = listaUsuarios;
        this.funcionarioResponsavel = funcionarioResponsavel; 
        this.idGrupo = idGrupo;
    }

    public int getIdGrupo() {
        return idGrupo;
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
        return "GrupoAtividade{" + "nomeAtividade=" + nomeGrupo +
                ", duracao=" + duracao + ", horaInicio=" + horaInicio + 
                ", diaSemana=" + diaSemana + ", descricaoAtividade=" + 
                descricaoGrupo + ", listaUsuarios=" + listaUsuarios + 
                ", funcionarioResponsavel=" + funcionarioResponsavel + '}';
    }


    
    
}
