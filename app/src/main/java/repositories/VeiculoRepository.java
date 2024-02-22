package repositories;

import database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoRepository {

    private DatabaseManager dbManager;

    public VeiculoRepository(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void criarTabelaVeiculo() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("CREATE TABLE IF NOT EXISTS Veiculo (")
                    .append("placa VARCHAR(8) PRIMARY KEY, ")
                    .append("Modelo_codMod INTEGER NOT NULL, ")
                    .append("Cliente_cpf BIGINT NOT NULL, ")
                    .append("cor VARCHAR(20) NOT NULL, ")
                    .append("FOREIGN KEY (Modelo_codMod) REFERENCES Modelo(codMod), ")
                    .append("FOREIGN KEY (Cliente_cpf) REFERENCES Cliente(cpf)")
                    .append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Veiculo criada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tabela Veiculo: " + ex.getMessage(), ex);
        }
    }

    public void deletarTabelaVeiculo() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DROP TABLE IF EXISTS Veiculo");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Veiculo deletada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tabela Veiculo: " + ex.getMessage(), ex);
        }
    }

    public void inserirVeiculo(String placa, Integer Modelo_codMod, Long Cliente_cpf, String cor) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("INSERT INTO Veiculo (placa, Modelo_codMod, Cliente_cpf, cor) VALUES ('")
                    .append(placa).append("', ")
                    .append(Modelo_codMod).append(", ")
                    .append(Cliente_cpf).append(", '")
                    .append(cor).append("')");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Veiculo inserido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir veiculo: " + ex.getMessage(), ex);
        }
    }

    public void listarVeiculos() throws SQLException {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Veiculo");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                String placa = resultSet.getString("placa");
                int Modelo_codMod = resultSet.getInt("Modelo_codMod");
                long Cliente_cpf = resultSet.getLong("Cliente_cpf");
                String cor = resultSet.getString("cor");

                System.out.println("Placa: " + placa + ", Codigo do Modelo: " + Modelo_codMod + ", CPF do Cliente: "
                        + Cliente_cpf + ", Cor: " + cor);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    public void deletarVeiculoByPlaca(String placa) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Veiculo WHERE placa = '").append(placa).append("'");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Veiculo deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar veiculo: " + ex.getMessage(), ex);
        }
    }

    public void atualizarVeiculo(String placa, Integer Modelo_codMod, Long Cliente_cpf, String cor) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("UPDATE Veiculo SET Modelo_codMod = ").append(Modelo_codMod)
                    .append(", Cliente_cpf = ").append(Cliente_cpf)
                    .append(", cor = '").append(cor)
                    .append("' WHERE placa = '").append(placa).append("'");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Veiculo atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar veiculo: " + ex.getMessage(), ex);
        }
    }

    public void deletarTodosVeiculos() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Veiculo");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Veiculos deletados com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar veiculos: " + ex.getMessage(), ex);
        }
    }
}
