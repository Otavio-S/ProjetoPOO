
package model;

import dao.UsuarioDAO;

public class GrupoAtividade {
    private int idGrupo;
    private String nomeGrupo;
    private int duracao;
    private Hora horaInicio;
    private DiaSemana diaSemana;
    private String descricaoGrupo;
    private UsuarioDAO listaUsuarios;
    private int idColaborador;
    
    public GrupoAtividade(int idGrupo,String nomeAtividade, int duracao, int hora, int minuto, DiaSemana diaSemana,
                           String descricaoAtividade, int idFuncionarioResponsavel){
        this.descricaoGrupo = descricaoAtividade;
        this.nomeGrupo = nomeAtividade;
        this.duracao = duracao;
        this.diaSemana = diaSemana;
        Hora h = new Hora(hora, minuto);
        this.horaInicio = h;
        this.idColaborador = idFuncionarioResponsavel; 
        this.idGrupo = idGrupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public int getDuracao() {
        return duracao;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public String getDescricaoGrupo() {
        return descricaoGrupo;
    }

    public UsuarioDAO getListaUsuarios() {
        return listaUsuarios;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return "GrupoAtividade{" + "idGrupo=" + idGrupo + ", nomeGrupo=" + nomeGrupo + ", duracao=" 
                + duracao + ", horaInicio=" + horaInicio + ", diaSemana="+ diaSemana 
                + ", descricaoGrupo=" + descricaoGrupo + ", listaUsuarios="
                + listaUsuarios + ", idColaborador=" + idColaborador + '}';
    }    
    
}
