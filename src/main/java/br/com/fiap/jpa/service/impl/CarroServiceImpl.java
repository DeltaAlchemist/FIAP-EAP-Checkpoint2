package br.com.fiap.jpa.service.impl;

import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.dao.impl.CarroDAOImpl;
import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.service.GenericService;

import java.util.ArrayList;
import java.util.List;

public class CarroServiceImpl extends GenericService<Carro, Long> {

    private static CarroServiceImpl instance = null;

    private CarroDAOImpl carroDAO;
    private AcessorioDAOImpl acessorioDAO;

    private CarroServiceImpl() {
        carroDAO = CarroDAOImpl.getInstance();
        acessorioDAO = AcessorioDAOImpl.getInstance();
    }

    public static CarroServiceImpl getInstance() {

        if (instance == null) {
            instance = new CarroServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Carro carro) {
        try {
            carroDAO.salvar(carro, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Método para associar um carro a um acessorio no relacionamento ManyToMany simples
     *
     */
	public void cadastrar(Long idCarro, Long idAcessorio) {
		try {
			Carro carro = obter(idCarro);
			Acessorio acessorio = acessorioDAO.obterPorId(idAcessorio, getEntityManager());

			List<Acessorio> acessorios = carro.getAcessorios();
			boolean cadastrado = false;

			if (acessorios == null) {
				acessorios = new ArrayList<>();
			} else {
				for (Acessorio acessorioDB : acessorios) {
					if (acessorioDB.getId().equals(idAcessorio)) {
						cadastrado = true;
						break;
					}
				}
			}

			if (!cadastrado) {
				acessorios.add(acessorio);
				carro.setAcessorios(acessorios);
				carroDAO.atualizar(carro, getEntityManager());
			}

		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}


    @Override
    public void atualizar(Carro carro) {
        try {
            carroDAO.atualizar(carro, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            carroDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public Carro obter(Long id) {
        Carro carro = null;

        try {
            carro = carroDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return carro;
    }

    @Override
    public List<Carro> listar() {
        List<Carro> carros = null;

        try {
            carros = carroDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return carros;
    }
}
