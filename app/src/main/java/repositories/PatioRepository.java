package repositories;

import database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatioRepository {

    private DatabaseManager dbManager;

    public PatioRepository(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void criarTabelaPatio() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("CREATE TABLE IF NOT EXISTS Patio (")
                    .append("num INTEGER PRIMARY KEY, ")
                    .append("ender VARCHAR(40) NOT NULL, ")
                    .append("capacidade INTEGER NOT NULL")
                    .append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Patio criada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tabela Patio: " + ex.getMessage(), ex);
        }
    }

    public void deletarTabelaPatio() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DROP TABLE IF EXISTS Patio");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Patio deletada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tabela Patio: " + ex.getMessage(), ex);
        }
    }

    public void inserirPatio(Integer num, String ender, Integer capacidade) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("INSERT INTO Patio (num, ender, capacidade) VALUES (")
                    .append(num).append(", '")
                    .append(ender).append("', ")
                    .append(capacidade).append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Patio inserido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir patio: " + ex.getMessage(), ex);
        }
    }

    public void listarPatios() throws SQLException {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Patio");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                int num = resultSet.getInt("num");
                String ender = resultSet.getString("ender");
                int capacidade = resultSet.getInt("capacidade");

                System.out.println("Numero do Patio: " + num + ", Endereco: " + ender + ", Capacidade: " + capacidade);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    public void deletarPatioByNum(Integer num) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Patio WHERE num = ").append(num);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Patio deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar patio: " + ex.getMessage(), ex);
        }
    }

    public void atualizarPatio(Integer num, String ender, Integer capacidade) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("UPDATE Patio SET ender = '").append(ender)
                    .append("', capacidade = ").append(capacidade)
                    .append(" WHERE num = ").append(num);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Patio atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar patio: " + ex.getMessage(), ex);
        }
    }

    public void deletarTodosPatios() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Patio");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Todos os Patios foram deletados com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar todos os patios: " + ex.getMessage(), ex);
        }
    }
}
