package facades;

import java.util.List;

import controllers.*;
import factories.*;
import models.*;
import utils.*;

public class MainFacade {
    // Controllers
    private GestorOnibus gestorOnibus;
    private GestorRotas gestorRotas;
    private GestorUsuario gestorUsuario;

    // Factories
    private EnderecoFactory enderecoFactory;
    private OnibusFactory onibusFactory;
    private PosicaoEmTempoRealFactory posicaoEmTempoRealFactory;
    private RotaFactory rotaFactory;
    private UsuarioFactory usuarioFactory;

    // Utils
    private Utils utils;

    // Instância unica da MainFacade
    private static MainFacade mainFacade;

    private MainFacade() {
        // Inicializando Controllers
        this.gestorOnibus = new GestorOnibus();
        this.gestorRotas = new GestorRotas();
        this.gestorUsuario = new GestorUsuario();

        // Inicializando Factories
        this.enderecoFactory = new EnderecoFactory();
        this.onibusFactory = new OnibusFactory();
        this.posicaoEmTempoRealFactory = new PosicaoEmTempoRealFactory();
        this.rotaFactory = new RotaFactory();
        this.usuarioFactory = new UsuarioFactory();

        // Inicializando Utils
        this.utils = new Utils();
    }

    // Método para obter a instância única da MainFacade
    public static MainFacade getInstance() {
        if (mainFacade == null) {
            mainFacade = new MainFacade();
        }

        return mainFacade;
    }

    // Métodos de Usuario
    public void adicionarUsuario(int id, String nome, String email, double latitude, double longitude, String rua, String numero) {
        Endereco endereco = enderecoFactory.criarEndereco(latitude, longitude, rua, numero);
        Usuario usuario = usuarioFactory.criarUsuario(id, nome, email, endereco);

        gestorUsuario.adicionarUsuario(usuario);
    }

    public void removerUsuario(int id) {
        Usuario usuario = gestorUsuario.buscarUsuario(id);

        gestorUsuario.removerUsuario(usuario);
    }
    
    public void atualizarUsuario(int id, String nome, String email) {
        Usuario usuario = this.buscarUsuario(id);

        usuario.setNome(nome);
        usuario.setEmail(email);        

        gestorUsuario.atualizarUsuario(usuario);
    }

    public void atualizarLocalizacaoUsuario(int id, double latitude, double longitude, String rua, String numero) {
        Usuario usuario = this.buscarUsuario(id);

        Endereco endereco = enderecoFactory.criarEndereco(latitude, longitude, rua, numero);
        usuario.setLocalizacao(endereco);

        gestorUsuario.atualizarUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return gestorUsuario.buscarUsuario(id);
    }

    public List<Usuario> getListaUsuario() {
        return gestorUsuario.getListaUsuario();
    }

    public void printUsuarios() {
        for (Usuario usuario : gestorUsuario.getListaUsuario()) {
            System.out.println(usuario.toString());
        }
    }

    // Métodos de Onibus
    public void adicionarOnibus(int id_onibus, int id_rota, String hora_estimada_chegada, int id_posicao_tempo_real, double latitude, double longitude, String rua, String numero) {
        Rota rotaAtual = this.buscarRota(id_rota);

        // Dados Posição em Tempo Real
        String horarioAtual = utils.getHorarioAtual();
        Endereco endereco_posicao_tempo_real = enderecoFactory.criarEndereco(latitude, longitude, rua, numero);
        PosicaoEmTempoReal posicao = posicaoEmTempoRealFactory.criarPosicaoEmTempoReal(id_posicao_tempo_real, endereco_posicao_tempo_real, horarioAtual);
       
        Onibus onibus = onibusFactory.criarOnibus(id_onibus, rotaAtual, hora_estimada_chegada, posicao);

        gestorOnibus.adicionarOnibus(onibus);
    }

    public void removerOnibus(int id) {
        Onibus onibus = gestorOnibus.buscarOnibus(id);

        gestorOnibus.removerOnibus(onibus);
    }

    public void atualizarRotaOnibus(int id_onibus, int id_rota) {
        Rota rotaAtual = this.buscarRota(id_rota);
        Onibus onibus = this.buscarOnibus(id_onibus);

        onibus.setRotaAtual(rotaAtual);

        gestorOnibus.atualizarOnibus(onibus);
    }

    public void atualizarPosicaoOnibus(int id_onibus, double latitude, double longitude, String rua, String numero) {
        Onibus onibus = this.buscarOnibus(id_onibus);

        Endereco endereco = enderecoFactory.criarEndereco(latitude, longitude, rua, numero);
        PosicaoEmTempoReal posicao = onibus.getPosicao();
        posicao.setEndereco(endereco);

        gestorOnibus.atualizarOnibus(onibus);
    }

    public void atualizarHoraEstimadaChegadaOnibus(int id_onibus, String hora_estimada_chegada) {
        Onibus onibus = this.buscarOnibus(id_onibus);

        onibus.setHora_estimada_chegada(hora_estimada_chegada);

        gestorOnibus.atualizarOnibus(onibus);
    }

    public Onibus buscarOnibus(int id) {
        return gestorOnibus.buscarOnibus(id);
    }

    public List<Onibus> getListaOnibus() {
        return gestorOnibus.getListaOnibus();
    }

    public void printOnibus() {
        for (Onibus onibus : gestorOnibus.getListaOnibus()) {
            System.out.println(onibus.toString());
        }
    }

    // Métodos de Rota
    public void adicionarRota(int id_rota, double latitude_ponto_inicial, double longitude_ponto_inicial, String rua_ponto_inicial, String numero_ponto_inicial, double latitude_ponto_final, double longitude_ponto_final, String rua_ponto_final, String numero_ponto_final) {
        Endereco ponto_inicial = enderecoFactory.criarEndereco(latitude_ponto_inicial, longitude_ponto_inicial, rua_ponto_inicial, numero_ponto_inicial);
        Endereco ponto_final = enderecoFactory.criarEndereco(latitude_ponto_final, longitude_ponto_final, rua_ponto_final, numero_ponto_final);

        Rota rota = rotaFactory.criarRota(id_rota, ponto_inicial, ponto_final);

        gestorRotas.adicionarRota(rota);
    }

    public void removerRota(int id) {
        Rota rota = this.buscarRota(id);

        gestorRotas.removerRota(rota);
    }

    public void atualizarRotaPontoInicial(int id, double latitude_ponto_inicial, double longitude_ponto_inicial, String rua_ponto_inicial, String numero_ponto_inicial) {
        Rota rota = this.buscarRota(id);

        Endereco ponto_inicial = enderecoFactory.criarEndereco(latitude_ponto_inicial, longitude_ponto_inicial, rua_ponto_inicial, numero_ponto_inicial);
        rota.setPonto_inicial(ponto_inicial);

        gestorRotas.atualizarRota(rota);
    }

    public void atualizarRotaPontoFinal(int id, double latitude_ponto_final, double longitude_ponto_final, String rua_ponto_final, String numero_ponto_final) {
        Rota rota = this.buscarRota(id);

        Endereco ponto_final = enderecoFactory.criarEndereco(latitude_ponto_final, longitude_ponto_final, rua_ponto_final, numero_ponto_final);
        rota.setPonto_final(ponto_final);
        
        gestorRotas.atualizarRota(rota);
    }

    public Rota buscarRota(int id) {
        return gestorRotas.buscarRota(id);
    }

    public List<Rota> getListaRotas() {
        return gestorRotas.getListaRotas();
    }    

    public void printRotas() {
        for (Rota rota : gestorRotas.getListaRotas()) {
            System.out.println(rota.toString());
        }
    }
}
