package database;

import services.ClienteService;
import services.EstacionaService;
import services.ModeloService;
import services.PatioService;
import services.VeiculoService;

public class CleanService {

    private DatabaseManager dbManager;

    public CleanService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Deletar todas as tabelas
    public void deletarTodasTabelas() {
        ClienteService clienteService = new ClienteService(dbManager);
        ModeloService modeloService = new ModeloService(dbManager);
        PatioService patioService = new PatioService(dbManager);
        VeiculoService veiculoService = new VeiculoService(dbManager);
        EstacionaService estacionaService = new EstacionaService(dbManager);

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
