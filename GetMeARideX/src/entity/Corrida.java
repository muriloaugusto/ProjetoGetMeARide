/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 */
public class Corrida {

    private String origem;
    private String destino;
    private Cliente cliente;
    private Taxista taxista;
    private int kilometroPercorrido;
    private int bandeira; /*indica o valor do kilometro rodado*/

    private int hora;
    private double tarifa;

    public Corrida(String origem, String destino, Cliente cliente, Taxista taxista) {
        this.origem = origem;
        this.destino = destino;
        this.cliente = cliente;
        this.taxista = taxista;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the taxista
     */
    public Taxista getTaxista() {
        return taxista;
    }

    /**
     * @param taxista the taxista to set
     */
    public void setTaxista(Taxista taxista) {
        this.taxista = taxista;
    }

    public double calculaTarifa() {
        switch (bandeira) {
            case 1: /*comum*/

                return tarifa + kilometroPercorrido * (2.75);
            case 2: /*especial*/

                return tarifa + kilometroPercorrido * (3.58);
            case 3: /*luxo*/

                return tarifa + kilometroPercorrido * (4.15);
        }
        return -1;
    }

    public void imprimeRecibo() {
        String comprovante = "";
        comprovante += "---------------Taxista-------------\n";
        comprovante += "Taxista : " + taxista.getNome() + "\n";
        comprovante += "Placa : " + taxista.getPlaca() + "\n";
        comprovante += "---------------Cliente--------------\n";
        comprovante += "Cliente : " + cliente.getNome() + "\n";
        comprovante += "CPF : " + cliente.getEmail() + "\n";
        comprovante += "---------------Corrida--------------\n";
        comprovante += "Origem : " + origem + "\n";
        comprovante += "Destino : " + destino + "\n";
        comprovante += "Hora : " + hora + "\n";
        comprovante += "Distância : " + kilometroPercorrido + "Km\n";
        comprovante += "Valor : R$ " + calculaTarifa() + "\n";
        JOptionPane.showMessageDialog(new JFrame("Comprovante de corrida"), comprovante);
    }

    public void inicia() {
        kilometroPercorrido = 0;
        tarifa = 4.5;
    }

    public void finaliza() {
        kilometroPercorrido = 80;
        bandeira = 1;
        imprimeRecibo();
    }
}