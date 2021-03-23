package br.com.jpa.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "cgt_Sequence", sequenceName = "cgt_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cgt_Sequence")
    @Column(name = "ID")

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @Deprecated
    public Categoria() {
    }


    public Categoria(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id=" + id + " nome= " + nome ;

    }
}
