package com.studentapi.Student_attendance.Service_implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.studentapi.Student_attendance.DTO.StudentDto;
import com.studentapi.Student_attendance.Entity.StudentEntity;
import com.studentapi.Student_attendance.Repositry.StudentRepo;
import com.studentapi.Student_attendance.Services.StudentService;

@Service
public class Student_implementation implements StudentService {

    @Autowired
    private StudentRepo repository;

    // ABSOLUTE PATH (FIX)
    private final String UPLOAD_DIR =
            System.getProperty("user.dir") + File.separator + "uploads";

    @Override
    public StudentEntity saveStudent(StudentDto dto) {

        StudentEntity student = new StudentEntity();
        student.setName(dto.getName());
        student.setRollNo(dto.getRollNo());
        student.setRegdNo(dto.getRegdNo());
        student.setMobileNo(dto.getMobileNo());
        student.setEmail(dto.getEmail());
        student.setBatch(dto.getBatch());
        student.setDepartment(dto.getDepartment());
        student.setCurrentYear(dto.getCurrentYear());
        student.setSection(dto.getSection());
        student.setGroupName(dto.getGroupName());
        student.setPassword(dto.getPassword());
        student.setSemester(dto.getSemester());

        // IMAGE UPLOAD (CORRECT)
        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            try {
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String fileName = UUID.randomUUID() + "_" +
                        StringUtils.cleanPath(dto.getImage().getOriginalFilename());

                File dest = new File(uploadDir, fileName);
                dto.getImage().transferTo(dest);

                student.setImagePath(dest.getAbsolutePath());

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Image upload failed");
            }
        }

        return repository.save(student);
    }
}
