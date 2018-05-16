import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Creator extends JFrame implements ActionListener {


    private JLabel label_studentID = new JLabel(" * ID: ");
    private JLabel label_studentName = new JLabel(" * Name: ");
    private JLabel label_studentEmail = new JLabel("Email: ");
    private JLabel label_studentGender = new JLabel(" * Gender: ");
    private JLabel label_studentIsGraduate = new JLabel("* isGraduate: ");

    private JLabel label_warning = new JLabel("Fields that have * are obligatory");

    private JTextField textField_studentID = new JTextField(14);
    private JTextField textField_studentName = new JTextField(14);
    private JTextField textField_studentEmail = new JTextField(14);

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioButton_isMale = new JRadioButton("M");
    private JRadioButton radioButton_isFemale = new JRadioButton("F");

    private JCheckBox checkBox_isGraduate = new JCheckBox();

    private ImageIcon image_title = new ImageIcon("images/student_creator.png");
    private JLabel titleLabel = new JLabel(image_title);

    private JButton submit_button = new JButton("Submit");
    private JButton cancel_button = new JButton("Cancel");

    private BorderLayout borderLayout = new BorderLayout(5, 5);
    private GridLayout gridLayout = new GridLayout(5, 1, 5, 40);

    private JPanel northPanel = new JPanel();
    private JPanel leftPanel = new JPanel(gridLayout);
    private JPanel rightPanel = new JPanel(gridLayout);
    private JPanel southPanel = new JPanel(new BorderLayout(1, 1));


    public Student_Creator() {

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Add Student");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(borderLayout);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);

        leftPanel.add(label_studentID);
        leftPanel.add(label_studentName);
        leftPanel.add(label_studentEmail);
        leftPanel.add(label_studentGender);
        leftPanel.add(label_studentIsGraduate);

        rightPanel.add(textField_studentID);
        rightPanel.add(textField_studentName);
        rightPanel.add(textField_studentEmail);

        Box box = Box.createHorizontalBox();
        box.add(this.radioButton_isMale);
        box.add(this.radioButton_isFemale);

        rightPanel.add(box);
        rightPanel.add(checkBox_isGraduate);

        label_warning.setForeground(Color.RED);
        southPanel.add(label_warning, BorderLayout.NORTH);

        submit_button.setBackground(new Color(12, 101, 116));
        submit_button.setForeground(Color.WHITE);
        cancel_button.setBackground(Color.RED);
        cancel_button.setForeground(Color.WHITE);
        southPanel.add(cancel_button, borderLayout.WEST);
        southPanel.add(submit_button, borderLayout.CENTER);

        northPanel.add(titleLabel);

        submit_button.addActionListener(this);
        cancel_button.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.cancel_button)) {

            this.dispose();

        } else if (e.getSource().equals(this.submit_button)) {

            if (isDataValid(
                    this.textField_studentID.getText(),
                    this.textField_studentName.getText(),
                    this.textField_studentEmail.getText()
            )) {

                boolean isAlreadyFound = false;
                for (int i = 0; i < Main.students.size(); i++) {

                    if (Main.students.get(i).getId_student().equals(
                            this.textField_studentID.getText()
                    )) {
                        isAlreadyFound = true;
                    }
                }

                if (isAlreadyFound == false) {
                    Student newStudent = new Student(
                            this.textField_studentName.getText(),
                            this.textField_studentID.getText(),
                            this.textField_studentEmail.getText(),
                            this.radioButton_isMale.isSelected(),
                            this.checkBox_isGraduate.isSelected()
                    );

                    Main.students.add(newStudent);

                    JOptionPane.showMessageDialog(
                            this,
                            "Student has been created successfully.",
                            "Student created",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    this.dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Student already added. No duplicates allowed.",
                            "Student already added",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "You have input some invalid data, please review your input.",
                        "Invalid input",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

    }

    private boolean isDataValid(String id, String name, String email) {

        return !id.equals("") && !name.equals("") && !email.equals("");
    }
}
