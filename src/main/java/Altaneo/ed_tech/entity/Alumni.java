package Altaneo.ed_tech.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Alumni {
    private String alumniName;
    private String position;
}
