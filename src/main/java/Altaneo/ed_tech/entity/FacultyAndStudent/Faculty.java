package Altaneo.ed_tech.entity.FacultyAndStudent;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Faculty {
    private String chairman;
    private String director;
    private String otherStaff;
}
