package negocio;

import entidade.Produto;
import java.sql.SQLException;
import java.util.List;
import persistencia.ProdutoDao;

/**
 *
 * @author Savio
 */
public class ProdutoBR {
      public void salvar(Produto obj) throws SQLException{
        if(obj.getId_prod() != 0) new ProdutoDao().alterar(obj);
        else new ProdutoDao().inserir(obj);
    }
    
    public void deletar(int codigo) throws SQLException{
        new ProdutoDao().deletar(codigo);
    }
    
    public Produto consultar(int codigo) throws SQLException{
        return new ProdutoDao().visualizarUm(codigo);
    }
    
    public List<Produto> listar() throws SQLException{
        return new ProdutoDao().visualizarAll();
    }
}
