/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import iservice.IChiTietSPService;
import iservice.IHoaDonChiTietService;
import iservice.IHoaDonService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSPService;
import service.HoaDonChiTietService;
import service.HoaDonService;
import viewmodel.ViewModelChiTietSP;
import viewmodel.ViewModelHoaDon;
import viewmodel.ViewModelHoaDonChiTiet;

/**
 *
 * @author Admin
 */
public class ViewHoaDonChiTiet extends javax.swing.JFrame {

    public IHoaDonChiTietService iHoaDonChiTietService = new HoaDonChiTietService();
    public IHoaDonService iHoaDonService = new HoaDonService();
    public IChiTietSPService iChiTietSPService = new ChiTietSPService();

    /**
     * Creates new form ViewHoaDonChiTiet
     */
    public ViewHoaDonChiTiet() {
        initComponents();
        loadTable(iHoaDonChiTietService.getAll());
        loadComboboxMaHD();
        loadComboboxIdChiTietSP();
    }
    
    public void loadTable(ArrayList<ViewModelHoaDonChiTiet> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        defaultTableModel.setRowCount(0);
        for (ViewModelHoaDonChiTiet viewModelHoaDonChiTiet : list) {
            defaultTableModel.addRow(new Object[]{
                viewModelHoaDonChiTiet.getMaHD(), viewModelHoaDonChiTiet.getIdChiTietSP(), viewModelHoaDonChiTiet.getSoLuong(), viewModelHoaDonChiTiet.getDonGia()
            });
        }
    }

    public void loadComboboxMaHD() {
        ArrayList<ViewModelHoaDon> list = iHoaDonService.getAll();
        for (ViewModelHoaDon viewModelHoaDon : list) {
            String maHD = viewModelHoaDon.getMa();
            cbbMaHoaDon.addItem(maHD);
        }
    }

    public void loadComboboxIdChiTietSP() {
        ArrayList<ViewModelChiTietSP> list = iChiTietSPService.getAll();
        for (ViewModelChiTietSP viewModelChiTietSP : list) {
            String idChiTietSP = viewModelChiTietSP.getId();
            cbbChiTietSP.addItem(idChiTietSP);
        }
    }

    public ViewModelHoaDonChiTiet getData() {
        // lấy ra mã 
        String maHD = cbbMaHoaDon.getSelectedItem().toString();
        // lấy ra id
        String idChiTietSP = cbbChiTietSP.getSelectedItem().toString();
        
        String soLuong = txtSoLuong.getText();
        String donGia = txtDonGia.getText();
        
        ViewModelHoaDonChiTiet viewModelHoaDonChiTiet = new ViewModelHoaDonChiTiet();
        viewModelHoaDonChiTiet.setMaHD(maHD);
        viewModelHoaDonChiTiet.setIdChiTietSP(idChiTietSP);
        
        int soLuongInt = Integer.parseInt(soLuong);
        double donGiaDouble = Double.parseDouble(donGia);
        viewModelHoaDonChiTiet.setSoLuong(soLuongInt);
        viewModelHoaDonChiTiet.setDonGia(donGiaDouble);
        return viewModelHoaDonChiTiet;
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
        jLabel1 = new javax.swing.JLabel();
        cbbMaHoaDon = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbbChiTietSP = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("maDH");

        jLabel2.setText("idChiTietSP");

        jLabel3.setText("SL");

        jLabel4.setText("Đơn giá");

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "IDCHiTietSP", "SL", "Đơn giá"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbMaHoaDon, 0, 126, Short.MAX_VALUE)
                    .addComponent(cbbChiTietSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong)
                    .addComponent(txtDonGia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnThem)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ViewModelHoaDonChiTiet viewModelHoaDonChiTiet = getData();
        JOptionPane.showMessageDialog(this, iHoaDonChiTietService.insert(viewModelHoaDonChiTiet));
        loadTable(iHoaDonChiTietService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDonChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbChiTietSP;
    private javax.swing.JComboBox<String> cbbMaHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
