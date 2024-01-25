/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tokoabadi;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class barang extends javax.swing.JFrame {
    
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    
    public barang() {
        initComponents();
        DisplayItems();
    }

    @SuppressWarnings("unchecked")  
    
    private void Clear(){
        nBarang.setText("");
        nJumlah.setValue(0);
        nHarga.setText("");
        nGambarr.setIcon(null);
    }
    
   private void DisplayItems() {
       try {
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TokoAbadi", "root", "");
        st = Con.createStatement();
        rs = st.executeQuery("select * from ItemsTbl");

        // Check if ResultSet is not null
        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            DefaultTableModel model = new DefaultTableModel();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            nTabel.setModel(model);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
            public ImageIcon ResizePhoto(String imagePath, byte[] pic) {
        ImageIcon myImage = null;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(nGambarr.getWidth(), nGambarr.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    String imgPath;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nBarang = new javax.swing.JTextField();
        nJumlah = new javax.swing.JSpinner();
        nKategori = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        nTabel = new javax.swing.JTable();
        btnGambar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        nHarga = new javax.swing.JTextField();
        nKotakGambar = new javax.swing.JPanel();
        nGambarr = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 85, 12));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gudang ");

        logout.setFont(new java.awt.Font("Century Schoolbook L", 0, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RASAKAN ABADI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(logout)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(16, 16, 16))
        );

        jLabel4.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(248, 85, 12));
        jLabel4.setText("Kelola Barang");

        jLabel5.setFont(new java.awt.Font("Century Schoolbook L", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(248, 85, 12));
        jLabel5.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Century Schoolbook L", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 85, 12));
        jLabel6.setText("Jumlah");

        jLabel7.setFont(new java.awt.Font("Century Schoolbook L", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 85, 12));
        jLabel7.setText("Kategori");

        nKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bahan Bangunan", "Alat Bangunan", "Lainnya" }));

        nTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Harga", "Jumlah", "Kategori"
            }
        ));
        nTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(nTabel);

        btnGambar.setBackground(new java.awt.Color(248, 85, 12));
        btnGambar.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        btnGambar.setForeground(new java.awt.Color(255, 255, 255));
        btnGambar.setText("Gambar");
        btnGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGambarActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(248, 85, 12));
        btnEdit.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(248, 85, 12));
        btnHapus.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Schoolbook L", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 85, 12));
        jLabel9.setText("Harga");

        javax.swing.GroupLayout nKotakGambarLayout = new javax.swing.GroupLayout(nKotakGambar);
        nKotakGambar.setLayout(nKotakGambarLayout);
        nKotakGambarLayout.setHorizontalGroup(
            nKotakGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nKotakGambarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nGambarr, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );
        nKotakGambarLayout.setVerticalGroup(
            nKotakGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nGambarr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        btnTambah.setBackground(new java.awt.Color(248, 85, 12));
        btnTambah.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nKotakGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(nHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(nKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nKotakGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGambarActionPerformed
        // TODO add your handling code here:
 try {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int hasil = file.showSaveDialog(file);

        // Check if user selected a file
        if (hasil == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            // Check if nGambarr is not null
            if (nGambarr != null) {
                nGambarr.setIcon(ResizePhoto(path, null));
            }

            imgPath = path;
        } else if (hasil == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Tidak ada File Yang Dipilih");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnGambarActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(nBarang.getText().isEmpty() || nJumlah.getValue().toString().isEmpty() || nHarga.getText().isEmpty() || nKategori.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Informasi tidak ada");
        }else{
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TokoAbadi","root",""); 
                PreparedStatement Save = Con.prepareStatement("INSERT INTO ItemsTbl (ItName, ItQty, ItPrice, ItCat, ItPhoto) VALUES (?, ?, ?, ?, ?)");
                Save.setString(1, nBarang.getText());
                Save.setInt(2, Integer.valueOf(nJumlah.getValue().toString()));
                Save.setInt(3, Integer.valueOf(nHarga.getText()));
                Save.setString(4, nKategori.getSelectedItem().toString());
                InputStream img = new FileInputStream(imgPath);
                Save.setBlob(5, img);
                int row = Save.executeUpdate();
                JOptionPane.showMessageDialog(this, "Barang Ditambahkan");
                Con.close();
                DisplayItems();
                Clear();
            }catch(Exception Ex){
                JOptionPane.showMessageDialog(this, Ex);
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void nTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nTabelMouseClicked
            // TODO add your handling code here:
           int row = nTabel.getSelectedRow();
    if (row != -1) {
        try {
            String itemName = nTabel.getValueAt(row, 0).toString();
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TokoAbadi", "root", "");

            PreparedStatement getData = Con.prepareStatement("SELECT * FROM ItemsTbl WHERE ItName=?");
            getData.setString(1, itemName);
            ResultSet dataRs = getData.executeQuery();

            if (dataRs.next()) {
                nBarang.setText(dataRs.getString("ItName"));
                nHarga.setText(String.valueOf(dataRs.getInt("ItPrice")));
                nJumlah.setValue(dataRs.getInt("ItQty"));
                nKategori.setSelectedItem(dataRs.getString("ItCat"));

                Blob imgBlob = dataRs.getBlob("ItPhoto");

                // Check if imgBlob is not null
                if (imgBlob != null) {
                    byte[] imgBytes = imgBlob.getBytes(1, (int) imgBlob.length());
                    ImageIcon imageIcon = new ImageIcon(imgBytes);
                    Image image = imageIcon.getImage().getScaledInstance(nGambarr.getWidth(), nGambarr.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon resizedImageIcon = new ImageIcon(image);
                    nGambarr.setIcon(resizedImageIcon);
                }
            }

            Con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data for editing: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_nTabelMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
       int row = nTabel.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris untuk diedit");
    } else {
        try {
            String itemName = nTabel.getValueAt(row, 0).toString();
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TokoAbadi", "root", "");

            // Update the selected data in the database based on the selected item
            PreparedStatement updateData = Con.prepareStatement("UPDATE ItemsTbl SET ItName=?, ItQty=?, ItPrice=?, ItCat=?, ItPhoto=? WHERE ItName=?");
            updateData.setString(1, nBarang.getText());
            updateData.setInt(2, Integer.valueOf(nJumlah.getValue().toString()));
            updateData.setInt(3, Integer.valueOf(nHarga.getText()));
            updateData.setString(4, nKategori.getSelectedItem().toString());

            // Check if imgPath is not null before setting the blob parameter
            if (imgPath != null) {
                InputStream img = new FileInputStream(imgPath);
                updateData.setBlob(5, img);
            } else {
                // Handle the case where imgPath is null (no new image selected)
                updateData.setBlob(5, (Blob) null);
            }

            updateData.setString(6, itemName);

            int updatedRow = updateData.executeUpdate();

            if (updatedRow > 0) {
                JOptionPane.showMessageDialog(this, "Data barang diupdate");
                DisplayItems();
                Clear();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data barang");
            }

            Con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = nTabel.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris untuk dihapus");
    } else {
        try {
            String itemName = nTabel.getValueAt(row, 0).toString();
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TokoAbadi", "root", "");
            PreparedStatement delete = Con.prepareStatement("DELETE FROM ItemsTbl WHERE ItName=?");
            delete.setString(1, itemName);
            int deleteRow = delete.executeUpdate();
            if (deleteRow > 0) {
                JOptionPane.showMessageDialog(this, "Barang dihapus");
                DisplayItems();
                Clear();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus barang");
            }
            Con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGambar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JTextField nBarang;
    private javax.swing.JLabel nGambarr;
    private javax.swing.JTextField nHarga;
    private javax.swing.JSpinner nJumlah;
    private javax.swing.JComboBox<String> nKategori;
    private javax.swing.JPanel nKotakGambar;
    private javax.swing.JTable nTabel;
    // End of variables declaration//GEN-END:variables
}
