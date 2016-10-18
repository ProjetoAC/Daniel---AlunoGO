package model;

/**
 *
 * @author Daniel
 */
public class Relatorio {
    private int Relatorioid;
    private int alunoid;

    public int getAlunoid() {
        return alunoid;
    }

    public void setAlunoid(int alunoid) {
        this.alunoid = alunoid;
    }
    private String Ata;

    public int getRelatorioid() {
        return Relatorioid;
    }

    public void setRelatorioid(int Relatorioid) {
        this.Relatorioid = Relatorioid;
    }

    public String getAta() {
        return Ata;
    }

    public void setAta(String Ata) {
        this.Ata = Ata;
    }
}
