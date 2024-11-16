package controllers;

import models.Usuario;

import java.util.List;
import java.util.ArrayList;

public class GestorUsuario {
    private List<Usuario> listaUsuario;

    public GestorUsuario() { 
        this.listaUsuario = new ArrayList<>(); 
    }

    public void adicionarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        listaUsuario.remove(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        for (Usuario u : listaUsuario) {
            if (u.getId_usuario() == usuario.getId_usuario()) {
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());
                u.setLocalizacao(usuario.getLocalizacao());
            }
        }
    }

    public Usuario buscarUsuario(int id_usuario) {
        for (Usuario u : listaUsuario) {
            if (u.getId_usuario() == id_usuario) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void printListaUsuario () {
        for (Usuario u : listaUsuario) {
            u.toString();
        }
    }
}