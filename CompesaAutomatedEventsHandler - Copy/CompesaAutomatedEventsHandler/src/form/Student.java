/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dbcon.DB;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import add.addStudent;
import delete.deleteStudent; 
/**
 *
 * @author RavenPC
 */
public class Student extends javax.swing.JPanel {

    /**
     * Creates new form Panel1
     */
    
           private TableRowSorter<DefaultTableModel> sorter;
          private DefaultTableModel model;
 public void displayTable() {

    try {
        Connection con = DB.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
        ResultSet rs = ps.executeQuery();

        // Create a DefaultTableModel to hold the data
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model based on the table structure
      model.addColumn("RFID");
        model.addColumn("Student ID");
        model.addColumn("Last Name");
        model.addColumn("Extension");
        model.addColumn("First Name");
        model.addColumn("Middle Name");
        model.addColumn("Email");
        model.addColumn("Added By");
        model.addColumn("Date Added");
        model.addColumn("Time Added");
        model.addColumn("Registration Status");
        model.addColumn("Update");
        model.addColumn("Delete");

        // Add rows to the model with the retrieved data
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("rfid"));
            row.add(rs.getString("studentID"));
            row.add(rs.getString("lastName"));
            row.add(rs.getString("extension"));
            row.add(rs.getString("firstName"));
            row.add(rs.getString("middleName"));
            row.add(rs.getString("email"));
            row.add(rs.getString("addedBy"));
        // Retrieve the dateAdded value

try {
    Date dateAdded = rs.getDate("dateAdded");
    
    if (dateAdded != null) {
        // Format the date as "Month DD, YYYY"
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        String formattedDate = dateFormat.format(dateAdded);
        row.add(formattedDate);
    } else {
        // Handle case where dateAdded is null
        row.add("N/A"); // Or any other placeholder value
    }
  
} catch (SQLException e) {
    e.printStackTrace();
    // Handle the SQL exception appropriately
}   
            row.add(rs.getString("timeAdded"));
              row.add(rs.getString("registration"));
            row.add("Update"); // Use text instead of JButton for initial rendering
            row.add("Delete"); // Use text instead of JButton for initial rendering

            model.addRow(row);
        }

        // Set the model to the table
        table.setModel(model);

        // Create a TableRowSorter and apply it to the table
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Sort the table by "Last Name" column in ascending order
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING)); // 2 represents the index of "Last Name" column
        sorter.setSortKeys(sortKeys);

        table.getColumn("Update").setCellRenderer(new Student.ButtonRenderer());
        table.getColumn("Update").setCellEditor(new Student.ButtonEditor(new JCheckBox()));
        table.getColumn("Delete").setCellRenderer(new Student.ButtonRenderer());
        table.getColumn("Delete").setCellEditor(new Student.ButtonEditor(new JCheckBox()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(true);

        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

  // Custom cell renderer for JButton class
 class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());

        // Set the button background color based on the column
        if (column == 11) {
            setBackground(Color.GREEN); // Set the background color to green for "Update" button
        } else if (column == 12) {
            setBackground(Color.RED); // Set the background color to red for "Delete" button
        } else {
            setBackground(UIManager.getColor("Button.background"));
        }

        return this;
    }
}

    // Custom cell editor for JButton class
    class ButtonEditor extends DefaultCellEditor {
    protected JButton button;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
                int selectedColumn = table.convertColumnIndexToModel(table.getEditingColumn());
                
                if (selectedColumn == 10) {
                    
                      int id = (int) table.getModel().getValueAt(selectedRow, 0);
                String studentID = (String) table.getModel().getValueAt(selectedRow, 1);
                String lastName = (String) table.getModel().getValueAt(selectedRow, 2);
                String extension = (String) table.getModel().getValueAt(selectedRow, 3);
                String firstName = (String) table.getModel().getValueAt(selectedRow, 4);
                String middleName = (String) table.getModel().getValueAt(selectedRow, 5);
                String email = (String) table.getModel().getValueAt(selectedRow, 6);
                
                // Store the data in variables or perform any other operations
                // with the retrieved data as needed

                // Example: Print the data
                System.out.println("ID: " + id);
                System.out.println("Student ID: " + studentID);
                System.out.println("Last Name: " + lastName);
                System.out.println("Extension: " + extension);
                System.out.println("First Name: " + firstName);
                System.out.println("Middle Name: " + middleName);
                System.out.println("Email: " + email);
//                    updateStudent update=new updateStudent(id,studentID,lastName,extension,firstName,middleName,email);
                //    update.setVisible(true);
                } else if (selectedColumn == 11) {
                    System.out.println("Delete Click");
                          String studentID = (String) table.getModel().getValueAt(selectedRow, 1);
            
   
            // Perform action for Yes
            deleteStudent del=new deleteStudent(studentID);
            del.setVisible(true);
     
       
        
                }
                
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(UIManager.getColor("Button.background"));
        }

        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }
}
String username;
    public Student(String user) {
        username=user; 
    initComponents();
            displayTable(); 
         
     
                  searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
    }
 private void filterTable() {
        String searchText = searchTextField.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); // Case-insensitive search
        sorter.setRowFilter(rowFilter);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(155, 156, 237));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("    Students");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search:");

        searchTextField.setBackground(new java.awt.Color(255, 255, 255));
        searchTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REFRESH");

        Add.setBackground(new java.awt.Color(0, 255, 0));
        Add.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(0, 0, 0));
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(Add)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
         // TODO add your handling code here:
       addStudent add=new addStudent(username);
   add.setVisible(true);
    }//GEN-LAST:event_AddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
