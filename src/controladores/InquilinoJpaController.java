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
import models.Inquilino;

/**
 *
 * @author Mario
 */
public class InquilinoJpaController implements Serializable {

    public InquilinoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public InquilinoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("InmobiliariaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inquilino inquilino) {
        if (inquilino.getContratos() == null) {
            inquilino.setContratos(new ArrayList<Contrato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Contrato> attachedContratos = new ArrayList<Contrato>();
            for (Contrato contratosContratoToAttach : inquilino.getContratos()) {
                contratosContratoToAttach = em.getReference(contratosContratoToAttach.getClass(), contratosContratoToAttach.getId());
                attachedContratos.add(contratosContratoToAttach);
            }
            inquilino.setContratos(attachedContratos);
            em.persist(inquilino);
            for (Contrato contratosContrato : inquilino.getContratos()) {
                Inquilino oldInquilinoOfContratosContrato = contratosContrato.getInquilino();
                contratosContrato.setInquilino(inquilino);
                contratosContrato = em.merge(contratosContrato);
                if (oldInquilinoOfContratosContrato != null) {
                    oldInquilinoOfContratosContrato.getContratos().remove(contratosContrato);
                    oldInquilinoOfContratosContrato = em.merge(oldInquilinoOfContratosContrato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inquilino inquilino) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inquilino persistentInquilino = em.find(Inquilino.class, inquilino.getId());
            List<Contrato> contratosOld = persistentInquilino.getContratos();
            List<Contrato> contratosNew = inquilino.getContratos();
            List<Contrato> attachedContratosNew = new ArrayList<Contrato>();
            for (Contrato contratosNewContratoToAttach : contratosNew) {
                contratosNewContratoToAttach = em.getReference(contratosNewContratoToAttach.getClass(), contratosNewContratoToAttach.getId());
                attachedContratosNew.add(contratosNewContratoToAttach);
            }
            contratosNew = attachedContratosNew;
            inquilino.setContratos(contratosNew);
            inquilino = em.merge(inquilino);
            for (Contrato contratosOldContrato : contratosOld) {
                if (!contratosNew.contains(contratosOldContrato)) {
                    contratosOldContrato.setInquilino(null);
                    contratosOldContrato = em.merge(contratosOldContrato);
                }
            }
            for (Contrato contratosNewContrato : contratosNew) {
                if (!contratosOld.contains(contratosNewContrato)) {
                    Inquilino oldInquilinoOfContratosNewContrato = contratosNewContrato.getInquilino();
                    contratosNewContrato.setInquilino(inquilino);
                    contratosNewContrato = em.merge(contratosNewContrato);
                    if (oldInquilinoOfContratosNewContrato != null && !oldInquilinoOfContratosNewContrato.equals(inquilino)) {
                        oldInquilinoOfContratosNewContrato.getContratos().remove(contratosNewContrato);
                        oldInquilinoOfContratosNewContrato = em.merge(oldInquilinoOfContratosNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = inquilino.getId();
                if (findInquilino(id) == null) {
                    throw new NonexistentEntityException("The inquilino with id " + id + " no longer exists.");
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
            Inquilino inquilino;
            try {
                inquilino = em.getReference(Inquilino.class, id);
                inquilino.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inquilino with id " + id + " no longer exists.", enfe);
            }
            List<Contrato> contratos = inquilino.getContratos();
            for (Contrato contratosContrato : contratos) {
                contratosContrato.setInquilino(null);
                contratosContrato = em.merge(contratosContrato);
            }
            em.remove(inquilino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inquilino> findInquilinoEntities() {
        return findInquilinoEntities(true, -1, -1);
    }

    public List<Inquilino> findInquilinoEntities(int maxResults, int firstResult) {
        return findInquilinoEntities(false, maxResults, firstResult);
    }

    private List<Inquilino> findInquilinoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inquilino.class));
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

    public Inquilino findInquilino(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inquilino.class, id);
        } finally {
            em.close();
        }
    }

    public int getInquilinoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inquilino> rt = cq.from(Inquilino.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Inquilino> findInquilinoByCuit(String cuit) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT i FROM Inquilino i WHERE i.cuit =:cuit";
            Query query = em.createQuery(jpql, Inquilino.class);
            query.setParameter("cuit", cuit);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
