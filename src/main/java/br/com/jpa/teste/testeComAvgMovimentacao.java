package br.com.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class testeComAvgMovimentacao {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg(m.valor) from Movimentacao m";

        TypedQuery<Double> query = em.createQuery(jpql,Double.class);
        Double MediaDasMovimentacao = query.getSingleResult();
        System.out.println(" a Media das movimentacao " + MediaDasMovimentacao);
    }
}
