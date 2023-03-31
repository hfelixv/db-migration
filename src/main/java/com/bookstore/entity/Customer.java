package com.bookstore.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.annotation.NotBlank;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class Customer {

    @Id
    @SequenceGenerator(name="employee_info_id_seq",
                       sequenceName="employee_info_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="employee_info_id_seq")
    @Column(name = "ID", updatable=false)
    private long id;

    @Column(name="FIRST_NAME")
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    @Column(name="LAST_NAME")
    private String surname;

    @NotBlank(message = "Email is required")
    @Column(name="JOB_TITLE")
    private String email;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name="SALARY")
    private Long salary;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
