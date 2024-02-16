package database.seeds;

import services.VeiculoService;

public class SeedsVeiculo {
    public SeedsVeiculo(VeiculoService veiculoService) {
        // Deletar tabela de Veiculo
        // veiculoService.deletarTabelaVeiculo();

        // Criar tabela de Veiculo
        veiculoService.criarTabelaVeiculo();

        // Inserir Veiculo
        veiculoService.inserirVeiculo("ABC1234", 2, 33351745002L, "Preto");
        veiculoService.inserirVeiculo("DEF5678", 2, 33351745002L, "Branco");
        veiculoService.inserirVeiculo("GHI9012", 2, 33351745002L, "Vermelho");
        veiculoService.inserirVeiculo("JKL3456", 2, 33351745002L, "Azul");
        veiculoService.inserirVeiculo("MNO7890", 2, 33351745002L, "Verde");
        veiculoService.inserirVeiculo("PQR1234", 2, 33351745002L, "Amarelo");
        veiculoService.inserirVeiculo("STU5678", 2, 33351745002L, "Rosa");
        veiculoService.inserirVeiculo("VWX9012", 2, 33351745002L, "Roxo");
        veiculoService.inserirVeiculo("YZA3456", 2, 33351745002L, "Laranja");
        veiculoService.inserirVeiculo("BCD7890", 2, 33351745002L, "Cinza");
    }
}
