package br.unipar.programacaointernet.servicecep.servicecep.dao;

import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void save(Usuario usario);
    void update(Usuario usuario);


    void delete(Usuario usuario);


    List<Usuario> findAll();

    Usuario findById(Long id);
}
