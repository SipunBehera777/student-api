package com.studentapi.Student_attendance.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

     @Column(nullable = false, unique = true)
    private String rollNo;

    @Column(nullable = false, length = 10)
    private String mobileNo;

    
    private String email;
    private String semester;

    private String batch;
    private String department;
    private String currentYear;
    private String section;
    private String groupName;
    private String regdNo;

      @Column(nullable = false)
    private String password;

     private String imagePath;
}
