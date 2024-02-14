package services;

import database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstacionaService {

    private DatabaseManager dbManager;

    public EstacionaService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void criarTabelaEstaciona() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("CREATE TABLE IF NOT EXISTS Estaciona (")
                    .append("cod INTEGER PRIMARY KEY, ")
                    .append("Patio_num INTEGER NOT NULL, ")
                    .append("Veiculo_placa VARCHAR(8) NOT NULL, ")
                    .append("dtEntrada VARCHAR(10) NOT NULL, ")
                    .append("dtSaida VARCHAR(10) NOT NULL, ")
                    .append("hsEntrada VARCHAR(10) NOT NULL, ")
                    .append("hsSaida VARCHAR(10) NOT NULL, ")
                    .append("FOREIGN KEY (Patio_num) REFERENCES Patio(num), ")
                    .append("FOREIGN KEY (Veiculo_placa) REFERENCES Veiculo(placa)")
                    .append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Estaciona criada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tabela Estaciona: " + ex.getMessage(), ex);
        }
    }

    public void deletarTabelaEstaciona() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DROP TABLE IF EXISTS Estaciona");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Estaciona deletada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tabela Estaciona: " + ex.getMessage(), ex);
        }
    }

    public void inserirEstaciona(Integer cod, Integer Patio_num, String Veiculo_placa, String dtEntrada, String dtSaida,
            String hsEntrada, String hsSaida) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append(
                    "INSERT INTO Estaciona (cod, Patio_num, Veiculo_placa, dtEntrada, dtSaida, hsEntrada, hsSaida) VALUES (")
                    .append(cod).append(", ")
                    .append(Patio_num).append(", '")
                    .append(Veiculo_placa).append("', '")
                    .append(dtEntrada).append("', '")
                    .append(dtSaida).append("', '")
                    .append(hsEntrada).append("', '")
                    .append(hsSaida).append("')");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Estacionamento inserido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir Estacionamento: " + ex.getMessage(), ex);
        }
    }

    public void listarEstaciona() throws SQLException {
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

                System.out.println(
                        "Codigo: " + cod + ", Numero do Patio: " + Patio_num + ", Placa do Veiculo: " + Veiculo_placa
                                + ", Data de Entrada: " + dtEntrada + ", Data de Saida: " + dtSaida
                                + ", Hora de Entrada: " + hsEntrada + ", Hora de Saida: " + hsSaida);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    public void deletarEstacionaByCod(Integer cod) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Estaciona WHERE cod = ").append(cod);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Estacionamento deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar Estacionamento: " + ex.getMessage(), ex);
        }
    }

    public void atualizarEstaciona(Integer cod, Integer Patio_num, String Veiculo_placa, String dtEntrada,
            String dtSaida, String hsEntrada, String hsSaida) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("UPDATE Estaciona SET Patio_num = ").append(Patio_num)
                    .append(", Veiculo_placa = '").append(Veiculo_placa)
                    .append("', dtEntrada = '").append(dtEntrada)
                    .append("', dtSaida = '").append(dtSaida)
                    .append("', hsEntrada = '").append(hsEntrada)
                    .append("', hsSaida = '").append(hsSaida)
                    .append("' WHERE cod = ").append(cod);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Estacionamento atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar Estacionamento: " + ex.getMessage(), ex);
        }
    }

    public void deletarTodosEstaciona() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Estaciona");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Estacionamento deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar Estacionamento: " + ex.getMessage(), ex);
        }
    }
}
