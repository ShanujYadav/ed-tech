package Altaneo.ed_tech.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Altaneo.ed_tech.entity.College;


@Repository
public interface CollegeRepo extends JpaRepository<College,Long>{
    Optional<College> findByName(String name);
}



// @Repository
// public interface CollegeRepo extends JpaRepository<College,Long>{
// }