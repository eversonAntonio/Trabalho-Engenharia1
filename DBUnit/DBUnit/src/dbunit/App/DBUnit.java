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
    public static void main(String[] args) {
        try {
            Pessoa p = new PessoaDAO().obter(10);
            System.out.println("Nome: " + p.getNome());
        } catch (IOException | SQLException ex) {
            System.err.println(ex);
        }
    }
    
}
