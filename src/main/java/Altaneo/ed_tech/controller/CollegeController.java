package Altaneo.ed_tech.controller;

import org.springframework.web.bind.annotation.RestController;

import Altaneo.ed_tech.DTO.CollegeDTO;
import Altaneo.ed_tech.entity.College;
import Altaneo.ed_tech.service.CollegeService;
import Altaneo.ed_tech.utils.ApiResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/college")
@CrossOrigin
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<College>> addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    @PostMapping("/details/{id}")
    public ResponseEntity<ApiResponse<Optional<College>>> getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse<List<CollegeDTO>>> getCollegeList() {
        return collegeService.getCollegeList();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse<College>> updateCollege(@PathVariable Long id, @RequestBody College college) {
        return collegeService.updateCollege(id,college);
    }
}