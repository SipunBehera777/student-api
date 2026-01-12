package com.studentapi.Student_attendance.Controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.studentapi.Student_attendance.DTO.StudentDto;
import com.studentapi.Student_attendance.Entity.StudentEntity;
import com.studentapi.Student_attendance.Services.StudentService;

@RestController
@RequestMapping("/api/students")
public class Student_Cotroller {
    @Autowired
    private StudentService service;
     @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StudentEntity> createStudent(
            @Valid @ModelAttribute StudentDto dto) {

        StudentEntity savedStudent = service.saveStudent(dto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
}
