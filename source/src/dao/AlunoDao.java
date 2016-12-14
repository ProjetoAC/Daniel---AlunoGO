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
            rs = st.executeQuery("SELECT ALUNOID, ATIVO, NOME_COMPLETO, NIS, OBS_ALUNO,"
                    + " RUA, NUMERO, BAIRRO, CIDADE, COMPLEMENTO, ENCAMINHADO,"
                    + " NOME_RESPONSAVEL, TELEFONE_RESPONSAVEL, WHATS_RESPONSAVEL, PARENTESCO_RESPONSAVEL,"
                    + " FACEBOOK_RESPONSAVEL, EMAIL_RESPONSAVEL, OBS_RESPONSAVEL,"
                    + " NASCIMENTO FROM ALUNOS WHERE ALUNOID = " + id);
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setAlunoid(rs.getInt("ALUNOID"));
                aluno.setAtivo(rs.getString("ATIVO"));
                aluno.setNome_completo(rs.getString("NOME_COMPLETO"));
                aluno.setNis(rs.getInt("NIS"));
                aluno.setObs_aluno(rs.getString("OBS_ALUNO"));
                aluno.setRua(rs.getString("RUA"));
                aluno.setNumero(rs.getInt("NUMERO"));
                aluno.setBairro(rs.getString("BAIRRO"));
                aluno.setCidade(rs.getString("CIDADE"));
                aluno.setComplemento(rs.getString("COMPLEMENTO"));
                aluno.setEncaminhado(rs.getString("ENCAMINHADO"));
                aluno.setNome_responsavel(rs.getString("NOME_RESPONSAVEL"));
                aluno.setTelefone_responsavel(rs.getString("TELEFONE_RESPONSAVEL"));
                aluno.setWhats_responsavel(rs.getString("WHATS_RESPONSAVEL"));
                aluno.setParentesco_responsavel(rs.getString("PARENTESCO_RESPONSAVEL"));
                aluno.setFacebook_responsavel(rs.getString("FACEBOOK_RESPONSAVEL"));
                aluno.setEmail_responsavel(rs.getString("EMAIL_RESPONSAVEL"));
                aluno.setObs_responsavel(rs.getString("OBS_RESPONSAVEL"));
                aluno.setNascimento(rs.getString("NASCIMENTO"));
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
            sql = "INSERT INTO alunos(alunoid, instituicaoid, ativo, nome_completo,"
                    + " nis, obs_aluno, rua, numero, bairro, cidade, complemento, encaminhado,"
                    + " nome_responsavel, telefone_responsavel, whats_responsavel,"
                    + " parentesco_responsavel, facebook_responsavel, email_responsavel,"
                    + " obs_responsavel, nascimento)"
                    + "VALUES (" + aluno.getAlunoid()
                    + ", " + aluno.getInstituicaoid()
                    + ", '" + aluno.getAtivo()
                    + "', '" + aluno.getNome_completo()
                    + "', " + aluno.getNis()
                    + ", '" + aluno.getObs_aluno()
                    + "', '" + aluno.getRua()
                    + "', " + aluno.getNumero()
                    + ", '" + aluno.getBairro()
                    + "', '" + aluno.getCidade()
                    + "', '" + aluno.getComplemento()
                    + "', '" + aluno.getEncaminhado()
                    + "', '" + aluno.getNome_responsavel()
                    + "', '" + aluno.getTelefone_responsavel()
                    + "', '" + aluno.getWhats_responsavel()
                    + "', '" + aluno.getParentesco_responsavel()
                    + "', '" + aluno.getFacebook_responsavel()
                    + "', '" + aluno.getEmail_responsavel()
                    + "', '" + aluno.getObs_responsavel()
                    + "', '" + aluno.getNascimento()
                    + "');";
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir aluno: " + ex);
            JOptionPane.showMessageDialog(null, "Problema ao inserir aluno:" + ex);
        }
        return false;
    }

    public boolean updateAluno(Aluno aluno) {
        String sql = "UPDATE alunos SET "
                + "alunoid=" + aluno.getAlunoid() + ", "
                + "instituicaoid=" + aluno.getInstituicaoid() + ", "
                + "ativo='" + aluno.getAtivo() + "', "
                + "nome_completo='" + aluno.getNome_completo() + "', "
                + "nis=" + aluno.getNis() + ", "
                + "obs_aluno='" + aluno.getObs_aluno() + "', "
                + "rua='" + aluno.getRua() + "', "
                + "numero=" + aluno.getNumero() + ", "
                + "bairro='" + aluno.getBairro() + "', "
                + "cidade='" + aluno.getCidade() + "', "
                + "complemento='" + aluno.getComplemento() + "', "
                + "encaminhado='" + aluno.getEncaminhado() + "', "
                + "nome_responsavel='" + aluno.getNome_responsavel() + "', "
                + "telefone_responsavel='" + aluno.getTelefone_responsavel() + "', "
                + "whats_responsavel='" + aluno.getWhats_responsavel() + "', "
                + "parentesco_responsavel='" + aluno.getParentesco_responsavel() + "', "
                + "email_responsavel='" + aluno.getEmail_responsavel() + "', "
                + "obs_responsavel='" + aluno.getObs_responsavel() + "', "
                + "nascimento='" + aluno.getNascimento() + "', "
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
            rs = st.executeQuery("SELECT ALUNOID, ATIVO, NOME_COMPLETO, NIS, OBS_ALUNO,"
                    + " RUA, NUMERO, BAIRRO, CIDADE, COMPLEMENTO, ENCAMINHADO,"
                    + " NOME_RESPONSAVEL, TELEFONE_RESPONSAVEL, WHATS_RESPONSAVEL, PARENTESCO_RESPONSAVEL,"
                    + " FACEBOOK_RESPONSAVEL, EMAIL_RESPONSAVEL, OBS_RESPONSAVEL,"
                    + " NASCIMENTO"
                    + " FROM ALUNOS WHERE LOWER(NOME_COMPLETO) LIKE LOWER('%" + texto + "%')");
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setAlunoid(rs.getInt("ALUNOID"));
                aluno.setAtivo(rs.getString("ATIVO"));
                aluno.setNome_completo(rs.getString("NOME_COMPLETO"));
                aluno.setNis(rs.getInt("NIS"));
                aluno.setObs_aluno(rs.getString("OBS_ALUNO"));
                aluno.setRua(rs.getString("RUA"));
                aluno.setNumero(rs.getInt("NUMERO"));
                aluno.setBairro(rs.getString("BAIRRO"));
                aluno.setCidade(rs.getString("CIDADE"));
                aluno.setComplemento(rs.getString("COMPLEMENTO"));
                aluno.setEncaminhado(rs.getString("ENCAMINHADO"));
                aluno.setNome_responsavel(rs.getString("NOME_RESPONSAVEL"));
                aluno.setTelefone_responsavel(rs.getString("TELEFONE_RESPONSAVEL"));
                aluno.setWhats_responsavel(rs.getString("WHATS_RESPONSAVEL"));
                aluno.setParentesco_responsavel(rs.getString("PARENTESCO_RESPONSAVEL"));
                aluno.setFacebook_responsavel(rs.getString("FACEBOOK_RESPONSAVEL"));
                aluno.setEmail_responsavel(rs.getString("EMAIL_RESPONSAVEL"));
                aluno.setObs_responsavel(rs.getString("OBS_RESPONSAVEL"));
                aluno.setNascimento(rs.getString("NASCIMENTO"));
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }
}
