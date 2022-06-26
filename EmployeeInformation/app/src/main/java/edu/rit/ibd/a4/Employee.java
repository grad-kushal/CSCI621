package edu.rit.ibd.a4;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;

public class Employee {

    static int empId = 0;

    int id;
    String fname;
    String lname;
    String photo;
    Date dob;
    String cell;
    String email;
    String address;
    String role;
    String department;
    int manager;
    ArrayList<Long> manages;
    String emergency_contact;
    Date joining;
    Date termination;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", photo='" + photo + '\'' +
                ", dob=" + dob +
                ", cell='" + cell + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                ", manager=" + manager +
                ", manages=" + manages +
                ", emergency_contact='" + emergency_contact + '\'' +
                ", joining=" + joining +
                ", termination=" + termination +
                '}';
    }

    public Employee(Faker faker) {
        this.id = empId++;
        this.fname = faker.name().firstName();
        this.lname = faker.name().lastName();
        this.address = faker.address().fullAddress();
        this.cell = faker.phoneNumber().cellPhone();
        this.department = (this.id == 0) ? "Executive" : EmployeeInformationApplication.departments.get((this.id% EmployeeInformationApplication.departments.size()));
        this.dob = faker.date().birthday();
        this.email = fname.toLowerCase() + "." + lname.toLowerCase() + "@dbsimail.com";
        this.emergency_contact = faker.phoneNumber().cellPhone();
        this.joining = faker.date().between(dob, new Date());
        this.manager = (this.id == 0) ? 9999 : -1;
        this.manages = new ArrayList<>();
        this.photo = null;
        this.role = (this.id == 0) ? "CEO" : getRole(department);
        this.termination = faker.date().between(joining, new Date());
    }

    private String getRole(String department) {
        return department + " Role";
    }
}