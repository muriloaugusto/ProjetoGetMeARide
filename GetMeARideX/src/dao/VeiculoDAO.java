/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Veiculo;
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
import ui.CadastroVeiculo;

/**
 *
 * @author murilo
 */
public class VeiculoDAO {

    public void salvaBD (Veiculo veiculo){                      
        try{
            Connection con = ConnectBD.getConnnection();
         
            if (ehValidoParaInclusão(veiculo).isEmpty()) {
                
                String query = "INSERT INTO cadastroveiculo (carro,placa,marca,cor,renavam) VALUES (?,?,?,?,?)";

                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, veiculo.getCarro());
                stmt.setString(2, veiculo.getPlaca());
                stmt.setString(3, veiculo.getMarca());
                stmt.setString(4, veiculo.getCor());
                stmt.setFloat(5, veiculo.getRenavam());
                stmt.executeUpdate();
                
                con.close();
                stmt.close();
                
               JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
            }else{
                JOptionPane.showMessageDialog(null,ehValidoParaInclusão(veiculo));
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
            String query2 = "SELECT * FROM cadastroveiculo WHERE placa = ? ";
            PreparedStatement stmt2;
            stmt2 = con2.prepareStatement(query2);
            stmt2.setString(1,pesquisa);
            rs= stmt2.executeQuery();
            return rs;
            
                            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTaxista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO PESQUISAR");
        }
       return rs;
    }
    public void RemoveBD (String index){
    // DELETAR / EXCLUIR
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "DELETE FROM cadastroveiculo WHERE placa= ? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, index);
            stmt.executeUpdate();        
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
        }
    
    
    }
    public void atualizaBD (String carro,String placa, String marca,String cor,Float renavam){
    // UPDATE 
        ConsultaTaxistas consultaTaxistas = new ConsultaTaxistas();
        try {             
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectBD.getConnnection();
            String query = "UPDATE cadastroveiculo set carro=?,placa=?,marca=?,cor=?,renavam=? WHERE placa=? ";
            com.mysql.jdbc.PreparedStatement stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, carro);
            stmt.setString(2, placa);
            stmt.setString(3, marca);
            stmt.setString(4, cor);
            stmt.setFloat(5, renavam);
            stmt.setString(6, placa);
           
            stmt.executeUpdate();   
           JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException ex) {
            System.err.printf("Ocorreu erro de SQL:" +ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        }
    
    
    }
    
    
    public ArrayList<String> ehValidoParaInclusão(Veiculo veiculo) {

        ArrayList<String> erros = new ArrayList<String>();
        
        CadastroVeiculo v = new CadastroVeiculo();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher(veiculo.getCarro());

        if (match.find() || veiculo.getCarro().equals("")) {
            erros.add("Carro inválido");
        }

        if (veiculo.getMarca().equals("")) {
            erros.add("Marca inválida");
        }
        
        if (veiculo.getPlaca().equals("   -    ")  ) {
            erros.add("Placa inválida");
        }
        
       if (veiculo.getCor().equals("")) {
            erros.add("Cor vazia");
        }
        
         if (v.renavamCampo.getText().equals("")) {
            erros.add("Renavam vazio");
        }
        return erros;

      }

}
