package com.studentapi.Student_attendance.DTO;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

     @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Roll No is required")
    private String rollNo;

    private String regdNo;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @Email(message = "Invalid email format")
    private String email;

    private String batch;
    private String department;
    private String currentYear;
    private String section;
    private String groupName;
    private String semester;

     @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
        message = "Password must contain uppercase, lowercase, number, and special character"
    )
    private String password;

    private MultipartFile image;
    
}
