/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Fabio V
 */
@Entity
public class Pessoas extends Usuarios implements Serializable{
    
    @NotBlank(message = "O nome deve ser informada")
    @Length(max = 100, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome",length = 100, nullable = false) 
    private String nome;
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 200, message = "O endereço não deve ter mais que {max} caracteres")
    @Column(name = "endereco",length = 200, nullable = false) 
    private String endereco;
    @NotBlank(message = "A cidade deve ser informada")
    @Length(max = 40, message = "A cidade não deve ter mais que {max} caracteres")
    @Column(name = "cidade",length = 40, nullable = false) 
    private String cidade;
    @NotBlank(message = "O CPF deve ser informado")
    @CPF(message = "O cpf deve ser valido")
    @Length(max = 14, message = "O CPF não deve ter mais que {max} caracteres")
    @Column(name = "cpf",length = 14, nullable = false) 
    private String cpf;
    @NotBlank(message = "O RG deve ser informado")
    @Length(max = 12, message = "O RG não deve ter mais que {max} caracteres")
    @Column(name = "rg",length = 12, nullable = false) 
    private String rg;
    @Column(name = "nascimento",length = 8, nullable = false) 
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 80, message = "email não deve ter mais que {max} caracteres")
    @Column(name = "email",length = 80, nullable = false) 
    private String email;
    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 14, message = "O telefone não deve ter mais que {max} caracteres")
    @Column(name = "T_celular",length = 14, nullable = false) 
    private String T_celular;
    @Length(max = 14, message = "O telefone não deve ter mais que {max} caracteres")
    @Column(name = "T_Fixo",length = 14) 
    private String T_fixo;
    @ManyToOne
    @JoinColumn(name = "categorias", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_tecnico_categoria"))
    private Categorias categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getT_celular() {
        return T_celular;
    }

    public void setT_celular(String T_celular) {
        this.T_celular = T_celular;
    }

    public String getT_fixo() {
        return T_fixo;
    }

    public void setT_fixo(String T_fixo) {
        this.T_fixo = T_fixo;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        final Pessoas other = (Pessoas) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
        
    

    
    
}
