package kz.bitlab.g128sprinttask61.repository;

import kz.bitlab.g128sprinttask61.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
