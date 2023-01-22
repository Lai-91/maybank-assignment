package com.khairenncode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    private String icNumber;
    private String lastname;
    private String firstname;
    private String dob;

    public Customer() {
    }

    public Customer(String icNumber, String lastname, String firstname, String dob) {
        this.icNumber = icNumber;
        this.lastname = lastname;
        this.firstname = firstname;
        this.dob = dob;
    }

    @Id
    @Column(name = "icNumber", nullable = false)
    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "firstname", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "dob", nullable = false)
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ic=" + icNumber +
                ", lastname='" + lastname +
                ", firstname='" + firstname +
                ", dob='" + dob +
                '}';
    }
}
