package br.com.jpa.teste;

import br.com.jpa.model.Conta;
import br.com.jpa.model.Movimentacao;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

public class TesteComJpql {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(7L);

        String jpql = " select m from Movimentacao m where m.conta = :pConta order by m.valor asc";

        TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
        query.setParameter("pConta",conta);
        List<Movimentacao> resultlist = query.getResultList();

        for (Movimentacao movimentacao :resultlist) {
            System.out.println("Descricao " + movimentacao.getDescricao());
            System.out.println("tipo " + movimentacao.getTipoDeMovimentacao());
            System.out.println("valor " + movimentacao.getValor());

        }
    }
}
