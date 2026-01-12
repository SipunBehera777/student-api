package com.studentapi.Student_attendance.Services;

import com.studentapi.Student_attendance.DTO.StudentDto;
import com.studentapi.Student_attendance.Entity.StudentEntity;

public interface StudentService {
    StudentEntity saveStudent(StudentDto dto);
}
