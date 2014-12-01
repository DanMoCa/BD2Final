/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2;

import entidades.EDITORIAL;
import entidades.EMPLEADO;
import entidades.PUESTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Employee extends javax.swing.JFrame {

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        loadEmployee();
        fillComboPuesto();
        fillComboEditorial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtFldIdEmpleado = new javax.swing.JTextField();
        jTxtFldName = new javax.swing.JTextField();
        jTxtFldMinit = new javax.swing.JTextField();
        jTxtFldApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtFldNivelPuesto = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jCBPuesto = new javax.swing.JComboBox();
        jLblJobDesc = new javax.swing.JLabel();
        jCBEditorial = new javax.swing.JComboBox();
        jLblEditorial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("( ͡° ͜ʖ ͡°)");

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
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setText("ID Empleado");

        jLabel2.setText("Nombre");

        jLabel3.setText("Minint");

        jLabel4.setText("Apellido");

        jTxtFldIdEmpleado.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldName.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldMinit.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldApellido.setPreferredSize(new java.awt.Dimension(150, 23));

        jLabel5.setText("ID Puesto");

        jLabel6.setText("Nivel Puesto");

        jLabel7.setText("ID Editorial");

        jLabel8.setText("Fecha de Empleo");

        jTxtFldNivelPuesto.setPreferredSize(new java.awt.Dimension(150, 23));

        jCBPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPuestoActionPerformed(evt);
            }
        });

        jCBEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtFldIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtFldMinit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtFldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtFldNivelPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBEditorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLblJobDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtFldIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtFldMinit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblJobDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldNivelPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        String formats = "yyyy-MM-dd";

        this.jXDatePicker1.setFormats(formats);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        EMPLEADO x;
        x = (EMPLEADO) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        PUESTO t = (PUESTO) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
        EDITORIAL e = (EDITORIAL) jTable1.getValueAt(jTable1.getSelectedRow(), 6);

        try {
            this.jTxtFldIdEmpleado.setText(((x.toString()) != null) ? x.toString() + "" : "");
            this.jTxtFldName.setText(((x.getFname()) != null) ? x.getFname() + "" : "");
            this.jTxtFldMinit.setText(((x.getMinit()) != null) ? x.getMinit() + "" : "");
            this.jTxtFldApellido.setText(((x.getLname()) != null) ? x.getLname() + "" : "");
            for (int i = 0; i < jCBPuesto.getItemCount(); i++) {
                if (t == null) {
                    jCBPuesto.setSelectedIndex(0);
                    jLblJobDesc.setText("");
                    break;
                }
                if (jCBPuesto.getItemAt(i) instanceof PUESTO
                        && t.getJobId().equals(((PUESTO) jCBPuesto.getItemAt(i)).getJobId())) {
                    jCBPuesto.setSelectedIndex(i);
                    break;
                }
            }
            this.jCBPuesto.setSelectedItem((t));
            this.jTxtFldNivelPuesto.setText(((x.getJobLvl()) != null) ? x.getJobLvl() + "" : "");
            for (int i = 0; i < jCBEditorial.getItemCount(); i++) {
                if (e == null) {
                    jCBEditorial.setSelectedIndex(0);
                    jLblEditorial.setText("");
                    break;
                }
                if (jCBEditorial.getItemAt(i) instanceof EDITORIAL
                        && e.getPubId().equals(((EDITORIAL) jCBEditorial.getItemAt(i)).getPubId())) {
                    jCBEditorial.setSelectedIndex(i);
                    break;
                }
            }

            this.jXDatePicker1.setDate(x.getHireDate());
        } catch (SQLException ex) {
            Logger.getLogger(Discounts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jCBPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPuestoActionPerformed
        // TODO add your handling code here:
        try {
            if (jCBPuesto.getSelectedItem() instanceof PUESTO) {
                PUESTO p = (PUESTO) jCBPuesto.getSelectedItem();
                jLblJobDesc.setText(p.getJobDesc());
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jCBPuestoActionPerformed

    private void jCBEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEditorialActionPerformed
        // TODO add your handling code here:
        try {
            if (jCBEditorial.getSelectedItem() instanceof EDITORIAL) {
                EDITORIAL p = (EDITORIAL) jCBEditorial.getSelectedItem();
                jLblEditorial.setText(p.getPubName());
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jCBEditorialActionPerformed

    /**
     * @param args the command line arguments
     */
    public void fillComboPuesto() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(PUESTO._SQL_NAME, PUESTO.class);

            ResultSet rs = st.executeQuery("SELECT value(j) FROM Puestos j ORDER BY j.JOB_ID");
            jCBPuesto.addItem("Seleccione Puesto");
            while (rs.next()) {
                PUESTO p = (PUESTO) rs.getObject(1);

                jCBPuesto.addItem(p);
            }
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void fillComboEditorial() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);

            ResultSet rs = st.executeQuery("SELECT value(e) FROM Editoriales e ORDER BY e.pub_id");
            jCBEditorial.addItem("Seleccione Editorial");
            while (rs.next()) {
                EDITORIAL p = (EDITORIAL) rs.getObject(1);

                jCBEditorial.addItem(p);
            }
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void loadEmployee() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(EMPLEADO._SQL_NAME, EMPLEADO.class);

            String[] columns = {
                "ID Empleado", "Nombre", "Minint", "Apellido", "ID Puesto", "Nivel puesto", "ID editorial", "Fecha contratación"
            };

            //8 columnas
            DefaultTableModel tm = new DefaultTableModel(null, columns) {
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };

            ResultSet rs = st.executeQuery("SELECT value(a) FROM empleados a");
            while (rs.next()) {
                EMPLEADO p = (EMPLEADO) rs.getObject(1);

                PUESTO y = null;
                try {
                    y = p.getRefJob().getValue();
                } catch (SQLException e) {
                    y = null;
                }

                EDITORIAL x = null;
                try {
                    x = p.getRefPub().getValue();
                } catch (SQLException e) {
                    x = null;
                }

                Date dateMeSenpai = new Date();
                dateMeSenpai.setTime(p.getHireDate().getTime());
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                String date = DATE_FORMAT.format(dateMeSenpai);

                Object[] row = {
                    p, p.getFname(), p.getMinit(), p.getLname(), y, p.getJobLvl(), x, date
                };

                tm.addRow(row);
            }
            jTable1.setModel(tm);
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void newEmployee() {
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(EMPLEADO._SQL_NAME, EMPLEADO.class);
            DefaultContext dc = new DefaultContext(conn);

            EMPLEADO e = new EMPLEADO();
            e.setConnectionContext(dc);

            //e.setEmpId(jTxtFldIdEmpleado);
//"ID Empleado", "Nombre", "Minint", "Apellido", "ID Puesto", "Nivel puesto", "ID editorial", "Fecha contratación"            
            e.setConnectionContext(dc);
        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCBEditorial;
    private javax.swing.JComboBox jCBPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblEditorial;
    private javax.swing.JLabel jLblJobDesc;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtFldApellido;
    private javax.swing.JTextField jTxtFldIdEmpleado;
    private javax.swing.JTextField jTxtFldMinit;
    private javax.swing.JTextField jTxtFldName;
    private javax.swing.JTextField jTxtFldNivelPuesto;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
