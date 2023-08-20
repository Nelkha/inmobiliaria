/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Contrato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Inmueble;

/**
 *
 * @author Mario
 */
public class InmuebleJpaController implements Serializable {

    public InmuebleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    public InmuebleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("InmobiliariaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inmueble inmueble) {
        if (inmueble.getContratos() == null) {
            inmueble.setContratos(new ArrayList<Contrato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Contrato> attachedContratos = new ArrayList<Contrato>();
            for (Contrato contratosContratoToAttach : inmueble.getContratos()) {
                contratosContratoToAttach = em.getReference(contratosContratoToAttach.getClass(), contratosContratoToAttach.getId());
                attachedContratos.add(contratosContratoToAttach);
            }
            inmueble.setContratos(attachedContratos);
            em.persist(inmueble);
            for (Contrato contratosContrato : inmueble.getContratos()) {
                Inmueble oldInmuebleOfContratosContrato = contratosContrato.getInmueble();
                contratosContrato.setInmueble(inmueble);
                contratosContrato = em.merge(contratosContrato);
                if (oldInmuebleOfContratosContrato != null) {
                    oldInmuebleOfContratosContrato.getContratos().remove(contratosContrato);
                    oldInmuebleOfContratosContrato = em.merge(oldInmuebleOfContratosContrato);
                }
            }
           
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inmueble inmueble) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmueble persistentInmueble = em.find(Inmueble.class, inmueble.getId());
            List<Contrato> contratosOld = persistentInmueble.getContratos();
            List<Contrato> contratosNew = inmueble.getContratos();
            List<Contrato> attachedContratosNew = new ArrayList<Contrato>();
            for (Contrato contratosNewContratoToAttach : contratosNew) {
                contratosNewContratoToAttach = em.getReference(contratosNewContratoToAttach.getClass(), contratosNewContratoToAttach.getId());
                attachedContratosNew.add(contratosNewContratoToAttach);
            }
            contratosNew = attachedContratosNew;
            inmueble.setContratos(contratosNew);
            inmueble = em.merge(inmueble);
            for (Contrato contratosOldContrato : contratosOld) {
                if (!contratosNew.contains(contratosOldContrato)) {
                    contratosOldContrato.setInmueble(null);
                    contratosOldContrato = em.merge(contratosOldContrato);
                }
            }
            for (Contrato contratosNewContrato : contratosNew) {
                if (!contratosOld.contains(contratosNewContrato)) {
                    Inmueble oldInmuebleOfContratosNewContrato = contratosNewContrato.getInmueble();
                    contratosNewContrato.setInmueble(inmueble);
                    contratosNewContrato = em.merge(contratosNewContrato);
                    if (oldInmuebleOfContratosNewContrato != null && !oldInmuebleOfContratosNewContrato.equals(inmueble)) {
                        oldInmuebleOfContratosNewContrato.getContratos().remove(contratosNewContrato);
                        oldInmuebleOfContratosNewContrato = em.merge(oldInmuebleOfContratosNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = inmueble.getId();
                if (findInmueble(id) == null) {
                    throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.");
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
            Inmueble inmueble;
            try {
                inmueble = em.getReference(Inmueble.class, id);
                inmueble.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.", enfe);
            }
            List<Contrato> contratos = inmueble.getContratos();
            for (Contrato contratosContrato : contratos) {
                contratosContrato.setInmueble(null);
                contratosContrato = em.merge(contratosContrato);
            }
            em.remove(inmueble);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inmueble> findInmuebleEntities() {
        return findInmuebleEntities(true, -1, -1);
    }

    public List<Inmueble> findInmuebleEntities(int maxResults, int firstResult) {
        return findInmuebleEntities(false, maxResults, firstResult);
    }

    private List<Inmueble> findInmuebleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inmueble.class));
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

    public Inmueble findInmueble(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inmueble.class, id);
        } finally {
            em.close();
        }
    }
 public Inmueble findInmuebleByDir(String dir) {
    EntityManager em = getEntityManager();
    try {
        String jpql = "SELECT i FROM Inmueble i WHERE i.direccion = :dir";
        Query query = em.createQuery(jpql, Inmueble.class);
        query.setParameter("dir", dir);
        
        List<Inmueble> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null; // Opcional: devolver null si no se encuentra ningún resultado.
        }
    } catch (Exception e) {
        
        e.printStackTrace();
        return null; 
    } finally {
        em.close();
    }
}
     
     public List<Contrato>findContratosInmueble(Inmueble inm){
     List<Contrato>contratos=inm.getContratos();
     return contratos;
     }

    public int getInmuebleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inmueble> rt = cq.from(Inmueble.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
