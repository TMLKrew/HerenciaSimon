/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Simon
 */
@Entity
//  La anotación @DiscriminatorValue funciona solo si hemos elegido InheritanceType.SINGLE_TABLE
//  @DiscriminatorValue(value = "PG")
public class Programador extends Tecnologo implements Serializable {

    protected String lenguajeFavorito;
    protected int aniosDeExperiencia;

    public Programador() {
    }

    public Programador(String lenguajeFavorito, int aniosDeExperiencia) {
        this.lenguajeFavorito = lenguajeFavorito;
        this.aniosDeExperiencia = aniosDeExperiencia;
    }

    public Programador(String lenguajeFavorito, int aniosDeExperiencia, int yearEstudio, Long id, String nombre, Date fechaNacimiento) {
        super(yearEstudio, id, nombre, fechaNacimiento);
        this.lenguajeFavorito = lenguajeFavorito;
        this.aniosDeExperiencia = aniosDeExperiencia;
    }

    public String getLenguajeFavorito() {
        return lenguajeFavorito;
    }

    public void setLenguajeFavorito(String lenguajeFavorito) {
        this.lenguajeFavorito = lenguajeFavorito;
    }

    public int getAniosDeExperiencia() {
        return aniosDeExperiencia;
    }

    public void setAniosDeExperiencia(int aniosDeExperiencia) {
        this.aniosDeExperiencia = aniosDeExperiencia;
    }

}
