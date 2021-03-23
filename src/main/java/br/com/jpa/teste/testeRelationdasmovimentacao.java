package br.com.jpa.teste;

import br.com.jpa.model.Conta;

import javax.persistence.*;
import java.util.List;

public class testeRelationdasmovimentacao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        //deve ser o mesmo nome da Class
        String jpql = "select c from Conta c left join fetch c.movimentacao";

        TypedQuery<Conta> query = em.createQuery(jpql,Conta.class);
        List<Conta> resultList = query.getResultList();
        for (Conta conta:resultList){
            System.out.println(" agencia:  " + conta.getAgencia());
            System.out.println(" saldo:  " + conta.getSaldo());
            System.out.println(" Titular:  " + conta.getTitular());
            System.out.println(" Numero:  " + conta.getNumero());
            System.out.println(" Movimentacaoes:  " + conta.getMovimentacao());

        }

    }
}
