package br.com.jpa.teste;

import br.com.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class criarconta {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Napo");
        conta.setAgencia(1222);
        conta.setNumero(1221);
        conta.setSaldo(new BigDecimal(1000.0));

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();


        EntityManager em2 = emf.createEntityManager();
        conta.setSaldo(new BigDecimal(1500.0));
        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

    }
}
