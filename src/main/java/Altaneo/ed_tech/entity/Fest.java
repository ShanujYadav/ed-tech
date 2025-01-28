package Altaneo.ed_tech.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Fest {
    private String festName;
    private String description;
}
