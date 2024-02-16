package services;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import entities.Cliente;
import entities.Estaciona;
import entities.Modelo;
import entities.Patio;
import entities.Veiculo;

public class LoadService {

    private DatabaseManager dbManager;

    public LoadService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Devolver Lista de Clientes para classe Clientes
    public List<Cliente> loadClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Cliente");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                long cpf = resultSet.getLong("cpf");
                String nome = resultSet.getString("nome");
                Date dtNasc = resultSet.getDate("dtNasc");

                Cliente cliente = new Cliente(cpf, nome, dtNasc);
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    // Devolver Lista de Modelos para classe Modelos
    public List<Modelo> loadModelos() throws SQLException {
        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Modelo");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                int codMod = resultSet.getInt("codMod");
                String desc_2 = resultSet.getString("Desc_2");

                Modelo modelo = new Modelo(codMod, desc_2);
                modelos.add(modelo);
            }
            return modelos;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    // Devolver Lista dos Patios para classe Patios
    public List<Patio> loadPatios() throws SQLException {
        List<Patio> patios = new ArrayList<Patio>();
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Patio");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                int num = resultSet.getInt("num");
                String ender = resultSet.getString("ender");
                int capacidade = resultSet.getInt("capacidade");

                Patio patio = new Patio(num, ender, capacidade);
                patios.add(patio);
            }
            return patios;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    // Devolver Lista de Veiculos para classe Veiculos
    public List<Veiculo> loadVeiculos(List<Cliente> clientes, List<Modelo> modelos) throws SQLException {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Veiculo");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                String placa = resultSet.getString("placa");
                int Modelo_codMod = resultSet.getInt("Modelo_codMod");
                long Cliente_cpf = resultSet.getLong("Cliente_cpf");
                String cor = resultSet.getString("cor");

                Veiculo veiculo = new Veiculo(placa, Modelo_codMod, Cliente_cpf, cor);
                veiculos.add(veiculo);
            }
            veiculos.forEach(veiculo -> {
                clientes.forEach(cliente -> {
                    if (veiculo.getCliente_cpf().equals(cliente.getCpf())) {
                        veiculo.setCliente(cliente);
                    }
                });
                modelos.forEach(modelo -> {
                    if (veiculo.getModelo_codMod() == modelo.getCodMod()) {
                        veiculo.setModelo(modelo);
                    }
                });
            });
            return veiculos;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    // Devolver Lista de Estacionamentos para classe Estaciona
    public List<Estaciona> loadEstaciona(List<Veiculo> veiculos, List<Patio> patios) throws SQLException {
        List<Estaciona> estacionamentos = new ArrayList<Estaciona>();
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Estaciona");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                int cod = resultSet.getInt("cod");
                int Patio_num = resultSet.getInt("Patio_num");
                String Veiculo_placa = resultSet.getString("Veiculo_placa");
                String dtEntrada = resultSet.getString("dtEntrada");
                String dtSaida = resultSet.getString("dtSaida");
                String hsEntrada = resultSet.getString("hsEntrada");
                String hsSaida = resultSet.getString("hsSaida");

                Estaciona estaciona = new Estaciona(cod, Patio_num, Veiculo_placa, dtEntrada, dtSaida, hsEntrada,
                        hsSaida);
                estacionamentos.add(estaciona);
            }
            estacionamentos.forEach(estaciona -> {
                veiculos.forEach(veiculo -> {
                    if (estaciona.getVeiculo_placa().equals(veiculo.getPlaca())) {
                        estaciona.setVeiculo(veiculo);
                    }
                });
                patios.forEach(patio -> {
                    if (estaciona.getPatio_num() == patio.getNum()) {
                        estaciona.setPatio(patio);
                    }
                });
            });
            return estacionamentos;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }
}
