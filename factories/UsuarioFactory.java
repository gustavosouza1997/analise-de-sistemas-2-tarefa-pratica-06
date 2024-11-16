package factories;

import models.Endereco;
import models.Usuario;

public class UsuarioFactory {
     public Usuario criarUsuario(int id_usuario, String nome, String email, Endereco localizacao) {
        return new Usuario(id_usuario, nome, email, localizacao);
    }
}