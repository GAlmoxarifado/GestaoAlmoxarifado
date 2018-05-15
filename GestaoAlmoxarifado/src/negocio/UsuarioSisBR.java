/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidade.Usuario;
import java.sql.SQLException;
import java.util.List;
import persistencia.UsuarioSistemaDAO;

/**
 *
 * @author rodri
 */
public class UsuarioSisBR {
    public void salvar(Usuario usuarioSis) throws SQLException{
        if(usuarioSis.getIdUsuario()!= 0) 
            new UsuarioSistemaDAO().alterar(usuarioSis);
        else 
            new UsuarioSistemaDAO().incluir(usuarioSis);
    }
    
    public void deletar(int codigo) throws SQLException{
        new UsuarioSistemaDAO().excluir(codigo);
    }
    
    public Usuario consultar(int codigo) throws SQLException{
        return new UsuarioSistemaDAO().consultar(codigo);
    }
    
    public Usuario consultar(String cpf, String senha) throws SQLException{
        return new UsuarioSistemaDAO().consultar(cpf, senha);
    }
    
    public List<Usuario> listar() throws SQLException{
        return new UsuarioSistemaDAO().listar();
    }
}
