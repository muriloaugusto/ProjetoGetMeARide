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
import ui.ConsultaTaxista;

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
    
    public void PesquisaBD (){
    // PESQUISAR / SELECIONAR     
       ResultSet rs = null;
       try {
            ConsultaTaxista daoConsulta = new ConsultaTaxista();
            Connection con2 = ConnectBD.getConnnection();
            String query2 = "SELECT * FROM cadastro WHERE nome = ? ";
            PreparedStatement stmt2;
            stmt2 = con2.prepareStatement(query2);
            stmt2.setString(1, daoConsulta.Pesquisar.getText());
            rs= stmt2.executeQuery();
            //modelo da tabela
            DefaultTableModel model = (DefaultTableModel) daoConsulta.jTableConsulta.getModel();
            model.setNumRows(0);    
  
            while(rs.next()){
                model.addRow (
                        new Object[] {
                            rs.getString("id"),
                            rs.getString("nome"),
                            rs.getString("endereco"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("placa"),  
                            rs.getString("senha"),
                        }
                );
           
            }
                  
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTaxista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO aqui");
        }
       
            /*PreparedStatement stmt2;
            stmt2 = con2.prepareStatement(query2);
            stmt2.setString(1, daoConsulta.Pesquisar.getText());  
            ResultSet rs;
            rs= stmt2.executeQuery();
            
            //modelo da tabela
            DefaultTableModel model = (DefaultTableModel) daoConsulta.jTableConsulta.getModel();
            model.setNumRows(0);    
  
            while(rs.next()){
                model.addRow (
                        new Object[] {
                            rs.getString("id"),
                            rs.getString("nome"),
                            rs.getString("endereco"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("placa"),  
                            rs.getString("senha"),
                        }
                );
           
            }
            stmt2.close();
            con2.close(); 
            * /*/
     
    
   
    
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
