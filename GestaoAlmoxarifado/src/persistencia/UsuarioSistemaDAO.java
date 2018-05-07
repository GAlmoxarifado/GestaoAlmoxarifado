/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Funcionario;
import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class UsuarioSistemaDAO {
    public void incluir(Usuario usuario) throws SQLException {

        //Cria o sql a ser executado
        String sql = "INSERT INTO usuario_sis (email, senha, funcionario, cpf)"
                + " VALUES (?,?,?,?)";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setString(1, usuario.getEmail());
        prd.setString(2, usuario.getSenha());
        prd.setInt(3, usuario.getFuncionario().getId());
        prd.setLong(4, usuario.getCpf());

        //Executa o sql contra o banco
        prd.execute();

        String sql2 = "SELECT currval('usuario_sis_id_usu_sis_seq') as id_usu_sis ";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            usuario.setIdUsuario(rs.getInt("id_usu_sis"));
        }

    }

    public void alterar(Usuario usuarioSis) throws SQLException {

        //Cria o sql a ser executado
        String sql = "UPDATE usuario_sis SET"
                + " email = ? , "
                + " senha = ? , "
                + " funcionario = ? , "
                + " cpf = ?"
                + " WHERE id_usu_sis = ?;";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setString(1, usuarioSis.getEmail());
        prd.setString(2, usuarioSis.getSenha());
        prd.setInt(3, usuarioSis.getFuncionario().getId());
        prd.setLong(4, usuarioSis.getCpf());
        prd.setInt(5, usuarioSis.getIdUsuario());

        //Executa o sql contra o banco
        prd.execute();

    }

    public void excluir(int codigo) throws SQLException {

        //Cria o sql a ser executado
        String sql = "DELETE FROM usuario_sis"
                + " WHERE id_usu_sis = ?;";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setInt(1, codigo);

        //Executa o sql contra o banco
        prd.execute();

    }

    public Usuario consultar(int codigo) throws SQLException {

        String sql = "SELECT id_usu_sis, email, senha, funcionario, cpf "
                + " FROM usuario_sis WHERE id_usu_sis = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);

        ResultSet rs = prd.executeQuery();

        Usuario usuarioSis = new Usuario();

        if (rs.next()) {
            usuarioSis.setIdUsuario(rs.getInt("id_usu_sis"));
            usuarioSis.setEmail(rs.getString("email"));
            usuarioSis.setSenha(rs.getString("senha"));
            usuarioSis.getFuncionario().setId(rs.getInt("funcionario"));
            usuarioSis.setCpf(rs.getInt("cpf"));
        }

        return usuarioSis;

    }

    public ArrayList<Usuario> listar() throws SQLException {

        String sql = "SELECT id_usu_sis, email, senha, funcionario, cpf "
                + " FROM usuario_sis ORDER BY id_usu_sis;";

        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();

        ResultSet rs = prd.executeQuery(sql);

        ArrayList<Usuario> lista = new ArrayList<>();

        while (rs.next()) {
            Funcionario usuarioAux = new FuncionarioDAO().consultar(rs.getInt("funcionario"));
            Usuario usuarioSis = new Usuario();
            usuarioSis.setIdUsuario(rs.getInt("id_usu_sis"));
            usuarioSis.setEmail(rs.getString("email"));
            usuarioSis.setSenha(rs.getString("senha"));
            usuarioSis.setFuncionario(usuarioAux);
            usuarioSis.setCpf(rs.getLong("cpf"));
            lista.add(usuarioSis);
        }

        return lista;

    }

}
