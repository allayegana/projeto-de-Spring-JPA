package br.com.jpa.teste;

import br.com.jpa.model.Movimentacao;
import br.com.jpa.model.MovimentoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class testeSumaDaMovimentacao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        BigDecimal somaDasMovimentacao = new MovimentoDAO(em).getSomaDeMovimentacao();
        System.out.println(" a soma das movimentacao " + somaDasMovimentacao);
    }
}
