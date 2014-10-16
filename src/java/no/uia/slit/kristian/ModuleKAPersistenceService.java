
package no.uia.slit.kristian;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author even
 */
public class ModuleKAPersistenceService {

   @PersistenceContext
   private EntityManager em;

   /** Retrieve the module with the specified id from the database */
   public ModuleKA find(long id) {
       ModuleKA m = em.find(ModuleKA.class, id);
       return m;
   }

   /** Return a list of all modules defined in the database */
   public List<ModuleKA> findAll() {
      TypedQuery<ModuleKA> q = em.createQuery("select m from ModuleKA m",
              ModuleKA.class);
      List<ModuleKA> modList = q.getResultList();
      return modList;
   }

   /** Save a module in the database */
   public void save(ModuleKA m) {
       em.merge(m);
   }

   /** Remove a module from the database */
   public void remove(ModuleKA m) {
       em.remove(m);
   }
}
