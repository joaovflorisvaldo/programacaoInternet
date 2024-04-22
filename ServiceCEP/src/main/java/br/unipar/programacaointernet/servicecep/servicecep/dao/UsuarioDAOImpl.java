package br.unipar.programacaointernet.servicecep.servicecep.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private EntityManager em = EntityManagerUtil.getManager();


    public UsuarioDAOImpl(EntityManager em) {
        this.em = em;

    }

    @Override
    public void save(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " Salvo Com Sucesso!!");

    }

    @Override
    public void update(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " Atualizo Com Sucesso!!");

    }

    @Override
    public void delete(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " Deletado Com Sucesso!!");

    }
    @Override
    public Usuario findById(Long id){
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return em.createQuery("SELECT u FROM Usuario u",
                Usuario.class).getResultList();
    }

}
