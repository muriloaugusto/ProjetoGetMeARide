/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cliente;
import entity.Pessoa;
import entity.Cliente;
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
import ui.CadastroCliente1;
import ui.ConsultaCliente1;

/**
 *
 * @author murilo
 */
public class ClienteDAO {

    public void salvaBD (Cliente cliente){                      
        try{
            Connection con = ConnectBD.getConnnection();
         
            if (ehValidoParaInclusão(cliente).isEmpty()) {
                
                String query = "INSERT INTO cadastroCliente (nome,endereco,telefone,email,CPF,senha) VALUES (?,?,?,?,?,?)";

                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEndereco());
                stmt.setString(3, cliente.getTelefone());
                stmt.setString(4, cliente.getEmail());
                stmt.setString(5, cliente.getCPF());
                stmt.setString(6, cliente.getSenha());

                stmt.executeUpdate();
               
               con.close();
               stmt.close();
               JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
            }else{
                JOptionPane.showMessageDialog(null,ehValidoParaInclusão(cliente));
            }
            
        }catch(SQLException ex){
            System.out.println("ERRO");
        }
    }
   public ResultSet PesquisaBD (String pesquisa){
    // PESQUISAR / SELECIONAR     
       ResultSet rs = null;
       try {
            ConsultaCliente1 daoConsulta = new ConsultaCliente1();
            Connection con2 = ConnectBD.getConnnection();
            String query2 = "SELECT * FROM cadastroCliente WHERE CPF = ? ";
            PreparedStatement stmt2;
            stmt2 = con2.prepareStatement(query2);
            stmt2.setString(1,pesquisa);
            rs= stmt2.executeQuery();
            return rs;
            
                            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO PESQUISAR");
        }
       return rs;
    } 

    public void RemoveBD (String index){
    // DELETAR / EXCLUIR
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "DELETE FROM cadastroCliente WHERE CPF= ? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, index);
            stmt.executeUpdate();        
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
        }
    
    
    }
    public void atualizaBD (String nome,String endereco, String email,String telefone,String CPF){
    // UPDATE 
        ConsultaCliente1 consultaCliente = new ConsultaCliente1();
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "UPDATE cadastroCliente set nome=?,endereco=?,telefone=?,email=?,cpf=? WHERE cpf=? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, telefone);
            stmt.setString(4, email);
            stmt.setString(5, CPF);
            stmt.setString(6, CPF);
           
            stmt.executeUpdate();   
           JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        }
    
    
    }
    
    
    public ArrayList<String> ehValidoParaInclusão(Cliente cliente) {

        ArrayList<String> erros = new ArrayList<String>();
        

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher(cliente.getNome());

       // Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
       
        Pattern p = Pattern.compile("\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b");
        Matcher match_mail = p.matcher(cliente.getEmail());
        
        
        if (match.find() || cliente.getNome().equals("")) {
            erros.add("Nome inválido");
        }

        if (cliente.getEndereco().equals("")) {
            erros.add("Endereço inválido");
        }
        
        if (cliente.getCPF().equals("   -   -   .  ")  ) {
            erros.add("CPF inválido");
        }
        

        if (cliente.getTelefone().equals("(  )     -    ")) {
            erros.add("Telefone inválido");
        }

        if (cliente.getSenha().equals("")) {
            erros.add("Senha vazia");
        }else if (!cliente.getSenha().equals(cliente.getConfirmarSenha())) {
            erros.add("Senhas Diferentes");
        }
        
        if (cliente.getEmail().equals("")) {
            erros.add("Email não encontrado");
        } else if (!match_mail.find()) {
           erros.add("Email invalido");
        }
        return erros;

      }

}
