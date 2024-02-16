package database.seeds;

import services.PatioService;

public class SeedsPatio {
    public SeedsPatio(PatioService patioService) {
        // Deletar tabela de Patio
        // patioService.deletarTabelaPatio();

        // Criar tabela de Patio
        patioService.criarTabelaPatio();

        // Deletar Todos os Patios
        patioService.deletarTodosPatios();

        // Inserir Patio
        patioService.inserirPatio(1, "Rua 1", 10);
        patioService.inserirPatio(2, "Rua 2", 20);
        patioService.inserirPatio(3, "Rua 3", 30);
        patioService.inserirPatio(4, "Rua 4", 40);
        patioService.inserirPatio(5, "Rua 5", 50);
        patioService.inserirPatio(6, "Rua 6", 60);
        patioService.inserirPatio(7, "Rua 7", 70);
        patioService.inserirPatio(8, "Rua 8", 80);
        patioService.inserirPatio(9, "Rua 9", 90);
        patioService.inserirPatio(10, "Rua 10", 100);
    }
}
