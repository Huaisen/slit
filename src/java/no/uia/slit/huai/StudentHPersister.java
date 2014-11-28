package no.uia.slit.huai;

import java.util.List;
import java.lang.String;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.huai.AbstractHPersister;
import no.uia.slit.huai.StudentEntity;
/**
 *
 * @author Huai
 */
@Stateless
public class StudentHPersister extends AbstractHPersister<StudentEntity>{
   
    @PersistenceContext
    EntityManager em;   

public StudentHPersister() {
        super(StudentEntity.class);
    }

    public EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @param studentid
     * @param firstname
     * @param lastname
     * @param email
     * @return
     */
    public StudentEntity createStudentEntity(long studentid,String firstname, String lastname, String email) {
        StudentEntity s = new StudentEntity();
        em.persist(s);
        s.setStudentid(studentid);
        s.setFirstname(firstname);
        s.setLastname(lastname);
        s.setEmail(email);
        return s;
    }

    public void delete(long studentid) {
        TypedQuery<StudentEntity> q = em.createNamedQuery("StudentEntity.byStudentid", StudentEntity.class);
        q.setParameter("studentid", studentid);
        List<StudentEntity> ls = q.getResultList();
        if (ls.size() == 1) delete(ls.get(0));
    }
}