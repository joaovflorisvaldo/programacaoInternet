package br.unipar.programacaointernet.servicecep.servicecep.service;

import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAO;
import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;
import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import jakarta.jws.WebService;

@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.servicecep.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI {
    @Override
    public String boasVinda(String nome) {
        return "BEm VIndo";
    }

    @Override
    public Usuario consultaUsuario(Long idusuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
        Usuario usuario = usuarioDAO.findById(idusuario);
        return usuario;
    }
}