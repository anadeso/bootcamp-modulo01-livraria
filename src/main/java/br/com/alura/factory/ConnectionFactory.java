package br.com.alura.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/carteira";
            String usuario = "root";
            String senha = "";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
