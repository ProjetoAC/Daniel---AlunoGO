package dao;

import model.Imagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Senai
 */
public class ImagemDAO {
public Boolean inserir(Imagem imagem)
    {
        Boolean retorno = false;
        String sql = "INSERT INTO imagem (id, binario) values (?,?)";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
            pst.setInt(1, imagem.getImagemid());
            pst.setBytes(2, imagem.getImagem());
            pst.executeUpdate();
            retorno = true;
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return retorno;
    
    }
    
    public Imagem buscar(Integer id)
    {
        Imagem retorno = null;
        String sql = "SELECT id,binario from imagem where id=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
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
