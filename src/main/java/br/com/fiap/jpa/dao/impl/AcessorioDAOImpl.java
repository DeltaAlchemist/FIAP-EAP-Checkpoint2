package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Acessorio;

public class AcessorioDAOImpl extends HibernateGenericDAO<Acessorio, Long> {

    private static AcessorioDAOImpl instance = null;

    private AcessorioDAOImpl() {
        super(Acessorio.class);
    }

    public static AcessorioDAOImpl getInstance() {

        if (instance == null) {
            instance = new AcessorioDAOImpl();
        }

        return instance;
    }
}
