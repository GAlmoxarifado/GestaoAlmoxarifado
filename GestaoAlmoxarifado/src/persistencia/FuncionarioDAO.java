/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Funcionario;
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
public class FuncionarioDAO {
    
    public void incluir(Funcionario funcionario) throws SQLException {

        //Cria o sql a ser executado
        String sql = "INSERT INTO funcionario (nome_func, matricula) VALUES (?,?)";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setString(1, funcionario.getNome());
        prd.setString(2, funcionario.getMatricula());

        //Executa o sql contra o banco
        prd.execute();

        String sql2 = "SELECT currval('funcionario_id_func_seq') as id_func ";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            funcionario.setId(rs.getInt("id_func"));
        }

    }

    public void alterar(Funcionario funcionario) throws SQLException {

        //Cria o sql a ser executado
        String sql = "UPDATE funcionario SET"
                + " nome_func = ? , "
                + " matricula = ? , "
                + " WHERE id_func = ?;";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setString(1, funcionario.getNome());
        prd.setString(2, funcionario.getMatricula());
        prd.setInt(3, funcionario.getId());

        //Executa o sql contra o banco
        prd.execute();

    }

    public void excluir(int codigo) throws SQLException {

        //Cria o sql a ser executado
        String sql = "DELETE FROM funcionario"
                + " WHERE id_func = ?;";

        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        //Cria o procedimento armazanado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores a serem injetados no código sql
        prd.setInt(1, codigo);

        //Executa o sql contra o banco
        prd.execute();

    }

    public Funcionario consultar(int codigo) throws SQLException {

        String sql = "SELECT id_func, nome_func, matricula"
                + " FROM funcionario WHERE id_func = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);

        ResultSet rs = prd.executeQuery();

        Funcionario usuarioSis = new Funcionario();

        if (rs.next()) {
            usuarioSis.setId(rs.getInt("id_func"));
            usuarioSis.setNome(rs.getString("nome_func"));
            usuarioSis.setMatricula(rs.getString("matricula"));
        }

        return usuarioSis;

    }

    public ArrayList<Funcionario> listar() throws SQLException {

        String sql = "SELECT id_func, nome_func, matricula"
                + " FROM funcionario ORDER BY id_func;";

        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();

        ResultSet rs = prd.executeQuery(sql);

        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id_func"));
            funcionario.setNome(rs.getString("nome_func"));
            funcionario.setMatricula(rs.getString("matricula"));
            lista.add(funcionario);
        }

        return lista;

    }
}
