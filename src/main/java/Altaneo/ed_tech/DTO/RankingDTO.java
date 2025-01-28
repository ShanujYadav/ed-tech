package Altaneo.ed_tech.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {
    private String nirfPara;
    private String naacGrade;
    private List<NirfRankingDTO> nirfRanking;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NirfRankingDTO {
        private String year;
        private String position;
    }
}