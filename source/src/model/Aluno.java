package model;

/**
 *
 * @author Daniel
 */

public class Aluno {
    private int alunoid;
    private int instituicaoid;
    private String nome_completo;
    private int idade;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String nome_responsavel;
    private String telefone_responsavel;
    private String parentesco_responsavel;        

    public int getInstituicaoid() {
        return instituicaoid;
    }

    public void setInstituicaoid(int instituicaoid) {
        this.instituicaoid = instituicaoid;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public int getAlunoid() {
        return alunoid;
    }

    public void setAlunoid(int alunoid) {
        this.alunoid = alunoid;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getTelefone_responsavel() {
        return telefone_responsavel;
    }

    public void setTelefone_responsavel(String telefone_responsavel) {
        this.telefone_responsavel = telefone_responsavel;
    }

    public String getParentesco_responsavel() {
        return parentesco_responsavel;
    }

    public void setParentesco_responsavel(String parentesco_responsavel) {
        this.parentesco_responsavel = parentesco_responsavel;
    }
}