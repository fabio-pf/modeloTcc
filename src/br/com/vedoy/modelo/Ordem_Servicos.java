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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Fabio V
 */
@Entity
public class Ordem_Servicos implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_os", sequenceName = "seq_os_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_os", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O tipo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "tipo_OS")
    private Categorias tipo_OS;
    @NotNull(message = "A descrição não pode ser nula")
    @Column(name = "descricao", nullable = false, length = 200, columnDefinition = "text")
    private String descricao_servico;
    @NotNull(message = "O produto não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "produto")
    private Produtos produto;
    @NotNull(message = "A prioridade deve ser definida")
    private int prioridade;
    private boolean status;
    @ManyToOne
    @NotNull(message = "Cliente não pode ser nulo")
    @JoinColumn(name = "cliente") 
    private Pessoas cliente;
    @ManyToOne
    @JoinColumn(name = "tecnico")   
    private Pessoas tecnico;
    @ManyToOne
    @NotNull(message = "Atendente não pode ser nulo")
    @JoinColumn(name = "atendente")    
    private Pessoas atendente;
    @NotNull(message = "Data de início não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio", nullable = false)
    private Calendar inicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fim")
    private Calendar fim;
    @Column(name = "observacoes", columnDefinition = "text", length = 100)
    private String Observacoes;
    @ManyToOne
    @JoinColumn(name = "causaPrincipal")    
    private Causas causaPrincipal;
    @ManyToOne
    @NotNull(message = "Sintoma não pode ser nulo")
    @JoinColumn(name = "sintomaPrincipal")  
    private Sintomas sintomaPrincipal;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "os_sintomas",
            joinColumns
            = @JoinColumn(name = "ordem_servicos", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "sintomas", referencedColumnName = "id_sint", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_os_sintomas",
                        columnNames = {"ORDEM_SERVICOS", "SINTOMAS"})})
    private List<Sintomas> os_sintomas = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "os_causas",
            joinColumns
            = @JoinColumn(name = "ordem_servicos", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "causas", referencedColumnName = "id_causa", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_os_causas",
                        columnNames = {"ORDEM_SERVICOS", "CAUSAS"})})
    private List<Causas> os_causas = new ArrayList<>();

    public Ordem_Servicos() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categorias getTipo_OS() {
        return tipo_OS;
    }

    public void setTipo_OS(Categorias tipo_OS) {
        this.tipo_OS = tipo_OS;
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

    public Pessoas getCliente() {
        return cliente;
    }

    public void setCliente(Pessoas cliente) {
        this.cliente = cliente;
    }

    public Pessoas getTecnico() {
        return tecnico;
    }

    public void setTecnico(Pessoas tecnico) {
        this.tecnico = tecnico;
    }

    public Pessoas getAtendente() {
        return atendente;
    }

    public void setAtendente(Pessoas atendente) {
        this.atendente = atendente;
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

    public Causas getCausaPrincipal() {
        return causaPrincipal;
    }

    public void setCausaPrincipal(Causas causaPrincipal) {
        this.causaPrincipal = causaPrincipal;
    }

    public Sintomas getSintomaPrincipal() {
        return sintomaPrincipal;
    }

    public void setSintomaPrincipal(Sintomas sintomaPrincipal) {
        this.sintomaPrincipal = sintomaPrincipal;
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

    
   
}
