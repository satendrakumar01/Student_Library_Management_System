package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String createStudent(Student student){

//        Student form the postman is already the basic attributes set


//        Card should be autogenrated when createStudent function is called


        Card card =new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);


//        Lets go the student



        student.setCard(card);



//        If there was a unidirectional mapping: we had to save both of them

//        But we are super advance and are using bidirectional :Child will auto matically saved.

        studentRepository.save(student);


//        by cascading effect child will automatically saved.
        return "student and card added";



    }



    public String findNameByEmail(String email){

        Student student = studentRepository.findByEmail(email);

        return student.getName();

    }

    public String updateMobNo(StudentUpdateMobRequestDto studentRequest){


//        Convert the dto to the entity so that it can be saved better


        Student originalStudent=studentRepository.findById(studentRequest.getId()).get();

//        we will keep the other properties as it is: and only change the required parameters;

        originalStudent.setMobNo(studentRequest.getMobNo());

        studentRepository.save(originalStudent);



        return "Updated student successfully";
    }
}
