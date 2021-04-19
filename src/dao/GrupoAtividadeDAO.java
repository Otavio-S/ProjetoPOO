package dao;

import java.util.List;
import model.Colaborador;
import model.DiaSemana;
import model.GrupoAtividade;

public class GrupoAtividadeDAO {
    private static List<GrupoAtividade> listaGrupoAtividades;
    
    public boolean novoGrupo(int idGrupo,String nomeAtividade, String duracao, String horaInicio, DiaSemana diaSemana,
                            String descricaoAtividade,
                            Colaborador funcionarioResponsavel){
        GrupoAtividade gaNovo = new GrupoAtividade(idGrupo, nomeAtividade, duracao, horaInicio, diaSemana, descricaoAtividade, funcionarioResponsavel);
        
        if(idExists(idGrupo)){
            return false;
        }
        else{
            listaGrupoAtividades.add(gaNovo);
            return true;
        }
    }
    
    private static boolean idExists(int id) {
        for(GrupoAtividade g : listaGrupoAtividades) {
            if(g.getIdGrupo() == id){
                return true;
            }
        }
        for(GrupoAtividade g : GrupoAtividadeDAO.listaGrupoAtividades) {
            if(g.getIdGrupo()== id) {
                return true;
            }
        }
        return false;
    }
    
    public void alterarDuracao(int idGrupo, String novaDuracao){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                g.setDuracao(novaDuracao);
            }
        }
    }
    
    public void alterarHoraInicio(int idGrupo, String novaHoraInicio){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                g.setHoraInicio(novaHoraInicio);
            }
        }
    }
    
    public void alterarHoraInicio(int idGrupo, DiaSemana novoDiaSemana){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                g.setDiaSemana(novoDiaSemana);
            }
        }
    }
    
    public void verAtividade(int idGrupo){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                g.toString();
            }
        }
    }
    
    public List<GrupoAtividade> listarGrupoAtividade(){
        return listaGrupoAtividades;
    }
}
