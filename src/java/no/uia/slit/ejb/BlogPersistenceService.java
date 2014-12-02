/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.ejb;

/**
 *
 * @author Nadia
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.entity.BlogEntry;


/**
 *
 * @author even
 */
@Stateless
public class BlogPersistenceService {

   @PersistenceContext
   private EntityManager em;

   /** Retrieve the blogentry with the specified id from the database
     * @param id
     * @return  */
   public BlogEntry find(long id) {
       BlogEntry m = em.find(BlogEntry.class, id);
       return m;
   }

   /** Return a list of all blogentry defined in the database
     * @return  */
   public List<BlogEntry> findAll() {
      TypedQuery<BlogEntry> q = em.createQuery("select m from BlogEntry m",
              BlogEntry.class);
      List<BlogEntry> modList = q.getResultList();
      return modList;
   }

   /** Save a blogentry in the database
     * @param m */
   public void save(BlogEntry m) {
       em.merge(m);
   }
 public BlogEntry getBlogFromDB(BlogEntry m){
       
      BlogEntry blogs = em.merge(m);
      
      return blogs;
   }
   /** Remove a blogentry from the database
     * @param m */
   public void remove(BlogEntry m) {
       em.remove(m);
   }
}