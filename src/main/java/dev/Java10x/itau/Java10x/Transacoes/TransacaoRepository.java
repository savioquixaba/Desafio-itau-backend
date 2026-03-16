package dev.Java10x.itau.Java10x.Transacoes;

import dev.Java10x.itau.Java10x.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacaoRepository {


    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();



    //salvar dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){

        listaDeTransacoes.add(transacaoDTO);
    }
    //apagar essa lista depois 60 segundos
    public void limparDados(TransacaoDTO transacaoDTO){

    }
    //deletar dados
    public void deletarDados(){
        listaDeTransacoes.clear();
    }

    //GERAR ESTATISTICAS

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){
        if (listaDeTransacoes.isEmpty()){
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }
        final var summary = listaDeTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(summary.getCount(),summary.getAverage(),summary.getMax(), summary.getMin(), summary.getSum());
    }
}
