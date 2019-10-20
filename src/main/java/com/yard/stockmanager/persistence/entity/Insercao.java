package com.yard.stockmanager.persistence.entity;
// Generated 20/10/2019 19:04:16 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Insercao generated by hbm2java
 */
@Entity
@Table(name="insercao"
    ,catalog="stockmanager"
)
public class Insercao  implements java.io.Serializable {


     private int id;
     private Funcionario funcionario;
     private Date data;
     private char ativo;
     private Set<EstoqueHasProduto> estoqueHasProdutos = new HashSet<EstoqueHasProduto>(0);

    public Insercao() {
    }

	
    public Insercao(int id, Funcionario funcionario, Date data, char ativo) {
        this.id = id;
        this.funcionario = funcionario;
        this.data = data;
        this.ativo = ativo;
    }
    public Insercao(int id, Funcionario funcionario, Date data, char ativo, Set<EstoqueHasProduto> estoqueHasProdutos) {
       this.id = id;
       this.funcionario = funcionario;
       this.data = data;
       this.ativo = ativo;
       this.estoqueHasProdutos = estoqueHasProdutos;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="funcionario_id", nullable=false)
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data", nullable=false, length=19)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    
    @Column(name="ativo", nullable=false, length=1)
    public char getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="insercao")
    public Set<EstoqueHasProduto> getEstoqueHasProdutos() {
        return this.estoqueHasProdutos;
    }
    
    public void setEstoqueHasProdutos(Set<EstoqueHasProduto> estoqueHasProdutos) {
        this.estoqueHasProdutos = estoqueHasProdutos;
    }




}


