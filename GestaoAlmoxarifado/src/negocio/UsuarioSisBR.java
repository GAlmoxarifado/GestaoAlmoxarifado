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
    public void salvar(Usuario funcionario) throws SQLException{
        if(funcionario.getIdUsuario()!= 0) 
            new UsuarioSistemaDAO().alterar(funcionario);
        else 
            new UsuarioSistemaDAO().incluir(funcionario);
    }
    
    public void deletar(int codigo) throws SQLException{
        new UsuarioSistemaDAO().excluir(codigo);
    }
    
    public Usuario consultar(int codigo) throws SQLException{
        return new UsuarioSistemaDAO().consultar(codigo);
    }
    
    public Usuario consultar(long cpf, String senha) throws SQLException{
        return new UsuarioSistemaDAO().consultar(cpf, senha);
    }
    
    public List<Usuario> listar() throws SQLException{
        return new UsuarioSistemaDAO().listar();
    }
}
