package com.studentapi.model;

import java.util.ArrayList;
import java.util.List;

public class StudentPojo {

    //    {"firstName":"Hesho","lastName":"Belo","email":"hesho@Hesho.com","programme":"ComputerScience","courses":["Accounting","Statistics"]}
    public String firstName, lastName, email, programme;
    private List<String> courses= new ArrayList<String>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setCourses(String course) {
        this.courses.add(course);
    }
}
