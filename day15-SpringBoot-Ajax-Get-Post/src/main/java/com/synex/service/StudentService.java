package com.synex.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.synex.model.Address;
import com.synex.model.Student;

@Service
public class StudentService {
    
    // CopyOnWriteArrayList allows removal while iterating
    List<Student> studentList = new CopyOnWriteArrayList<>();
    
    public List<Student> getAllStudents() {
        return studentList;
    }
    
    public List<Student> addStudent(Student student) {
        studentList.add(student);
        return studentList;
    }
    
    public List<Student> removeStudent(int studentId) {
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (studentId == student.getId()) {
                studentList.remove(student);
            }
        }
        return studentList;
    }
    
    public Address getAddress(int studentId) {
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (studentId == student.getId()) {
                return student.getAddress();
            }
        }
        return null;
    }
    
}
