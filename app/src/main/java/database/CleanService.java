package database;

import repositories.ClienteRepository;
import repositories.EstacionaRepository;
import repositories.ModeloRepository;
import repositories.PatioRepository;
import repositories.VeiculoRepository;

public class CleanService {

    private DatabaseManager dbManager;

    public CleanService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Deletar todas as tabelas
    public void deletarTodasTabelas() {
        ClienteRepository clienteService = new ClienteRepository(dbManager);
        ModeloRepository modeloService = new ModeloRepository(dbManager);
        PatioRepository patioService = new PatioRepository(dbManager);
        VeiculoRepository veiculoService = new VeiculoRepository(dbManager);
        EstacionaRepository estacionaService = new EstacionaRepository(dbManager);

        estacionaService.deletarTodosEstaciona();
        estacionaService.deletarTabelaEstaciona();

        veiculoService.deletarTodosVeiculos();
        veiculoService.deletarTabelaVeiculo();

        clienteService.deletarTodosClientes();
        clienteService.deletarTabelaCliente();

        modeloService.deletarTodosModelos();
        modeloService.deletarTabelaModelo();

        patioService.deletarTodosPatios();
        patioService.deletarTabelaPatio();
    }
}
