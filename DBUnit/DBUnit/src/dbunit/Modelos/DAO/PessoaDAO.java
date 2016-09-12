/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit.Modelos.DAO;

import dbunit.Modelos.Bean.Pessoa;
import dbunit.Util.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 *
 * @author PC
 */
public class PessoaDAO {

    protected Database db = new Database();

    public void salvar(Pessoa p) throws SQLException {
        if (p.getIdPessoa() != 0) {
            String sql = "INSERT INTO pessoa (idPessoa, nome, cidade, email) VALUES (?, ?, ?, ?)";
            try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, RETURN_GENERATED_KEYS)) {

                ps.setInt(1, p.getIdPessoa());
                ps.setString(2, p.getNome());
                ps.setString(3, p.getCidade());
                ps.setString(4, p.getEmail());

                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.first()) {
                        p.setIdPessoa(rs.getInt(1));
                    }
                }
            }
        } else {
            String sql = "INSERT INTO pessoa (nome, cidade, email) VALUES (?, ?, ?)";

            try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, RETURN_GENERATED_KEYS)) {

                ps.setString(1, p.getNome());
                ps.setString(2, p.getCidade());
                ps.setString(3, p.getEmail());

                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.first()) {
                        p.setIdPessoa(rs.getInt(1));
                    }
                }
            }
        }
    }

    public Pessoa obter(int codigo) throws IOException, SQLException {
        String sql = "SELECT * FROM pessoa WHERE idPessoa = ?";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, codigo);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setIdPessoa(rs.getInt("idPessoa"));
                    p.setNome(rs.getString("nome"));
                    p.setCidade(rs.getString("cidade"));
                    p.setEmail(rs.getString("email"));
                    return p;
                }
            }
        }
        return null;
    }

    public void atualizar(Pessoa p) throws IOException, SQLException {
        String sql = "UPDATE pessoa SET nome = ?, cidade = ?, email = ? "
                + "WHERE idPessoa = ?";

        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(
                sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getCidade());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getIdPessoa());

            ps.executeUpdate();
        }
    }

    public void apagar(int codigo) throws IOException, SQLException {
        String sql = "DELETE FROM pessoa WHERE idPessoa = ?";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(
                sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, codigo);
            ps.executeUpdate();
        }
    }

    public void apagar(Pessoa p) throws IOException, SQLException {
        apagar(p.getIdPessoa());
    }

}
