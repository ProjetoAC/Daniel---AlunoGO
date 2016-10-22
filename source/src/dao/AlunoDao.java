package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;

/**
 *
 * @author Daniel
 */
public class AlunoDao {

    Statement st;

    public AlunoDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Aluno getAlunoByID(int id) {
        ResultSet rs;
        Aluno aluno;
        try {
            rs = st.executeQuery("SELECT ALUNOID, NOME_COMPLETO, IDADE, RUA, NUMERO,"
                    + " BAIRRO, CIDADE, NOME_RESPONSAVEL, TELEFONE_RESPONSAVEL,"
                    + " PARENTESCO_RESPONSAVEL FROM ALUNOS WHERE ALUNOID = " + id);
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setAlunoid(rs.getInt("ALUNOID"));
                aluno.setNome_completo(rs.getString("NOME_COMPLETO"));
                aluno.setIdade(rs.getInt("IDADE"));
                aluno.setRua(rs.getString("RUA"));
                aluno.setNumero(rs.getInt("NUMERO"));
                aluno.setBairro(rs.getString("BAIRRO"));
                aluno.setCidade(rs.getString("CIDADE"));
                aluno.setNome_responsavel(rs.getString("NOME_RESPONSAVEL"));
                aluno.setTelefone_responsavel(rs.getString("TELEFONE_RESPONSAVEL"));
                aluno.setParentesco_responsavel(rs.getString("PARENTESCO_RESPONSAVEL"));
                return aluno;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereAluno(Aluno aluno) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(ALUNOID)+1, 1) AS ALUNOID FROM ALUNOS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("ALUNOID");
            }
            aluno.setAlunoid(id);
            sql = "INSERT INTO alunos( alunoid, instituicaoid, idade, rua, numero, "
                    + "bairro, cidade, nome_responsavel, telefone_responsavel, parentesco_responsavel, nome_completo,"
                    + " complemento)"
                    + "VALUES (" + aluno.getAlunoid()
                    + ", " + aluno.getInstituicaoid()
                    + ", " + aluno.getIdade()
                    + ", '" + aluno.getRua()
                    + "', " + aluno.getNumero()
                    + ", '" + aluno.getBairro()
                    + "', '" + aluno.getCidade()
                    + "', '" + aluno.getNome_responsavel()
                    + "', '" + aluno.getTelefone_responsavel()
                    + "', '" + aluno.getParentesco_responsavel()
                    + "', '" + aluno.getNome_completo()
                    + "', '" + aluno.getComplemento()
                    + "')";
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir aluno: " + ex);
            aluno.setAlunoid(0);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean updateAluno(Aluno aluno) {
        String sql = "UPDATE alunos SET "
                + "alunoid=" + aluno.getAlunoid() + ", "
                + "nome_completo='" + aluno.getNome_completo() + "', "
                + "idade=" + aluno.getIdade() + ", "
                + "rua='" + aluno.getRua() + "', "
                + "numero=" + aluno.getNumero() + ", "
                + "bairo='" + aluno.getBairro() + "', "
                + "cidade='" + aluno.getCidade() + "', "
                + "nome_responsavel='" + aluno.getNome_responsavel() + "', "
                + "telefone_responsavel='" + aluno.getTelefone_responsavel() + "', "
                + "parentescto_responsavel='" + aluno.getParentesco_responsavel() + "',"
                + "WHERE alunoid=" + aluno.getAlunoid() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Aluno> getAlunos(String texto) {
        ResultSet rs;
        Aluno aluno;
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try {
            rs = st.executeQuery("SELECT ALUNOID, NOME_COMPLETO, IDADE,"
                    + " RUA, NUMERO, BAIRRO, CIDADE, NOME_RESPONSAVEL,"
                    + " TELEFONE_RESPONSAVEL, PARENTESCO_RESPONSAVEL,INSTITUICAOID, COMPLEMENTO"
                    + " FROM ALUNOS WHERE LOWER(NOME_COMPLETO) LIKE LOWER('%" + texto + "%')");
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setAlunoid(rs.getInt("ALUNOID"));
                aluno.setNome_completo(rs.getString("NOME_COMPLETO"));
                aluno.setIdade(rs.getInt("IDADE"));
                aluno.setRua(rs.getString("RUA"));
                aluno.setNumero(rs.getInt("NUMERO"));
                aluno.setBairro(rs.getString("BAIRRO"));
                aluno.setCidade(rs.getString("CIDADE"));
                aluno.setNome_responsavel(rs.getString("NOME_RESPONSAVEL"));
                aluno.setTelefone_responsavel(rs.getString("TELEFONE_RESPONSAVEL"));
                aluno.setParentesco_responsavel(rs.getString("PARENTESCO_RESPONSAVEL"));
                aluno.setInstituicaoid(rs.getInt("INSTITUICAOID"));
                aluno.setComplemento(rs.getString("COMPLEMENTO"));
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean deleteAluno(int id) {
        String sql = "DELETE FROM ALUNOS WHERE ALUNOID = " + id;
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
