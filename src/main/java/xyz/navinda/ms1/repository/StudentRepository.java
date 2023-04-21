package xyz.navinda.ms1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.navinda.ms1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}