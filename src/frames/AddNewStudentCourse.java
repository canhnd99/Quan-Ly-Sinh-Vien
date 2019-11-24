/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import controllers.CourseController;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import models.Course;

/**
 *
 * @author sunflower
 */
public class AddNewStudentCourse extends javax.swing.JFrame {

    int mousepressX;
    int mousepressY;

    CourseController cc;
    Course course;

    public AddNewStudentCourse() {
        initComponents();
        setLocationRelativeTo(null);
        cc = new CourseController();
        course = new Course();

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

        course.loadCourseIdToCombobox(cbox);

        loadCbox();

        btn_add.addActionListener((ActionEvent e) -> {
            if (txt_student_id.getText().equals("Student ID")
                    || txt_course_id.getText().equals("Course ID")) {
                JOptionPane.showMessageDialog(null, "Enter student id and choose course!");
            } else {
                cc.addNewStudentCourseIntoDatabase(txt_student_id, txt_course_id,
                        txt_course_name, txt_course_level, txt_course_time);
            }
        });
    }

    public void loadCbox() {
        cbox.addActionListener((ActionEvent e) -> {
            String courseId = cbox.getItemAt(cbox.getSelectedIndex());
            course.fillCourseFields(courseId, txt_course_id,
                    txt_course_name, txt_course_level, txt_course_time);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_exit = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        txt_student_id = new javax.swing.JTextField();
        txt_course_name = new javax.swing.JTextField();
        txt_course_level = new javax.swing.JTextField();
        txt_course_time = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbox = new javax.swing.JComboBox<>();
        txt_course_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(102, 0, 102));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Student's Course");

        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N

        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar.png"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_mini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_exit)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_mini, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_student_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_student_id.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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

        txt_course_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_name.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_course_name.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_name.setText("Course Name");
        txt_course_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_course_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_course_nameFocusLost(evt);
            }
        });

        txt_course_level.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_level.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_course_level.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_level.setText("Course Level");
        txt_course_level.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_course_levelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_course_levelFocusLost(evt);
            }
        });

        txt_course_time.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_time.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_course_time.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_time.setText("Course Time");
        txt_course_time.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_course_timeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_course_timeFocusLost(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(51, 51, 51));
        btn_add.setText("Add New Student's Course");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student-45.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course-45.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course_1-45.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level-45.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock-45.png"))); // NOI18N

        cbox.setBackground(new java.awt.Color(255, 255, 255));
        cbox.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        txt_course_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_course_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_id.setText("Course ID");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/card-45.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_course_level, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_student_id, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_course_id)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(txt_course_name))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(12, 12, 12)
                                .addComponent(txt_course_time)))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_student_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_course_name)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_course_level, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_course_time, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        mousepressX = evt.getX();
        mousepressY = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int ox = evt.getXOnScreen();
        int oy = evt.getYOnScreen();

        setLocation(ox - mousepressX, oy - mousepressY);
    }//GEN-LAST:event_headerMouseDragged

    private void txt_student_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusGained
        if (txt_student_id.getText().equals("Student ID")) {
            txt_student_id.setText("");
            txt_student_id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_student_idFocusGained

    private void txt_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusLost
        if (txt_student_id.getText().equals("")) {
            txt_student_id.setText("Student ID");
            txt_student_id.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_student_idFocusLost

    private void txt_course_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_nameFocusGained
        if (txt_course_name.getText().equals("Course Name")) {
            txt_course_name.setText("");
            txt_course_name.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_course_nameFocusGained

    private void txt_course_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_nameFocusLost
        if (txt_course_name.getText().equals("")) {
            txt_course_name.setText("Course Name");
            txt_course_name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_course_nameFocusLost

    private void txt_course_levelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_levelFocusGained
        if (txt_course_level.getText().equals("Course Level")) {
            txt_course_level.setText("");
            txt_course_level.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_course_levelFocusGained

    private void txt_course_levelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_levelFocusLost
        if (txt_course_level.getText().equals("")) {
            txt_course_level.setText("Course Level");
            txt_course_level.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_course_levelFocusLost

    private void txt_course_timeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_timeFocusGained
        if (txt_course_time.getText().equals("Course Time")) {
            txt_course_time.setText("");
            txt_course_time.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_course_timeFocusGained

    private void txt_course_timeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_course_timeFocusLost
        if (txt_course_time.getText().equals("")) {
            txt_course_time.setText("Course Time");
            txt_course_time.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_course_timeFocusLost

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
            java.util.logging.Logger.getLogger(AddNewStudentCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewStudentCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewStudentCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewStudentCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewStudentCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_mini;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_level;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_course_time;
    private javax.swing.JTextField txt_student_id;
    // End of variables declaration//GEN-END:variables
}
