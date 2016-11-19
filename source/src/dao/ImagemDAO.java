package dao;

import model.Imagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class ImagemDAO {

    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO imagem(id, binario) "
            + "VALUES ((SELECT COALESCE(max(id)+1,1) FROM imagem),?,?);";
    static String SELECTALL = "SELECT id, binario"
            + " FROM imagem where id=?";

    public Boolean inserir(Imagem imagem) throws SQLException {
        try {
            PreparedStatement pst = Conexao.getConexao().prepareStatement(INSERT);
            pst.setInt(1, imagem.getImagemid());
            pst.setBytes(2, imagem.getImagem());
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao inserir imagem: " + ex);
        }

        return false;
    }

    public Imagem buscar(Integer id) throws SQLException {
        Imagem retorno = null;

        try {
            PreparedStatement pst = Conexao.getConexao().prepareStatement(SELECTALL);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                retorno = new Imagem();
                retorno.setImagemid(rs.getInt("id"));
                retorno.setImagem(rs.getBytes("binario"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }

        return retorno;
    }
}
