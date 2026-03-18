package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO {

    // ── Salvar (insert) ─────────────────────────────────────────────────────
    public void salvar(Cliente c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar (update) ───────────────────────────────────────────────────
    public void atualizar(Cliente c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Excluir (delete) ─────────────────────────────────────────────────────
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, id);
            if (c != null) em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir cliente: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Buscar por ID ────────────────────────────────────────────────────────
    public Cliente buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    // ── Listar todos ─────────────────────────────────────────────────────────
    public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c ORDER BY c.nomeCompleto", Cliente.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Pesquisar por nome (LIKE) ─────────────────────────────────────────────
    public List<Cliente> pesquisarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Cliente> q = em.createQuery(
                "SELECT c FROM Cliente c WHERE LOWER(c.nomeCompleto) LIKE :nome ORDER BY c.nomeCompleto",
                Cliente.class);
            q.setParameter("nome", "%" + nome.toLowerCase() + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // ── Pesquisar por CPF ─────────────────────────────────────────────────────
    public Cliente buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Cliente> result = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf)
                .getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
}
