package br.com.jpa.teste;

import br.com.jpa.model.Categoria;
import br.com.jpa.model.Conta;
import br.com.jpa.model.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class testeJpqlMovimentacaoCategoriaJoin {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        String jpql = " select m from Movimentacao m join m.categoria c where c = :pCategoria";

        TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
        query.setParameter("pCategoria",categoria);
        List<Movimentacao> resultlist = query.getResultList();

        for (Movimentacao movimentacao :resultlist) {
            System.out.println("Descricao " + movimentacao.getDescricao());
            System.out.println("tipo " + movimentacao.getTipoDeMovimentacao());
            System.out.println("valor " + movimentacao.getValor());
            System.out.println("categoria " + movimentacao.getCategoria());

        }
    }
}
