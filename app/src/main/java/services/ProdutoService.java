/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
// Classe para lidar com a lógica de negócios relacionada aos produtos
public class ProdutoService {

    private DatabaseManager dbManager;

    public ProdutoService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void listarProdutos() throws SQLException {
        try {
            StringBuilder commit = new StringBuilder();
            commit.append("SELECT * FROM produto");

            ResultSet resultSet = dbManager.executeQuery(commit.toString());
            while (resultSet.next()) {
                int res = resultSet.getInt("cod_prod");
                System.out.println(res);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar a consulta SQL: " + ex.getMessage(), ex);
        }
    }

    // Outros métodos relacionados aos produtos, como inserir, atualizar, excluir, etc.
}
