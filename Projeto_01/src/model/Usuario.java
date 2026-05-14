package model;

public class Usuario {
    private int id;
    private String nome;
    private String CPF;
    private boolean ind;

    public Usuario() {}

    public Usuario(int id, String nome, String CPF, boolean ind) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.ind = ind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean isInd() {
        return ind;
    }

    public void setInd(boolean ind) {
        this.ind = ind;
    }
	
}
