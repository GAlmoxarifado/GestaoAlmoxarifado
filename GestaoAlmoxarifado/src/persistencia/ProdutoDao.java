package persistencia;

import entidade.Produto;
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
public class ProdutoDao {
    public void inserir(Produto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO produto (id_prod, nome, descricao, codigoBusca, valorUnitario, categoria) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, entidade.getId_prod());
        ps.setString(2, entidade.getNome());
        ps.setString(3, entidade.getDescricao());
        ps.setInt(4, entidade.getCodigoBusca());
        ps.setDouble(5, entidade.getValorUnitario());
        ps.setInt(6, entidade.getCategoria().getId());
        ps.execute();
        
        String sql2 = "SELECT currval('produto_id_prod_seq');";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            entidade.setId_prod(rs.getInt(1));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM produto WHERE id_prod = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void alterar(Produto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE produto SET nome=?, descricao=?, codigoBusca=?, valorUnitario=?, categoria=? WHERE id_prod=?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, entidade.getNome());
        ps.setString(2, entidade.getDescricao());
        ps.setInt(3, entidade.getCodigoBusca());
        ps.setDouble(4, entidade.getValorUnitario());
        ps.setInt(5, entidade.getCategoria().getId());
        ps.setInt(6, entidade.getId_prod());
        ps.executeUpdate();
    }
    
    public Produto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM produto WHERE id_prod = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new Produto(rs.getString(1), rs.getString(2), rs.getInt(3), 
                    rs.getInt(4), rs.getDouble(5), new CategoriaDao().visualizarUm(rs.getInt(6)));
        }
        return null;
    }
    
    public List<Produto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM produto ORDER BY id_prod;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Produto(rs.getString(1), rs.getString(2), rs.getInt(3), 
                    rs.getInt(4), rs.getDouble(5), new CategoriaDao().visualizarUm(rs.getInt(6))));
        }
        return lista;
    }
}
