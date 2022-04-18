package br.com.fiap.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {

    public Carro() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Carro(String placa, String cor, String chassi, Modelo modelo) {
        this();
        this.placa = placa;
        this.cor = cor;
        this.chassi = chassi;
        this.modelo = modelo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
    private Long id;

    @Column(name = "ds_placa", nullable = false)
    private String placa;

    @Column(name = "ds_cor", nullable = false)
    private String cor;

    @Column(name = "ds_chassi", nullable = false, length = 17)
    private String chassi;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToMany
    @JoinTable(
            name = "tb_carro_acessorio",
            joinColumns = @JoinColumn(name = "acessorio_id"),
            inverseJoinColumns = @JoinColumn(name = "carro_id")
    )
    private List<Acessorio> acessorios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", chassi='" + chassi + '\'' +
                '}';
    }
}
