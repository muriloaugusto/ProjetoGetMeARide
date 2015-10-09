/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ricardo e Murilo
 */
public class Pessoa {
    
    private String nome;
    private String endereço;
    private String Telefone;
    private String email;
    private String senha;
    private String confirmarSenha;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereço
     */
    public String getEndereco() {
        return endereço;
    }

    /**
     * @param endereço the endereço to set
     */
    public void setEndereco(String endereço) {
        this.endereço = endereço;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha.toString();
    }

    /**
     * @return the confirmarSenha
     */
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    /**
     * @param confirmarSenha the confirmarSenha to set
     */
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha.toString();
    }
    
    
}
