package database.seeds;

import repositories.EstacionaRepository;

public class SeedsEstaciona {
    public SeedsEstaciona(EstacionaRepository estacionaService) {
        // Deletar tabela de Estaciona
        // estacionaService.deletarTabelaEstaciona();

        // Criar tabela de Estaciona
        estacionaService.criarTabelaEstaciona();

        // Inserir Estaciona
        estacionaService.inserirEstaciona(1, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(2, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(3, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(4, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(5, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(6, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(7, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(8, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(9, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
        estacionaService.inserirEstaciona(10, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "12:00:00");
    }
}
