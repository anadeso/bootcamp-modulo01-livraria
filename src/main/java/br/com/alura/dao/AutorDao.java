package br.com.alura.dao;

import br.com.alura.modelo.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Autor> listar() {
        try {
            String sql = "select * from autor";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            List<Autor> autores = new ArrayList<>();

            while (resultSet.next()) {
                Autor autor = new Autor();
                autor.setNome(resultSet.getString("nome"));
                autor.setEmail(resultSet.getString("email"));
                autor.setDataNascimento(resultSet.getDate("data").toLocalDate());
                autor.setMiniCurriculo(resultSet.getString("minic"));

                autores.add(autor);
            }
            return autores;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
