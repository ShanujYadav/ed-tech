package Altaneo.ed_tech.entity.FacultyAndStudent;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Students {
    private String total;
    private String underGraduates;
    private String postGraduates;
    private String doctoral;
    private String threeYearPlacement;
    private String alumni;
    private String highestPackage;
}