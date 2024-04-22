package br.unipar.programacaointernet.servicecep.servicecep.service;

import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAO;
import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;
import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface UsuarioSEI {
    @WebMethod
    String boasVinda(@WebParam(name = "nome") String nome);

   @WebMethod
    Usuario consultaUsuario(@WebParam(name = "idUsuario") Long idUsuario);



}
