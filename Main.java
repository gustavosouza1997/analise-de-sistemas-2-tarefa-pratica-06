import facades.MainFacade;

public class Main {

    public static void main(String[] args) {
        MainFacade facade = MainFacade.getInstance();

        // Adicionar usuários
        facade.adicionarUsuario(
            1, 
            "Gustavo Alex de Souza", 
            "gustavosouza@sou.faccat.br",
            50.11526, 
            128.16515, 
            "Rua Julio Kohlrausch", 
            "9175"
        );
        facade.adicionarUsuario(
            2, 
            "Luciano Rafael da Rosa", 
            "luciano.rosa@sou.faccat.br", 
            129.05926, 
            65056514, 
            "Rua Santa Rosa", 
            "9999"
        );
        
        // Print de todos os usuários cadastrados
        System.out.println("\nUsuários cadastrados:");	
        facade.printUsuarios();

        // Remover usuário de id 2
        facade.removerUsuario(2);

        System.out.println("\nUsuários cadastrados após remoção do usuário:");
        // Print de todos os usuários cadastrados
        facade.printUsuarios();

        // Atualizar usuário de id 1
        facade.atualizarUsuario(1, "Gustavo Alex de Souza", "teste123@gmail.com");	

        System.out.println("\nUsuários cadastrados após atualização do usuário:");
        facade.printUsuarios();

        // Atualizar localização do usuário de id 1
        facade.atualizarLocalizacaoUsuario(1, 50.11526, 128.16515, "Estrada Padilha", "9175");

        System.out.println("\nUsuários cadastrados após atualização da localização do usuário:");
        facade.printUsuarios();

        // Adicionar rotas
        facade.adicionarRota(1, 123.55145, 1285.456142, "Estrada Padilha", "8000", 50.11526, 128.16515, "Estrada Padilha", "9175");
        facade.adicionarRota(2, 123.55145, 1285.456142, "Estrada Padilha", "200", 50.11526, 128.16515, "Estrada Padilha", "460");

        // Print de todas as rotas cadastradas
        System.out.println("\nRotas cadastradas:");
        facade.printRotas();

        // Atualizar Ponto Inicial da Rota de id 1
        facade.atualizarRotaPontoInicial(1, 50.11526, 128.16515, "Estrada Padilha", "9175");

        System.out.println("\nRotas cadastradas após atualização do ponto inicial da rota:");
        facade.printRotas();

        // Atualizar Ponto Final da Rota de id 1
        facade.atualizarRotaPontoFinal(1, 50.11526, 128.16515, "Tristão Monteiro", "256");

        System.out.println("\nRotas cadastradas após atualização do ponto final da rota:");
        facade.printRotas();

        // Remover rota de id 2
        facade.removerRota(2);

        System.out.println("\nRotas cadastradas após remoção da rota:");
        facade.printRotas();

        // Adicionar ônibus
        facade.adicionarOnibus(1, 1, "14:50", 1, 50.11526, 128.16515, "Estrada Padilha", "9175");
        
        // Print de todos os ônibus cadastrados
        System.out.println("\nÔnibus cadastrados:");
        facade.printOnibus();

        // Atualizar localização do ônibus de id 1
        facade.atualizarPosicaoOnibus(1, 1235.11526, 135.16515, "Estrada Padilha", "230");

        System.out.println("\nÔnibus cadastrados após atualização da localização do ônibus:");
        facade.printOnibus();
    }
}