package com.acem.acemanager.pojo;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Member {
        
    private String id;
    // private int idCard;
    // private int idCity;
    // private int idFaculty;
    // private int idField;
    // private int idSession;
    
    @Size(min=9, max=9, message = "Passport MUST contains 9 characters")
    private String passport; // NBE388510, MUST: 9 chars max
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @Past // Date should be in the past than today
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate; // can't be null or not in the format: dd/MM/yyyy

    private int age; // Should do automatically be calucated from birthdate
    @NotBlank(message = "Email cannot be blank")
    private String email;
    
    private Integer matriculeAmci; // 20111473, MUST: 8 chars
    private Boolean isMember;
    //private Role role;


    public Member() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMatriculeAmci() {
        return this.matriculeAmci;
    }

    public void setMatriculeAmci(Integer matriculeAmci) {
        this.matriculeAmci = matriculeAmci;
    }

    public Boolean isIsMember() {
        return this.isMember;
    }

    public Boolean getIsMember() {
        return this.isMember;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }
}
