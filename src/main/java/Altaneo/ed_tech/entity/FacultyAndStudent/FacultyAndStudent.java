package Altaneo.ed_tech.entity.FacultyAndStudent;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class FacultyAndStudent {

    @Embedded
    private Faculty faculty;

    @Embedded
    private Students students;   
}
