/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2;

import entidades.DESCUENTO;
import entidades.TIENDA;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.driver.OracleConnection;
import sqlj.runtime.ref.DefaultContext;

/**
 *
 * @author DanMoCa14z
 */
public class Discounts extends javax.swing.JFrame {

    /**
     * Creates new form Discounts
     */
    public Discounts() {
        initComponents();
        loadDiscounts();
        fillComboTienda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTxtFldCantAlta = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTxtFldDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtFldTipoDescuento = new javax.swing.JTextField();
        jTxtFldCantBaja = new javax.swing.JTextField();
        jLblTienda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("( ͡° ͜ʖ ͡°) - Descuentos");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTxtFldCantAlta.setMinimumSize(new java.awt.Dimension(150, 23));
        jTxtFldCantAlta.setPreferredSize(new java.awt.Dimension(150, 23));

        jComboBox1.setMinimumSize(new java.awt.Dimension(28, 23));
        jComboBox1.setName(""); // NOI18N
        jComboBox1.setPreferredSize(new java.awt.Dimension(28, 23));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTxtFldDescuento.setMinimumSize(new java.awt.Dimension(150, 23));
        jTxtFldDescuento.setPreferredSize(new java.awt.Dimension(150, 23));

        jLabel1.setText("Tipo de Descuento");

        jLabel2.setText("ID Tienda");

        jLabel3.setText("Cantidad Baja");

        jLabel4.setText("Cantidad Alta");

        jLabel5.setText("Descuento");

        jTxtFldTipoDescuento.setMinimumSize(new java.awt.Dimension(150, 23));
        jTxtFldTipoDescuento.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldCantBaja.setMinimumSize(new java.awt.Dimension(150, 23));
        jTxtFldCantBaja.setPreferredSize(new java.awt.Dimension(150, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFldCantBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtFldCantAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtFldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtFldTipoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFldTipoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLblTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtFldCantBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFldCantAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtFldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar Cambios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fillFields();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        try {
            if (jComboBox1.getSelectedItem() instanceof TIENDA){
                TIENDA p = (TIENDA)jComboBox1.getSelectedItem();
                jLblTienda.setText(p.getStorName());
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        fillFields();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        newDiscount();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateDiscount();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteDiscount();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void clearFields(){
        jTxtFldCantAlta.setText("");
        jTxtFldCantBaja.setText("");
        jTxtFldDescuento.setText("");
        jTxtFldTipoDescuento.setText("");
        jComboBox1.removeAllItems();
        fillComboTienda();
        jLblTienda.setText("");
    }
    
    public void fillFields(){
         DESCUENTO x;
        x = (DESCUENTO) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        TIENDA ti = (TIENDA) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        try {
            this.jTxtFldTipoDescuento.setText(((x.getDiscounttype()) != null) ? x.getDiscounttype() + "" : "");
            for(int i = 0; i < jComboBox1.getItemCount(); i++){
                if (ti == null){
                    jComboBox1.setSelectedIndex(0);
                    jLblTienda.setText("");
                    break;
                }
                if (jComboBox1.getItemAt(i) instanceof TIENDA &&
                        ti.getStorId().equals(((TIENDA)jComboBox1.getItemAt(i)).getStorId())){
                    jComboBox1.setSelectedIndex(i);
                    break;
                }
            }
            this.jTxtFldCantBaja.setText(((x.getLowqty()) != null) ? x.getLowqty() + "" : "");
            this.jTxtFldCantAlta.setText(((x.getHighqty()) != null) ? x.getHighqty() + "" : "");
            this.jTxtFldDescuento.setText(((x.getDiscount()) != null) ? x.getDiscount() + "" : "");
        } catch (SQLException ex) {
            Logger.getLogger(Discounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fillComboTienda() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(TIENDA._SQL_NAME, TIENDA.class);
            
            ResultSet rs = st.executeQuery("SELECT value(a) FROM tiendas a ORDER BY a.STOR_ID");
            
            jComboBox1.addItem("Seleccione Tianguis");
            while (rs.next()) {                
                TIENDA p = (TIENDA) rs.getObject(1);
                
                jComboBox1.addItem(p);
            }
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void loadDiscounts() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(DESCUENTO._SQL_NAME, DESCUENTO.class);

            String[] columns = {
                "Tipo de Descuneto", "ID Tienda", "Cantidad Baja", "Cantidad Alta", "Descuento"
            };

            ResultSet rs = st.executeQuery("SELECT value(a) FROM descuentos a");
            DefaultTableModel tm = new DefaultTableModel(null, columns) {
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };

            while (rs.next()) {
                DESCUENTO p = (DESCUENTO) rs.getObject(1);

                TIENDA t = null;
                try {
                    t = p.getRefStor().getValue();
                } catch (java.lang.NullPointerException nipex) {
                    t = null;
                }

                Object[] row = {
                    p, t, p.getLowqty(), p.getHighqty(), p.getDiscount()
                };

                tm.addRow(row);
            }
            jTable1.setModel(tm);
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void newDiscount(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(DESCUENTO._SQL_NAME, DESCUENTO.class);
            map.put(TIENDA._SQL_NAME, TIENDA.class);
            DefaultContext dc = new DefaultContext(conn);

            DESCUENTO p = new DESCUENTO();
            p.setConnectionContext(dc);

            p.setHighqty(new BigDecimal(jTxtFldCantAlta.getText()));
            p.setLowqty(new BigDecimal(jTxtFldCantBaja.getText()));            
            p.setDiscounttype(jTxtFldTipoDescuento.getText());
            p.setDiscount(new BigDecimal(jTxtFldDescuento.getText()));
            
            TIENDA t = (TIENDA)jComboBox1.getSelectedItem();
            t.setConnectionContext(dc);
            p.setRefStor(t.getref());
            
            p.guardar();
            loadDiscounts();
            clearFields();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void updateDiscount(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(DESCUENTO._SQL_NAME, DESCUENTO.class);
            map.put(TIENDA._SQL_NAME, TIENDA.class);
            DefaultContext dc = new DefaultContext(conn);

            DESCUENTO p = new DESCUENTO();
            p.setConnectionContext(dc);
            
            p = (DESCUENTO)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            
            p.setHighqty(new BigDecimal(jTxtFldCantAlta.getText()));
            p.setLowqty(new BigDecimal(jTxtFldCantBaja.getText()));            
            p.setDiscounttype(jTxtFldTipoDescuento.getText());
            p.setDiscount(new BigDecimal(jTxtFldDescuento.getText()));
            
            TIENDA t = (TIENDA)jComboBox1.getSelectedItem();
            t.setConnectionContext(dc);
            p.setRefStor(t.getref());
            
            p.guardar();
            loadDiscounts();
            clearFields();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void deleteDiscount(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(DESCUENTO._SQL_NAME, DESCUENTO.class);
            DefaultContext dc = new DefaultContext(conn);

            DESCUENTO p = new DESCUENTO();
            p.setConnectionContext(dc);
            
            p = (DESCUENTO)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            
            p.borrar();
            loadDiscounts();
            clearFields();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Discounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Discounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Discounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Discounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Discounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblTienda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtFldCantAlta;
    private javax.swing.JTextField jTxtFldCantBaja;
    private javax.swing.JTextField jTxtFldDescuento;
    private javax.swing.JTextField jTxtFldTipoDescuento;
    // End of variables declaration//GEN-END:variables
}
