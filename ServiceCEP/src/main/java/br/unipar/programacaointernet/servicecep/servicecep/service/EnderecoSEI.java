package br.unipar.programacaointernet.servicecep.servicecep.service;

import br.unipar.programacaointernet.servicecep.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface EnderecoSEI {
    @WebMethod
    String boasVinda(@WebParam(name = "nome") String nome);

    @WebMethod
    Endereco consultarEndereco(@WebParam(name = "idEndereco") Long idEndereco);

    Endereco consultarEnderecoPorCep(String cep);
}
