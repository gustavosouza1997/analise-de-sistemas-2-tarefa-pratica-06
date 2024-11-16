package factories;

import models.Endereco;
import models.Rota;

public class RotaFactory {
     public Rota criarRota(int id_rota, Endereco ponto_inicial, Endereco ponto_final) {
        return new Rota(id_rota, ponto_inicial, ponto_final);
    }
}
