package br.com.alura.dao;

import br.com.alura.modelo.Autor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorDao {
    private Connection conexao;

    public AutorDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Autor autor) {
        try {
            String sql = "insert into autor(nome, email, data, minic) values(?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getEmail());
            ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
            ps.setString(4, autor.getMiniCurriculo());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
