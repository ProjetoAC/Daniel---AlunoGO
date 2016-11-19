package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class relatorioAtaDao {
    Statement st;
    ResultSet rs;
    
    static String SELECT = "select * from relatorio where alunoid =1";
    
     public ResultSet RelatorioAta(){
          try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECT);
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados no BD: " + ex);
        }
         return rs;
     }
}
