package Altaneo.ed_tech.entity.ranking;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.Data;


@Data
@Embeddable
public class Ranking {
    private String naacGrade;
    private String nirfPara;
    

    @ElementCollection
    @Valid
    private List<NirfRanking> nirfRanking;
}