/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fabio V
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 3, discriminatorType = DiscriminatorType.STRING)
public abstract class Usuarios implements Serializable{
   
    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String usuario;
    private String senha;
    @ManyToMany
    @JoinTable(name = "tipos_usuario",
            joinColumns
            = @JoinColumn(name = "usuario", referencedColumnName = "usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "tipo_usuario", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_tipos_usuarios",
                        columnNames = {"usuario", "tipo_usuario"})})
    private List<Tipo_Usuario> tipos_usuario = new ArrayList<>();
        
    public Usuarios() {
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tipo_Usuario> getTipos_usuario() {
        return tipos_usuario;
    }

    public void setTipos_usuario(List<Tipo_Usuario> tipos_usuario) {
        this.tipos_usuario = tipos_usuario;
    }

    
    
    
}
