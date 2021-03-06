/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import dao.VeiculoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MURILO
 * 
 */
public class ConsultaVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaVeiculo
     */
    public ConsultaVeiculo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pesquisar = new javax.swing.JTextField();
        txtLabel = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cadastroTaxistaTexto = new javax.swing.JLabel();
        Excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Pesquisar1 = new javax.swing.JTextField();
        txtLabel1 = new javax.swing.JLabel();
        Editar1 = new javax.swing.JButton();
        Buscar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableConsultaVeiculo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cadastroTaxistaTexto1 = new javax.swing.JLabel();
        Excluir1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });

        txtLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtLabel.setText("Digite a placa:");

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Telefone", "E-mail", "Placa"
            }
        ));
        jScrollPane1.setViewportView(jTableConsulta);

        jPanel4.setBackground(new java.awt.Color(51, 153, 0));

        cadastroTaxistaTexto.setBackground(new java.awt.Color(0, 102, 102));
        cadastroTaxistaTexto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastroTaxistaTexto.setText("Consulta Taxista");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(cadastroTaxistaTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(cadastroTaxistaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Obs: Digite a placa (exemplo: DDD-4545)");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pesquisar1ActionPerformed(evt);
            }
        });

        txtLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtLabel1.setText("Digite a placa:");

        Editar1.setText("Editar");
        Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar1ActionPerformed(evt);
            }
        });

        Buscar1.setText("Buscar");
        Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar1ActionPerformed(evt);
            }
        });

        jTableConsultaVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Carro", "Marca", "Cor", "Placa", "Renavam"
            }
        ));
        jScrollPane2.setViewportView(jTableConsultaVeiculo);

        jPanel5.setBackground(new java.awt.Color(51, 153, 0));

        cadastroTaxistaTexto1.setBackground(new java.awt.Color(0, 102, 102));
        cadastroTaxistaTexto1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastroTaxistaTexto1.setText("Consulta Veículo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(cadastroTaxistaTexto1)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(cadastroTaxistaTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Excluir1.setText("Excluir");
        Excluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Obs: Digite a placa (exemplo: DDD-4545)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Excluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Pesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLabel1)
                    .addComponent(Buscar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excluir1)
                    .addComponent(Editar1))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed

   }//GEN-LAST:event_PesquisarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       
    }//GEN-LAST:event_EditarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
   
    }//GEN-LAST:event_BuscarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
      
    }//GEN-LAST:event_ExcluirActionPerformed

    private void Pesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pesquisar1ActionPerformed

   }//GEN-LAST:event_Pesquisar1ActionPerformed

    private void Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar1ActionPerformed
        // EDITAR
        VeiculoDAO daoVeiculo = new VeiculoDAO();
        String carro, marca, cor, placa;
        Float renavam;
        carro = (String) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 0);
        marca = (String) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 1);
        cor = (String) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 2);
        placa = (String) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 3);
        renavam = (Float) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 4);
        daoVeiculo.atualizaBD(carro, placa, marca, cor, renavam);
    }//GEN-LAST:event_Editar1ActionPerformed

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        VeiculoDAO daoAutomovel = new VeiculoDAO();
        ResultSet rs;
        String s = Pesquisar1.getText();
        try {
            rs = daoAutomovel.PesquisaBD(s);
            //modelo da tabela
            DefaultTableModel model = (DefaultTableModel) jTableConsultaVeiculo.getModel();
            model.setNumRows(0);
            while (rs.next()) {
                model.addRow(
                        new Object[]{
                            //   rs.getString("id"),
                            rs.getString("carro"),
                            rs.getString("marca"),
                            rs.getString("cor"),
                            rs.getString("placa"),
                            rs.getFloat("renavam"),
                           
                        });

            }
        } catch (Exception e) {
            System.out.println("Parou aqui no BUSCAR");
        }
    }//GEN-LAST:event_Buscar1ActionPerformed

    private void Excluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir1ActionPerformed
        // DELETAR / EXCLUIR
        VeiculoDAO daocarro = new VeiculoDAO();
        ResultSet rs2;
        String s2 = Pesquisar1.getText();
        try {
            String index;
            index = (String) jTableConsultaVeiculo.getModel().getValueAt(jTableConsultaVeiculo.getSelectedRow(), 3);
            daocarro.RemoveBD(index);

            // UPDATE DADOS
            try {
                rs2 = daocarro.PesquisaBD(s2);
                //modelo da tabela
                DefaultTableModel model = (DefaultTableModel) jTableConsultaVeiculo.getModel();
                model.setNumRows(0);
                while (rs2.next()) {
                    model.addRow(
                            new Object[]{
                            rs2.getString("carro"),
                            rs2.getString("placa"),
                            rs2.getString("marca"),
                            rs2.getString("cor"),
                            rs2.getFloat("renavam"),
                            
                            });

                }
            } catch (Exception e) {
                System.out.println("Parou no Excluir");
            }

        } catch (Exception ex) {
            System.err.printf("Ocorreu um erro");
        }
    }//GEN-LAST:event_Excluir1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaVeiculo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Buscar1;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Editar1;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Excluir1;
    public javax.swing.JTextField Pesquisar;
    public javax.swing.JTextField Pesquisar1;
    private javax.swing.JLabel cadastroTaxistaTexto;
    private javax.swing.JLabel cadastroTaxistaTexto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTableConsulta;
    public javax.swing.JTable jTableConsultaVeiculo;
    private javax.swing.JLabel txtLabel;
    private javax.swing.JLabel txtLabel1;
    // End of variables declaration//GEN-END:variables
}
