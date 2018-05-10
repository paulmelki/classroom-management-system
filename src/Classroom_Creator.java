import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Classroom_Creator extends JFrame implements ActionListener {


    private JLabel label_code_classroom = new JLabel(" * Code: ");
    private JLabel label_title_classroom = new JLabel(" * Classroom Title: ");
    private JLabel label_instructorName_classroom = new JLabel(" * Instructor's name: ");
    private JLabel label_dateEnds_classroom = new JLabel("Date course ends: ");
    private JLabel label_maximumNumberOfStudents_classroom = new JLabel(" * Maximum number of students: ");
    private JLabel label_numberOfTests_classroom = new JLabel("Number of Tests: ");

    private JLabel label_warning = new JLabel("Fields that have * must be filled");

    private JTextField textField_code_classroom = new JTextField(14);
    private JTextField textField_title_classroom = new JTextField(14);
    private JTextField textField_instructorName_classroom = new JTextField(14);
    private JTextField textField_dateEnds_classroom = new JTextField(14);
    private JTextField textField_maximumNumberOfStudents_classroom = new JTextField(14);
    private JTextField textField_numberOfTests_classroom = new JTextField(14);

    private JButton submit_button = new JButton("Submit");
    private JButton cancel_button = new JButton("Cancel");

    private BorderLayout borderLayout = new BorderLayout(5, 5);

    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel southPanel = new JPanel(new BorderLayout(5, 5));

    private JPanel centerPanel = new JPanel(new GridLayout(5, 2, 5, 5));


    public Classroom_Creator() {

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setTitle("Create classroom");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setLayout(borderLayout);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(5, 2, 5, 10));
        this.add(southPanel, BorderLayout.SOUTH);

        centerPanel.add(label_code_classroom);
        centerPanel.add(textField_code_classroom);

        centerPanel.add(label_title_classroom);
        centerPanel.add(textField_title_classroom);

        centerPanel.add(label_instructorName_classroom);
        centerPanel.add(textField_instructorName_classroom);

        centerPanel.add(label_dateEnds_classroom);
        centerPanel.add(textField_dateEnds_classroom);

        centerPanel.add(label_maximumNumberOfStudents_classroom);
        centerPanel.add(textField_maximumNumberOfStudents_classroom);

        centerPanel.add(label_numberOfTests_classroom);
        centerPanel.add(textField_numberOfTests_classroom);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
