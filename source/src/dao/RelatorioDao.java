package dao;

import model.Relatorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class RelatorioDao {
    Statement st;

    public RelatorioDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }
    public Relatorio getRelatorioByID(int id) {
        ResultSet rs;
        Relatorio relatorio;
        try {
            rs = st.executeQuery("SELECT RELATORIOID, ALUNOID, ATA" 
                    + "FROM RELATORIO WHERE RELATORIOID = " + id);
            while (rs.next()) {
                relatorio = new Relatorio();
                relatorio.setRelatorioid(rs.getInt("RELATORIOID"));
                relatorio.setAta(rs.getString("ATA"));
                return relatorio;
            }
        } catch (SQLException ex) {

        }
        return null;
    }
    public boolean insereRelatorio(Relatorio relatorio) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(RELATORIOID)+1, 1) AS RELATORIOID FROM RELATORIO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("RELATORIOID");
            }
            relatorio.setRelatorioid(id);
            sql = "INSERT INTO relatorio(relatorioid, alunoid, ata) "
                    + "VALUES (" + relatorio.getRelatorioid()
                    +", 1" /*+ relatorio.getAlunoid()*/
                    + ", '" + relatorio.getAta()
                    + "')";
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir relatorio: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
    public boolean updateRelatorio(Relatorio relatorio) {
        String sql = "UPDATE alunos SET "
                + "relatorioid=" + relatorio.getRelatorioid() + ", "
                + "ata='" + relatorio.getAta() + "', "
                + "WHERE instituicaoid=" + relatorio.getRelatorioid() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update:" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
    public ArrayList<Relatorio> getRelatorios() {
        ResultSet rs;
        Relatorio relatorio;
        ArrayList<Relatorio> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT RELATORIOID, ATA"
                    + " FROM INSTITUICAO");
            while (rs.next()) {
                relatorio = new Relatorio();
                relatorio.setRelatorioid(rs.getInt("RELATORIOID"));
                relatorio.setAta(rs.getString("ATA"));
                lista.add(relatorio);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }
    public boolean deleteRelatorio(int id) {
        String sql = "DELETE FROM RELATORIO WHERE RELATORIOID = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }
}
