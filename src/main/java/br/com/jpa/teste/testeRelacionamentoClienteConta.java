package br.com.jpa.teste;

import br.com.jpa.model.Cliente;
import br.com.jpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testeRelacionamentoClienteConta {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setNome("MAHAMA GANA");
        cliente.setEndereco("rua mogi mirim 88 ");
        cliente.setProfissao(" profesor ");
        cliente.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();



    }
}
