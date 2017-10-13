/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabio V
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuarios implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @NotNull(message = "O nome deve ser informado")
    @Column(name = "usuario", length = 50)
    private String usuario;
    @NotNull(message = "A senha deve ser informada")
    @Column(name = "senha", length = 50)
    private String senha;
    @NotNull(message = "A senha deve ser informada")
    @ManyToOne
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "nome",
            foreignKey = @ForeignKey(name = "fk_usuario_tipo"))
    private Tipo_Usuario tipo;
    
    @ManyToMany
    @JoinTable(name = "tipos_usuario",
            joinColumns
            = @JoinColumn(name = "usuarios", referencedColumnName = "usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "tipo_usuario", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_tipos_usuarios",
                        columnNames = {"usuarios", "tipo_usuario"})})
    private List<Tipo_Usuario> tipos_usuario = new ArrayList<>();

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

    public Tipo_Usuario getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Usuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    
}
