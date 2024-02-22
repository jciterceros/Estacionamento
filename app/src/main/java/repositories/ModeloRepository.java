package repositories;

import database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloRepository {
    private DatabaseManager dbManager;

    public ModeloRepository(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void criarTabelaModelo() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("CREATE TABLE IF NOT EXISTS Modelo (")
                    .append("codMod INTEGER PRIMARY KEY, ")
                    .append("Desc_2 VARCHAR(40) NOT NULL")
                    .append(")");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Modelo criada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tabela Modelo: " + ex.getMessage(), ex);
        }
    }

    public void deletarTabelaModelo() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DROP TABLE IF EXISTS Modelo");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Tabela Modelo deletada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tabela Modelo: " + ex.getMessage(), ex);
        }
    }

    public void inserirModelo(Integer codMod, String desc_2) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("INSERT INTO Modelo (codMod, Desc_2) VALUES (")
                    .append(codMod).append(", '")
                    .append(desc_2).append("')");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Modelo inserido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir modelo: " + ex.getMessage(), ex);
        }
    }

    public void listarModelos() throws SQLException {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("SELECT * FROM Modelo");

            ResultSet resultSet = dbManager.executeQuery(querySQL.toString());
            while (resultSet.next()) {
                int codMod = resultSet.getInt("codMod");
                String desc_2 = resultSet.getString("Desc_2");

                System.out.println("Codigo do Modelo: " + codMod + ", Descricao: " + desc_2);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    public void deletarModeloByCod(Integer codMod) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Modelo WHERE codMod = ").append(codMod);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Modelo deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar modelo: " + ex.getMessage(), ex);
        }
    }

    public void atualizarModelo(Integer codMod, String desc_2) {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("UPDATE Modelo SET Desc_2 = '").append(desc_2)
                    .append("' WHERE codMod = ").append(codMod);

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Modelo atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar modelo: " + ex.getMessage(), ex);
        }
    }

    public void deletarTodosModelos() {
        try {
            StringBuilder querySQL = new StringBuilder();
            querySQL.append("DELETE FROM Modelo");

            dbManager.executeUpdate(querySQL.toString());
            System.out.println("Todos os modelos foram deletados com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar todos os modelos: " + ex.getMessage(), ex);
        }
    }
}
