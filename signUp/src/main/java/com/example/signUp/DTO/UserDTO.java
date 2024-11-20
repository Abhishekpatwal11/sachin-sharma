package com.example.signUp.DTO;


public class UserDTO {
       private String fName;
       private String lName;
       private String email;
       private String password;

    public UserDTO(String fName, String lName, String email,String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password=password;
    }

    public UserDTO() {
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

