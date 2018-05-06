package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection conexao;
    
    public static Connection getConexao(){
        try{
            if(conexao == null || conexao.isClosed()){
                conexao = conectar();
            }
        }catch(Exception e){
            System.out.printf("Erro: %s\n", e.getMessage());
        }
        return conexao;
    }

    private static Connection conectar() throws ClassNotFoundException, SQLException{
        try{
            
            Class.forName("org.postgresql.Driver");
        
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/almoxarifado","postgres","123456");
        }catch(ClassNotFoundException e){
            System.out.println("Não foi encontrada a biblioteca postgres!");
            return null;
        }catch(SQLException e){
            System.out.println("Banco/Usuário/Senha estão errados. Verifique sua conexão com o banco de dados");
            return null;
        }
    }
}
