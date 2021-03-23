package br.com.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Entity
public class Conta implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "ca_Sequence", sequenceName = "ca_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ca_Sequence")
    @Column(name = "ID")

    private Long id;
    private Integer agencia;
    private Integer numero;
    private String Titular;

    @OneToMany(mappedBy = "conta",fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacao;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    private BigDecimal saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public List<Movimentacao> getMovimentacao() {
        return movimentacao;
    }
}
