package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    // ── Salvar ───────────────────────────────────────────────────────────────
    public void salvar(Produto p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar produto: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar ────────────────────────────────────────────────────────────
    public void atualizar(Produto p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Excluir ──────────────────────────────────────────────────────────────
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, id);
            if (p != null) em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Buscar por ID ────────────────────────────────────────────────────────
    public Produto buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    // ── Listar todos ─────────────────────────────────────────────────────────
    public List<Produto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT p FROM Produto p ORDER BY p.nomeProd", Produto.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

    // ── Pesquisar por nome ────────────────────────────────────────────────────
    public List<Produto> pesquisarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Produto> q = em.createQuery(
                "SELECT p FROM Produto p WHERE LOWER(p.nomeProd) LIKE :nome ORDER BY p.nomeProd",
                Produto.class);
            q.setParameter("nome", "%" + nome.toLowerCase() + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // ── Dar baixa no estoque (saída) ──────────────────────────────────────────
    public void darBaixaEstoque(int idProduto, int qtdSaida) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, idProduto);
            if (p == null) throw new RuntimeException("Produto não encontrado.");
            if (p.getQuantidade() < qtdSaida)
                throw new RuntimeException("Estoque insuficiente. Disponível: " + p.getQuantidade());
            p.setQuantidade(p.getQuantidade() - qtdSaida);
            p.setSaidas(p.getSaidas() + qtdSaida);
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Registrar entrada no estoque ──────────────────────────────────────────
    public void registrarEntrada(int idProduto, int qtdEntrada) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, idProduto);
            if (p == null) throw new RuntimeException("Produto não encontrado.");
            p.setQuantidade(p.getQuantidade() + qtdEntrada);
            p.setEntradas(p.getEntradas() + qtdEntrada);
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // ── Atualizar preço ───────────────────────────────────────────────────────
    public void atualizarPreco(int idProduto, BigDecimal novoPreco) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, idProduto);
            if (p != null) {
                p.setPreco(novoPreco);
                em.merge(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar preço: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
