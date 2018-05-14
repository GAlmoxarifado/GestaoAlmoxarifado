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
        
        String sql = "INSERT INTO ENTRADA (id_Entrada, data_Validade, data_Entrada, quantidade, acao,"
                + " produto, usuario_Sis, funcionario) VALUES (?,?,?,?,?,"
                + "?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, produtoEnt.getId());
        ps.setDate(2, produtoEnt.getData_Validade());
        ps.setDate(3, produtoEnt.getData_Entrada());
        ps.setDouble(4, produtoEnt.getQuantidade());
        ps.setInt(5, produtoEnt.getAcao());
       
        ps.setInt(6, produtoEnt.getProduto().getId_prod());
        ps.setInt(7, produtoEnt.getUsuario_Sis().getIdUsuario());
        ps.setInt(8, produtoEnt.getFuncionario().getId());
       
        ps.execute();
        
        String sql2 = "SELECT currval('entrada_id_entrada_seq');";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql2);
        while(rs.next()){
            produtoEnt.setId(rs.getInt(1));
        }
    }
    
    public void deletar(int id) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "DELETE FROM ENTRADA WHERE id_Entrada=?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
    public void alterar(EntradaProduto entidade) throws SQLException{
        Connection con = util.Conexao.getConexao();
        
        String sql = "UPDATE ENTRADA SET data_Validade =?, data_Entrada=?, quantidade=?, acao=?,"
                + " produto=?, usuario_Sis=?, funcionario=?"
                + " WHERE id_Entrada=?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, entidade.getData_Validade());
        ps.setDate(2, entidade.getData_Entrada());
        ps.setDouble(3, entidade.getQuantidade());
        ps.setInt(4, entidade.getAcao());
        
        ps.setInt(5, entidade.getProduto().getId_prod());
        ps.setInt(6, entidade.getUsuario_Sis().getIdUsuario());
        ps.setInt(7, entidade.getFuncionario().getId());
       
        ps.setInt(8, entidade.getId());
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
                    new UsuarioSistemaDAO().consultar(rs.getInt(7)), 
                    new FuncionarioDAO().consultar(rs.getInt(8)));
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
                    new UsuarioSistemaDAO().consultar(rs.getInt(7)), 
                    new FuncionarioDAO().consultar(rs.getInt(8))));
        }
        return lista;
    }
}
