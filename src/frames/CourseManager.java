package frames;

import controllers.CourseController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Course;

/**
 *
 * @author sunflower
 */
public class CourseManager extends javax.swing.JFrame {

    int mousePressedX;
    int mousePressedY;

    CourseController cc;
    Course course;

    public CourseManager() {

        initComponents();
        setLocationRelativeTo(null);

        cc = new CourseController();
        course = new Course();

        loadDataToTable();

        lb_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setVisible(false);
            }
        });

        lb_mini.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setState(ICONIFIED);
            }
        });
        
        updateNumberOfStudents();

        btn_reload.addActionListener((ActionEvent e) -> {
            loadDataToTable();
        });
        
        btn_search.addActionListener((ActionEvent e) -> {
            String searchId = txt_search.getText().toUpperCase();
            ArrayList<Course> list = course.getListStudentCourses(1, searchId);
            displaySearchValues(list);
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                ArrayList<Course> list = course.getListStudentCourses(0, "");
                int clickedRow = table.getSelectedRow();
                String msv = list.get(clickedRow).getStudentId();
                String mkh = list.get(clickedRow).getCourseId();
                String tkh = list.get(clickedRow).getCourseName();
                int lv = list.get(clickedRow).getCourseLevel();
                int tg = list.get(clickedRow).getCourseTime();
                txt_student_id_2.setText(msv);
                txt_student_id_2.setForeground(Color.BLACK);
                txt_course_id_2.setText(mkh);
                txt_course_id_2.setForeground(Color.BLACK);
                txt_course_name_2.setText(tkh);
                txt_course_name_2.setForeground(Color.BLACK);
                txt_course_level_2.setText(lv+"");
                txt_course_level_2.setForeground(Color.BLACK);
                txt_course_time_2.setText(tg+"");
                txt_course_time_2.setForeground(Color.BLACK);
            }
        });

        course.loadCourseIdToCombobox(cbox);
        
        loadCBox();
        
        btn_add.addActionListener((ActionEvent e) -> {
            cc.addNewCourseIntoDatabase(txt_course_id, txt_course_name,
                    txt_course_level, txt_course_time);
            cbox.removeAllItems();
            course.loadCourseIdToCombobox(cbox);
            
        });
        
        btn_update.addActionListener((ActionEvent e) -> {
            cc.updateCourseInDatabase(txt_course_id, txt_course_name,
                    txt_course_level, txt_course_time);
            cbox.removeAllItems();
            course.loadCourseIdToCombobox(cbox);
        });
        
        btn_delete_1.addActionListener((ActionEvent e) -> {
            String courseId = txt_course_id.getText().toUpperCase();
            course.delete(0, "", courseId);
            cbox.removeAllItems();
            course.loadCourseIdToCombobox(cbox);
        });
        
        btn_delete_2.addActionListener((ActionEvent e) -> {
            String studentId = txt_student_id_2.getText().toUpperCase();
            String courseId = txt_course_id_2.getText().toUpperCase();
            course.delete(1, studentId, courseId);
            updateNumberOfStudents();
        });
        
        btn_clear.addActionListener((ActionEvent e) -> {
            txt_course_id.setText("");
            txt_course_name.setText("");
            txt_course_time.setText("");
            txt_course_level.setText("");
        });
    }

    public void updateNumberOfStudents(){
        int slkh = getNumberOfCourses();
        txt_numbers.setText(slkh + "");
        txt_numbers.setEditable(false);
    }
    
    public void loadCBox() {
        cbox.addActionListener((ActionEvent e) -> {
            String courseId = cbox.getItemAt(cbox.getSelectedIndex());
            course.fillCourseFields(courseId, txt_course_id,
                    txt_course_name, txt_course_time, txt_course_level);
        });
    }

    public int getNumberOfCourses() {
        ArrayList<Course> list = course.getListStudentCourses(0, "");
        return list.size();
    }

    public void loadDataToTable() {
        ArrayList<Course> list = course.getListStudentCourses(0, "");
        displaySearchValues(list);
    }

    public void displaySearchValues(ArrayList<Course> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] cols = {"Student ID", "Course ID", "Course Name", "Level", "Time"};
        String[][] rows = new String[100][5];
        int i = 0;
        while (i < list.size()) {
            rows[i][0] = list.get(i).getStudentId();
            rows[i][1] = list.get(i).getCourseId();
            rows[i][2] = list.get(i).getCourseName();
            rows[i][3] = list.get(i).getCourseLevel() + "";
            rows[i][4] = list.get(i).getCourseTime() + "";
            model.setDataVector(rows, cols);
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_exit = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_course_id = new javax.swing.JTextField();
        cbox = new javax.swing.JComboBox<>();
        txt_course_name = new javax.swing.JTextField();
        txt_course_time = new javax.swing.JTextField();
        txt_course_level = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_delete_1 = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_student_id_2 = new javax.swing.JTextField();
        txt_course_id_2 = new javax.swing.JTextField();
        txt_course_name_2 = new javax.swing.JTextField();
        txt_course_level_2 = new javax.swing.JTextField();
        txt_course_time_2 = new javax.swing.JTextField();
        btn_delete_2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_numbers = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        header.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Manager");

        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N

        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar.png"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_mini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_exit)
                .addGap(15, 15, 15))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_mini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Course");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        txt_course_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_id.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_course_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_id.setText("Course ID");

        cbox.setBackground(new java.awt.Color(255, 255, 255));
        cbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txt_course_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_name.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_course_name.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_name.setText("Course Name");

        txt_course_time.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_time.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_course_time.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_time.setText("Course Time");

        txt_course_level.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_level.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_course_level.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_level.setText("Course Level");

        btn_add.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(0, 153, 0));
        btn_add.setText("ADD");
        btn_add.setIconTextGap(25);

        btn_clear.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(153, 0, 153));
        btn_clear.setText("CLEAR");

        btn_delete_1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_delete_1.setForeground(new java.awt.Color(204, 0, 0));
        btn_delete_1.setText("DELETE");

        btn_update.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(204, 204, 0));
        btn_update.setText("UPDATE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_course_id)
                    .addComponent(txt_course_name, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(txt_course_time)
                    .addComponent(txt_course_level))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btn_delete_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txt_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_course_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_course_level, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        jPanel6.setBackground(new java.awt.Color(0, 153, 204));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Student's Course");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        txt_student_id_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_student_id_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_student_id_2.setForeground(new java.awt.Color(204, 204, 204));
        txt_student_id_2.setText("Student ID");

        txt_course_id_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_id_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_course_id_2.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_id_2.setText("Course ID");

        txt_course_name_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_name_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_course_name_2.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_name_2.setText("Course Name");

        txt_course_level_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_level_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_course_level_2.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_level_2.setText("Course Level");

        txt_course_time_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_course_time_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_course_time_2.setForeground(new java.awt.Color(204, 204, 204));
        txt_course_time_2.setText("Course Time");

        btn_delete_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_delete_2.setForeground(new java.awt.Color(204, 0, 0));
        btn_delete_2.setText("DELETE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_course_level_2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_course_name_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(txt_course_id_2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_student_id_2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_course_time_2))
                .addGap(18, 18, 18)
                .addComponent(btn_delete_2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_delete_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_student_id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_course_id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(txt_course_name_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_course_level_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_course_time_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Number of student's course:");

        txt_numbers.setBackground(new java.awt.Color(255, 255, 255));
        txt_numbers.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_numbers.setForeground(new java.awt.Color(102, 102, 102));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Course ID", "Course Name", "Course Level", "Course Time"
            }
        ));
        jScrollPane1.setViewportView(table);

        txt_search.setBackground(new java.awt.Color(255, 255, 255));
        txt_search.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_search.setForeground(new java.awt.Color(204, 204, 204));
        txt_search.setText("Search by student ID");
        txt_search.setOpaque(false);
        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchFocusLost(evt);
            }
        });

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-35.png"))); // NOI18N

        btn_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload-35.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numbers, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numbers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12))
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
        mousePressedX = evt.getX();
        mousePressedY = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int ox = evt.getXOnScreen();
        int oy = evt.getYOnScreen();
        setLocation(ox - mousePressedX, oy - mousePressedY);
    }//GEN-LAST:event_headerMouseDragged

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        if (txt_search.getText().equals("Search by student ID")) {
            txt_search.setText("");
            txt_search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_searchFocusGained

    private void txt_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusLost
        if (txt_search.getText().equals("")) {
            txt_search.setText("Search by student ID");
            txt_search.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_searchFocusLost

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
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CourseManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete_1;
    private javax.swing.JButton btn_delete_2;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_mini;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_id_2;
    private javax.swing.JTextField txt_course_level;
    private javax.swing.JTextField txt_course_level_2;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_course_name_2;
    private javax.swing.JTextField txt_course_time;
    private javax.swing.JTextField txt_course_time_2;
    private javax.swing.JTextField txt_numbers;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_student_id_2;
    // End of variables declaration//GEN-END:variables
}
