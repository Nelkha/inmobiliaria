/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Garante;

/**
 *
 * @author Nelkha
 */
public class GaranteJpaController implements Serializable {

    public GaranteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public GaranteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("InmobiliariaPU");
    }

    public void create(Garante garante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(garante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Garante garante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            garante = em.merge(garante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = garante.getId();
                if (findGarante(id) == null) {
                    throw new NonexistentEntityException("The garante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Garante garante;
            try {
                garante = em.getReference(Garante.class, id);
                garante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The garante with id " + id + " no longer exists.", enfe);
            }
            em.remove(garante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Garante> findGaranteEntities() {
        return findGaranteEntities(true, -1, -1);
    }

    public List<Garante> findGaranteEntities(int maxResults, int firstResult) {
        return findGaranteEntities(false, maxResults, firstResult);
    }

    private List<Garante> findGaranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Garante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Garante findGarante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Garante.class, id);
        } finally {
            em.close();
        }
    }

    public int getGaranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Garante> rt = cq.from(Garante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Garante> findGaranteByCuit(String cuit) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT g FROM Garante g WHERE g.cuit =:cuit";
            Query query = em.createQuery(jpql, Garante.class);
            query.setParameter("cuit", cuit);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
