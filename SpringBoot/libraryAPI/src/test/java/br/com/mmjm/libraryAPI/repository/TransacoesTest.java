package br.com.mmjm.libraryAPI.repository;

import br.com.mmjm.libraryAPI.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService service;

    /**
     * Commit -> Confirmar as alterações no banco de dados
     * Rollback -> desfazer as alterações no banco de dados
     */
    @Test
    void transacaoSimplesTest() {
        service.executar();
    }

    @Test
    void transacaoEstadoManagerTest() {
        service.atualizacaoSemAtualizacao();
    }
}
