package br.com.jpa.teste;

import br.com.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class testandoestado {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("sadio");
        conta.setAgencia(1222);
        conta.setNumero(1221);
        conta.setSaldo(new BigDecimal(1000.0));

        em.getTransaction().begin();
        em.persist(conta);
        em.remove(conta);
        em.getTransaction().commit();
    }
}
