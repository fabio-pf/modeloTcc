/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Fabio V
 */
@Entity
@DiscriminatorValue(value = "tec")
public class Tecnicos  extends Pessoas implements Serializable{

    
    
    @ManyToOne
    @JoinColumn(name = "cota")
    private Cotas cota;
    @ManyToOne
    @JoinColumn(name = "categoria" )
    private Categorias categoria;

    public Tecnicos() {
        super();
    }

    public Cotas getCota() {
        return cota;
    }

    public void setCota(Cotas cota) {
        this.cota = cota;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }
    
    
  
}
