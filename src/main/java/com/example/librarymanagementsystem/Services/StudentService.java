package com.example.librarymanagementsystem.Services;

import com.example.librarymanagementsystem.Entities.Student;
import com.example.librarymanagementsystem.Repositories.StudentRepository;
import com.example.librarymanagementsystem.RequestDtos.AddStudentRequest;
import com.example.librarymanagementsystem.RequestDtos.ModifyPhnNoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

        @Autowired
        private StudentRepository studentRepository;
    public String addStudent(AddStudentRequest addStudentRequest) {

        Student student=new Student(addStudentRequest.getName(),addStudentRequest.getBranch(),addStudentRequest.getCgpa(),addStudentRequest.getPhoneNo());

       Student savedStudent= studentRepository.save(student);

        return "Student has been saved to DB with studentId "+savedStudent.getStudentID();

    }

    public Student findStudentById(Integer studentId)throws Exception {


        Optional<Student> optionalStudent=studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()){
            throw new Exception("Student Id entered is Incorrect");
        }
        Student student=optionalStudent.get();
        return student;
    }

    public String modifyPhnNo(ModifyPhnNoRequest modifyPhnNoRequest) {
        Integer studentId=modifyPhnNoRequest.getStudentId();
        String newPhnNo=modifyPhnNoRequest.getNewPhnNo();


        Student student=studentRepository.findById(studentId).get();
        student.setPhoneNo(newPhnNo);
        studentRepository.save(student);
        return "Phone No. has been modified";

    }
}
