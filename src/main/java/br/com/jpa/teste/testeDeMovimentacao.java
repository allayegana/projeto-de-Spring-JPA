package br.com.jpa.teste;

import br.com.jpa.model.Conta;
import br.com.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testeDeMovimentacao {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        Movimentacao movimentacao = em.find(Movimentacao.class,1L);
        Conta conta = movimentacao.getConta();
        int quantidadeDeMouvementacao = conta.getMovimentacao().size();
        System.out.println("quantidade de movimentacao " + quantidadeDeMouvementacao);
        System.out.println( "conta do Titular " + conta.getTitular() + " ----> " +  conta.getSaldo());
    }
}
