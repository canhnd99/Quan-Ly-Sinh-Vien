package frames;

import controllers.StudentController;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddNewStudent extends javax.swing.JFrame {

    int mousepressX;
    int mousepressY;

    StudentController stdc;

    public AddNewStudent() {
        initComponents();
        setLocationRelativeTo(null);

        stdc = new StudentController();

        lb_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });

        lb_mini.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(ICONIFIED);
            }
        });

        rb_male.setSelected(true);

        rb_male.addActionListener((ActionEvent e) -> {
            if (rb_male.isSelected()) {
                rb_female.setSelected(false);
            }
        });

        rb_female.addActionListener((ActionEvent e) -> {
            if (rb_female.isSelected()) {
                rb_male.setSelected(false);
            }
        });

        btn_add_student.addActionListener((ActionEvent e) -> {
            String gender = "Male";
            if (rb_female.isSelected()) {
                gender = "Female";
            }
            stdc.addNewStudentIntoDatabase(txt_student_id, txt_student_name, gender,
                    date_birth, txt_student_phone, txt_address);
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb_student_address = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        pn_header = new javax.swing.JPanel();
        lb_header = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        lb_exit = new javax.swing.JLabel();
        txt_student_name = new javax.swing.JTextField();
        txt_student_phone = new javax.swing.JTextField();
        txt_student_id = new javax.swing.JTextField();
        rb_male = new javax.swing.JRadioButton();
        rb_female = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_add_student = new javax.swing.JButton();
        date_birth = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();

        cb_student_address.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_student_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_student_addressActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pn_header.setBackground(new java.awt.Color(102, 0, 102));
        pn_header.setForeground(new java.awt.Color(255, 255, 255));
        pn_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pn_headerMouseDragged(evt);
            }
        });
        pn_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_headerMousePressed(evt);
            }
        });

        lb_header.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lb_header.setForeground(new java.awt.Color(255, 255, 255));
        lb_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_header.setText("Add New Student");

        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar.png"))); // NOI18N
        lb_mini.setText("jLabel2");

        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        lb_exit.setText("jLabel3");

        javax.swing.GroupLayout pn_headerLayout = new javax.swing.GroupLayout(pn_header);
        pn_header.setLayout(pn_headerLayout);
        pn_headerLayout.setHorizontalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_headerLayout.createSequentialGroup()
                .addComponent(lb_header, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_mini, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_headerLayout.setVerticalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_mini, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txt_student_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_student_name.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_student_name.setForeground(new java.awt.Color(204, 204, 204));
        txt_student_name.setText("Student Name");
        txt_student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_student_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_nameFocusLost(evt);
            }
        });
        txt_student_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_student_nameKeyPressed(evt);
            }
        });

        txt_student_phone.setBackground(new java.awt.Color(255, 255, 255));
        txt_student_phone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_student_phone.setForeground(new java.awt.Color(204, 204, 204));
        txt_student_phone.setText("Phone Number");
        txt_student_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_student_phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_phoneFocusLost(evt);
            }
        });
        txt_student_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_student_phoneKeyPressed(evt);
            }
        });

        txt_student_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_student_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_student_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_student_id.setText("Student ID");
        txt_student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_student_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_idFocusLost(evt);
            }
        });
        txt_student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_student_idKeyPressed(evt);
            }
        });

        rb_male.setBackground(new java.awt.Color(255, 255, 255));
        rb_male.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rb_male.setText("Male");

        rb_female.setBackground(new java.awt.Color(255, 255, 255));
        rb_female.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rb_female.setText("Female");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/id_student.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-student-male-35.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-male-and-female-35.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-birthday-cake-35.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ringing-phone-35.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-address-35.png"))); // NOI18N

        btn_add_student.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_add_student.setText("ADD NEW STUDENT");

        date_birth.setBackground(new java.awt.Color(255, 255, 255));

        txt_address.setBackground(new java.awt.Color(255, 255, 255));
        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_address.setForeground(new java.awt.Color(204, 204, 204));
        txt_address.setRows(5);
        txt_address.setText("Enter your address");
        txt_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_addressFocusLost(evt);
            }
        });
        txt_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txt_address);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add_student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_student_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_student_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_student_id)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(date_birth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rb_male, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(rb_female)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pn_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_student_id))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txt_student_name))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_female, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rb_male, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(date_birth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txt_student_phone))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_add_student, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_student_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusGained
        if (txt_student_id.getText().equals("Student ID")) {
            txt_student_id.setText("");
            txt_student_id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_student_idFocusGained

    private void txt_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusLost
        if (txt_student_id.getText().isEmpty()) {
            txt_student_id.setText("Student ID");
            txt_student_id.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_student_idFocusLost

    private void txt_student_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_nameFocusGained
        if (txt_student_name.getText().equals("Student Name")) {
            txt_student_name.setText("");
            txt_student_name.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_student_nameFocusGained

    private void txt_student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_nameFocusLost
        if (txt_student_name.getText().isEmpty()) {
            txt_student_name.setText("Student Name");
            txt_student_name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_student_nameFocusLost

    private void txt_student_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_phoneFocusGained
        if (txt_student_phone.getText().equals("Phone Number")) {
            txt_student_phone.setText("");
            txt_student_phone.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_student_phoneFocusGained

    private void txt_student_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_phoneFocusLost
        if (txt_student_phone.getText().isEmpty()) {
            txt_student_phone.setText("Phone Number");
            txt_student_phone.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_student_phoneFocusLost

    private void cb_student_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_student_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_student_addressActionPerformed

    private void txt_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusGained
        if (txt_address.getText().equals("Enter your address")) {
            txt_address.setText("");
            txt_address.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_addressFocusGained

    private void txt_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusLost
        if (txt_address.getText().isEmpty()) {
            txt_address.setText("Enter your address");
            txt_address.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_addressFocusLost

    private void pn_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_headerMouseDragged

        int ox = evt.getXOnScreen();
        int oy = evt.getYOnScreen();

        setLocation(ox - mousepressX, oy - mousepressY);
    }//GEN-LAST:event_pn_headerMouseDragged

    private void pn_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_headerMousePressed
        mousepressX = evt.getX();
        mousepressY = evt.getY();
    }//GEN-LAST:event_pn_headerMousePressed

    private void txt_student_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_student_idKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            txt_student_name.requestFocus();
        }
    }//GEN-LAST:event_txt_student_idKeyPressed

    private void txt_student_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_student_nameKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            txt_student_phone.requestFocus();
        }
    }//GEN-LAST:event_txt_student_nameKeyPressed

    private void txt_student_phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_student_phoneKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            txt_address.requestFocus();
        }
    }//GEN-LAST:event_txt_student_phoneKeyPressed

    private void txt_addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addressKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            txt_student_id.requestFocus();
        }
    }//GEN-LAST:event_txt_addressKeyPressed

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
            java.util.logging.Logger.getLogger(AddNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewStudent().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_student;
    private javax.swing.JComboBox<String> cb_student_address;
    private com.toedter.calendar.JDateChooser date_birth;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_header;
    private javax.swing.JLabel lb_mini;
    private javax.swing.JPanel pn_header;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_student_id;
    private javax.swing.JTextField txt_student_name;
    private javax.swing.JTextField txt_student_phone;
    // End of variables declaration//GEN-END:variables
}
