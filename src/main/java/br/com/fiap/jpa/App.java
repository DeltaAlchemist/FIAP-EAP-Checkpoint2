package br.com.fiap.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Cadastro;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;
import br.com.fiap.jpa.service.impl.CadastroServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;

public class App {

    public static void main(String[] args) {

        AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
        CarroServiceImpl carroService = CarroServiceImpl.getInstance();
        ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
        CadastroServiceImpl cadastroService = CadastroServiceImpl.getInstance();

        Modelo modelo1 = new Modelo("X5");
        Acessorio acessorio1 = new Acessorio("Parabrisa" );
        Acessorio acessorio2 = new Acessorio("Volante" );
        Carro carro1 = new Carro("DHG-4442", "Preto", "9BWZZZ377VT004251", modelo1);

        modeloService.inserir(modelo1);
        acessorioService.inserir(acessorio1);
        acessorioService.inserir(acessorio2);

        carroService.inserir(carro1);

        /**
         * Decidimos criar uma tabela auxiliar (Cadastro) para relacionar o Carro com Acessório e vice-versa
         */

        Cadastro cadastro1 = new Cadastro(carro1, acessorio1);
        Cadastro cadastro2 = new Cadastro(carro1, acessorio2);

        cadastroService.inserir(cadastro1);
        cadastroService.inserir(cadastro2);

        Carro carrao = carroService.obter(1L);

        cadastroService.listar().forEach(System.out::println);
        System.out.println(carrao);
    }

}
