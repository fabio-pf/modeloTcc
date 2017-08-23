
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "Tipo_Usuario")
public class Tipo_Usuario implements Serializable {
    @Id
    @Column(name = "nome", length = 30, nullable = false)      
    private String nome;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 40, message = "A descrição não deve ter mais que {max} caracteres")
    @Column(name = "descricao",length = 40, nullable = false)    
    private String descricao;
    
    public Tipo_Usuario() {
        super();
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        final Tipo_Usuario other = (Tipo_Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}