package Altaneo.ed_tech.entity.ranking;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class CourseAndFee {
    private String course;
    private String fee;
    private String eligibility;
    private String duration;
}