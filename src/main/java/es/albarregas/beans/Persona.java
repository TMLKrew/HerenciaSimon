/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Simon
 */
@Entity
@Table(name = "PersonasHerencia")
//  @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//  @Inheritance(strategy = InheritanceType.JOINED)
 @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//  La anotación @DiscriminatorColumn funciona solo si hemos elegido InheritanceType.SINGLE_TABLE
//  @DiscriminatorColumn(name = "DIS", discriminatorType = DiscriminatorType.STRING)
public abstract class Persona implements Serializable {

    @Id
//  La anotacion @GeneratedValue tendra la estrategia GenerationType.TABLE si hemos elegido InheritanceType.TABLE_PER_CLASS
  @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nombre;
//  Los atributos de tipo Date, o que traten fechas deberan llevar la anotacion @Temporal
    @Temporal(TemporalType.DATE)
    protected Date fechaNacimiento;

    public Persona() {
    }

    public Persona(Long id, String nombre, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
