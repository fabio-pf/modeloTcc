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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Fabio V
 */
@Entity
public class Causas implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_causas", sequenceName = "seq_causas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_causas", strategy = GenerationType.SEQUENCE)
    private Integer id_causa;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 100, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome",length = 100, nullable = false)
    private String nome;
    @NotBlank(message = "A sigla deve ser informada")
    @Length(max = 3, message = "A sigla não deve ter mais que {max} caracteres")
    @Column(name = "sigla",length = 3, nullable = false) 
    private String sigla;
    @NotBlank(message = "A descriçao deve ser informada")
    @Length(max = 200, message = "A descrição não deve ter mais que {max} caracteres")
    @Column(name = "descricao",length = 200, nullable = false) 
    private String descricao;

    public Causas() {
        
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getId_causa() {
        return id_causa;
    }

    public void setId_causa(int id_causa) {
        this.id_causa = id_causa;
    }
    
}
