package dev.Java10x.itau.Java10x.Transacoes;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoDTO transacaoDTO) {
        //valor maior ou igual a 0
        if (transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0) {
            //transacao não é valida valor menor ou igual a zero
            throw new IllegalArgumentException("Erro: Não é uma transação valida, o valor deve ser maior que 0.");
        }
        //data menor ou igual a data de hoje
        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Na data da Transação.");
        }

        //há outros jeitos de fazer porém esse eu fiz sozinho
        // data e hora presentes ( body não pode ser null )
        if (transacaoDTO.getValor() == null) {
            throw new IllegalArgumentException("Campo não pode ser vazio");
        }
        if (transacaoDTO.getDataHora() == null){
            throw new IllegalArgumentException("Campo hora não pode ser vazio");
        }
    }
}