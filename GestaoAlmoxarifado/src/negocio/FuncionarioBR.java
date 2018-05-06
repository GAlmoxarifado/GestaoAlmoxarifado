/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidade.Funcionario;
import java.sql.SQLException;
import java.util.List;
import persistencia.FuncionarioDAO;

/**
 *
 * @author rodri
 */
public class FuncionarioBR {
    
    public void salvar(Funcionario funcionario) throws SQLException{
        if(funcionario.getId() != 0) new FuncionarioDAO().alterar(funcionario);
        else new FuncionarioDAO().incluir(funcionario);
    }
    
    public void deletar(int codigo) throws SQLException{
        new FuncionarioDAO().excluir(codigo);
    }
    
    public Funcionario consultar(int codigo) throws SQLException{
        return new FuncionarioDAO().consultar(codigo);
    }
    
    public List<Funcionario> listar() throws SQLException{
        return new FuncionarioDAO().listar();
    }
}
