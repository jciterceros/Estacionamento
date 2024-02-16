package database.seeds;

import services.ModeloService;

public class SeedsModelo {
    public SeedsModelo(ModeloService modeloService) {
        // Deletar tabela de Modelo
        // modeloService.deletarTabelaModelo();

        // Criar tabela de Modelo
        modeloService.criarTabelaModelo();

        // Deletar Todos os Modelos
        modeloService.deletarTodosModelos();

        // Inserir Modelo
        modeloService.inserirModelo(1, "Fusca");
        modeloService.inserirModelo(2, "Gol");
        modeloService.inserirModelo(3, "Palio");
        modeloService.inserirModelo(4, "Uno");
        modeloService.inserirModelo(5, "Celta");
        modeloService.inserirModelo(6, "Corsa");
        modeloService.inserirModelo(7, "Onix");
        modeloService.inserirModelo(8, "Prisma");
        modeloService.inserirModelo(9, "Civic");
        modeloService.inserirModelo(10, "Corolla");
    }
}
