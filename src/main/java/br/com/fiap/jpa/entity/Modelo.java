package br.com.fiap.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_modelo")
@SequenceGenerator(name = "modelo",sequenceName = "SQ_TB_MODELO", allocationSize = 1)
public class Modelo implements Serializable {

    public Modelo() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Modelo(String descricao) {
        this();
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelo")
    private Long id;

    @Column(name = "ds_modelo", nullable = false)
    private String descricao;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "modelo", fetch = FetchType.EAGER)
    private Set<Carro> carros;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
