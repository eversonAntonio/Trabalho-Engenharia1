/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dbunit.Modelos.Bean.Pessoa;
import dbunit.Modelos.DAO.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Diego
 */
public class Teste {

    @Test
    public void testSalvar() throws SQLException, IOException {
        PessoaDAO teste = new PessoaDAO();
        Pessoa p = new Pessoa();
        p.setIdPessoa(101);
        p.setNome("Diego");
        p.setEmail("diego.dalto@hotmail.com");
        p.setCidade("Coxim");

        teste.salvar(p);

        Pessoa aux;
        aux = teste.obter(p.getIdPessoa());

        assertEquals(aux.getIdPessoa(), p.getIdPessoa());
    }

    @Test
    public void testObter() throws IOException, SQLException {
        PessoaDAO teste = new PessoaDAO();
        Pessoa p = new Pessoa();
        p.setIdPessoa(100);
        p.setNome("Daniel");
        p.setCidade("Point-à-Pitre");
        p.setEmail("dcook2r@tinyurl.com");

        Pessoa aux;
        aux = teste.obter(p.getIdPessoa());
        assertEquals(p, aux);
    }

    @Test
    public void testAtualizar() throws SQLException, IOException {
        PessoaDAO teste = new PessoaDAO();
        Pessoa p = new Pessoa();
        p.setIdPessoa(102);
        p.setNome("Dalto");
        p.setEmail("dalto.diego@hotmail.com");
        p.setCidade("Coxim");

        teste.salvar(p);

        Pessoa aux;
        aux = teste.obter(p.getIdPessoa());

        aux.setNome("Dalto alterado");
        aux.setEmail("doekdeo.diego@hotmail.com");
        aux.setCidade("Sonora");
        teste.atualizar(aux);
        
        p = teste.obter(p.getIdPessoa());

        assertEquals(p, aux);
    }

    @Test
    public void testApagar() throws SQLException, IOException {
        PessoaDAO teste = new PessoaDAO();
        Pessoa p = new Pessoa();
        p.setIdPessoa(102);
        p.setNome("Samara");
        p.setEmail("samara@hotmail.com");
        p.setCidade("Coxim");
        
        int aux = p.getIdPessoa();
        
        teste.salvar(p);
        
        teste.apagar(p);
        teste.obter(p.getIdPessoa());
        Assert.assertNotEquals(p.getIdPessoa(), aux);
    }

}

