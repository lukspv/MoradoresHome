/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.dao.MoradorDao;
import modelo.dao.ApartamentoDao;
import modelo.entidade.Apartamento;
import modelo.entidade.Morador;

/**
 *
 * @author Lucas
 */
public class TelaListaMoradores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListaMoldelo
     */
    public TelaListaMoradores() {
        initComponents();
        preencherComboApartamento(jCapartamento);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTdescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTmodelo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTcpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCapartamento = new javax.swing.JComboBox<>();
        jTtel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBalterar = new javax.swing.JButton();
        jBexcluir = new javax.swing.JButton();
        jBpdf = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Listar Moradores");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Informe o CPF");

        jTdescricao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTdescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdescricaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTdescricao))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTmodelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Apartamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTmodelo.getTableHeader().setReorderingAllowed(false);
        jTmodelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTmodeloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTmodelo);
        if (jTmodelo.getColumnModel().getColumnCount() > 0) {
            jTmodelo.getColumnModel().getColumn(0).setResizable(false);
            jTmodelo.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTmodelo.getColumnModel().getColumn(1).setResizable(false);
            jTmodelo.getColumnModel().getColumn(1).setPreferredWidth(240);
            jTmodelo.getColumnModel().getColumn(2).setResizable(false);
            jTmodelo.getColumnModel().getColumn(2).setPreferredWidth(240);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CPF");

        jTcpf.setEditable(false);
        jTcpf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome");

        jTnome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apartamento");

        jCapartamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCapartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));

        jTtel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefone");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTnome)
                    .addComponent(jCapartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTtel, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCapartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBalterar.setBackground(new java.awt.Color(255, 102, 0));
        jBalterar.setText("Alterar");
        jBalterar.setEnabled(false);
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        jBexcluir.setBackground(new java.awt.Color(255, 0, 0));
        jBexcluir.setText("Excluir");
        jBexcluir.setEnabled(false);
        jBexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexcluirActionPerformed(evt);
            }
        });

        jBpdf.setBackground(new java.awt.Color(51, 51, 255));
        jBpdf.setText("Export Todos Cadastros");
        jBpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBalterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTdescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdescricaoKeyReleased

        preencherTabelaMorador();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTdescricaoKeyReleased

    private void jTmodeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTmodeloMouseClicked

        buscarModelo();

        // TODO add your handling code here:
    }//GEN-LAST:event_jTmodeloMouseClicked

    private void jBpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpdfActionPerformed

        try {
            exportarPDF();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaListaMoradores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBpdfActionPerformed

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexcluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_jBexcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBexcluir;
    private javax.swing.JButton jBpdf;
    private javax.swing.JComboBox<String> jCapartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTcpf;
    private javax.swing.JTextField jTdescricao;
    private javax.swing.JTable jTmodelo;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTtel;
    // End of variables declaration//GEN-END:variables

    private void preencherTabelaMorador() {
        limpartabela();
        try {
            String des = jTdescricao.getText();
            List<Morador> lista = new MoradorDao().listarTodos(des);
            DefaultTableModel tabela = (DefaultTableModel) jTmodelo.getModel();
            for (Morador m : lista) {
                tabela.addRow(new Object[]{m.getmocpf(), m.getmonome(), m.getapartemento().getapnumero()});

            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaListaMoradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpartabela() {

        while (jTmodelo.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTmodelo.getModel()).removeRow(0);
        }

    }//fim

    public void preencherComboApartamento(JComboBox combo) {
        ApartamentoDao fdao = new ApartamentoDao();

        try {
            List<Apartamento> lista = fdao.listarTodos();

            for (Apartamento fab : lista) {
                combo.addItem(fab);
            }
        } catch (SQLException ex) {

            System.out.println("Erro ao recuperar");
        }

    }

    private void buscarModelo() {
        int linha = jTmodelo.getSelectedRow();
        String codigo = (String.valueOf(jTmodelo.getValueAt(linha, 0)));

        try {

            Morador modelo = new MoradorDao().buscar(codigo);
            jTcpf.setText(String.valueOf(modelo.getmocpf()));
            jTnome.setText(modelo.getmonome());
            jTtel.setText(modelo.getmofone());
            jCapartamento.getModel().setSelectedItem(modelo.getapartemento());
            jBalterar.setEnabled(true);
            jBexcluir.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(TelaListaMoradores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim

    private void alterar() {

        MoradorDao mdao = new MoradorDao();
        Morador mod = new Morador();

        mod.setmocpf(jTcpf.getText());
        mod.setmonome(jTnome.getText());
        mod.setmofone(jTtel.getText());

        Apartamento fab = (Apartamento) jCapartamento.getSelectedItem();

        mod.setapartemento(fab);

        jTnome.setText("");
        jTcpf.setText("");
        jTtel.setText("");
        jTdescricao.setText("");

        jCapartamento.setSelectedIndex(0);
        jTnome.requestFocus();

        try {
            mdao.alterar(mod);

            System.out.println("Salvo com Sucesso");
        } catch (SQLException ex) {
            System.out.println("Não salvou");;
        }
    }

    private void excluir() {

        MoradorDao mdao = new MoradorDao();
        //Morador mod = new Morador();
        String cpf = jTcpf.getText();

        //Apartamento fab = (Apartamento) jCapartamento.getSelectedItem();
        //mod.setapartemento(fab);
        jTnome.setText("");
        jTcpf.setText("");
        jTtel.setText("");
        jTdescricao.setText("");

        jCapartamento.setSelectedIndex(0);
        jTnome.requestFocus();

        try {
            mdao.excluir(cpf);

            System.out.println("Salvo com Sucesso");
        } catch (SQLException ex) {
            System.out.println("Não salvou");;
        }

    }

    private void exportarPDF() throws FileNotFoundException {

        MoradorDao m = new MoradorDao();

        try {
            m.relatorio();
        } catch (SQLException ex) {
            Logger.getLogger(TelaListaMoradores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
