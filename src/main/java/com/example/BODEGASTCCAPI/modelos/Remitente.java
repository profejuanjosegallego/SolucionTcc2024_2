package com.example.BODEGASTCCAPI.modelos;


import jakarta.persistence.*;

@Entity
@Table(name = "remitentes")
public class Remitente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombres", nullable = false)
    private String nombres;

    @Column(name="departamento", nullable = false)
    private String departamento;

    @Column(name="municipio", nullable = false)
    private String municipio;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="metodo_pago", nullable = false)
    private String metodoPago;

    public Remitente() {
    }

    public Remitente(Long id, String nombres, String departamento, String municipio, String direccion, String metodoPago) {
        this.id = id;
        this.nombres = nombres;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
