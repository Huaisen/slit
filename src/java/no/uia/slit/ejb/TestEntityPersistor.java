package no.uia.slit.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import no.uia.slit.entity.TestEntity;

/**
 *
 * @author evenal
 */
@Stateless
public class TestEntityPersistor extends AbstractPersister<TestEntity> {

    @PersistenceContext
    EntityManager em;

        public TestEntityPersistor() {
        super(TestEntity.class);
    }
        
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
        public TestEntity createTeacher(String username) {
        TestEntity t = new TestEntity();
        t.setUsername(username);
        em.merge(t);
        return t;
    }
}
