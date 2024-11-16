package models;

public class Usuario {
    private int id_usuario;
    private String nome;
    private String email;
    private Endereco localizacao;

    public Usuario(int id_usuario, String nome, String email, Endereco localizacao) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    // Getters e Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Endereco localizacao) {
        this.localizacao = localizacao;
    }

    public String toString() {
        return "ID: " + id_usuario + "\nNome: " + nome + "\nEmail: " + email + "\nLocalização: " + localizacao.toString();
    }
}