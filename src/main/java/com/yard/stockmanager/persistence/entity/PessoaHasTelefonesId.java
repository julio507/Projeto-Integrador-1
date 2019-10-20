package com.yard.stockmanager.persistence.entity;
// Generated 20/10/2019 19:04:16 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PessoaHasTelefonesId generated by hbm2java
 */
@Embeddable
public class PessoaHasTelefonesId  implements java.io.Serializable {


     private int pessoaId;
     private int telefonesId;

    public PessoaHasTelefonesId() {
    }

    public PessoaHasTelefonesId(int pessoaId, int telefonesId) {
       this.pessoaId = pessoaId;
       this.telefonesId = telefonesId;
    }
   


    @Column(name="pessoa_id", nullable=false)
    public int getPessoaId() {
        return this.pessoaId;
    }
    
    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }


    @Column(name="telefones_id", nullable=false)
    public int getTelefonesId() {
        return this.telefonesId;
    }
    
    public void setTelefonesId(int telefonesId) {
        this.telefonesId = telefonesId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PessoaHasTelefonesId) ) return false;
		 PessoaHasTelefonesId castOther = ( PessoaHasTelefonesId ) other; 
         
		 return (this.getPessoaId()==castOther.getPessoaId())
 && (this.getTelefonesId()==castOther.getTelefonesId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPessoaId();
         result = 37 * result + this.getTelefonesId();
         return result;
   }   


}


