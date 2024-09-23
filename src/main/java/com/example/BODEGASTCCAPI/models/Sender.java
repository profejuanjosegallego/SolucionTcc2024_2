package com.example.BODEGASTCCAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "senders")
public class Sender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_names", nullable = false)
    private String firstNames;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    public Sender() {
    }

    public Sender(Long id, String firstNames, String department, String city, String address, String paymentMethod) {
        this.id = id;
        this.firstNames = firstNames;
        this.department = department;
        this.city = city;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
