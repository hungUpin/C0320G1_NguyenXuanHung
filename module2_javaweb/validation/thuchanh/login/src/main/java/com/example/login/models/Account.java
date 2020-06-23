package com.example.login.models;

import com.example.login.validation.PhoneNumberConstrain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @NotBlank(message = "FirstName not blank!!!")
    @Size(min=5,max = 45,message = "FirstName must from 5 to 45 characters")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "LastName not blank!!!")
    @Size(min=5,max = 45,message = "LastName must from 5 to 45 characters")
    private String lastName;
    @PhoneNumberConstrain
    @Column(name = "phone_number")
    private String phoneNumber;
    @Min(value = 18)
    @Column(name = "age")
    private Integer age;
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$",message = "Email is invalid")
    @Column(name="email")
    private String email;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
