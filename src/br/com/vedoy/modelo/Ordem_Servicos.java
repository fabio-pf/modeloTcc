/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vedoy.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
    @Column(name = "observacoes", columnDefinition = "text")
    private String Observacoes;
    
    @ManyToMany
    @JoinTable(name = "os_sintomas",
            joinColumns
            = @JoinColumn(name = "ordem_servicos", referencedColumnName = "id_os", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "sintomas", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_os_sintomas",
                        columnNames = {"os", "sintoma"})})
    private List<Sintomas> os_sintomas = new ArrayList<>();
    
   @ManyToMany
    @JoinTable(name = "os_causas",
            joinColumns
            = @JoinColumn(name = "ordem_servicos", referencedColumnName = "id_os", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "causas", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_os_causas",
                        columnNames = {"os", "causa"})})
    private List<Causas> os_causas = new ArrayList<>();

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

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }

    public Usuarios getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuarios tecnico) {
        this.tecnico = tecnico;
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

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public List<Sintomas> getOs_sintomas() {
        return os_sintomas;
    }

    public void setOs_sintomas(List<Sintomas> os_sintomas) {
        this.os_sintomas = os_sintomas;
    }

    public List<Causas> getOs_causas() {
        return os_causas;
    }

    public void setOs_causas(List<Causas> os_causas) {
        this.os_causas = os_causas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_os;
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
        final Ordem_Servicos other = (Ordem_Servicos) obj;
        if (this.id_os != other.id_os) {
            return false;
        }
        return true;
    }
    
    
   
   
    
}
