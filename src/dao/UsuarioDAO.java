/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Data;
import model.Usuario;

/**
 *
 * @author Otavio
 */
public class UsuarioDAO {
    
    private static List<Usuario> usuarios = new ArrayList<>();
    
    public static boolean inserirUsuario(String idUsuario, String nome, String CPF, int dia, int mes, int ano, String senha) {
        
        Data d = new Data(dia, mes, ano);
        Usuario u = new Usuario(idUsuario, nome, CPF, d, senha);
        
        if(idExists(u.getIdusuario())) return false;
        usuarios.add(u);
        return true;
    }
    
    private static boolean idExists(String id) {
        for(Usuario u : usuarios) {
            if(u.getIdusuario().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean atualizarSenhaUsuario(String idUsuario, String senha) {
        for(Usuario u : usuarios) {
            if(u.getIdusuario().equals(idUsuario)) {
                u.alterarSenha(senha);
                return true;
            }
        }
        return false;
    }
    
    public static Usuario pesquisa(String nome) {
        for(Usuario u : usuarios) {
            if(u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }
    
    public static Usuario pesquisaID(String id) {
        for(Usuario u : usuarios) {
            if(u.getIdusuario().equals(id)) {
                return u;
            }
        }
        return null;
    }
    
    public static boolean removerUsuario(String idUsuario) {
        for(Usuario u : usuarios) {
            if(u.getIdusuario().equals(idUsuario)) {
                usuarios.remove(u);
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarAcesso(String id, String senha) {
        if(UsuarioDAO.idExists(id)) {
            for(Usuario u : usuarios) {
                if(u.getSenhaAcesso().equals(senha) && u.getIdusuario().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static List<Usuario> listarUsuarios() {
        return usuarios;
    }    
    
}
