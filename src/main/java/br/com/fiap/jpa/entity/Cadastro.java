//package br.com.fiap.jpa.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "tb_cadastro")
//public class Cadastro implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
//    private Long id;
//
//    @Column(name = "st_ativo")
//    private Boolean ativo;
//
//    @Column(name = "dt_cadastro")
//    private LocalDateTime dataCadastro;
//
//    @Column(name = "dt_atualizacao")
//    private LocalDateTime dataAtualizacao;
//
//    @OneToOne(mappedBy = "carro", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Endereco endereco;
//
//    @ManyToOne
//    @JoinColumn(name = "aluno_id")
//    private Aluno aluno;
//
//    @ManyToOne
//    @JoinColumn(name = "curso_id")
//    private Curso curso;
//}
