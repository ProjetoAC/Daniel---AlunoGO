package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Conexao {
            private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
           try{
            conexao = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/AlunoGO", 
                    "postgres", 
                    "postgres");
           }catch(SQLException ex){
               System.out.println("Erro Conexao Banco"+ex);
           }
        }
        return conexao;
    }
        public static PreparedStatement getPreparedStatement(String sql){
        // testo se a conexão já foi criada
        if (conexao == null){
            // cria a conexão
            conexao = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return conexao.prepareStatement(sql);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
