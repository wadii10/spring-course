package iit.tn.example.cours.service;

import iit.tn.example.cours.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<StudentDto> studentDtos = new ArrayList<>();

    public StudentService() {
        studentDtos.add(new StudentDto(1, "wadii"));
        studentDtos.add(new StudentDto(2, "yessin"));
    }

    public List<StudentDto> getAll() {
        return studentDtos;
    }

    public void deleteStudent(int id) {
        studentDtos.removeIf( s -> s.getId() == id);
    }

    public void addStudent(StudentDto studentDto) {
        studentDtos.add(studentDto);
    }
}
