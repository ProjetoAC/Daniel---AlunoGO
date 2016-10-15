package Dao;

import Model.Imagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class ImagemDAO {

    public Boolean inserir(Imagem imagem) throws SQLException {
        Boolean retorno = false;
        String sql = "INSERT INTO imagem (binario) values (?)";

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setBytes(1, imagem.getImagem());
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return retorno;
    }

    public Imagem buscar(Integer id) throws SQLException {
        Imagem retorno = null;
        String sql = "SELECT id ,binario from imagem where id=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
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
