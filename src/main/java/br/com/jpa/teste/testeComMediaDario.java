package br.com.jpa.teste;

import br.com.jpa.model.MediaComData;
import br.com.jpa.model.MovimentoDAO;

import javax.persistence.*;
import java.util.List;

public class testeComMediaDario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        List<MediaComData> MediaDasMovimentacao = new MovimentoDAO(em).getMediaDariosMovimentacao();
        for (MediaComData media : MediaDasMovimentacao){
            System.out.println(" a Media das movimentacao por dias " + media.getDias() + "/" + media.getMes() + "/" + media.getValor() );
        }

    }
}
