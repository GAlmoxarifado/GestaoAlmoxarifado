/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class UsuarioAlmoxarifadoDAO {
    public void incluir(Usuario usuarioAlmox) throws SQLException {

        //Cria o sql a ser executado
        String sql = "INSERT INTO usuario_almox (funcionario)"
                + " VALUES (?)";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setInt(1, usuarioAlmox.getFuncionario().getId());
        
        //Executa o sql contra o banco
        prd.execute();

        String sql2 = "SELECT currval('usuario_almox_id_usu_almox_seq') as id_usu_almox ";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            usuarioAlmox.setIdUsuario(rs.getInt("id_usu_almox"));
        }

    }

//    public void alterar(Usuario usuarioAlmox) throws SQLException {

//        //Cria o sql a ser executado
//        String sql = "UPDATE usuario_almox SET"
//                + " funcionario = ? , "
//                + " WHERE id_usu_almox = ?;";
//
//        //Cria a conexão com o banco a partir da classe utilitária
//        Connection cnn = util.Conexao.getConexao();
//        //Cria o procedimento armazanado a partir do sql gerado
//        PreparedStatement prd = cnn.prepareStatement(sql);
//
//        //Seta os valores a serem injetados no código sql
//        prd.setInt(1, usuarioAlmox.getFuncionario().getId());
//        
//        //Executa o sql contra o banco
//        prd.execute();
//
//    }

//    public void excluir(int codigo) throws SQLException {
//
//        //Cria o sql a ser executado
//        String sql = "DELETE FROM usuario_almox"
//                + " WHERE id_usu_almox = ?;";
//
//        //Cria a conexão com o banco a partir da classe utilitária
//        Connection cnn = util.Conexao.getConexao();
//        //Cria o procedimento armazanado a partir do sql gerado
//        PreparedStatement prd = cnn.prepareStatement(sql);
//
//        //Seta os valores a serem injetados no código sql
//        prd.setInt(1, codigo);
//
//        //Executa o sql contra o banco
//        prd.execute();
//
//    }

//    public Usuario consultar(int codigo) throws SQLException {
//
//        String sql = "SELECT id_func, nome_func, matricula "
//                + " FROM funcionario JOIN usuario_almox ON"
//                + " usuario_almox = funcionario.id_func WHERE"
//                + " usuario_almox = ?;";
//
//        Connection cnn = util.Conexao.getConexao();
//        PreparedStatement prd = cnn.prepareStatement(sql);
//        prd.setInt(1, codigo);
//
//        ResultSet rs = prd.executeQuery();
//
//        Usuario usuarioAlmox = new Usuario();
//
//        if (rs.next()) {
//            usuarioAlmox.setIdUsuario(rs.getInt("id_usu_almox"));
//            usuarioAlmox.setEmail(rs.getString("email"));
//            usuarioAlmox.setSenha(rs.getString("senha"));
//            usuarioAlmox.getFuncionario().setId(rs.getInt("funcionario"));
//            usuarioAlmox.setCpf(rs.getString("cpf"));
//        }
//
//        return usuarioAlmox;
//
//    }
//
//    public ArrayList<Usuario> listar() throws SQLException {
//
//        String sql = "SELECT id_usu_almox, email, senha, funcionario, cpf "
//                + " FROM usuario_almox ORDER BY id_usu_almox;";
//
//        Connection cnn = util.Conexao.getConexao();
//        Statement prd = cnn.createStatement();
//
//        ResultSet rs = prd.executeQuery(sql);
//
//        ArrayList<Usuario> lista = new ArrayList<Usuario>();
//
//        while (rs.next()) {
//            Usuario usuarioAlmox = new Usuario();
//            usuarioAlmox.setIdUsuario(rs.getInt("id_usu_almox"));
//            usuarioAlmox.setEmail(rs.getString("email"));
//            usuarioAlmox.setSenha(rs.getString("senha"));
//            usuarioAlmox.getFuncionario().setId(rs.getInt("funcionario"));
//            usuarioAlmox.setCpf(rs.getString("cpf"));
//            lista.add(usuarioAlmox);
//        }
//
//        return lista;
//
//    }
}
