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
//  @DiscriminatorValue(value = "NM")
public class Normal extends Persona implements Serializable {

    protected String ocupacion;

    public Normal() {
    }

    public Normal(String ocupacion, Long id, String nombre, Date fechaNacimiento) {
        super(id, nombre, fechaNacimiento);
        this.ocupacion = ocupacion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

}
