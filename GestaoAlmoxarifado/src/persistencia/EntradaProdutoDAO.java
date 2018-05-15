package persistencia;

import entidade.EntradaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.ProdutoBR;

/**
 *
 * @author Savio
 */
public class EntradaProdutoDAO {
    public void inserir(EntradaProduto produtoEnt) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO entrada (data_validade, data_entrada, quantidade, acao,"
                + " produto, usuario_sis) VALUES (?,?,?,?,?,?);";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setDate(1, produtoEnt.getData_Validade());
        ps.setDate(2, produtoEnt.getData_Entrada());
        ps.setDouble(3, produtoEnt.getQuantidade());
        ps.setInt(4, produtoEnt.getAcao());
        ps.setInt(5, produtoEnt.getProduto().getId_prod());
        ps.setInt(6, produtoEnt.getUsuario_Sis().getIdUsuario());
       
        ps.execute();
        
        String sql2 = "SELECT currval('entrada_id_entrada_seq') as id_entrada;";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            produtoEnt.setId(rs.getInt("id_entrada"));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM entrada WHERE id_entrada=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void alterar(EntradaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE entrada SET data_validade = ?, data_entrada = ?,"
                + " quantidade = ?, acao = ?,"
                + " produto=?, usuario_sis = ?"
                + " WHERE id_entrada = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, entidade.getData_Validade());
        ps.setDate(2, entidade.getData_Entrada());
        ps.setDouble(3, entidade.getQuantidade());
        ps.setInt(4, entidade.getAcao());
        
        ps.setInt(5, entidade.getProduto().getId_prod());
        ps.setInt(6, entidade.getUsuario_Sis().getIdUsuario());
       
        ps.setInt(8, entidade.getId());
        ps.executeUpdate();
    }
    
    public void alterarQuantidade(EntradaProduto entidade, Double quantidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE entrada SET quantidade = ? WHERE id_entrada = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, entidade.getQuantidade() - quantidade);
        ps.setInt(2, entidade.getId());
        ps.executeUpdate();
    }
    
    public EntradaProduto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT *, TO_CHAR(data_validade, 'DD/MM/YYYY'),"
                + " TO_CHAR(data_entrada, 'DD/MM/YYYY HH:MM:SS')"
                + " FROM entrada WHERE id_entrada = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new EntradaProduto(rs.getInt(1), rs.getDate(2), 
                    rs.getDate(3), rs.getDouble(4), rs.getInt(5), 
                    new ProdutoDao().visualizarUm(rs.getInt(6)), 
                    new UsuarioSistemaDAO().consultar(rs.getInt(7)));
        }
        return null;
    }
    
    public List<EntradaProduto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT *, TO_CHAR(data_validade, 'DD/MM/YYYY'),"
                + " TO_CHAR(data_entrada, 'DD/MM/YYYY HH:MM:SS')"
                + " FROM entrada ORDER BY id_entrada;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<EntradaProduto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new EntradaProduto(rs.getInt(1), rs.getDate(2), 
                    rs.getDate(3), rs.getDouble(4), rs.getInt(5), 
                    new ProdutoDao().visualizarUm(rs.getInt(6)), 
                    new UsuarioSistemaDAO().consultar(rs.getInt(7))));
        }
        return lista;
    }
}
