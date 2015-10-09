/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pessoa;
import entity.Taxista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.CadastroTaxista;
import ui.ConsultaTaxistas;

/**
 *
 * @author murilo
 */
public class TaxistaDAO {

    public void salvaBD (Taxista taxista){                      
        try{
            Connection con = ConnectBD.getConnnection();
         
            if (!ehValidoParaInclusão(taxista).isEmpty()) {
                
                String query = "INSERT INTO cadastro (nome,endereco,email,telefone,placa,senha) VALUES (?,?,?,?,?,?)";

                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, taxista.getNome());
                stmt.setString(2, taxista.getEndereco());
                stmt.setString(3, taxista.getEmail());
                stmt.setString(4, taxista.getTelefone());
                stmt.setString(5, taxista.getPlaca());
                stmt.setString(6, taxista.getSenha());

                stmt.executeUpdate();
               
               con.close();
               stmt.close();
               JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
            }else{
                JOptionPane.showMessageDialog(null,ehValidoParaInclusão(taxista));
            }
            
        }catch(SQLException ex){
            System.out.println("ERRO");
        }
    }
    
    public ResultSet PesquisaBD (String pesquisa){
    // PESQUISAR / SELECIONAR     
       ResultSet rs = null;
       try {
            ConsultaTaxistas daoConsulta = new ConsultaTaxistas();
            Connection con2 = ConnectBD.getConnnection();
            String query2 = "SELECT * FROM cadastro WHERE nome = ? ";
            PreparedStatement stmt2;
            stmt2 = con2.prepareStatement(query2);
            stmt2.setString(1,pesquisa);
            rs= stmt2.executeQuery();
            return rs;
  
            
                  
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTaxista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO aqui");
        }
       return rs;
    }
    public void RemoveBD (String index){
    // DELETAR / EXCLUIR
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "DELETE FROM cadastro WHERE nome= ? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, index);
            stmt.executeUpdate();        
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
        }
    
    
    }
    public void atualizaBD (String nome,String endereco, String email,String telefone,String placa, String senha){
    // UPDATE 
        ConsultaTaxistas consultaTaxistas = new ConsultaTaxistas();
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "UPDATE cadastro set nome=?,endereco=?,email=?,telefone=?,placa=?,senha=? WHERE placa= ? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, placa);
            stmt.setString(6, senha);
            stmt.setString(7, placa);
            stmt.executeUpdate();        
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
        }
    
    
    }
    
    
    public ArrayList<String> ehValidoParaInclusão(Taxista taxista) {

        ArrayList<String> erros = new ArrayList<String>();
        

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher(taxista.getNome());

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher match_mail = p.matcher(taxista.getEmail());

        if (match.find()) {
            erros.add("Nome inválido");
        }

        if (taxista.getEndereco().equals("")) {
            erros.add("Endereço inválido");
        }
        
        if (taxista.getPlaca().equals("   -    ") ) {
            erros.add("Placa inválida");
        }

        if (taxista.getTelefone().equals("(  )     -    ")) {
            erros.add("Telefone inválido");
        }

        if (taxista.getSenha().equals("")) {
            erros.add("Senha vazia");
        }else if (!taxista.getSenha().equals(taxista.getConfirmarSenha())) {
            erros.add("Senhas Diferentes");
        }
        
        if (taxista.getEmail() == null) {
            erros.add("Email não encontrado");
        } else if (match_mail.find()) {
            erros.add("Email não encontrado");
        }
        return erros;

      }

}
