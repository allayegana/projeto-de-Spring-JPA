package br.com.jpa.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentoDAO {

   private EntityManager em ;

    public MovimentoDAO(EntityManager em) {

        this.em = em;
    }

    public List<Movimentacao> getMovimentacaoFiltradasComData(Integer dias,Integer mes,Integer anos){

        String sql = "select m from Movimentacao m";

        if (dias != null){

            sql = sql + "where day(m.dias) = :pDias";

        }
        if (mes != null){
            sql = sql + "and month(m.mes) = :pMes";
        }
        if (anos != null){

            sql = sql + "and yaer(m.anos) = :pAnos";
        }
        return null;
    }

    public List<MediaComData> getMediaDariosMovimentacao(){

        TypedQuery<MediaComData> query = em.createNamedQuery("jpql",MediaComData.class);
        return  query.getResultList();

    }

    public BigDecimal getSomaDeMovimentacao(){

        String jpql = "select sum(m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql,BigDecimal.class);
        BigDecimal somaDasMovimentacao = query.getSingleResult();
        return somaDasMovimentacao;
    }
}
