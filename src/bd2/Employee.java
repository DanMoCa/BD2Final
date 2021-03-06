/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2;

import entidades.EDITORIAL;
import entidades.EMPLEADO;
import entidades.PUESTO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        jPanel1 = new javax.swing.JPanel();
        jTxtFldMinit = new javax.swing.JTextField();
        jLblEditorial = new javax.swing.JLabel();
        jTxtFldApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtFldNivelPuesto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jCBPuesto = new javax.swing.JComboBox();
        jTxtFldIdEmpleado = new javax.swing.JTextField();
        jLblJobDesc = new javax.swing.JLabel();
        jTxtFldName = new javax.swing.JTextField();
        jCBEditorial = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("( ͡° ͜ʖ ͡°) - Empleados");
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
        jScrollPane2.setViewportView(jTable1);

        jTxtFldMinit.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldApellido.setPreferredSize(new java.awt.Dimension(150, 23));

        jLabel5.setText("ID Puesto");

        jLabel6.setText("Nivel Puesto");

        jLabel7.setText("ID Editorial");

        jLabel1.setText("ID Empleado");

        jLabel8.setText("Fecha de Empleo");

        jLabel2.setText("Nombre");

        jTxtFldNivelPuesto.setPreferredSize(new java.awt.Dimension(150, 23));

        jLabel3.setText("Minint");

        jLabel4.setText("Apellido");

        jCBPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPuestoActionPerformed(evt);
            }
        });

        jTxtFldIdEmpleado.setPreferredSize(new java.awt.Dimension(150, 23));

        jTxtFldName.setPreferredSize(new java.awt.Dimension(150, 23));

        jCBEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtFldIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtFldMinit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtFldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtFldNivelPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLblJobDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtFldIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtFldMinit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblJobDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldNivelPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        String formats = "yyyy-MM-dd";

        this.jXDatePicker1.setFormats(formats);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fillFields();
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

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        fillFields();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        newEmployee();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateEmployee();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteEmployee();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void clearFields() {
        jTxtFldIdEmpleado.setText("");
        jTxtFldApellido.setText("");
        jTxtFldMinit.setText("");
        jTxtFldName.setText("");
        jTxtFldNivelPuesto.setText("");
        jCBEditorial.setSelectedIndex(0);
        jCBPuesto.setSelectedIndex(0);
    }

    public void fillFields() {
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
    }

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
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            map.put(PUESTO._SQL_NAME, PUESTO.class);
            DefaultContext dc = new DefaultContext(conn);

            EMPLEADO e = new EMPLEADO();
            e.setConnectionContext(dc);

            e.setEmpId(jTxtFldIdEmpleado.getText());
            e.setFname(jTxtFldName.getText());
            e.setLname(jTxtFldApellido.getText());
            e.setMinit(jTxtFldMinit.getText());
            e.setJobLvl(new BigDecimal(jTxtFldNivelPuesto.getText()));
            e.setHireDate(new Timestamp(jXDatePicker1.getDate().getTime()));

            EDITORIAL ed = (EDITORIAL) jCBEditorial.getSelectedItem();
            ed.setConnectionContext(dc);
            e.setRefPub(ed.getref());

            PUESTO p = (PUESTO) jCBPuesto.getSelectedItem();
            p.setConnectionContext(dc);
            e.setRefJob(p.getref());

            e.guardar();
            loadEmployee();
            clearFields();

        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void updateEmployee() {
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(EMPLEADO._SQL_NAME, EMPLEADO.class);
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            map.put(PUESTO._SQL_NAME, PUESTO.class);
            DefaultContext dc = new DefaultContext(conn);

            EMPLEADO e = new EMPLEADO();
            e.setConnectionContext(dc);
            e = (EMPLEADO) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            e.setEmpId(jTxtFldIdEmpleado.getText());
            e.setFname(jTxtFldName.getText());
            e.setLname(jTxtFldApellido.getText());
            e.setMinit(jTxtFldMinit.getText());
            e.setJobLvl(new BigDecimal(jTxtFldNivelPuesto.getText()));
            e.setHireDate(new Timestamp(jXDatePicker1.getDate().getTime()));

            EDITORIAL ed = (EDITORIAL) jCBEditorial.getSelectedItem();
            ed.setConnectionContext(dc);
            e.setRefPub(ed.getref());

            PUESTO p = (PUESTO) jCBPuesto.getSelectedItem();
            p.setConnectionContext(dc);
            e.setRefJob(p.getref());

            e.guardar();
            loadEmployee();
            clearFields();

        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void deleteEmployee() {
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(EMPLEADO._SQL_NAME, EMPLEADO.class);
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            map.put(PUESTO._SQL_NAME, PUESTO.class);
            DefaultContext dc = new DefaultContext(conn);

            EMPLEADO e = new EMPLEADO();
            e.setConnectionContext(dc);
            e = (EMPLEADO) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            e.borrar();

            loadEmployee();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
