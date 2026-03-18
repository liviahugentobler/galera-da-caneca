package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Pagamento;
import javax.persistence.EntityManager;
import java.util.List;

public class PagamentoDAO {

    // ── Salvar ───────────────────────────────────────────────────────────────
    public void salvar(Pagamento p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar pagamento: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar ────────────────────────────────────────────────────────────
    public void atualizar(Pagamento p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar pagamento: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Listar todos ─────────────────────────────────────────────────────────
    public List<Pagamento> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT p FROM Pagamento p ORDER BY p.id DESC", Pagamento.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Buscar por venda ─────────────────────────────────────────────────────
    public Pagamento buscarPorVenda(int idVenda) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Pagamento> r = em.createQuery(
                "SELECT p FROM Pagamento p WHERE p.venda.id = :id", Pagamento.class)
                .setParameter("id", idVenda)
                .getResultList();
            return r.isEmpty() ? null : r.get(0);
        } finally {
            em.close();
        }
    }

    // ── Excluir ──────────────────────────────────────────────────────────────
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Pagamento p = em.find(Pagamento.class, id);
            if (p != null) em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir pagamento: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
