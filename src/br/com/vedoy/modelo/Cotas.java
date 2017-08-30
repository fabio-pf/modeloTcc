/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Fabio V
 */
@Entity
public class Cotas implements Serializable{ 
    
    @Id
    @SequenceGenerator(name = "seq_cotas", sequenceName = "seq_cotas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cotas", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private int cota;

    public Cotas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCota() {
        return cota;
    }

    public void setCota(int cota) {
        this.cota = cota;
    }   
}
