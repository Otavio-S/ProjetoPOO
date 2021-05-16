package dao;

import java.util.List;
import model.DiaSemana;
import model.GrupoAtividade;
import model.Hora;

public class GrupoAtividadeDAO {
    private static List<GrupoAtividade> listaGrupoAtividades;
    
    public boolean novoGrupo(int idGrupo,String nomeAtividade, int duracao, int hora, int minuto, DiaSemana diaSemana,
                           String descricaoAtividade, int idFuncionarioResponsavel){
        GrupoAtividade gaNovo = new GrupoAtividade(idGrupo, nomeAtividade, duracao, hora, minuto, diaSemana, descricaoAtividade, idFuncionarioResponsavel);
        
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
    
    public void alterarDuracao(int idGrupo, int novaDuracao){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                g.setDuracao(novaDuracao);
            }
        }
    }
    
    public void alterarHoraInicio(int idGrupo, int novaHoraInicio, int novoMinutoInicio){
        for(GrupoAtividade g :listaGrupoAtividades){
            if(g.getIdGrupo() == idGrupo){
                Hora h = new Hora(novaHoraInicio, novoMinutoInicio);
                g.setHoraInicio(h);
            }
        }
    }
    
    public void alterarDiaSemana(int idGrupo, DiaSemana novoDiaSemana){
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
