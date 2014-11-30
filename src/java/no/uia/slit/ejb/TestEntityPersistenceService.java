/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.entity.Module;
import no.uia.slit.entity.TestEntity;

/**
 *
 * @author kristianandersson
 */
@Stateless
public class TestEntityPersistenceService {
       @PersistenceContext
   private EntityManager em;

   /** Retrieve the module with the specified id from the database */
   public TestEntity find(long id) {
       TestEntity m = em.find(TestEntity.class, id);
       return m;
   }

   /** Return a list of all modules defined in the database */
   public List<TestEntity> findAll() {
      TypedQuery<TestEntity> q = em.createQuery("select m from Module m",
              TestEntity.class);
      List<TestEntity> modList = q.getResultList();
      return modList;
   }

   /** Save a module in the database */
   public void save(TestEntity m) {
       em.merge(m);
   }

   /** Remove a module from the database */
   public void remove(TestEntity m) {
       m = em.merge(m);
       em.remove(m);
   }
}
