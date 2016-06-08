package com.theironyard;

/**
 * Created by will on 6/8/16.
 */
public class Person {
    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ip;

    public Person(int id, String firstName, String lastName, String email, String country, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ip = ip;


    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

}

