package com.khairenncode.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
    private Long icNumber;
    private String lastname;
    private String firstname;
    private String dob;

    public Customer() {
    }

    public Customer(Long icNumber, String lastname, String firstname, String dob) {
        this.icNumber = icNumber;
        this.lastname = lastname;
        this.firstname = firstname;
        this.dob = dob;
    }

    @Id
    @Column(name = "icNumber", nullable = false)
    public Long getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(Long icNumber) {
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
