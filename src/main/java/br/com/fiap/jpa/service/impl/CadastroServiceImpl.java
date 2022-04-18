package br.com.fiap.jpa.service.impl;

import br.com.fiap.jpa.dao.impl.CadastroDAOImpl;
import br.com.fiap.jpa.entity.Cadastro;
import br.com.fiap.jpa.service.GenericService;

import java.util.List;

public class CadastroServiceImpl extends GenericService<Cadastro, Long> {

    private static CadastroServiceImpl instance = null;

    private CadastroDAOImpl cadastroDAO;

    private CadastroServiceImpl() {
        cadastroDAO =CadastroDAOImpl.getInstance();
    }

    public static CadastroServiceImpl getInstance() {

        if (instance == null) {
            instance = new CadastroServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Cadastro instance) {
        try {
            cadastroDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Cadastro instance) {
        try {
            cadastroDAO.atualizar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            cadastroDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Cadastro obter(Long id) {
        Cadastro cadastro = null;

        try {
            cadastro = cadastroDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return cadastro;
    }

    @Override
    public List<Cadastro> listar() {
        List<Cadastro> cadastros = null;

        try {
            cadastros = cadastroDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return cadastros;
    }
}
