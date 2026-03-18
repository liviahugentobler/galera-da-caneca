package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Venda;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class VendaDAO {

    // ── Salvar ───────────────────────────────────────────────────────────────
    public void salvar(Venda v) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar venda: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar ────────────────────────────────────────────────────────────
    public void atualizar(Venda v) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar venda: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Listar todas ─────────────────────────────────────────────────────────
    public List<Venda> listarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT v FROM Venda v ORDER BY v.id DESC", Venda.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Listar por vendedor ────────────────────────────────────────────────────
    public List<Venda> listarPorVendedor(int idVendedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT v FROM Venda v WHERE v.vendedor.id = :id ORDER BY v.id DESC",
                Venda.class)
                .setParameter("id", idVendedor)
                .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Total geral de vendas ──────────────────────────────────────────────────
    public BigDecimal totalGeral() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Object r = em.createQuery(
                "SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v")
                .getSingleResult();
            return new BigDecimal(r.toString());
        } finally {
            em.close();
        }
    }

    // ── Total de vendas de um vendedor ─────────────────────────────────────────
    public BigDecimal totalPorVendedor(int idVendedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Object r = em.createQuery(
                "SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v WHERE v.vendedor.id = :id")
                .setParameter("id", idVendedor)
                .getSingleResult();
            return new BigDecimal(r.toString());
        } finally {
            em.close();
        }
    }

    // ── Contagem total de vendas ────────────────────────────────────────────────
    public long contarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return (long) em.createQuery("SELECT COUNT(v) FROM Venda v")
                .getSingleResult();
        } finally {
            em.close();
        }
    }

    // ── Contagem por vendedor ────────────────────────────────────────────────────
    public long contarPorVendedor(int idVendedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return (long) em.createQuery(
                "SELECT COUNT(v) FROM Venda v WHERE v.vendedor.id = :id")
                .setParameter("id", idVendedor)
                .getSingleResult();
        } finally {
            em.close();
        }
    }
}
