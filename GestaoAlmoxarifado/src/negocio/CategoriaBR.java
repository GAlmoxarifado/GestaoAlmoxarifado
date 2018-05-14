package negocio;

import entidade.CategoriaProduto;
import java.sql.SQLException;
import java.util.List;
import persistencia.CategoriaDao;

/**
 *
 * @author Savio
 */
public class CategoriaBR {
    
    public void salvar(CategoriaProduto obj) throws SQLException{
        if(obj.getId() != 0) new CategoriaDao().alterar(obj);
        else new CategoriaDao().inserir(obj);
        
    }
    public void deletar(int codigo) throws SQLException{
        new CategoriaDao().deletar(codigo);
    }
    
    public CategoriaProduto consultar(int codigo) throws SQLException{
        return new CategoriaDao().visualizarUm(codigo);
    }
    
    public List<CategoriaProduto> listar() throws SQLException{
        return new CategoriaDao().visualizarAll();
    }
}
