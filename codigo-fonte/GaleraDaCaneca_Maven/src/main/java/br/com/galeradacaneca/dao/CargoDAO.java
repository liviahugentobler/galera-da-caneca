package br.com.galeradacaneca.dao;

import br.com.galeradacaneca.model.Cargo;
import javax.persistence.EntityManager;
import java.util.List;

public class CargoDAO {

    public List<Cargo> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cargo c ORDER BY c.descricao", Cargo.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public Cargo buscarPorDescricao(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Cargo> r = em.createQuery(
                "SELECT c FROM Cargo c WHERE c.descricao = :desc", Cargo.class)
                .setParameter("desc", descricao)
                .getResultList();
            return r.isEmpty() ? null : r.get(0);
        } finally {
            em.close();
        }
    }
}
