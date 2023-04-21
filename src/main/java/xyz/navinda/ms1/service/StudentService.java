package xyz.navinda.ms1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.navinda.ms1.entity.Student;
import xyz.navinda.ms1.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student update(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
