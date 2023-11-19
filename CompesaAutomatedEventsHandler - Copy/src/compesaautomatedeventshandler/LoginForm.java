/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compesaautomatedeventshandler;


import Main.Main;
import dbcon.adminAdd;
import dbcon.facilitatorAdd;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Frost
 */
 public class LoginForm extends javax.swing.JFrame {
     boolean passwordVisible = false;
     public LoginForm() {
       initComponents();
     }

     class jPanelGradient extends JPanel {
       protected void paintComponent(Graphics g) {
         Graphics2D g2d = (Graphics2D) g;
         int width = getWidth();
         int height = getHeight();
         Color color1 = new Color(25, 5, 60);
         Color color2 = new Color(0, 0, 153);
         GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
         g2d.setPaint(gp);
         g2d.fillRect(0, 0, width, height);

       }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        CheckBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        pword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MATH SCIENCE CLASS ATTENDANCE SYSTEM");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PASSWORD:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 270, 150, 29);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USERNAME:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 180, 170, 40);

        uname.setBackground(new java.awt.Color(255, 255, 255));
        uname.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel1.add(uname);
        uname.setBounds(310, 180, 460, 40);

        CheckBox.setBackground(new java.awt.Color(102, 255, 255));
        CheckBox.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        CheckBox.setForeground(new java.awt.Color(0, 0, 0));
        CheckBox.setText("Show Password");
        CheckBox.setFocusPainted(false);
        CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(CheckBox);
        CheckBox.setBounds(650, 320, 130, 28);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(660, 360, 120, 34);

        pword.setBackground(new java.awt.Color(255, 255, 255));
        pword.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        pword.setForeground(new java.awt.Color(0, 0, 0));
        pword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwordActionPerformed(evt);
            }
        });
        jPanel1.add(pword);
        pword.setBounds(310, 260, 460, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/COMPESA Log in BG 3(1).png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 960, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxActionPerformed
        // TODO add your handling code here:
        if (passwordVisible) {
          pword.setEchoChar('*');
          passwordVisible = false;
          CheckBox.setText("Show Password");
        } else {
          pword.setEchoChar((char) 0);
          passwordVisible = true;
          CheckBox.setText("Hide Password");
        }
    }//GEN-LAST:event_CheckBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = uname.getText();
        String password = String.valueOf(pword.getPassword());
        if (adminAdd.validate(name, password)) {
          //  adminSuccess admin=new adminSuccess();
          new Main(name).setVisible(true);
          //  admin.setVisible(true);

          dispose();
        } else if (facilitatorAdd.validate(name, password)) {
          //    facilitatorSuccess facilitator=new facilitatorSuccess();
          //    facilitator.setVisible(true);
          new Main(name).setVisible(true);
          //   facilitator.setLocationRelativeTo(null);
          dispose();
        } else {
          JOptionPane.showMessageDialog(null, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
          uname.setText("");
          pword.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwordActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_pwordActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pword;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
