package com.learning.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTables(
        {
                @SecondaryTable(name = "ADDRESSES", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID")),
                @SecondaryTable(name = "PHONES", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
        }
)
public class Passenger {

    @Id
    @Column(name = "PASSENGER_ID")
    private int id;

    @Column(name = "PASSENGER_NAME", table = "PASSENGERS")
    private String name;

    @Column(name = "PASSENGER_PHONE", table = "PHONES", columnDefinition = "varchar(12) not null")
    private String phoneNumber;

    @Column(name = "STREET", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String street;

    @Column(name = "NUMBER", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String number;

    @Column(name = "ZIP_CODE", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String zipCode;

    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String city;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Passenger() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
