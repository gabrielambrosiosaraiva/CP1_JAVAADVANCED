package dao;

import jakarta.persistence.EntityManager;
import model.Funcionario;

public class FuncionarioDAO {

    private EntityManager em;

    public FuncionarioDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Funcionario f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        System.out.println("INSERT executado");
    }

    public Funcionario buscar(Long id) {
        System.out.println("SELECT executado");
        return em.find(Funcionario.class, id);
    }

    public void atualizar(Funcionario f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
        System.out.println("UPDATE executado");
    }

    public void deletar(Funcionario f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        System.out.println("DELETE executado");
    }
}