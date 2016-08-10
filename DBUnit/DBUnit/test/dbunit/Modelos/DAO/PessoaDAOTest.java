/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit.Modelos.DAO;

import dbunit.Modelos.Bean.Pessoa;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author PC
 */
public class PessoaDAOTest {

    PessoaDAO p = new PessoaDAO();

    //@Test
    public void testSalvar() throws IOException, SQLException {
        Pessoa pessoa = p.obter(3);
        pessoa.setNome("Diego");
        p.salvar(pessoa);
        Assert.assertNotNull(pessoa);
        Assert.assertEquals("Diego", pessoa.getNome());
    }

    //@Test
    public void testObter() throws IOException, SQLException {
        Pessoa pessoa = p.obter(3);
        Assert.assertNotNull(pessoa);
        Assert.assertEquals("Donna", pessoa.getNome());
        Assert.assertEquals("Banyulegi", pessoa.getCidade());
        Assert.assertEquals("dwillis2@epa.gov", pessoa.getEmail());
        Assert.assertEquals(3, pessoa.getIdPessoa());
    }

    @Test
    public void testAtualizar() throws IOException, SQLException {
        Pessoa pessoa = p.obter(3);
        pessoa.setNome("Diegão");
        p.atualizar(pessoa);
        Assert.assertNotNull(pessoa);
        //Assert.assertEquals("Diegão", pessoa.getNome());
    }

    //@Test
    public void testApagar() throws SQLException, IOException {
        Pessoa pessoa = p.obter(2);
        pessoa.setNome("Jane");
        p.salvar(pessoa);
        p.apagar(pessoa);
        Assert.assertEquals("Jane", pessoa.getNome());
    }
    
    @Before
    public void adicionaPraTeste(){
        
    }
    
    @After
    public void aconteceDepois(){
        
    }
}
