package factories;

import models.Endereco;

public class EnderecoFactory {
    public Endereco criarEndereco(double latitude, double longitude, String rua, String numero) {
        return new Endereco(latitude, longitude, rua, numero);
    }
}
