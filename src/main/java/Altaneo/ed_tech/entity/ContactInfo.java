package Altaneo.ed_tech.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactInfo {
    private String phone;
    private String email;
    private String website;
    private String description;
}