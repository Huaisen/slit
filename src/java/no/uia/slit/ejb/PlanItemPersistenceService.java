package no.uia.slit.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.auth.AuthUser;
import no.uia.slit.entity.Module;
import no.uia.slit.entity.PlanItem;


/**
 *
 * @author even
 */
@Stateless
public class PlanItemPersistenceService {

   @PersistenceContext
   private EntityManager em;

   /** Retrieve the module with the specified id from the database */
   public PlanItem find(long id) {
       PlanItem m = em.find(PlanItem.class, id);
       return m;
   }

   /** Return a list of all modules defined in the database */
   public List<PlanItem> findAll() {
      TypedQuery<PlanItem> q = em.createQuery("select p from PlanItem p",
              PlanItem.class);
      List<PlanItem> modList = q.getResultList();
      return modList;
   }
   public List<PlanItem> findAllByUser(AuthUser u) {
     
        TypedQuery<PlanItem> q = em.createQuery("SELECT p FROM PlanItem p WHERE p.user=:user",
              PlanItem.class);
      
    q.setParameter("user", u);

        
      List<PlanItem> modList = q.getResultList();
      return modList;
       
   }
      public List<PlanItem> findAllLockedPlanItemsByUser(AuthUser u) {
     
        TypedQuery<PlanItem> q = em.createQuery("SELECT p FROM PlanItem p WHERE p.user=:user AND p.planItemLocked=TRUE",
              PlanItem.class);
      
    q.setParameter("user", u);

        
      List<PlanItem> modList = q.getResultList();
      return modList;
       
   }

   
   public List<PlanItem> findAllByUserAndModule(Module m, AuthUser u) {
      TypedQuery<PlanItem> q = em.createQuery("SELECT p FROM PlanItem p WHERE p.module=:module AND p.user=:user",
              PlanItem.class);
      
    q.setParameter("module", m);
    q.setParameter("user", u);

        
      List<PlanItem> modList = q.getResultList();
      return modList;
   }
      
   public PlanItem findOneByUserAndModule(Module m, AuthUser u) {
      TypedQuery<PlanItem> q = em.createQuery("SELECT p FROM PlanItem p WHERE p.module=:module AND p.user=:user",
              PlanItem.class);
    q.setMaxResults(1);
    q.setParameter("module", m);
    q.setParameter("user", u);

        
      List<PlanItem> modList = q.getResultList();
      if (modList.isEmpty()){
          
          return null;
      }
      else{
          
          return modList.get(0);
      }
         
   }

   /** Save a module in the database */
   public void save(PlanItem m) {
       em.merge(m);
   }
   

   /** Remove a module from the database */
   public void remove(PlanItem m) {
       m = em.merge(m);
       em.remove(m);
   }
}
