/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Fabio V
 */
@Entity
public class Ordem_Servicos implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_os", sequenceName = "seq_os_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_os", strategy = GenerationType.SEQUENCE)
    private int id_os;
    @NotNull(message = "O tipo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "tipoOS")
    private Categorias tipo;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao_servico;
    @NotNull(message = "O produto não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "produto")
    private Produtos produto;
    @NotNull(message = "A prioridade deve ser definida")
    private int prioridade;
    @NotNull(message = "O status deve ser definido")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_clientes")    
    private Usuarios cliente;
    @ManyToOne
    @JoinColumn(name = "id_tecnico")    
    private Usuarios tecnico;
    @NotNull(message = "Data de início não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio", nullable = false)
    private Calendar inicio;
    @NotNull(message = "Data de fim não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "fim", nullable = false)
    private Calendar fim;
    @ManyToOne
    @JoinColumn(name = "id_causa")
    private Causas causa;
    @ManyToOne
    @JoinColumn(name = "id_sintoma")
    private Sintomas sintoma;
    @Column(name = "observacoes", columnDefinition = "text")
    private String Observacoes;

    public Ordem_Servicos() {
    }

    public int getId_os() {
        return id_os;
    }

    public void setId_os(int id_os) {
        this.id_os = id_os;
    }

    public Categorias getTipo() {
        return tipo;
    }

    public void setTipo(Categorias tipo) {
        this.tipo = tipo;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   


    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
    }

    public Causas getCausa() {
        return causa;
    }

    public void setCausa(Causas causa) {
        this.causa = causa;
    }

    public Sintomas getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintomas sintoma) {
        this.sintoma = sintoma;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    
    
    
    
    
}
