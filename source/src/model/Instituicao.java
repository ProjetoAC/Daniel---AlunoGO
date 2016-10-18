package model;

/**
 *
 * @author Daniel
 */
public class Instituicao {
    private int Instituicaoid;
    private String Nome;
    private String Natureza_administrativa;

    public int getInstituicaoid() {
        return Instituicaoid;
    }

    public void setInstituicaoid(int Instituicaoid) {
        this.Instituicaoid = Instituicaoid;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNatureza_administrativa() {
        return Natureza_administrativa;
    }

    public void setNatureza_administrativa(String Natureza_administrativa) {
        this.Natureza_administrativa = Natureza_administrativa;
    }
}
