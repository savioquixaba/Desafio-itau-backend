package dev.Java10x.itau.Java10x.Transacoes;

import org.springframework.stereotype.Repository;

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
}
