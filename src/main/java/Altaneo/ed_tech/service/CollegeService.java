package Altaneo.ed_tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Altaneo.ed_tech.DTO.CollegeDTO;
import Altaneo.ed_tech.entity.Alumni;
import Altaneo.ed_tech.entity.College;
import Altaneo.ed_tech.entity.Fest;
import Altaneo.ed_tech.entity.ranking.CourseAndFee;
import Altaneo.ed_tech.entity.ranking.NirfRanking;
import Altaneo.ed_tech.repo.CollegeRepo;
import Altaneo.ed_tech.utils.ApiResponse;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepo collegeRepo;

    // public String<College> getCollegeByName(String name) {
    // System.out.println("name ----------"+name);
    // if(collegeRepo.findByName(name).isPresent()){
    // return
    // }
    // else{
    // }
    // }

    public ResponseEntity<ApiResponse<College>> addCollege(College college) {
        System.out.println("College-------------" + college);
        try {
            if (college.getContactInfo() == null) {
                throw new IllegalArgumentException("contactInfo Section is missing!.");
            }
            if (college.getRanking() == null) {
                throw new IllegalArgumentException("ranking Section is missing!.");
            }
            if (college.getScholarships() == null) {
                throw new IllegalArgumentException("Scholarship Section is missing!.");
            }
            if (college.getCourseAndFee() == null) {
                throw new IllegalArgumentException("courseAndFee Section is missing!.");
            }
            if (college.getFacultyAndStudent() == null
                    || college.getFacultyAndStudent().getFaculty() == null
                    || college.getFacultyAndStudent().getStudents() == null) {
                throw new IllegalArgumentException("facultyAndStudent Section is missing!.");
            }

            if (college.getAlumni() == null) {
                throw new IllegalArgumentException("Alumni Section is missing!.");
            }
            if (college.getFest() == null) {
                throw new IllegalArgumentException("Fest Section is missing!.");
            }

            checkMandatory(college.getName(), "name");
            if (collegeRepo.findByName(college.getName()).isPresent()) {
                return ApiResponse.send(409, "College Already exists");
            }
            checkMandatory(college.getSortName(), "sort Name");
            checkMandatory(college.getCategory(), "Category");
            checkMandatory(college.getType(), "Type");
            checkMandatory(college.getLogoUrl(), "LogoUrl ");
            checkMandatory(college.getImgUrl(), "ImgUrl ");
            checkMandatory(college.getEstablished(), "established");
            checkMandatory(college.getSize(), "size");
            checkMandatory(college.getRating(), "rating");
            checkMandatory(college.getCity(), "city");
            checkMandatory(college.getState(), "state");
            checkMandatory(college.getCountry(), "country");

            checkMandatory(college.getContactInfo().getPhone(), "phone");
            checkMandatory(college.getContactInfo().getWebsite(), "website");
            checkMandatory(college.getContactInfo().getEmail(), "email");
            checkMandatory(college.getContactInfo().getDescription(), "Description");

            checkMandatory(college.getRanking().getNaacGrade(), "NaacGrade");
            checkMandatory(college.getRanking().getNirfPara(), "NIRF Paragraph");

            for (NirfRanking nirfRanking : college.getRanking().getNirfRanking()) {
                checkMandatory(nirfRanking.getYear(), "Nirf year");
                checkMandatory(nirfRanking.getPosition(), "Nirf position");
            }

            if (college.getScholarships() == null || college.getScholarships().isEmpty()) {
                throw new IllegalArgumentException("Scholarship field cannot be empty.");
            }

            if (college.getCourseAndFee() == null || college.getCourseAndFee().isEmpty()) {
                throw new IllegalArgumentException("courseAndFee field cannot be empty.");
            }
            for (CourseAndFee courseAndFee : college.getCourseAndFee()) {
                checkMandatory(courseAndFee.getCourse(), "Course");
                checkMandatory(courseAndFee.getDuration(), "duration");
                checkMandatory(courseAndFee.getEligibility(), "eligibility");
                checkMandatory(courseAndFee.getFee(), "fee");
            }

            checkMandatory(college.getFacultyAndStudent().getFaculty().getChairman(), "chairman");
            checkMandatory(college.getFacultyAndStudent().getFaculty().getDirector(), "director");
            checkMandatory(college.getFacultyAndStudent().getFaculty().getOtherStaff(), "otherStaff");

            checkMandatory(college.getFacultyAndStudent().getStudents().getTotal(), "total");
            checkMandatory(college.getFacultyAndStudent().getStudents().getUnderGraduates(), "underGraduates");
            checkMandatory(college.getFacultyAndStudent().getStudents().getPostGraduates(), "postGraduates");
            checkMandatory(college.getFacultyAndStudent().getStudents().getDoctoral(), "doctoral");
            checkMandatory(college.getFacultyAndStudent().getStudents().getAlumni(), "alumni");
            checkMandatory(college.getFacultyAndStudent().getStudents().getThreeYearPlacement(), "threeYearPlacement");
            checkMandatory(college.getFacultyAndStudent().getStudents().getHighestPackage(), "highestPackage");

            if (college.getAlumni() == null || college.getAlumni().isEmpty()) {
                throw new IllegalArgumentException("Alumni field cannot be empty.");
            }
            for (Alumni alumni : college.getAlumni()) {
                checkMandatory(alumni.getAlumniName(), "Alumni Name");
                checkMandatory(alumni.getPosition(), "Alumni Position");
            }

            if (college.getFest() == null || college.getFest().isEmpty()) {
                throw new IllegalArgumentException("Fest field cannot be empty.");
            }
            for (Fest fest : college.getFest()) {
                checkMandatory(fest.getFestName(), "Fest Name");
                checkMandatory(fest.getDescription(), "Fest Description");
            }
            College savedCollege = collegeRepo.save(college);
            return ApiResponse.send(200, "College Added Successfully !", savedCollege);
        } catch (IllegalArgumentException e) {
            return ApiResponse.send(400, e.getMessage());
        } catch (Exception e) {
            return ApiResponse.send(500, e.getMessage());
        }
    }

    private void checkMandatory(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " field cannot be empty.");
        }
    }

    public ResponseEntity<ApiResponse<Optional<College>>> getCollegeById(Long id) {
        try {
            Optional<College> findCollege = collegeRepo.findById(id);
            if (findCollege.isPresent()) {
                return ApiResponse.send(200, "College Data !", findCollege);
            }
            return ApiResponse.send(404, "Data Not Found !");
        } catch (Exception e) {
            return ApiResponse.send(500, e.getMessage());
        }
    }

    public ResponseEntity<ApiResponse<List<CollegeDTO>>> getCollegeList() {
        try {
            List<College> colleges = collegeRepo.findAll();

            if (colleges.isEmpty()) {
                return ApiResponse.send(404, "College List Not Found !");
            }

            List<CollegeDTO> collegeList = colleges.stream().map(college -> {
                CollegeDTO dto = new CollegeDTO();
                dto.setId(college.getId());
                dto.setName(college.getName());
                dto.setSortName(college.getSortName());
                dto.setCategory(college.getCategory());
                dto.setType(college.getType());
                dto.setLogoUrl(college.getLogoUrl());
                dto.setImgUrl(college.getImgUrl());
                dto.setEstablished(college.getEstablished());
                dto.setSize(college.getSize());
                dto.setRating(college.getRating());
                dto.setCity(college.getCity());
                dto.setState(college.getState());
                dto.setCountry(college.getCountry());
                return dto;
            }).toList();

            return ApiResponse.send(200, "College List !", collegeList);
        } catch (Exception e) {
            return ApiResponse.send(500, e.getMessage());
        }
    }

    public ResponseEntity<ApiResponse<College>> updateCollege(Long id, College college) {
        try {
            if (collegeRepo.existsById(id)) {
                college.setId(id);
                College updatedCollege = collegeRepo.save(college);
                return ApiResponse.send(200, "College Updated !", updatedCollege);
            }
            return ApiResponse.send(400, "College Not find by Id!");
        } catch (Exception e) {
            return ApiResponse.send(500, e.getMessage());
        }
    }
}