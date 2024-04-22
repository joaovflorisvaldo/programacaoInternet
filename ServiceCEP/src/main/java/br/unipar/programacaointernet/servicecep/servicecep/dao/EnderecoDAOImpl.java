package br.unipar.programacaointernet.servicecep.servicecep.dao;


import br.unipar.programacaointernet.servicecep.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class EnderecoDAOImpl implements EnderecoDao {

    private EntityManager em = EntityManagerUtil.getManager();


    public EnderecoDAOImpl(EntityManager manager) {
        this.em = em;
    }


    @Override
    public void save(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(endereco);
        transaction.commit();
        System.out.println("Enreco " + endereco.toString() +
                " Salvo Com Sucesso!!");
    }

    @Override
    public void update(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(endereco);
        transaction.commit();
        System.out.println("Update " + endereco.toString() +
                " Salvo Com Sucesso!!");

    }

    @Override
    public void delete(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(endereco);
        transaction.commit();
        System.out.println("Delete " + endereco.toString() +
                " Salvo Com Sucesso!!");

    }

    @Override
    public List<Endereco> findAll() {
        return em.createQuery("SELECT e FROM Endereco e",
                Endereco.class).getResultList();
    }

    @Override
    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public Endereco findByCep(String cep) {
        try {
            return em.createQuery("SELECT e FROM Endereco e WHERE cep = :c",
                    Endereco.class).setParameter("c", cep).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}





    /**@Override
    public Usuario findById(Long id){
    return em.find(Endereco.class, id);
    }

     @Override
     public List<Usuario> findAll() {
     return em.createQuery("SELECT u FROM Endereco e",
     Endereco.class).getResultList();
     }**/


