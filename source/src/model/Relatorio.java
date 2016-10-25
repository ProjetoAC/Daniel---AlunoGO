package model;

/**
 *
 * @author Daniel
 */
public class Relatorio {
    private int Relatorioid;
    private int alunoid;
    private String Ata;
    private String Titulo;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getAlunoid() {
        return alunoid;
    }

    public void setAlunoid(int alunoid) {
        this.alunoid = alunoid;
    }


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
