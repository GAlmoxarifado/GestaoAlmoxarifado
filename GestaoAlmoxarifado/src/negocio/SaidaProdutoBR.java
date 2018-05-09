package negocio;

import entidade.SaidaProduto;
import java.sql.SQLException;
import java.util.List;
import persistencia.SaidaProdutoDAO;

/**
 *
 * @author Savio
 */
public class SaidaProdutoBR {
    public void salvar(SaidaProduto obj) throws SQLException{
        if(obj.getId() != 0) new SaidaProdutoDAO().alterar(obj);
        else new SaidaProdutoDAO().inserir(obj);
        
    }
    public void deletar(int codigo) throws SQLException{
        new SaidaProdutoDAO().deletar(codigo);
    }
    
    public SaidaProduto consultar(int codigo) throws SQLException{
        return new SaidaProdutoDAO().visualizarUm(codigo);
    }
    
    public List<SaidaProduto> listar() throws SQLException{
        return new SaidaProdutoDAO().visualizarAll();
    }
}
