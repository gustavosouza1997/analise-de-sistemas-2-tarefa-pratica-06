package factories;

import models.Endereco;
import models.PosicaoEmTempoReal;

public class PosicaoEmTempoRealFactory {
    public PosicaoEmTempoReal criarPosicaoEmTempoReal(int id_posicao, Endereco endereco, String horario) {
        return new PosicaoEmTempoReal(id_posicao, endereco, horario);
    }
}
