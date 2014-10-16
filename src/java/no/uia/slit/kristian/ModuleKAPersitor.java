/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.kristian;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.ejb.AbstractPersister;
import no.uia.slit.entity.Student;

/**
 *
 * @author kristianandersson
 */
@Stateless

public class ModuleKAPersitor extends AbstractPersister<ModuleKA> {

    @PersistenceContext
    EntityManager em;


    public ModuleKAPersitor() {
        super(ModuleKA.class);
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public ModuleKA createModuleKA(long id) {
        ModuleKA s = new ModuleKA();
        em.persist(s);
        s.setId(id);
        return s;
    }

    public void delete(long id) {
        TypedQuery<ModuleKA> q = em.createNamedQuery("ModuleKA.byID", ModuleKA.class);
        q.setParameter("id", id);
        List<ModuleKA> ls = q.getResultList();
        if (ls.size() == 1) delete(ls.get(0));
    }    
}
