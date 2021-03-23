package br.com.jpa.teste;

import br.com.jpa.model.Movimentacao;
import br.com.jpa.model.MovimentoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class testandoCritirioBuil {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
            EntityManager em = emf.createEntityManager();

            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
            Root<Movimentacao> root = query.from(Movimentacao.class);

              Expression<BigDecimal>  sum = criteriaBuilder.sum(root.<BigDecimal>get("valor"));
               query.select(sum);

            TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
            System.out.println(" a soma das movimentacao " + typedQuery.getSingleResult());
        }
}
