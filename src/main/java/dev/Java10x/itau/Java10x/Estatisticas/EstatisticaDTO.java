package dev.Java10x.itau.Java10x.Estatisticas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EstatisticaDTO {

    private  long count;
    private  double avg;
    private  double max;
    private  double min;
    private  double sum;

    public EstatisticaDTO(long count, Double avg, Double max, Double min, Double sum) {
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

}
