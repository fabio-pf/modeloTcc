package br.com.vedoy;

import br.com.vedoy.modelo.Categorias;
import br.com.vedoy.modelo.Tipo_Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirTipoUsuario {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirTipoUsuario() {

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
    public void testePersistirTipoUsuario() {
        boolean exception = false;
        try {
            Tipo_Usuario obj = new Tipo_Usuario();
            obj.setNome("USUARIO");
            obj.setDescricao("Acesso Parcial");
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
