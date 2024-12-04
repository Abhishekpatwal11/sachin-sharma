package com.example.signUp.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "FirstName")
    private String fName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "LastName")
    private String lName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "Email")
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "Password")
    private String password;

    public User(Integer id, String fName, String lName, String email,String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password=password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}