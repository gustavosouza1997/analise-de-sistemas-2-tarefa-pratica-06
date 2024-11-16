package factories;

import models.Onibus;
import models.PosicaoEmTempoReal;
import models.Rota;

public class OnibusFactory {
    public Onibus criarOnibus(int id_onibus, Rota rotaAtual, String hora_estimada_chegada, PosicaoEmTempoReal posicao) {
        return new Onibus(id_onibus, rotaAtual, hora_estimada_chegada, posicao);
    }
}
