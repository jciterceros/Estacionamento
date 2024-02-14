package services;

import database.DatabaseManager;
import entities.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private DatabaseManager dbManager;

    public ClienteService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void criarTabelaCliente() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("CREATE TABLE IF NOT EXISTS Cliente (")
                    .append("cpf BIGINT PRIMARY KEY, ")
                    .append("nome VARCHAR(60) NOT NULL, ")
                    .append("dtNasc DATE NOT NULL")
                    .append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Cliente criada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tabela Cliente: " + ex.getMessage(), ex);
        }
    }

    public void deletarTabelaCliente() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DROP TABLE IF EXISTS Cliente");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Cliente deletada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tabela Cliente: " + ex.getMessage(), ex);
        }
    }

    public void inserirCliente(Long cpf, String nome, String dtNasc) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("INSERT INTO Cliente (cpf, nome, dtNasc) VALUES (")
                    .append(cpf).append(", '")
                    .append(nome).append("', '")
                    .append(dtNasc).append("')");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir cliente: " + ex.getMessage(), ex);
        }
    }

    public void deletarClienteByCPF(Long cpf) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Cliente WHERE cpf = ").append(cpf);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar cliente: " + ex.getMessage(), ex);
        }
    }

    public void atualizarCliente(Long cpf, String nome, String dtNasc) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("UPDATE Cliente SET nome = '").append(nome)
                    .append("', dtNasc = '").append(dtNasc)
                    .append("' WHERE cpf = ").append(cpf);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar cliente: " + ex.getMessage(), ex);
        }
    }

    public void listarClientes() throws SQLException {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Cliente");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                long cpf = resultSet.getLong("cpf");
                String nome = resultSet.getString("nome");
                Date dtNasc = resultSet.getDate("dtNasc");

                System.out.println("CPF: " + cpf + ", Nome: " + nome + ", Data de Nascimento: " + dtNasc);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
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

    public void deletarTodosClientes() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Cliente");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Todos os clientes foram deletados com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar todos os clientes: " + ex.getMessage(), ex);
        }
    }
}
