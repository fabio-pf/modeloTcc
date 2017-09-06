/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy;

import br.com.vedoy.modelo.Categorias;
import br.com.vedoy.modelo.Clientes;
import br.com.vedoy.modelo.Cotas;
import br.com.vedoy.modelo.Pessoas;
import br.com.vedoy.modelo.Tecnicos;
import br.com.vedoy.modelo.Tipo_Usuario;
import br.com.vedoy.modelo.Usuarios;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Fabio V
 */
public class Testes {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public Testes() {
    }
    
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("OSModeloPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Tecnicos obj = new Tecnicos();
            obj.setNome("Joao Machado");
            obj.setUsuario("joao.m");
            obj.setSenha("123");
            obj.setEndereco("Rua Silveira Martins, 141");
            obj.setCidade("Passo Fundo");
            obj.setCpf("82459479034");
            obj.setRg("8086658914");
            obj.setNascimento(Calendar.getInstance());
            obj.setEmail("fabio.vedoy@hotmail.com");
            obj.setT_celular("54-991169397");
            obj.setCategoria(em.find(Categorias.class, 1));
            Tipo_Usuario t = em.find(Tipo_Usuario.class, "ADMINISTRADOR");
            obj.getTipos_usuario().add(t);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
}
