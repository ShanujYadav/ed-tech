package Altaneo.ed_tech.entity.ranking;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class NirfRanking {
    @NotBlank(message = "year is required.")
    private String year;
    @NotBlank(message = "position is required.")
    private String position;
}
