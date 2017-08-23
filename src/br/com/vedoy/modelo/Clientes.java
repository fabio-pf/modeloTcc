/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Fabio V
 */
@Entity
@DiscriminatorValue(value = "cli")
public class Clientes extends Pessoas implements Serializable{

    public Clientes() {
        super();
    }
   
}
