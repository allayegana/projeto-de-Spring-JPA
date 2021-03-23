package br.com.jpa.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name = "jpql",query="select new br.com.jpa.model.MediaComData(avg(m.valor),day(m.data),month(m.data)) from Movimentacao m group by day(m.data),month(m.data),year(m.data)")

@Entity
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "mv_Sequence", sequenceName = "mv_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mv_Sequence")
    @Column(name = "ID")

    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDeMovimentacao tipoDeMovimentacao;
    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;

    @ManyToMany
    private List<Categoria> categoria;

    @ManyToOne
    private Conta conta;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoDeMovimentacao getTipoDeMovimentacao() {
        return tipoDeMovimentacao;
    }

    public void setTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Movimentacao{" +
                "tipoDeMovimentacao=" + tipoDeMovimentacao +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", conta=" + conta +
                '}';
    }
}
