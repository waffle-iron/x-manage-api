package com.example.entity;

import javax.persistence.*;

@Entity(name="customer")
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = true)
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {

        return String.format("Hotfix from Master[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}