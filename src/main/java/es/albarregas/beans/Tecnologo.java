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
//  @DiscriminatorValue(value = "TC")
public class Tecnologo extends Persona implements Serializable {

    protected int yearEstudio;

    public Tecnologo() {
    }

    public Tecnologo(int yearEstudio) {
        this.yearEstudio = yearEstudio;
    }

    public Tecnologo(int yearEstudio, Long id, String nombre, Date fechaNacimiento) {
        super(id, nombre, fechaNacimiento);
        this.yearEstudio = yearEstudio;
    }

    public int getYearEstudio() {
        return yearEstudio;
    }

    public void setYearEstudio(int yearEstudio) {
        this.yearEstudio = yearEstudio;
    }

}
