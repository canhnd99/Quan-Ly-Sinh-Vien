package frames;

import controllers.ScoreController;
import controllers.StudentController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Score;
import models.Student;

public class ScoreManager extends javax.swing.JFrame {

    ScoreController sc;
    StudentController stdc;
    Score score;
    Student student;

    int pressedX;
    int pressedY;

    public ScoreManager() {

        sc = new ScoreController();
        stdc = new StudentController();
        score = new Score();
        student = new Student();

        initComponents();
        setLocationRelativeTo(null);

        //hiển thị dữ liệu lên bảng khi khởi tạo frame.
        loadDataToTable();

        //đóng frame.
        lb_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                System.exit(0);
            }
        });

        //thu nhỏ frame.
        lb_mini.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setState(ICONIFIED);
            }
        });

        //khởi tạo ban đầu radio button bigger được tích.
        radio_bigger.setSelected(true);

        //nếu tích vào radio button smaller thì bỏ tích ở bigger.
        radio_smaller.addActionListener((ActionEvent e) -> {
            if (radio_smaller.isSelected()) {
                radio_bigger.setSelected(false);
            }
        });

        //nếu tích vào radio bigger thì bỏ tích ở smaller.
        radio_bigger.addActionListener((ActionEvent e) -> {
            if (radio_bigger.isSelected()) {
                radio_smaller.setSelected(false);
            }
        });

        //load lại bảng khi nhấn nút reload.
        btn_reload.addActionListener((ActionEvent e) -> {
            loadDataToTable();
        });

        //tìm kiếm theo Student ID.
        btn_search_student_id.addActionListener((ActionEvent e) -> {
            String studentId = txt_search_student_id.getText().toUpperCase();
            if (studentId.equals("")) {
                JOptionPane.showMessageDialog(null, "search value is empty!");
            } else {
                ArrayList<Score> list = score.getListScores(1, 0.0, studentId);
                displaySearchValues(list);
            }
        });

        //tìm kiếm theo Course ID.
        btn_search_course_id.addActionListener((ActionEvent e) -> {
            String courseId = txt_search_course_id.getText().toUpperCase();
            if (courseId.equals("")) {
                JOptionPane.showMessageDialog(null, "search value is empty!");
            } else {
                ArrayList<Score> list = score.getListScores(2, 0.0, courseId);
                displaySearchValues(list);
            }
        });

        //Sắp xếp
        cbox_sort.addActionListener((ActionEvent e) -> {
            ArrayList<Score> list = score.getListScores(0, 0.0, "");
            if ("Sort by Student ID".equals(cbox_sort.getItemAt(cbox_sort.getSelectedIndex()))) {
                list.sort(new SortScoreByStudentId());
                displaySearchValues(list);
            }
            if ("Sort by Course ID".equals(cbox_sort.getItemAt(cbox_sort.getSelectedIndex()))) {
                list.sort(new SortScoreByCourseId());
                displaySearchValues(list);
            }
            if ("Sort by Score".equals(cbox_sort.getItemAt(cbox_sort.getSelectedIndex()))) {
                list.sort(new SortByScore());
                displaySearchValues(list);
            }
        });

        //Lọc theo điểm.
        btn_filter.addActionListener((ActionEvent e) -> {
            double diem = Double.parseDouble(txt_filter_score.getText());
            if (radio_bigger.isSelected()) {
                ArrayList<Score> list = score.getListScores(3, diem, "");
                displaySearchValues(list);
            } else {
                ArrayList<Score> list = score.getListScores(4, diem, "");
                displaySearchValues(list);
            }
        });

        /*Xóa điểm trong DB*/
        btn_delete.addActionListener((ActionEvent e) -> {
            ArrayList<Score> list = score.getListScores(0, 0.0, "");
            int clickedRow = table.getSelectedRow();
            if (clickedRow == -1) {
                JOptionPane.showMessageDialog(null, "PLEASE CHOOSE A ROW TO DELETE!");
            } else {
                String studentId = list.get(clickedRow).getStudentId();
                score.deleteScoreInDatabase(studentId);
            }
        });

        /*Cập nhật điểm trong DB*/
        btn_update.addActionListener((ActionEvent e) -> {
            ArrayList<Score> list = score.getListScores(0, 0.0, "");
            int clickedRow = table.getSelectedRow();
            if (clickedRow == -1) {
                JOptionPane.showMessageDialog(null, "PLEASE CHOOSE A ROW TO UPDATE!");
            } else {
                String msv = list.get(clickedRow).getStudentId();
                String mkh = list.get(clickedRow).getCourseId();
                double ds = list.get(clickedRow).getScore();
                String tt = list.get(clickedRow).getStatus();
                UpdateScore us = new UpdateScore();
                us.loadRowValues(msv, mkh, ds, tt);
                us.setVisible(true);
            }
        });

        btn_view_student.addActionListener((ActionEvent e) -> {
            int clickedRow = table.getSelectedRow();
            if (clickedRow == -1) {
                JOptionPane.showMessageDialog(null, "PLEASE CHOOSE A ROW TO VIEW!");
            } else {
                ArrayList<Student> list = student.getListStudents(1, "B115");
                String msv = list.get(clickedRow).getStudentId();
                String ten = list.get(clickedRow).getStudentName();
                String gt = list.get(clickedRow).getStudentGender();
                String sn = list.get(clickedRow).getStudentBirthDate();
                String sdt = list.get(clickedRow).getStudentPhone();
                String dc = list.get(clickedRow).getStudentAddress();
                ViewStudent vs = new ViewStudent();
                vs.loadRowValues(msv, ten, gt, sn, sdt, dc);
                vs.setVisible(true);
            }
        });

    }

    public void loadDataToTable() {
        ArrayList<Score> list = score.getListScores(0, 0.0, "");
        displaySearchValues(list);
    }

    public void displaySearchValues(ArrayList<Score> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] cols = {"Student ID", "Course ID", "Score", "Status"};
        String[][] rows = new String[100][4];
        int i = 0;
        while (i < list.size()) {
            rows[i][0] = list.get(i).getStudentId();
            rows[i][1] = list.get(i).getCourseId();
            rows[i][2] = list.get(i).getScore() + "";
            rows[i][3] = list.get(i).getStatus();
            model.setDataVector(rows, cols);
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_exit = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        btn_reload = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbox_sort = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_search_student_id = new javax.swing.JTextField();
        btn_search_student_id = new javax.swing.JButton();
        txt_search_course_id = new javax.swing.JTextField();
        btn_search_course_id = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_filter_score = new javax.swing.JTextField();
        btn_filter = new javax.swing.JButton();
        radio_bigger = new javax.swing.JRadioButton();
        radio_smaller = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_view_student = new javax.swing.JButton();
        btn_view_course = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1132, 760));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1138, 760));

        lb_header.setBackground(new java.awt.Color(255, 255, 255));
        lb_header.setPreferredSize(new java.awt.Dimension(1132, 56));
        lb_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lb_headerMouseDragged(evt);
            }
        });
        lb_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_headerMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scores Management");

        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N

        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar.png"))); // NOI18N

        javax.swing.GroupLayout lb_headerLayout = new javax.swing.GroupLayout(lb_header);
        lb_header.setLayout(lb_headerLayout);
        lb_headerLayout.setHorizontalGroup(
            lb_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lb_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194)
                .addComponent(lb_mini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_exit)
                .addGap(21, 21, 21))
        );
        lb_headerLayout.setVerticalGroup(
            lb_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_mini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_reload.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/replay-35.png"))); // NOI18N
        btn_reload.setText("Reload");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        cbox_sort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbox_sort.setForeground(new java.awt.Color(204, 204, 204));
        cbox_sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Student ID", "Sort by Course ID", "Sort by Score" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sort");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cbox_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        txt_search_student_id.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txt_search_student_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_search_student_id.setText("Search by student ID");
        txt_search_student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_search_student_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_search_student_idFocusLost(evt);
            }
        });

        btn_search_student_id.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-35.png"))); // NOI18N

        txt_search_course_id.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txt_search_course_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_search_course_id.setText("Search by course ID");
        txt_search_course_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_search_course_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_search_course_idFocusLost(evt);
            }
        });

        btn_search_course_id.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-35.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_search_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_search_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Filter");

        txt_filter_score.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txt_filter_score.setForeground(new java.awt.Color(204, 204, 204));
        txt_filter_score.setText("Enter score");
        txt_filter_score.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_filter_scoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_filter_scoreFocusLost(evt);
            }
        });

        btn_filter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_filter.setText("FILTER");

        radio_bigger.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        radio_bigger.setText("Bigger");

        radio_smaller.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        radio_smaller.setText("Smaller");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(radio_bigger, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radio_smaller, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_filter_score, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_filter_score, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_bigger)
                    .addComponent(radio_smaller))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        table.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Course ID", "Score", "State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        btn_delete.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(153, 0, 0));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-45.png"))); // NOI18N
        btn_delete.setText("DELETE");

        btn_update.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(0, 102, 51));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/renew-45.png"))); // NOI18N
        btn_update.setText("UPDATE");

        btn_view_student.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_view_student.setForeground(new java.awt.Color(204, 204, 0));
        btn_view_student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student-45.png"))); // NOI18N
        btn_view_student.setText("STUDENT");

        btn_view_course.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_view_course.setForeground(new java.awt.Color(153, 0, 255));
        btn_view_course.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course-45.png"))); // NOI18N
        btn_view_course.setText("COURSE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_update)
                                .addGap(37, 37, 37)
                                .addComponent(btn_view_student)
                                .addGap(32, 32, 32)
                                .addComponent(btn_view_course))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reload)))
                .addGap(22, 22, 22))
            .addComponent(lb_header, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lb_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_delete)
                            .addComponent(btn_update)
                            .addComponent(btn_view_student)
                            .addComponent(btn_view_course))))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Set sự kiện để khi nhấn vào một ô textfield thì text placeholder sẽ mất
    * và hiện trở lại khi kích ra chỗ khác.
     */
    private void txt_search_student_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_search_student_idFocusGained
        if (txt_search_student_id.getText().equals("Search by student ID")) {
            txt_search_student_id.setText("");
            txt_search_student_id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_search_student_idFocusGained

    private void txt_search_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_search_student_idFocusLost
        if (txt_search_student_id.getText().isEmpty()) {
            txt_search_student_id.setText("Search by student ID");
            txt_search_student_id.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt_search_student_idFocusLost

    private void txt_search_course_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_search_course_idFocusGained
        if (txt_search_course_id.getText().equals("Search by course ID")) {
            txt_search_course_id.setText("");
            txt_search_course_id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_search_course_idFocusGained

    private void txt_search_course_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_search_course_idFocusLost
        if (txt_search_course_id.getText().isEmpty()) {
            txt_search_course_id.setText("Search by course ID");
            txt_search_course_id.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt_search_course_idFocusLost

    /*
    * Đoạn này dùng để set moveable cho frame.
     */
    private void lb_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_headerMouseDragged
        int ox = evt.getXOnScreen();
        int oy = evt.getYOnScreen();
        setLocation(ox - pressedX, oy - pressedY);
    }//GEN-LAST:event_lb_headerMouseDragged

    private void lb_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_headerMousePressed
        pressedX = evt.getX();
        pressedY = evt.getY();
    }//GEN-LAST:event_lb_headerMousePressed

    private void txt_filter_scoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_filter_scoreFocusGained
        if (txt_filter_score.getText().equals("Enter score")) {
            txt_filter_score.setText("");
            txt_filter_score.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_filter_scoreFocusGained

    private void txt_filter_scoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_filter_scoreFocusLost
        if (txt_filter_score.getText().isEmpty()) {
            txt_filter_score.setText("Enter score");
            txt_filter_score.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt_filter_scoreFocusLost

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
            java.util.logging.Logger.getLogger(ScoreManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScoreManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_filter;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_search_course_id;
    private javax.swing.JButton btn_search_student_id;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view_course;
    private javax.swing.JButton btn_view_student;
    private javax.swing.JComboBox<String> cbox_sort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JPanel lb_header;
    private javax.swing.JLabel lb_mini;
    private javax.swing.JRadioButton radio_bigger;
    private javax.swing.JRadioButton radio_smaller;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_filter_score;
    private javax.swing.JTextField txt_search_course_id;
    private javax.swing.JTextField txt_search_student_id;
    // End of variables declaration//GEN-END:variables
}
