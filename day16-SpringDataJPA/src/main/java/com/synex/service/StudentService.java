package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.AddressD;
import com.synex.domain.StudentD;
import com.synex.repository.AddressRepository;
import com.synex.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired StudentRepository studentRepository;
    @Autowired AddressRepository addressRepository;
    
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
        
        // Because of OneToOne Mapping and Student has Address, it needs to create address first then save student.
        // Or make Address @Embeddabble and Student.address @Embedded. (& remove @Entity from Address class)
        
        // See if student exists just to make sure not to keep creating address when there is already one for this student.
        StudentD persistentStudent = studentRepository.findById(student.getId()).orElse(null);
        
        AddressD adrs = student.getAddress();  // address from text fields.
        AddressD address;
        AddressD persistentAddress;
        
        if (persistentStudent == null) {  // if student does not exists, create new address by auto generating new address id.
            // id=0 is ignored. Auto id generation is from 1 for Oracle SQL or MySQL. So it generates next available id.
            address = new AddressD(0, adrs.getHouseNo(), adrs.getCity(), adrs.getProvince(), adrs.getCountry(), adrs.getPhone());
            persistentAddress = addressRepository.save(address);  // address.id generated from DB
        }
        else {  // else update address with address id from DB.
            address = new AddressD(persistentStudent.getAddress().getId(), adrs.getHouseNo(), adrs.getCity(), adrs.getProvince(), adrs.getCountry(), adrs.getPhone());
            persistentAddress = addressRepository.save(address);  // updates address in DB.
        }

        student.setAddress(persistentAddress);  // gets address id along with other address info I already knew.
        return studentRepository.save(student);  // On DB, student gets student.address column: address.id. (because it's one to one).
    }
    
    public void removeStudent(int studentId, int addressId) {
//        Iterator<Student> itr = studentList.iterator();
//        while (itr.hasNext()) {
//            Student student = itr.next();
//            if (studentId == student.getId()) {
//                studentList.remove(student);
//            }
//        }
//        return studentList;
        studentRepository.deleteById(studentId);
        addressRepository.deleteById(addressId);  // Address must be deleted after. Can't be deleted before because student has it.
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
    
    // Not using it. addStudent has this functionality.
    public StudentD updateStudent(StudentD student) {
        StudentD persistObj = studentRepository.findById(student.getId()).orElse(null);  // get a student data from DB
        persistObj.setName(student.getName());  // updating name & age. leaving address same.
        persistObj.setAge(student.getAge());
        return studentRepository.save(persistObj);  // saving back to DB
    }
    
}
