/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Contrato;
import models.Garante;
import models.Inquilino;
import models.Inmueble;

/**
 *
 * @author Mario
 */
public class ContratoJpaController implements Serializable {

    public ContratoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ContratoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("InmobiliariaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contrato contrato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inquilino inquilino = contrato.getInquilino();
            if (inquilino != null) {
                inquilino = em.getReference(inquilino.getClass(), inquilino.getId());
                contrato.setInquilino(inquilino);
            }
            Inmueble inmueble = contrato.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getId());
                contrato.setInmueble(inmueble);
            }
            Garante garante = contrato.getGarante();
            if (garante != null) {
                garante = em.getReference(garante.getClass(), garante.getId());
                contrato.setGarante(garante);
            }
            em.persist(contrato);
            if (inquilino != null) {
                inquilino.getContratos().add(contrato);
                inquilino = em.merge(inquilino);
            }
            if (inmueble != null) {
                inmueble.getContratos().add(contrato);
                inmueble = em.merge(inmueble);
            }
            if (garante != null) {
                contrato.setGarante(garante);
            }
            em.getTransaction().commit();

            em.getTransaction().begin();
            contrato = em.merge(contrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contrato contrato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Garante garante = contrato.getGarante(); // Agregar esta línea para obtener el garante

            if (garante != null) {
                garante = em.getReference(garante.getClass(), garante.getId());
                contrato.setGarante(garante);
            }

            Contrato persistentContrato = em.find(Contrato.class, contrato.getId());
            Inquilino inquilinoOld = persistentContrato.getInquilino();
            Inquilino inquilinoNew = contrato.getInquilino();
            Inmueble inmuebleOld = persistentContrato.getInmueble();
            Inmueble inmuebleNew = contrato.getInmueble();
            if (inquilinoNew != null) {
                inquilinoNew = em.getReference(inquilinoNew.getClass(), inquilinoNew.getId());
                contrato.setInquilino(inquilinoNew);
            }
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getId());
                contrato.setInmueble(inmuebleNew);
            }
            contrato = em.merge(contrato);
            if (inquilinoOld != null && !inquilinoOld.equals(inquilinoNew)) {
                inquilinoOld.getContratos().remove(contrato);
                inquilinoOld = em.merge(inquilinoOld);
            }
            if (inquilinoNew != null && !inquilinoNew.equals(inquilinoOld)) {
                inquilinoNew.getContratos().add(contrato);
                inquilinoNew = em.merge(inquilinoNew);
            }
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.getContratos().remove(contrato);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                inmuebleNew.getContratos().add(contrato);
                inmuebleNew = em.merge(inmuebleNew);
            }
            em.getTransaction().commit();

            em.getTransaction().begin();
            contrato = em.merge(contrato);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = contrato.getId();
                if (findContrato(id) == null) {
                    throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.");
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
            Contrato contrato;
            try {
                contrato = em.getReference(Contrato.class, id);
                contrato.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.", enfe);
            }
            Inquilino inquilino = contrato.getInquilino();
            if (inquilino != null) {
                inquilino.getContratos().remove(contrato);
                inquilino = em.merge(inquilino);
            }
            Inmueble inmueble = contrato.getInmueble();
            if (inmueble != null) {
                inmueble.getContratos().remove(contrato);
                inmueble = em.merge(inmueble);
            }
            em.remove(contrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contrato> findContratoEntities() {

        return findContratoEntities(true, -1, -1);
    }

    public List<Contrato> findContratoEntities(int maxResults, int firstResult) {
        return findContratoEntities(false, maxResults, firstResult);
    }

    private List<Contrato> findContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contrato.class));
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

    public Contrato findContrato(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contrato> rt = cq.from(Contrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Contrato> findVigentes(LocalDate fechaActual) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT c FROM Contrato c WHERE c.fechaFin >=:fechaActual";
            Query query = em.createQuery(jpql, Contrato.class);
            query.setParameter("fechaActual", fechaActual);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
     public List<Contrato> findVencidos(LocalDate fechaActual) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT c FROM Contrato c WHERE c.fechaFin <:fechaActual";
            Query query = em.createQuery(jpql, Contrato.class);
            query.setParameter("fechaActual", fechaActual);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
