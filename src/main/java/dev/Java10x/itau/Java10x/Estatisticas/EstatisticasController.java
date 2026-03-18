package dev.Java10x.itau.Java10x.Estatisticas;

import dev.Java10x.itau.Java10x.Transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {


    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    //criar Rota de estatistica e uma logica para trabalhar com dados
    @GetMapping
    public ResponseEntity estatisticas() {
        //log de requisição criado via lombok
        log.info("Calculando estatistica de transações : " + estatisticaProperties.segundos());
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }
}