package br.com.jpa.teste;

import br.com.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class altercaoSaldoDeallaye {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta contaDoallaye = em.find(Conta.class,1L);

        contaDoallaye.setSaldo(new BigDecimal(50.0));

        em.getTransaction().begin();
        em.persist(contaDoallaye);
        em.getTransaction().commit();
    }
}
