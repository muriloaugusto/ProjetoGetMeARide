/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ricardo
 */
public class Cliente extends Pessoa {
     private String CPF;
    
    public Cliente(){
        CPF = "";
    }

    /**
     * @return the placa
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param placa the placa to set
     */
    public void setCPF(String cpf) {
        this.CPF = cpf;
    }
    
  
}
