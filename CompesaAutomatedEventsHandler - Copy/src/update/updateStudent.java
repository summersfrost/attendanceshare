/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import dbcon.DB;
import dbcon.StudentDao;
import dbcon.inputFormatting;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Frost
 */
public class updateStudent extends javax.swing.JFrame {

    /**
     * Creates new form addEquipment
     */
    String imgname, firstName, middleName, lastName, extension, email, mobileNo, img, yearlevel,sub1,sub2,sub3,sub4,sub5,sub6;

    String savepath1;
    int id;
    String studentID, rfid;
    public updateStudent(String studentID, String rfid) {
      this.studentID = studentID;
      initComponents();
      
DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
DefaultComboBoxModel<String> comboBoxModel1 = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
DefaultComboBoxModel<String> comboBoxModel3 = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
DefaultComboBoxModel<String> comboBoxModel4 = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
DefaultComboBoxModel<String> comboBoxModel5 = new DefaultComboBoxModel<>(); // Create a DefaultComboBoxModel
try {
    // Establish a database connection
    Connection conn = DB.getConnection();
    Statement stmt = conn.createStatement();

    // Execute the SQL query
    ResultSet resultSet = stmt.executeQuery("SELECT classIdentity FROM subjects");

    // Populate the comboBoxModel with data from the database
    while (resultSet.next()) {
        String subjName = resultSet.getString("classIdentity");
        comboBoxModel.addElement(subjName);
          comboBoxModel1.addElement(subjName);
            comboBoxModel2.addElement(subjName);
              comboBoxModel3.addElement(subjName);
              comboBoxModel4.addElement(subjName);
              comboBoxModel5.addElement(subjName);
    }

    // Set the model for your JComboBox
    jComboBox2.setModel(comboBoxModel);
    jComboBox3.setModel(comboBoxModel1);
    jComboBox4.setModel(comboBoxModel2);
    jComboBox5.setModel(comboBoxModel3);
     jComboBox6.setModel(comboBoxModel4);
    jComboBox7.setModel(comboBoxModel5);
    // Close the database connection
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
}
      setLocationRelativeTo(null);

      textField.setText(studentID);

      try {
        Connection con = DB.getConnection();
        String query = "SELECT rfid, firstName, middleName, lastName, extension, email, mobileNo,img,yearlvl,subj1,subj2,subj3,subj4,subj5,subj6 FROM students WHERE studentID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, studentID);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
          firstName = resultSet.getString("firstName");
          middleName = resultSet.getString("middleName");
          lastName = resultSet.getString("lastName");
          rfid=resultSet.getString("rfid");
          extension = resultSet.getString("extension");
          email = resultSet.getString("email");
          mobileNo = resultSet.getString("mobileNo");
          yearlevel = resultSet.getString("yearlvl");
          sub1 = resultSet.getString("subj1");
          sub2 = resultSet.getString("subj2");
          sub3 = resultSet.getString("subj3");
          sub4= resultSet.getString("subj4");
          img = resultSet.getString("img");

          displayImage(img);

          fname.setText(firstName);
          mname.setText(middleName);
          lname.setText(lastName);
          xtension.setText(extension);
          mail.setText(email);
          studmobno.setText(mobileNo);
          yrLvl.setText(yearlevel);
          studRFID.setText(rfid);
          subj1.setText(sub1);
          subj2.setText(sub2);
          subj3.setText(sub3);
          subj4.setText(sub4);
          subj5.setText(sub5);
          subj6.setText(sub6);

        } else {
         JOptionPane.showMessageDialog(null, "Student not Found");

        }

        con.close();
      } catch (SQLException e) {
             String error=e.getMessage();
              JOptionPane.showMessageDialog(null, error);
      }
      /*     textField_1.setText(firstName);
        textField_2.setText(middleName);
         textField_3.setText(lastName);
           textField_4.setText(extension);
         textField_5.setText(email);
         textField_6.setText(mobileno);*/

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
        jLabel2 = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        home = new javax.swing.JButton();
        updateStudents = new javax.swing.JButton();
        btnAddEquipment1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        xtension = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        addLogo = new javax.swing.JLabel();
        studmobno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        yrLvl = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        studRFID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        subj1 = new javax.swing.JTextField();
        subj3 = new javax.swing.JTextField();
        subj4 = new javax.swing.JTextField();
        subj2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        subj5 = new javax.swing.JTextField();
        subj6 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UPDATE STUDENT");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student ID:");

        textField.setBackground(new java.awt.Color(255, 255, 255));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name:");

        fname.setBackground(new java.awt.Color(255, 255, 255));
        fname.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Middle Name:");

        mname.setBackground(new java.awt.Color(255, 255, 255));
        mname.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name:");

        lname.setBackground(new java.awt.Color(255, 255, 255));
        lname.setForeground(new java.awt.Color(0, 0, 0));

        home.setBackground(new java.awt.Color(0, 204, 204));
        home.setForeground(new java.awt.Color(0, 0, 0));
        home.setText("BACK");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        updateStudents.setBackground(new java.awt.Color(153, 255, 0));
        updateStudents.setForeground(new java.awt.Color(0, 0, 0));
        updateStudents.setText("UPDATE STUDENT");
        updateStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentsActionPerformed(evt);
            }
        });

        btnAddEquipment1.setBackground(new java.awt.Color(255, 0, 51));
        btnAddEquipment1.setForeground(new java.awt.Color(0, 0, 0));
        btnAddEquipment1.setText("CLEAR INPUTS");
        btnAddEquipment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEquipment1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Extension:");

        xtension.setBackground(new java.awt.Color(255, 255, 255));
        xtension.setForeground(new java.awt.Color(0, 0, 0));

        mail.setBackground(new java.awt.Color(255, 255, 255));
        mail.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email:");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None","Jr.", "Sr.", "I", "II","III","IV","V" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        addLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-replace-100.png"))); // NOI18N

        studmobno.setBackground(new java.awt.Color(255, 255, 255));
        studmobno.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mobile No.:");

        imageLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        imageLabel.setForeground(new java.awt.Color(255, 255, 255));
        imageLabel.setText("      Choose image");
        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setText("Add Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Year Level:");

        yrLvl.setBackground(new java.awt.Color(255, 255, 255));
        yrLvl.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year","3rd Year","4th Year" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("RFID:");

        studRFID.setBackground(new java.awt.Color(255, 255, 255));
        studRFID.setForeground(new java.awt.Color(0, 0, 0));
        studRFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studRFIDActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Subjects Enrolled:");

        subj1.setBackground(new java.awt.Color(255, 255, 255));
        subj1.setForeground(new java.awt.Color(0, 0, 0));
        subj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subj1ActionPerformed(evt);
            }
        });

        subj3.setBackground(new java.awt.Color(255, 255, 255));
        subj3.setForeground(new java.awt.Color(0, 0, 0));
        subj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subj3ActionPerformed(evt);
            }
        });

        subj4.setBackground(new java.awt.Color(255, 255, 255));
        subj4.setForeground(new java.awt.Color(0, 0, 0));
        subj4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subj4ActionPerformed(evt);
            }
        });

        subj2.setBackground(new java.awt.Color(255, 255, 255));
        subj2.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        subj5.setBackground(new java.awt.Color(255, 255, 255));
        subj5.setForeground(new java.awt.Color(0, 0, 0));
        subj5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subj5ActionPerformed(evt);
            }
        });

        subj6.setBackground(new java.awt.Color(255, 255, 255));
        subj6.setForeground(new java.awt.Color(0, 0, 0));
        subj6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subj6ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(xtension, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(addLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(subj1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel10))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studRFID, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studmobno, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(yrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subj2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subj3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subj4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subj6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subj5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(studRFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(xtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(studmobno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subj4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subj5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subj6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnAddEquipment1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateStudents)
                .addGap(12, 12, 12)
                .addComponent(home)
                .addGap(16, 16, 16))
        );

        xtension.setEditable(false);
        xtension.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_homeActionPerformed

    private void updateStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentsActionPerformed
 String studentID = textField.getText();
String firstName = fname.getText();
String middleName = mname.getText();
String lastName = lname.getText();
String extension = xtension.getText();
String email = mail.getText();
String mobileno = studmobno.getText();
String yearLvl = yrLvl.getText();
String rfid=studRFID.getText();
String sub1=subj1.getText();
String  sub2=subj2.getText();
String sub3=subj3.getText();
String sub4=subj4.getText();
String sub5=subj5.getText();
String sub6=subj6.getText();
Date currentDate = new Date();

// Format the date and time using SimpleDateFormat
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

String formattedDate = dateFormat.format(currentDate);
String formattedTime = timeFormat.format(currentDate);

// Validate studentID format
boolean isStudentIDValid = Pattern.matches("^\\d{2}-\\d{4}-\\d{3}$", studentID);

// Capitalize first letter of each word in firstName, middleName, and lastName
inputFormatting nameFormat = new inputFormatting();
firstName = nameFormat.capitalizeWords(firstName);
lastName = nameFormat.capitalizeWords(lastName);
if (!middleName.isEmpty()) {
  middleName = nameFormat.capitalizeWords(middleName);
}

// Validate extension if not blank
boolean isExtensionValid = extension.isEmpty() ||
  Pattern.matches("^(Jr\\.|Sr\\.|[I-VI]{1,3})$", extension);

// Validate middle name (must not be a single character)
boolean isMiddleNameValid = middleName.isEmpty() || middleName.length() > 1;

// Validate firstName, middleName, and lastName
boolean isNameValid = Pattern.matches("^[a-zA-Z\\s-]+$", firstName) &&
  Pattern.matches("^[a-zA-Z\\s-]*$", middleName) &&
  Pattern.matches("^[a-zA-Z\\s-]+$", lastName) &&
  !firstName.contains("--") && !middleName.contains("--") && !lastName.contains("--");

// Validate email address
boolean isEmailValid = Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
boolean isMobileNoValid = mobileno.matches("\\d{11}");

if ( isNameValid||!isNameValid) {
  String imgpath_name = "C:\\Documents\\CompesaEventHandler\\CompesaAutomatedEventsHandler\\img\\img";

  // Check if a new image has been selected
  boolean isNewImageSelected = (imgname != null) && !imgname.isEmpty();

  // Only save the image if a new image has been selected
  if (isNewImageSelected) {
    saveDisplayedImageToFile(imgpath_name, imgname);
  }
System.out.println(rfid);
System.out.println(sub1 + " " + sub2+ " " + sub3 + " " + sub4);
  int rowsAffected = StudentDao.update(studentID, firstName, middleName, lastName, extension, email, mobileno, isNewImageSelected ? savepath1 : img, yearLvl,rfid,sub1,sub2,sub3,sub4,sub5,sub6);

  if (rowsAffected > 0) {
    JOptionPane.showMessageDialog(updateStudent.this, "Student updated successfully!");
    dispose();
  } else {
    JOptionPane.showMessageDialog(updateStudent.this, "Failed to update the student. Please try again.");
  }
} else {
  String errorMessage = "Invalid input! Please check your entries.\n\n";

  if (!isStudentIDValid) {
    errorMessage += "- Student ID must be in the format XX-XXXX-XXX.\n";
  }
  if (!isExtensionValid) {
    errorMessage += "- Invalid extension. Valid extensions are Jr., Sr., or Roman numerals I to VI.\n";
  }
  if (!isMiddleNameValid) {
    errorMessage += "- Middle name must not be a single character.\n";
  }
  if (!isNameValid) {
    errorMessage += "- Invalid name format. Only letters, hyphens, and spaces are allowed.\n";
  }
  if (!isEmailValid) {
    errorMessage += "- Invalid email address.\n";
  }
  if (!isMobileNoValid) {
    errorMessage += "Mobile no should be an 11-digit number.";
  }
  JOptionPane.showMessageDialog(updateStudent.this, errorMessage);
}
    }//GEN-LAST:event_updateStudentsActionPerformed

    private void btnAddEquipment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEquipment1ActionPerformed
        // TODO add your handling code here:
        textField.setText("");
        fname.setText("");
        mname.setText("");
        lname.setText("");
        xtension.setText("");
        mail.setText("");
    }//GEN-LAST:event_btnAddEquipment1ActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
            // TODO add your handling code here:
        String selectedItem = (String) jComboBox.getSelectedItem();

        if (selectedItem.equalsIgnoreCase("None")) {
          xtension.setText("");
        } else {

          xtension.setText(selectedItem);
        }
    }//GEN-LAST:event_jComboBoxActionPerformed
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(this);

      if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String fileName = selectedFile.getName();
        imgname = fileName;
        displayImage(selectedFile.getAbsolutePath());
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) jComboBox1.getSelectedItem();

        yrLvl.setText(selectedItem);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void studRFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studRFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studRFIDActionPerformed

    private void subj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subj1ActionPerformed

    private void subj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subj3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subj3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
               String selectedItem = (String) jComboBox2.getSelectedItem();
          subj1.setText(selectedItem);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
               String selectedItem = (String) jComboBox3.getSelectedItem();
          subj2.setText(selectedItem);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
               String selectedItem = (String) jComboBox4.getSelectedItem();
          subj3.setText(selectedItem);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void subj4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subj4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subj4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
               String selectedItem = (String) jComboBox5.getSelectedItem();
          subj4.setText(selectedItem);
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void subj5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subj5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subj5ActionPerformed

    private void subj6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subj6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subj6ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
            String selectedItem = (String) jComboBox6.getSelectedItem();
          subj5.setText(selectedItem);
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
         String selectedItem = (String) jComboBox7.getSelectedItem();
          subj6.setText(selectedItem);
    }//GEN-LAST:event_jComboBox7ActionPerformed
        public void displayImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        imageLabel.setText("");
        imageLabel.setIcon(imageIcon);
    }
        

private void saveDisplayedImageToFile(String saveDirectory, String fileName) {
  File directory = new File(saveDirectory);
  if (!directory.exists()) {
    directory.mkdirs();
  }

  ImageIcon imageIcon = (ImageIcon) imageLabel.getIcon();
  if (imageIcon != null) {
    Image image = imageIcon.getImage();
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();

    String savePath = Paths.get(saveDirectory, fileName).toString();

    // Check if the new savePath is different from the existing savepath1
    if (!savePath.equals(savepath1)) {
      try {
        ImageIO.write(bufferedImage, "jpg", new File(savePath));
     //   System.out.println("Image saved to: " + savePath);
        savepath1 = savePath; // Update savepath1 only when a new image is saved
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
    //  System.out.println("Image path has not changed. No need to save.");
    }
  }
}


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
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
               // new updateStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLogo;
    private javax.swing.JButton btnAddEquipment1;
    private javax.swing.JTextField fname;
    private javax.swing.JButton home;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField studRFID;
    private javax.swing.JTextField studmobno;
    private javax.swing.JTextField subj1;
    private javax.swing.JTextField subj2;
    private javax.swing.JTextField subj3;
    private javax.swing.JTextField subj4;
    private javax.swing.JTextField subj5;
    private javax.swing.JTextField subj6;
    private javax.swing.JTextField textField;
    private javax.swing.JButton updateStudents;
    private javax.swing.JTextField xtension;
    private javax.swing.JTextField yrLvl;
    // End of variables declaration//GEN-END:variables


}
