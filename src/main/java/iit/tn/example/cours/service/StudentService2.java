package iit.tn.example.cours.service;

import iit.tn.example.cours.entity.Student;
import iit.tn.example.cours.exception.CompteNotFoundException;
import iit.tn.example.cours.exception.StudentNotFoundException;
import iit.tn.example.cours.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService2 {
    
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Integer id) throws StudentNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new CompteNotFoundException("Student with id=" + id + " is not found"));
    }

    public void updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElseThrow(() -> new StudentNotFoundException("student with id=" + student.getId() + " not found"));
        existingStudent.setName(student.getName());
        studentRepository.save(existingStudent);
    }

}
