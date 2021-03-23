package br.com.jpa.teste;

import br.com.jpa.model.Categoria;
import br.com.jpa.model.Conta;
import br.com.jpa.model.Movimentacao;
import br.com.jpa.model.TipoDeMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class testeRelacionamentomovimenteCategoria {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(2L);

        Categoria categoria = new Categoria("viajem");
        Categoria categoria1 = new Categoria("Negocios");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoDeMovimentacao(TipoDeMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(300));
        movimentacao.setDescricao("viajar para SP");
        movimentacao.setData(LocalDateTime.now().plusDays(1));
        movimentacao.setCategoria(Arrays.asList(categoria,categoria1));
        movimentacao.setConta(conta);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setTipoDeMovimentacao(TipoDeMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal(100));
        movimentacao1.setDescricao("viajar para RJ");
        movimentacao1.setData(LocalDateTime.now().plusDays(2));
        movimentacao1.setCategoria(Arrays.asList(categoria,categoria1));
        movimentacao1.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(movimentacao);
        em.persist(movimentacao1);
        em.persist(categoria);
        em.persist(categoria1);
        em.getTransaction().commit();
        em.close();


    }
}
