package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sintoma
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha")
    private LocalDate fecha; 
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    public Sintoma(){ 
    }

    public Sintoma(String nombre, LocalDate fecha, String descripcion){
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString()
    {
        return "Sintoma{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", fecha=" + fecha +
               ", descripcion='" + descripcion.substring(0, Math.min(descripcion.length(), 30)) + (descripcion.length() > 30 ? "..." : "") + '\'' +
               '}';
    }
}
