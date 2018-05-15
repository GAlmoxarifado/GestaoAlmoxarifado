package persistencia;

import entidade.SaidaProduto;
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
public class SaidaProdutoDAO {
    public void inserir(SaidaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "INSERT INTO saida (data_saida, quantidade,"
                + " produto, funcionario) VALUES (?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, entidade.getData_Saida());
        ps.setDouble(2, entidade.getQuantidade());
        ps.setInt(3, entidade.getEntradaProduto().getId());
        ps.setInt(4, entidade.getFuncionario().getId());
       
        ps.execute();
        
        String sql2 = "SELECT currval('saida_id_saida_seq') as id_saida;";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            entidade.setId(rs.getInt("id_saida"));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM saida WHERE id_Saida=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void alterar(SaidaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE saida SET  data_saida = ?, quantidade = ?,  produto = ?, funcionario = ? "
                + " WHERE id_saida = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, entidade.getData_Saida());
        ps.setDouble(2, entidade.getQuantidade());
        ps.setInt(3, entidade.getEntradaProduto().getId());
        ps.setInt(4, entidade.getFuncionario().getId());
       
        ps.setInt(5, entidade.getId());
        ps.executeUpdate();
    }
    
    public SaidaProduto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM saida WHERE id_saida = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new SaidaProduto(rs.getInt(1), rs.getDate(2), rs.getDouble(3), 
                    new EntradaProdutoDAO().visualizarUm(rs.getInt(4)),
                    new FuncionarioDAO().consultar(rs.getInt(5)));
        }
        return null;
    }
    
    public List<SaidaProduto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM saida ORDER BY id_saida;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<SaidaProduto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new SaidaProduto(rs.getInt(1), rs.getDate(2), rs.getDouble(3), 
                    new EntradaProdutoDAO().visualizarUm(rs.getInt(4)),
                    new FuncionarioDAO().consultar(rs.getInt(5))));
        }
        return lista;
    }
}
