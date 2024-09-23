package com.example.BODEGASTCCAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Merchandise")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iup")
    private Long id;

    @Column(name = "volume", nullable = false)
    private Double volume;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "merchandise_name", nullable = false, length = 50)
    private String name;

    @Column(name = "recipient_type")
    private String recipientType;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "department")
    private String department;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "exit_date")
    private LocalDate exitDate;

    public Merchandise() {
    }

    public Merchandise(Long id, Double volume, Double weight, String name, String recipientType, String recipientName, String department, String city, String address, LocalDate entryDate, LocalDate exitDate) {
        this.id = id;
        this.volume = volume;
        this.weight = weight;
        this.name = name;
        this.recipientType = recipientType;
        this.recipientName = recipientName;
        this.department = department;
        this.city = city;
        this.address = address;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }
}
