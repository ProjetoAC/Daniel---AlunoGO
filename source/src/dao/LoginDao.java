package dao;

import model.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Senai
 */
public class LoginDao {

    Statement st;

    public LoginDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }
    public boolean insereLogin(Login login) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT IDLOGIN FROM LOGAR";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDLOGIN");
            }
            login.setIdlogin(id);
            sql = "INSERT INTO logar( idlogin, login, senha"
                    + "VALUES (" + login.getIdlogin()
                    + ", '" + login.getLogin()
                    + "', '" + login.getSenha()
                    + "')";
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
       /* public Login getLoginByLogin(Login login) {
        ResultSet rs;
        TelaLogin telalogin = new TelaLogin();
        try {
           /// rs = st.executeQuery("SELECT idlogin, login, senha " 
                   // + "FROM logar WHERE login = '" + telalogin.txtLogin.getText() +"' ");
           // while (rs.next()) {
                login = new Login();
                login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));
                return login;
            }
        } catch (SQLException ex) {

        }
        return null;
    }*/
}