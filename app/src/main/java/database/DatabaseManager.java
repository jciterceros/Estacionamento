/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Fernando
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private DatabaseConfig config;
    private Connection connection;

    public DatabaseManager(DatabaseConfig config) {
        this.config = config;
        connect();
    }

    private void connect() {
        try {
            String url = "jdbc:postgresql://" + config.getHost() + ":" + config.getPort() + "/" + config.getDatabase();
            connection = DriverManager.getConnection(url, config.getUser(), config.getPassword());
            System.out.println("Conexao feita com Sucesso....");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + ex.getMessage(), ex);
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconexao feita com Sucesso....");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao desconectar do banco de dados: " + ex.getMessage(), ex);
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try {
            // return connection.createStatement().executeQuery(query);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    public int executeUpdate(String query) throws SQLException {
        try {
            // connection.createStatement().executeUpdate(query);
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a atualização SQL: " + ex.getMessage(), ex);
        }
    }
}