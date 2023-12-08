package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.AddressD;
import com.synex.domain.StudentD;
import com.synex.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired StudentRepository studentRepository;
    
    // Instead of using local volatile memory, use DB. Save to DB and get from DB.
    // CopyOnWriteArrayList allows removal while iterating
    // List<Student> studentList = new CopyOnWriteArrayList<>();
    
    public List<StudentD> getAllStudents() {
        // return studentList;
        return studentRepository.findAll();
    }
    
    public StudentD addStudent(StudentD student) {
        // studentList.add(student);
        // return studentList;
        return studentRepository.save(student);
    }
    
    public void removeStudent(int studentId) {
//        Iterator<Student> itr = studentList.iterator();
//        while (itr.hasNext()) {
//            Student student = itr.next();
//            if (studentId == student.getId()) {
//                studentList.remove(student);
//            }
//        }
//        return studentList;
        studentRepository.deleteById(studentId);
    }
    
    public AddressD getAddress(int studentId) {
//        Iterator<Student> itr = studentList.iterator();
//        while (itr.hasNext()) {
//            Student student = itr.next();
//            if (studentId == student.getId()) {
//                return student.getAddress();
//            }
//        }
//        return null;
        StudentD student = studentRepository.findById(studentId).orElse(null);  // return value if present or return null
        return student.getAddress();
    }
    
    public StudentD updateStudent(StudentD student) {
        StudentD persistObj = studentRepository.findById(student.getId()).orElse(null);  // get a student data from DB
        persistObj.setName(student.getName());  // updating name & age. leaving address same.
        persistObj.setAge(student.getAge());
        return studentRepository.save(persistObj);  // saving back to DB
    }
    
}
