package controllers;

import models.Onibus;

import java.util.List;
import java.util.ArrayList;

public class GestorOnibus {
    private List<Onibus> listaOnibus;

    public GestorOnibus() {
        this.listaOnibus = new ArrayList<>();
    }

    public void adicionarOnibus(Onibus onibus) {
        listaOnibus.add(onibus);
    }

    public void removerOnibus(Onibus onibus) {
        listaOnibus.remove(onibus);
    }

    public void atualizarOnibus(Onibus onibus) {
        for (Onibus o : listaOnibus) {
            if (o.getId_onibus() == onibus.getId_onibus()) {
                o.setRotaAtual(onibus.getRotaAtual());
                o.setHora_estimada_chegada(onibus.getHora_estimada_chegada());
                o.setPosicao(onibus.getPosicao());
            }
        }
    }

    public Onibus buscarOnibus(int id_onibus) {
        for (Onibus o : listaOnibus) {
            if (o.getId_onibus() == id_onibus) {
                return o;
            }
        }
        return null;
    }

    public List<Onibus> getListaOnibus() {
        return listaOnibus;
    }

    public void printListaOnibus() {
        for (Onibus o : listaOnibus) {
            o.toString();
        }
    }
}