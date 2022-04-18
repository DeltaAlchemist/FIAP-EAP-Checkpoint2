package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Cadastro;

public class CadastroDAOImpl extends HibernateGenericDAO<Cadastro, Long>{

    private static CadastroDAOImpl instance = null;

    public CadastroDAOImpl() {
        super(Cadastro.class);
    }

    public static CadastroDAOImpl getInstance() {

        if (instance == null) {
            instance = new CadastroDAOImpl();
        }

        return instance;
    }
}
