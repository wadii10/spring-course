package iit.tn.example.cours.repository;

import iit.tn.example.cours.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
