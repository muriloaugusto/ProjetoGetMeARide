/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pessoa;
import entity.Taxista;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ricardo
 */
public class TaxistaDAO {

    public ArrayList<String> ehValidoParaInclusão(Taxista taxista) {

        ArrayList<String> erros = new ArrayList<String>();

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher(taxista.getNome());

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher match_mail = p.matcher(taxista.getEmail());

        if (match.find()) {
            erros.add("Nome inválido");
        }

        if (taxista.getEndereço().equals("")) {
            erros.add("Endereço inválido");
        }

        if (taxista.getPlaca().equals("   -    ")) {
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
