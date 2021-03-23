package br.com.jpa.teste;

import br.com.jpa.model.Conta;
import br.com.jpa.model.Movimentacao;
import br.com.jpa.model.TipoDeMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ConcurrentModificationException;

public class testeRelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setSaldo(new BigDecimal(900));
        conta.setTitular("mamou");
        conta.setNumero(2323);
        conta.setAgencia(2123);

        Movimentacao movimentacao =new Movimentacao();
        movimentacao.setValor(new BigDecimal(200));
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Churasco");
        movimentacao.setTipoDeMovimentacao(TipoDeMovimentacao.ENTRADA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();
        em.close();


    }
}
