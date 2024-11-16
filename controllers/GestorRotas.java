package controllers;

import models.Rota;

import java.util.List;
import java.util.ArrayList;

public class GestorRotas {
    private List<Rota> listaRotas;

    public GestorRotas() {
        this.listaRotas = new ArrayList<>();
    }

    public void adicionarRota(Rota rota) {
        listaRotas.add(rota);
    }

    public void removerRota(Rota rota) {
        listaRotas.remove(rota);
    }

    public void atualizarRota(Rota rota) {
        for (Rota r : listaRotas) {
            if (r.getId_rota() == rota.getId_rota()) {
                r.setPonto_inicial(rota.getPonto_inicial());
                r.setPonto_final(rota.getPonto_final());
            }
        }
    }

    public Rota buscarRota(int id_rota) {
        for (Rota r : listaRotas) {
            if (r.getId_rota() == id_rota) {
                return r;
            }
        }
        return null;
    }

    public List<Rota> getListaRotas() {
        return listaRotas;
    }

    public void printListaRotas() {
        for (Rota r : listaRotas) {
            r.toString();
        }
    }
}