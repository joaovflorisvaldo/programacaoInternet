package br.unipar.programacaointernet.servicecep.servicecep.service;

import br.unipar.programacaointernet.servicecep.servicecep.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.dao.EnderecoDao;
import br.unipar.programacaointernet.servicecep.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.Main;
import jakarta.jws.WebService;


@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.servicecep.service.EnderecoSEI")
public class EnderecoSIB implements EnderecoSEI {

    @Override
    public String boasVinda(String nome) {
        return "Boas Vindas";
    }

    @Override
    public Endereco consultarEndereco(Long idEndereco) {
        EnderecoDao enderecoDao = new EnderecoDAOImpl(EntityManagerUtil.getManager());
        Endereco endereco = enderecoDao.findById(idEndereco);
        return endereco;
    }
    @Override
    public Endereco consultarEnderecoPorCep(String cep) {
        EnderecoDao enderecoDao = new EnderecoDAOImpl(EntityManagerUtil.getManager());
        Endereco endereco = enderecoDao.findByCep(cep);
        if (endereco == null){
            try {
                endereco = Main.getViaCep(cep);

                enderecoDao.save(endereco);

            }catch (Exception e){
                throw  new RuntimeException(e);
            }
        }
        return endereco;
    }
}
