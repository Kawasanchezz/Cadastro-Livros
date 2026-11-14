package br.com.livraria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL_PADRAO = "jdbc:mysql://localhost:3306/livraria_db";
    private static final String USUARIO_PADRAO = "root";

    private final String url = ler("DB_URL", URL_PADRAO);
    private final String usuario = ler("DB_USER", USUARIO_PADRAO);
    private final String senha = System.getenv("DB_PASSWORD");

    public Connection abrir() throws SQLException {
        if (senha == null) {
            throw new SQLException("Variável de ambiente DB_PASSWORD não definida.");
        }
        return DriverManager.getConnection(url, usuario, senha);
    }

    private static String ler(String nome, String padrao) {
        String valor = System.getenv(nome);
        return valor == null || valor.isEmpty() ? padrao : valor;
    }
}
