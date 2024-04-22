package br.unipar.programacaointernet.servicecep.servicecep.util;

import br.unipar.programacaointernet.servicecep.servicecep.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.dao.EnderecoDao;
import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAO;
import br.unipar.programacaointernet.servicecep.servicecep.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.model.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int selecao;
        try {
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
            /**
            Scanner scan = new Scanner(System.in);

            System.out.println(getViaCep("Usuário 1 ou Endereço 2 "));
            selecao = scan.nextInt();

            if(selecao == 1){
                System.out.println(getViaCep("Adicionar, Editar, Deletar"));
                selecao = scan.nextInt();
                if (selecao == 1){
                    salvarUsuario();
                } else if (selecao == 2) {
                    editarUsuario();
                } else if (selecao == 3) {
                    deletarUsuario();
                }else
                    System.out.println(getViaCep("Opção não registrada"));

            } else if (selecao == 2) {

            }else
                System.out.println(getViaCep("Opção não registrada"));
                **/

            salvarUsuario();
            //editarUsuario();
            //deletarUsuario();
            //buscarTodosUsuarios();
            //buscarTodosPorID();
            salvarEndereco();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void salvarEndereco() {
        try {
            EnderecoDao enderecoDao = new EnderecoDAOImpl(EntityManagerUtil.getManager());
            enderecoDao.save(getViaCep("85816278"));
            System.out.println(getViaCep("85816278"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void buscarTodosUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());

        List<Usuario> usuarios = usuarioDAO.findAll();

        for (Usuario usuario : usuarios) {
            System.out.println("Usuario" + usuario.getNome() +
                    " encontrado com sucesso!");
        }
    }

    private static void buscarTodosPorID() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
        List<Usuario> usuarios = (List<Usuario>) usuarioDAO.findById(1L);
    }

    private static void deletarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
        Usuario usuario = usuarioDAO.findById(1L);  //1 Longa
        usuarioDAO.delete(usuario);
    }

    private static void editarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
        Usuario usuario = usuarioDAO.findById(1L);  //1 Longa
        usuarioDAO.update(usuario);
    }

    private static void salvarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());

       Usuario usuario = new Usuario();


        usuario.setNome("julia");
        usuario.setLogin("juju");
        usuario.setSenha("senhaNova");

        usuarioDAO.save(usuario);
    }

    public static Endereco getViaCep(String cep) throws Exception {
        URL url = new URL("http://viacep.com.br/ws/"
                + cep.replace("-", "")
                .replace(".", "")
                + "/xml/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += inputLine;

        in.close();
        return Endereco.unmarshalFromString(result);
    }
}
