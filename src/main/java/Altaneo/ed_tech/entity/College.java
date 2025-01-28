package Altaneo.ed_tech.entity;

import java.util.List;

import Altaneo.ed_tech.entity.FacultyAndStudent.FacultyAndStudent;
import Altaneo.ed_tech.entity.ranking.CourseAndFee;
import Altaneo.ed_tech.entity.ranking.Ranking;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private Ranking ranking;

    @ElementCollection
    @CollectionTable(name = "college_scholarships", joinColumns = @JoinColumn(name = "college_id"))
    private List<String> scholarships;

    @ElementCollection
    @CollectionTable(name = "college_courseAndFee", joinColumns = @JoinColumn(name = "college_id"))
    private List<CourseAndFee> courseAndFee;

    @Embedded
    private FacultyAndStudent facultyAndStudent;

    @ElementCollection
    @CollectionTable(name = "college_alumni", joinColumns = @JoinColumn(name = "college_id"))
    private List<Alumni> alumni;

    @ElementCollection
    @CollectionTable(name = "college_fest", joinColumns = @JoinColumn(name = "college_id"))
    private List<Fest> fest;
}