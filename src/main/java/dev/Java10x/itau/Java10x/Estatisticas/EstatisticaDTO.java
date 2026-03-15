package dev.Java10x.itau.Java10x.Estatisticas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticaDTO {

    private  long count;
    private  double avg;
    private  double max;
    private  double min;
    private  double sum;


}
