package negocio;

import entidade.EntradaProduto;
import java.sql.SQLException;
import java.util.List;
import persistencia.EntradaProdutoDAO;

/**
 *
 * @author Savio
 */
public class EntradaProdutoBR {
    public void salvar(EntradaProduto obj) throws SQLException{
        if(obj.getId() != 0) new EntradaProdutoDAO().alterar(obj);
        else new EntradaProdutoDAO().inserir(obj);
        
    }
    public void deletar(int codigo) throws SQLException{
        new EntradaProdutoDAO().deletar(codigo);
    }
    
    public EntradaProduto consultar(int codigo) throws SQLException{
        return new EntradaProdutoDAO().visualizarUm(codigo);
    }
    
    public List<EntradaProduto> listar() throws SQLException{
        return new EntradaProdutoDAO().visualizarAll();
    }
}
