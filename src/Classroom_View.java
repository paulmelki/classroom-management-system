import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Classroom_View extends JFrame implements ActionListener {

    private Classroom thisClassroom;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu_students = new JMenu("Students");
    private JMenu menu_tests = new JMenu("Tests");
    private JMenu menu_edit = new JMenu("Edit");
    private JMenuItem menu_refresh = new JMenuItem("Refresh");

    private JMenuItem menuItem_AddStudent = new JMenuItem("Add a new student");
    private JMenuItem menuItem_removeStudent = new JMenuItem("Remove a student");

    private JMenuItem menuItem_addTest = new JMenuItem("Add a new test");
    private JMenuItem menuItem_deleteTest = new JMenuItem("Delete a test");

    private GridLayout gridLayout = new GridLayout(1, 2, 4, 4);
    private BorderLayout borderLayout_leftPanel = new BorderLayout(4, 4);

    private JPanel leftPanel = new JPanel(this.borderLayout_leftPanel);
    private JPanel rightPanel = new JPanel(new BorderLayout(2, 2));

    private JPanel leftPanel_northPanel = new JPanel(new GridLayout(3, 1, 2, 1));
    private JPanel leftPanel_southPanel = new JPanel();

    private JPanel rightPanel_northPanel = new JPanel();
    private JPanel rightPanel_southPanel = new JPanel(new BorderLayout(1, 1));
    private JLabel label_students = new JLabel("Students:");

    private JLabel label_classroomTitle;
    private JLabel label_instructorName;
    private JLabel label_numberOfEnrolledStudents;

    private DefaultListModel<String> listModel_students;
    private JList<String> listOfStudents;

    private DefaultListModel<String> listModel_tests;
    private JList<String> listOfTests;

    private JLabel label_noTests = new JLabel("There are no tests in this course");
    private JLabel label_noStudents = new JLabel("There are no students in this course");

    private ArrayList<Integer> indices = new ArrayList<Integer>();

    public Classroom_View(Classroom thisClassroom) {

        this.thisClassroom = thisClassroom;
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setTitle(thisClassroom.getCode_classroom() + " - " + thisClassroom.getTitle_classroom());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setJMenuBar(this.menuBar);

        this.menuBar.add(this.menu_students);
        this.menuBar.add(this.menu_tests);
        this.menuBar.add(this.menu_edit);
        this.menuBar.add(this.menu_refresh);

        this.menu_students.add(menuItem_AddStudent);
        this.menu_students.add(menuItem_removeStudent);

        this.menu_tests.add(menuItem_addTest);
        this.menu_tests.add(menuItem_deleteTest);

        this.setLayout(gridLayout);
        this.add(leftPanel);
        this.add(rightPanel);

        this.leftPanel.setBorder(BorderFactory.createSoftBevelBorder(1));
        this.rightPanel.setBorder(BorderFactory.createSoftBevelBorder(1));

        this.leftPanel_northPanel.setBorder(BorderFactory.createSoftBevelBorder(1));
        this.leftPanel_southPanel.setBorder(BorderFactory.createSoftBevelBorder(1));
        this.leftPanel.add(leftPanel_northPanel, BorderLayout.CENTER);
        this.leftPanel.add(leftPanel_southPanel, BorderLayout.SOUTH);


        this.label_classroomTitle = new JLabel(thisClassroom.getCode_classroom() + " - " +
                thisClassroom.getTitle_classroom());
        this.label_classroomTitle.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        this.label_classroomTitle.setOpaque(true);
        this.label_classroomTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.label_classroomTitle.setBackground(new Color(22, 106, 140));
        this.label_classroomTitle.setForeground(new Color(7, 234, 56));
        this.leftPanel_northPanel.add(label_classroomTitle);

        this.label_instructorName = new JLabel("Instructor: " + thisClassroom.getInstructorName_classroom());
        this.label_instructorName.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        this.label_instructorName.setOpaque(true);
        this.label_instructorName.setHorizontalAlignment(SwingConstants.CENTER);
        this.label_instructorName.setBackground(new Color(22, 106, 140));
        this.label_instructorName.setForeground(new Color(7, 234, 56));
        this.leftPanel_northPanel.add(label_instructorName);

        this.label_numberOfEnrolledStudents = new JLabel("Enrolled Students: " + thisClassroom.getNumberOfEnrolledStudents());
        this.label_numberOfEnrolledStudents.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        this.label_numberOfEnrolledStudents.setOpaque(true);
        this.label_numberOfEnrolledStudents.setHorizontalAlignment(SwingConstants.CENTER);
        this.label_numberOfEnrolledStudents.setBackground(new Color(22, 106, 140));
        this.label_numberOfEnrolledStudents.setForeground(new Color(7, 234, 56));
        this.leftPanel_northPanel.add(label_numberOfEnrolledStudents);

        if (thisClassroom.getNumberOfEnrolledStudents() > 0) {
            this.listModel_students = new DefaultListModel<String>();
            for (int i = 0; i < thisClassroom.getNumberOfEnrolledStudents(); i++) {

                this.listModel_students.addElement(thisClassroom.getEnrolledStudents().get(i).getId_student() + " - " +
                        thisClassroom.getEnrolledStudents().get(i).getName_student());

            }


            this.listOfStudents = new JList<>(listModel_students);
            this.listOfStudents.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            this.listOfStudents.setPreferredSize(new Dimension(400, 700));
            this.rightPanel.add(this.listOfStudents, BorderLayout.CENTER);
        } else {

            this.label_noStudents.setOpaque(true);
            this.label_noStudents.setHorizontalAlignment(SwingConstants.CENTER);
            this.label_noStudents.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            this.label_noStudents.setBackground(new Color(232, 232, 232));
            this.label_noStudents.setForeground(new Color(22, 106, 140));
            this.label_noStudents.setPreferredSize(new Dimension(400, 350));
            this.rightPanel.add(this.label_noStudents, BorderLayout.CENTER);

        }

        this.label_students.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        this.label_students.setOpaque(true);
        this.label_students.setHorizontalAlignment(SwingConstants.CENTER);
        this.label_students.setBackground(new Color(22, 106, 140));
        this.label_students.setForeground(Color.WHITE);
        this.label_students.setPreferredSize(new Dimension(400, 50));
        this.rightPanel.add(label_students, BorderLayout.NORTH);

        if (!(thisClassroom.getNumberOfTests() == 0)) {
            this.listModel_tests = new DefaultListModel<String>();
            for (int i = 0; i < thisClassroom.getNumberOfTests(); i++) {
                if (!(thisClassroom.getTests().get(i).equals(null))) {

                    this.listModel_tests.addElement(thisClassroom.getTests().get(i).getTitle_test());
                }
            }

            this.listOfTests = new JList<>(this.listModel_tests);
            this.listOfTests.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            this.listOfTests.setPreferredSize(new Dimension(400, 350));
            this.leftPanel_southPanel.add(this.listOfTests);
        } else {

            this.label_noTests.setOpaque(true);
            this.label_noTests.setHorizontalAlignment(SwingConstants.CENTER);
            this.label_noTests.setFont(new Font("Sans-Serif", Font.BOLD, 20));
            this.label_noTests.setBackground(new Color(232, 232, 232));
            this.label_noTests.setForeground(new Color(22, 106, 140));
            this.label_noTests.setPreferredSize(new Dimension(400, 350));
            this.leftPanel_southPanel.add(this.label_noTests);

        }

        this.menu_refresh.addActionListener(this);
        this.menuItem_AddStudent.addActionListener(this);
        this.menuItem_removeStudent.addActionListener(this);

        this.setVisible(true);

    }

    private void changeInterface() {

        this.remove(this.label_noStudents);
        this.remove(this.label_noTests);

        if (thisClassroom.getNumberOfTests() > 0) {

            for (int i = 0; i < thisClassroom.getNumberOfTests(); i++) {
                if (!(thisClassroom.getTests().get(i).equals(null))) {

                    this.listModel_tests.addElement(thisClassroom.getTests().get(i).getTitle_test());
                }
            }

            this.listOfTests = new JList<>(this.listModel_tests);
            this.listOfTests.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            this.listOfTests.setPreferredSize(new Dimension(400, 350));
            this.leftPanel_southPanel.add(this.listOfTests);
        }


        if (thisClassroom.getNumberOfEnrolledStudents() > 0) {
            this.listModel_students = new DefaultListModel<String>();
            for (int i = 0; i < thisClassroom.getNumberOfEnrolledStudents(); i++) {

                this.listModel_students.addElement(thisClassroom.getEnrolledStudents().get(i).getId_student() + " - " +
                        thisClassroom.getEnrolledStudents().get(i).getName_student());

            }


            this.listOfStudents = new JList<>(listModel_students);
            this.listOfStudents.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            this.listOfStudents.setPreferredSize(new Dimension(400, 700));
            this.rightPanel.add(this.listOfStudents, BorderLayout.CENTER);
        }


        this.paintComponent(this.getGraphics());
    }


    public void receiveIndices(ArrayList<Integer> indices, int operationType) {

        this.indices = indices;
        if (this.indices.size() > 0) {

            for (Integer i : this.indices) {

                System.out.println(Main.students.get(i).getName_student());
            }

            if (operationType == Student_Listing.TYPE_ADD) {

                for (Integer i : this.indices) {

                    thisClassroom.enrollStudent(Main.students.get(i));
                }
            } else if (operationType == Student_Listing.TYPE_DELETE) {

                for (Integer i : this.indices) {

                    this.listModel_students.removeElement(thisClassroom.getEnrolledStudents().get(i).getId_student() + " - " +
                            thisClassroom.getEnrolledStudents().get(i).getName_student());
                    thisClassroom.disenrollStudent(Main.students.get(i));
                }
            }
        }

        this.indices.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.menu_refresh)) {

            this.changeInterface();
        } else if (e.getSource().equals(this.menuItem_AddStudent)) {

            Student_Listing sl = new Student_Listing(this, Student_Listing.TYPE_ADD);

        } else if (e.getSource().equals(this.menuItem_removeStudent)) {

            Student_Listing sl = new Student_Listing(this, Student_Listing.TYPE_DELETE);
        }


    }


    protected void paintComponent(Graphics g) {

        super.paintComponents(g);

    }
}
