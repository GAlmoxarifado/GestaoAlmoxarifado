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
        
        String sql = "INSERT INTO SAIDA (id_Saida , data_Saida, quantidade,"
                + " produto, usuario_Sis) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, entidade.getId());
        ps.setDate(2, entidade.getData_Saida());
        ps.setInt(3, entidade.getQuantidade());
        ps.setInt(4, entidade.getProduto());
        ps.setInt(5, entidade.getUsuario_sis());
       
        ps.execute();
        
        String sql2 = "SELECT currval('saida_id_saida_seq');";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            entidade.setId(rs.getInt(1));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM SAIDA WHERE id_Saida=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    public void alterar(SaidaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE SAIDA SET  data_Saida=?, quantidade=?,  produto=?, usuario_Sis=? "
                + " WHERE id_Saida=?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, entidade.getData_Saida());
        ps.setInt(2, entidade.getQuantidade());
        ps.setInt(3, entidade.getProduto());
        ps.setInt(4, entidade.getUsuario_sis());
       
        ps.setInt(5, entidade.getId());
        ps.executeUpdate();
    }
    
    public SaidaProduto visualizarUm(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM SAIDA WHERE id_Saida=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            return new SaidaProduto(rs.getInt(1) ,rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
        }
        return null;
    }
    
    public List<SaidaProduto> visualizarAll() throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "SELECT * FROM SAIDA ORDER BY id_Saida;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<SaidaProduto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new SaidaProduto(rs.getInt(1) ,rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
        }
        return lista;
    }
}
