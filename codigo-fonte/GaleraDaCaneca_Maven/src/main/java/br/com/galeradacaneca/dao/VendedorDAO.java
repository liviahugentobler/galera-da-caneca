package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Vendedor;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VendedorDAO {

    // ── Salvar ───────────────────────────────────────────────────────────────
    public void salvar(Vendedor v) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar funcionário: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar ────────────────────────────────────────────────────────────
    public void atualizar(Vendedor v) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Excluir ──────────────────────────────────────────────────────────────
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Vendedor v = em.find(Vendedor.class, id);
            if (v != null) em.remove(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir funcionário: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Buscar por ID ────────────────────────────────────────────────────────
    public Vendedor buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    // ── Listar todos ─────────────────────────────────────────────────────────
    public List<Vendedor> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT v FROM Vendedor v ORDER BY v.nomeCompleto", Vendedor.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Pesquisar por nome ────────────────────────────────────────────────────
    public List<Vendedor> pesquisarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Vendedor> q = em.createQuery(
                "SELECT v FROM Vendedor v WHERE LOWER(v.nomeCompleto) LIKE :nome ORDER BY v.nomeCompleto",
                Vendedor.class);
            q.setParameter("nome", "%" + nome.toLowerCase() + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // ── Autenticação (login + senha) ─────────────────────────────────────────
    public Vendedor autenticar(String email, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Vendedor> result = em.createQuery(
                "SELECT v FROM Vendedor v WHERE v.email = :email AND v.senha = :senha",
                Vendedor.class)
                .setParameter("email", email)
                .setParameter("senha", senha)
                .getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }

    // ── Alterar senha (apenas gerente pode chamar) ────────────────────────────
    public void alterarSenha(int idVendedor, String novaSenha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Vendedor v = em.find(Vendedor.class, idVendedor);
            if (v != null) {
                v.setSenha(novaSenha);
                em.merge(v);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao alterar senha: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Total de vendas de um vendedor (soma das vendas) ──────────────────────
    public double totalVendasPorVendedor(int idVendedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Object result = em.createQuery(
                "SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v WHERE v.vendedor.id = :id")
                .setParameter("id", idVendedor)
                .getSingleResult();
            return ((Number) result).doubleValue();
        } finally {
            em.close();
        }
    }
}
