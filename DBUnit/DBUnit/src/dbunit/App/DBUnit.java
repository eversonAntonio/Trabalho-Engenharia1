/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit.App;

import dbunit.Modelos.Bean.Pessoa;
import dbunit.Modelos.DAO.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DBUnit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Pessoa p = new Pessoa();
        p.setIdPessoa(101);
        p.setNome("Diego");
        p.setEmail("diego.dalto@hotmail.com");
        p.setCidade("Coxim");
        
         PessoaDAO teste = new PessoaDAO();
         teste.salvar(p);
        

    }

}
