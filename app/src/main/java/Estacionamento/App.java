/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Estacionamento;

import database.DatabaseConfig;
import database.DatabaseManager;
import java.sql.SQLException;

import services.CleanService;
import services.ClienteService;
import services.EstacionaService;
import services.ModeloService;
import services.PatioService;
import services.VeiculoService;

public class App {

    public String getGreeting() {
        return "Seja bem-vindo ao Sistema de Estacionamento de vehiculos";
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new App().getGreeting());

        // Configuração do banco de dados
        DatabaseConfig config = new DatabaseConfig("localhost", "5433", "Estacionamento", "postgres", "postgres");

        // Inicialização do gerenciador do banco de dados
        DatabaseManager dbManager = new DatabaseManager(config);

        // Deletar todas as tabelas, Inicializar tudo do Zero
        CleanService cleanService = new CleanService(dbManager);
        cleanService.deletarTodasTabelas();

        // Inicialização do serviço Cliente
        ClienteService clienteService = new ClienteService(dbManager);

        // Deletar tabela de Cliente
        // clienteService.deletarTabelaCliente();

        // Criar tabela de Cliente
        clienteService.criarTabelaCliente();

        // Deletar Todos os Clientes
        clienteService.deletarTodosClientes();

        // Inserir Cliente
        clienteService.inserirCliente(33351745001L, "Fernando", "1990-01-01");
        clienteService.inserirCliente(33351745002L, "Maria", "1991-01-01");
        clienteService.inserirCliente(33351745003L, "Joao", "1992-01-01");
        clienteService.inserirCliente(33351745004L, "Jose", "1993-01-01");
        clienteService.inserirCliente(33351745005L, "Ana", "1994-01-01");
        clienteService.inserirCliente(33351745006L, "Paulo", "1995-01-01");
        clienteService.inserirCliente(33351745007L, "Pedro", "1996-01-01");
        clienteService.inserirCliente(33351745008L, "Lucas", "1997-01-01");
        clienteService.inserirCliente(33351745009L, "Marcos", "1998-01-01");
        clienteService.inserirCliente(33351745010L, "Lucia", "1999-01-01");

        // Listar produtos
        clienteService.listarClientes();

        // Deletar Cliente por ID
        clienteService.deletarClienteByCPF(33351745001L);

        // Atualizar Cliente
        clienteService.atualizarCliente(33351745002L, "Maria Silva", "1991-01-01");

        // Listar produtos
        clienteService.listarClientes();

        // Inicialização do serviço Modelo
        ModeloService modeloService = new ModeloService(dbManager);

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

        // Listar modelos
        modeloService.listarModelos();

        // Deletar Modelo pelo Código
        modeloService.deletarModeloByCod(1);

        // Atualizar Modelo
        modeloService.atualizarModelo(2, "Gol G5");

        // Listar modelos
        modeloService.listarModelos();

        // Inicialização do serviço Patio
        PatioService patioService = new PatioService(dbManager);

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

        // Listar patios
        patioService.listarPatios();

        // Deletar Patio pelo Número
        patioService.deletarPatioByNum(1);

        // Atualizar Patio
        patioService.atualizarPatio(2, "Rua 2", 25);

        // Listar patios
        patioService.listarPatios();

        // Inicialização do serviço Patio
        VeiculoService veiculoService = new VeiculoService(dbManager);

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

        // Listar veiculos
        veiculoService.listarVeiculos();

        // Deletar Veiculo pela Placa
        veiculoService.deletarVeiculoByPlaca("ABC1234");

        // Atualizar Veiculo
        veiculoService.atualizarVeiculo("DEF5678", 2, 33351745002L, "Branco");

        // Listar veiculos
        veiculoService.listarVeiculos();

        // Inicialização do serviço Patio
        EstacionaService estacionaService = new EstacionaService(dbManager);

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

        // Listar estacionas
        estacionaService.listarEstaciona();

        // Deletar Estaciona pelo Código
        estacionaService.deletarEstacionaByCod(1);

        // Atualizar Estaciona
        estacionaService.atualizarEstaciona(2, 2, "DEF5678", "2021-01-01", "2021-01-01", "10:00:00", "15:00:00");

        // Listar estacionas
        estacionaService.listarEstaciona();

        dbManager.disconnect();
        System.out.println("Saindo da aplicacao volte novamente...");
    }
}