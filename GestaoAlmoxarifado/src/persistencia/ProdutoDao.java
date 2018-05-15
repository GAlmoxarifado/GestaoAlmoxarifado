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
        
        String sql = "INSERT INTO produto (nome, descricao, valor_unitario, "
                + "categoria, codigo_busca) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, entidade.getNome());
        ps.setString(2, entidade.getDescricao());
        ps.setDouble(3, entidade.getValorUnitario());
        ps.setInt(4, entidade.getCategoria().getId());
        ps.setInt(5, entidade.getCodigoBusca());
        ps.execute();
        
        String sql2 = "SELECT currval('produto_id_prod_seq') as id_prod;";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            entidade.setId_prod(rs.getInt("id_prod"));
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
        
        String sql = "UPDATE produto SET nome = ?, descricao = ?, valor_unitario = ?, "
                + "categoria = ?, codigo_busca = ? WHERE id_prod = ?;";
        
        Connection con = util.Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, entidade.getNome());
        ps.setString(2, entidade.getDescricao());
        ps.setDouble(3, entidade.getValorUnitario());
        ps.setInt(4, entidade.getCategoria().getId());
        ps.setInt(5, entidade.getCodigoBusca());
        ps.setInt(6, entidade.getId_prod());
        ps.execute();
    }
    
    public Produto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT id_prod, nome, descricao,"
                + " valor_unitario, categoria, codigo_busca"
                + " FROM produto WHERE id_prod = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return new Produto(rs.getString("nome"), rs.getString("descricao"), rs.getInt("id_prod"), 
                    rs.getInt("codigo_busca"), rs.getDouble("valor_unitario"), new CategoriaDao().visualizarUm(rs.getInt("categoria")));
        }
        return null;
    }
    
    public List<Produto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT id_prod, nome, descricao,"
                + " valor_unitario, categoria, codigo_busca"
                + " FROM produto ORDER BY id_prod;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Produto(rs.getString("nome"), rs.getString("descricao"), rs.getInt("id_prod"), 
                    rs.getInt("codigo_busca"), rs.getDouble("valor_unitario"), new CategoriaDao().visualizarUm(rs.getInt("categoria"))));
        }
        return lista;
    }
}
