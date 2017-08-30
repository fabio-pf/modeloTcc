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
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Fabio V
 */
@Entity
@Table(name = "produto")
public class Produtos implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id_prod;
    @NotBlank(message = "O nome deve ser informada")
    @Length(max = 40, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome",length = 40, nullable = false)
    private String nome;
    @NotBlank(message = "A sigla deve ser informada")
    @Length(max = 3, message = "A sigla não deve ter mais que {max} caracteres")
    @Column(name = "sigla",length = 3, nullable = false) 
    private String sigla;
    @NotBlank(message = "A descriçao deve ser informada")
    @Length(max = 100, message = "A descrição não deve ter mais que {max} caracteres")
    @Column(name = "descricao",length = 100, nullable = false) 
    private String descricao;

    public Produtos() {
        
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_prod;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produtos other = (Produtos) obj;
        if (this.id_prod != other.id_prod) {
            return false;
        }
        return true;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
    
    
    
}
