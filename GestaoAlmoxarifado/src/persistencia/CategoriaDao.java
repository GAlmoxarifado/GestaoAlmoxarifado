package persistencia;

import entidade.CategoriaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Savio
 */
public class CategoriaDao {
     public void inserir(CategoriaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO Categoria_Prod (id_cat_prod, nome) VALUES (?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, entidade.getId());
        ps.setString(2, entidade.getNome());
        ps.execute();
        
        String sql2 = "SELECT currval('categoria_id_seq');";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            entidade.setId(rs.getInt(1));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM Categoria_Prod WHERE id_cat_prod=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    public void alterar(CategoriaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE Categoria_Prod SET nome=? WHERE id_cat_prod=?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, entidade.getNome());
        ps.setInt(2, entidade.getId());
        ps.executeUpdate();
    }
    
    public CategoriaProduto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM Categoria_Prod WHERE id_cat_prod=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new CategoriaProduto(rs.getInt(1) ,rs.getString(2));
        }
        return null;
    }
    
    public List<CategoriaProduto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM Categoria_Prod ORDER BY id_cat_prod;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<CategoriaProduto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new CategoriaProduto(rs.getInt(1) ,rs.getString(2)));
        }
        return lista;
    }
}
