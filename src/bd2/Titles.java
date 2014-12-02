/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2;

import entidades.EDITORIAL;
import entidades.TITULO;
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
public class Titles extends javax.swing.JFrame {

    /**
     * Creates new form Titles
     */
    public Titles() {
        initComponents();
        loadTitles();
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtFldAvance = new javax.swing.JTextField();
        jTxtFldRegalias = new javax.swing.JTextField();
        jTxtFldYTDVentas = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtFldNotas = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCBEditorial = new javax.swing.JComboBox();
        jTxtFldPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtFldIdTitulo = new javax.swing.JTextField();
        jLblEditorial = new javax.swing.JLabel();
        jTxtFldNombre = new javax.swing.JTextField();
        jTxtFldTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDatePicker.setMaximumSize(new java.awt.Dimension(200, 23));

        jLabel6.setText("Avance");

        jLabel7.setText("Regalias");

        jLabel8.setText("YTD_Ventas");

        jLabel10.setText("Fecha Publicacion");

        jTxtFldAvance.setMaximumSize(new java.awt.Dimension(200, 23));

        jTxtFldRegalias.setMaximumSize(new java.awt.Dimension(200, 23));

        jTxtFldYTDVentas.setMaximumSize(new java.awt.Dimension(200, 23));

        jTxtFldNotas.setColumns(20);
        jTxtFldNotas.setRows(5);
        jScrollPane2.setViewportView(jTxtFldNotas);

        jLabel9.setText("Notas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFldYTDVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtFldRegalias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtFldAvance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtFldAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtFldRegalias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtFldYTDVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        String formats = "yyyy-MM-dd";

        this.jDatePicker.setFormats(formats);

        jCBEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEditorialActionPerformed(evt);
            }
        });

        jTxtFldPrecio.setMaximumSize(new java.awt.Dimension(150, 23));

        jLabel1.setText("ID Titulo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo");

        jLabel4.setText("ID Editorial");

        jLabel5.setText("Precio");

        jTxtFldIdTitulo.setMaximumSize(new java.awt.Dimension(150, 23));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtFldNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jTxtFldIdTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTxtFldTipo)
                                .addGap(101, 101, 101)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFldIdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtFldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jCBEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtFldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fillFields();
    }//GEN-LAST:event_jTable1MouseClicked

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
        newTitle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateTitle();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteTitle();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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

    public void fillFields() {
        TITULO x;
        x = (TITULO) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        EDITORIAL e = (EDITORIAL) jTable1.getValueAt(jTable1.getSelectedRow(), 3);

        try {
            this.jTxtFldIdTitulo.setText(((x.getTitleId()) != null) ? x.getTitleId() + "" : "");
            this.jTxtFldNombre.setText(((x.getTitleName()) != null) ? x.getTitleName() + "" : "");
            this.jTxtFldTipo.setText(((x.getTitleType()) != null) ? x.getTitleType() + "" : "");
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
            this.jTxtFldPrecio.setText(((x.getPrice()) != null) ? x.getPrice() + "" : "");
            this.jTxtFldAvance.setText(((x.getAdvance()) != null) ? x.getAdvance() + "" : "");
            this.jTxtFldRegalias.setText(((x.getRoyalty()) != null) ? x.getRoyalty() + "" : "");
            this.jTxtFldYTDVentas.setText(((x.getYtdSales()) != null) ? x.getYtdSales() + "" : "");
            this.jTxtFldNotas.setText(((x.getNotes()) != null) ? x.getNotes() + "" : "");
            this.jDatePicker.setDate(x.getPubdate());
        } catch (SQLException ex) {
            Logger.getLogger(Discounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearFields() {
        this.jTxtFldIdTitulo.setText("");
        this.jTxtFldNombre.setText("");
        this.jTxtFldTipo.setText("");
        this.jTxtFldPrecio.setText("");
        this.jTxtFldAvance.setText("");
        this.jTxtFldRegalias.setText("");
        this.jTxtFldYTDVentas.setText("");
        this.jTxtFldNotas.setText("");
        this.jDatePicker.setDate(null);
        this.jCBEditorial.setSelectedIndex(0);
    }

    public void loadTitles() {
        try {
            OracleConnection conn = (OracleConnection) Conexion.GetConnection();
            Statement st = conn.createStatement();
            Map map = (Map) conn.getTypeMap();
            map.put(TITULO._SQL_NAME, TITULO.class);
            String[] columns = {
                "ID Titulo", "Nombre", "Tipo", "ID Editorial", "Precio", "Avance", "Regalias", "YTD_Ventas", "Notas", "Fecha Publicación"
            };

            DefaultTableModel tm = new DefaultTableModel(null, columns) {
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };

            ResultSet rs = st.executeQuery("SELECT value(a) FROM titulos a");
            while (rs.next()) {
                TITULO p = (TITULO) rs.getObject(1);

                EDITORIAL ed = null;
                try {
                    ed = p.getRefPub().getValue();
                } catch (SQLException e) {
                    ed = null;
                }

                Date dateMeSenpai = new Date();
                dateMeSenpai.setTime(p.getPubdate().getTime());
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
                String date = DATE_FORMAT.format(dateMeSenpai);

                Object[] row = {
                    p, p.getTitleName(), p.getTitleType(), ed, p.getPrice(), p.getAdvance(), p.getRoyalty(), p.getYtdSales(), p.getNotes(), date
                };

                tm.addRow(row);
            }
            jTable1.setModel(tm);
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void newTitle(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(TITULO._SQL_NAME, TITULO.class);
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            DefaultContext dc = new DefaultContext(conn);

            TITULO p = new TITULO();
            p.setConnectionContext(dc);

            p.setTitleId(jTxtFldIdTitulo.getText());
            p.setAdvance(new BigDecimal(jTxtFldAvance.getText()));
            p.setYtdSales(new BigDecimal(jTxtFldYTDVentas.getText()));
            p.setTitleType(jTxtFldTipo.getText());
            p.setTitleName(jTxtFldNombre.getText());
            p.setRoyalty(new BigDecimal(jTxtFldRegalias.getText()));
            p.setPrice(new BigDecimal(jTxtFldPrecio.getText()));
            p.setPubdate(new Timestamp(jDatePicker.getDate().getTime()));
            p.setNotes(jTxtFldNotas.getText());
            
            EDITORIAL e = (EDITORIAL)jCBEditorial.getSelectedItem();
            e.setConnectionContext(dc);
                        
            p.setRefPub(e.getref());
                       
            p.guardar();
            loadTitles();
            clearFields();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void updateTitle(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(TITULO._SQL_NAME, TITULO.class);
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            DefaultContext dc = new DefaultContext(conn);

            TITULO p = new TITULO();
            p.setConnectionContext(dc);
            p = (TITULO)jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            p.setTitleId(jTxtFldIdTitulo.getText());
            p.setAdvance(new BigDecimal(jTxtFldAvance.getText()));
            p.setYtdSales(new BigDecimal(jTxtFldYTDVentas.getText()));
            p.setTitleType(jTxtFldTipo.getText());
            p.setTitleName(jTxtFldNombre.getText());
            p.setRoyalty(new BigDecimal(jTxtFldRegalias.getText()));
            p.setPrice(new BigDecimal(jTxtFldPrecio.getText()));
            p.setPubdate(new Timestamp(jDatePicker.getDate().getTime()));
            
            p.setNotes(jTxtFldNotas.getText());
            EDITORIAL e = (EDITORIAL)jCBEditorial.getSelectedItem();
            e.setConnectionContext(dc);
            System.out.println(e.getPubId());
            
            p.setRefPub(e.getref());
            
            System.out.println(p.getTitleId());
            
            p.guardar();
            loadTitles();
            clearFields();
        } catch (SQLException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void deleteTitle(){
        try {
            OracleConnection conn = Conexion.GetConnection();
            Map map = (Map) conn.getTypeMap();
            map.put(TITULO._SQL_NAME, TITULO.class);
            map.put(EDITORIAL._SQL_NAME, EDITORIAL.class);
            DefaultContext dc = new DefaultContext(conn);

            TITULO p = new TITULO();
            p.setConnectionContext(dc);

            p = (TITULO)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            
            p.borrar();
                    
            loadTitles();
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
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Titles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jCBEditorial;
    private org.jdesktop.swingx.JXDatePicker jDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblEditorial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtFldAvance;
    private javax.swing.JTextField jTxtFldIdTitulo;
    private javax.swing.JTextField jTxtFldNombre;
    private javax.swing.JTextArea jTxtFldNotas;
    private javax.swing.JTextField jTxtFldPrecio;
    private javax.swing.JTextField jTxtFldRegalias;
    private javax.swing.JTextField jTxtFldTipo;
    private javax.swing.JTextField jTxtFldYTDVentas;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
