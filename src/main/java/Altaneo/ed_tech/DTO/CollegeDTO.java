package Altaneo.ed_tech.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDTO {
    private Long id;
    private String name;
    private String sortName;
    private String category;
    private String type;
    private String logoUrl;
    private String imgUrl;
    private String established;
    private String size;
    private String rating;
    private String city;
    private String state;
    private String country;
}