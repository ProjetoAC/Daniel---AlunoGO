package dao;

import model.Instituicao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class InstituicaoDao {

    Statement st;

    public InstituicaoDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Instituicao getInstituicaoByID(int id) {
        ResultSet rs;
        Instituicao instituicao;
        try {
            rs = st.executeQuery("SELECT INSTITUICAOID, NOME, NATUREZA_ADMNISTRATIVA "
                    + "FROM INSTITUICAO WHERE INSTITUICAOID = " + id);
            while (rs.next()) {
                instituicao = new Instituicao();
                instituicao.setInstituicaoid(rs.getInt("INSTITUICAOID"));
                instituicao.setNome(rs.getString("NOME"));
                instituicao.setNatureza_administrativa(rs.getString("NATURAZA_ADMNISTRATIVA"));
                return instituicao;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereInstituicao(Instituicao instituicao) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(INSTITUICAOID)+1, 1) AS INSTITUICAOID FROM INSTITUICAO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("INSTITUICAOID");
            }
            instituicao.setInstituicaoid(id);
            sql = "INSERT INTO instituicao( instituicaoid, nome, natureza_admnistrativa)"
                    + "VALUES (" + instituicao.getInstituicaoid()
                    + ", '" + instituicao.getNome()
                    + "', '" + instituicao.getNatureza_administrativa()
                    + "')";
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir instituicao: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean updateInstituicao(Instituicao instituicao) {
        String sql = "UPDATE alunos SET "
                + "instituicaoid=" + instituicao.getInstituicaoid() + ", "
                + "nome='" + instituicao.getNome() + "', "
                + "natureza_admnistrativa='" + instituicao.getNatureza_administrativa() + "', "
                + "WHERE instituicaoid=" + instituicao.getInstituicaoid() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Instituicao> getInstituicoes() {
        ResultSet rs;
        Instituicao instituicao;
        ArrayList<Instituicao> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT INSTITUICAOID, NOME, NATUREZA_ADMNISTRATIVA"
                    + " FROM INSTITUICAO");
            while (rs.next()) {
                instituicao = new Instituicao();
                instituicao.setInstituicaoid(rs.getInt("INSTITUICAOID"));
                instituicao.setNome(rs.getString("NOME"));
                instituicao.setNatureza_administrativa(rs.getString("NATUREZA_ADMNISTRATIVA"));
                lista.add(instituicao);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean deleteInstituicao(int id) {
        String sql = "DELETE FROM INSTITUICAO WHERE INSTITUICAOID = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Instituicao> getInstituicoesByName(String texto) {
        ResultSet rs;
        Instituicao instituicao;
        ArrayList<Instituicao> lista = new ArrayList<Instituicao>();
        try {
            rs = st.executeQuery("SELECT INSTITUICAOID, NOME, NATUREZA_ADMNISTRATIVA "
                    + "FROM INSTITUICAO WHERE NOME LIKE LOWER('%" + texto + "%')");
            while (rs.next()) {
                instituicao = new Instituicao();
                instituicao.setInstituicaoid(rs.getInt("INSTITUICAOID"));
                instituicao.setNome(rs.getString("NOME"));
                instituicao.setNatureza_administrativa(rs.getString("NATUREZA_ADMNISTRATIVA"));
                lista.add(instituicao);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public Instituicao getInstituicoesById(int id) {
        ResultSet rs;
        Instituicao instituicao;
        try {
            rs = st.executeQuery("SELECT INSTITUICAOID, NOME, NATUREZA_ADMNISTRATIVA "
                    + "FROM INSTITUICAO WHERE INSTITUICAOID = " + id);
            while (rs.next()) {
                instituicao = new Instituicao();
                instituicao.setInstituicaoid(rs.getInt("INSTITUICAOID"));
                instituicao.setNome(rs.getString("NOME"));
                instituicao.setNatureza_administrativa(rs.getString("NATUREZA_ADMNISTRATIVA"));
                return instituicao;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return null;
    }

}
