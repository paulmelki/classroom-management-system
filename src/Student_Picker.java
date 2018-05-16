
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Student_Picker extends JFrame implements ActionListener {


    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu_edit = new JMenu("Edit");
    private JMenuItem menu_refresh = new JMenuItem("Refresh");

    private JMenuItem menuItem_addStudents = new JMenuItem("Add a new students");
    private JMenuItem menuItem_deleteStudents = new JMenuItem("Delete a student");

    private ImageIcon image_noStudents = new ImageIcon("images/no_students.png");
    private JLabel label_noStudents = new JLabel(image_noStudents);

    private ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
    private GridLayout gridLayout = new GridLayout(12, 5, 4, 4);

    public Student_Picker() {


        changeInterface();

        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Classrooms");
        this.setJMenuBar(this.menuBar);

        this.menuBar.add(menu_edit);
        this.menuBar.add(menu_refresh);
        this.menu_edit.add(menuItem_addStudents);
        this.menu_edit.add(menuItem_deleteStudents);


        if (Main.students.size() == 0) {
            this.add(label_noStudents);
        }

        this.menuItem_addStudents.addActionListener(this);
        this.menuItem_deleteStudents.addActionListener(this);
        this.menu_refresh.addActionListener(this);

        this.setVisible(true);
    }


    public void changeInterface() {

        if (Main.students.size() > 0) {

            this.getContentPane().removeAll();

            this.setLayout(gridLayout);

            this.listOfButtons = new ArrayList<JButton>();

            for (int i = 0; i < Main.students.size(); i++) {

                JButton button_student = new JButton(
                        Main.students.get(i).getId_student() + " - " +
                                Main.students.get(i).getName_student()
                );

                button_student.setBackground(new Color(12, 101, 116));
                button_student.setForeground(Color.WHITE);
                button_student.addActionListener(this);
                this.add(button_student);
                this.listOfButtons.add(button_student);
                this.paintComponent(this.getGraphics());
            }
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.menu_refresh)) {

            changeInterface();

        }

        if (e.getSource().equals(this.menuItem_addStudents)) {

            Student_Creator sc = new Student_Creator();
        }

    }

    protected void paintComponent(Graphics g) {

        super.paintComponents(g);
    }
}
