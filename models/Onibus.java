package models;

public class Onibus {
    private int id_onibus;
    private Rota rotaAtual;
    private String hora_estimada_chegada;
    private PosicaoEmTempoReal posicao;

    public Onibus(int id_onibus, Rota rotaAtual, String hora_estimada_chegada, PosicaoEmTempoReal posicao) {
        this.id_onibus = id_onibus;
        this.rotaAtual = rotaAtual;
        this.hora_estimada_chegada = hora_estimada_chegada;
        this.posicao = posicao;
    }

    // Getters e Setters
    public int getId_onibus() {
        return id_onibus;
    }

    public Rota getRotaAtual() {
        return rotaAtual;
    }

    public void setRotaAtual(Rota rotaAtual) {
        this.rotaAtual = rotaAtual;
    }

    public String getHora_estimada_chegada() {
        return hora_estimada_chegada;
    }

    public void setHora_estimada_chegada(String hora_estimada_chegada) {
        this.hora_estimada_chegada = hora_estimada_chegada;
    }

    public PosicaoEmTempoReal getPosicao() {
        return posicao;
    }

    public void setPosicao(PosicaoEmTempoReal posicao) {
        this.posicao = posicao;
    }

    public String toString() {
        return "ID: " + id_onibus + "\nRota Atual: " + rotaAtual.toString() + "\nHora Estimada de Chegada: " + hora_estimada_chegada + "\nPosição: " + posicao.toString();
    }
}