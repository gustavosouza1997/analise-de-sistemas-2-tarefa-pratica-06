package models;

public class PosicaoEmTempoReal {
    private int id_posicao;
    private Endereco endereco;
    private String horario;

    public PosicaoEmTempoReal(int id_posicao, Endereco endereco, String horario) {
        this.id_posicao = id_posicao;
        this.endereco = endereco;
        this.horario = horario;
    }

    // Getters e Setters
    public int getId_posicao() {
        return id_posicao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString() {
        return "ID: " + id_posicao + "\nEndereço: " + endereco.toString() + "\nHorário: " + horario;
    }
}