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
//  @DiscriminatorValue(value = "TS")
public class Tester extends Tecnologo implements Serializable {

    protected String herramientasDeTester;

    public Tester() {
    }

    public Tester(String herramientasDeTester, int yearEstudio, Long id, String nombre, Date fechaNacimiento) {
        super(yearEstudio, id, nombre, fechaNacimiento);
        this.herramientasDeTester = herramientasDeTester;
    }

    public String getHerramientasDeTester() {
        return herramientasDeTester;
    }

    public void setHerramientasDeTester(String herramientasDeTester) {
        this.herramientasDeTester = herramientasDeTester;
    }

}
