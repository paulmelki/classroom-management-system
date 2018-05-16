import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Classroom_Creator extends JFrame implements ActionListener {


    private JLabel label_code_classroom = new JLabel(" * Code: ");
    private JLabel label_title_classroom = new JLabel(" * Classroom Title: ");
    private JLabel label_instructorName_classroom = new JLabel(" * Instructor's name: ");
    private JLabel label_maximumNumberOfStudents_classroom = new JLabel(" * Maximum number of students: ");

    private JLabel label_warning = new JLabel("Fields that have * are obligatory");

    private JTextField textField_code_classroom = new JTextField(14);
    private JTextField textField_title_classroom = new JTextField(14);
    private JTextField textField_instructorName_classroom = new JTextField(14);
    private JTextField textField_maximumNumberOfStudents_classroom = new JTextField(14);

    private ImageIcon icon_title = new ImageIcon("images/classroom_creator.png");
    private JLabel titleLabel = new JLabel(icon_title);

    private JButton submit_button = new JButton("Submit");
    private JButton cancel_button = new JButton("Cancel");

    private BorderLayout borderLayout = new BorderLayout(5, 5);
    private GridLayout gridLayout = new GridLayout(5, 1, 5, 40);

    private JPanel northPanel = new JPanel();
    private JPanel leftPanel = new JPanel(gridLayout);
    private JPanel rightPanel = new JPanel(gridLayout);
    private JPanel southPanel = new JPanel(new BorderLayout(1, 1));
//    private JPanel southLeft = new JPanel(new GridLayout(2, 2, 30, 1));


    public Classroom_Creator() {

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Create classroom");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setLayout(borderLayout);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);

        leftPanel.add(label_code_classroom);
        leftPanel.add(label_title_classroom);
        leftPanel.add(label_instructorName_classroom);
        leftPanel.add(label_maximumNumberOfStudents_classroom);

        rightPanel.add(textField_code_classroom);
        rightPanel.add(textField_title_classroom);
        rightPanel.add(textField_instructorName_classroom);
        rightPanel.add(textField_maximumNumberOfStudents_classroom);

        label_warning.setForeground(Color.RED);
        southPanel.add(label_warning, BorderLayout.NORTH);
//        southPanel.add(southCenterPanel);

        submit_button.setBackground(new Color(12, 101, 116));
        submit_button.setForeground(Color.WHITE);
        cancel_button.setBackground(Color.RED);
        cancel_button.setForeground(Color.WHITE);
        southPanel.add(cancel_button, borderLayout.WEST);
        southPanel.add(submit_button, borderLayout.CENTER);

        northPanel.add(titleLabel);


        cancel_button.addActionListener(this);
        submit_button.addActionListener(this);


        this.setVisible(true);
    }


    private boolean isDataValid(String code, String title, String instructorName, int number) {

        return !code.equals("") && !title.equals("") && !instructorName.equals("") && number > 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource().equals(this.cancel_button)) {

            this.dispose();
        } else if (e.getSource().equals(this.submit_button)) {

            try {

                if (isDataValid(this.textField_code_classroom.getText(), this.textField_title_classroom.getText(),
                        this.textField_instructorName_classroom.getText(),
                        Integer.parseInt(this.textField_maximumNumberOfStudents_classroom.getText()))) {


                    Classroom newClassroom = new Classroom(
                            this.textField_code_classroom.getText(),
                            this.textField_title_classroom.getText(),
                            this.textField_instructorName_classroom.getText(),
                            Integer.parseInt(textField_maximumNumberOfStudents_classroom.getText())
                    );


                    Main.classrooms.add(newClassroom);
                    JOptionPane.showMessageDialog(this,
                            "Classroom has been created successfully!",
                            "Classroom created!",
                            JOptionPane.INFORMATION_MESSAGE);

                    this.dispose();

                }
            } catch (Exception exc) {

                JOptionPane.showMessageDialog(this,
                        "Make sure to enter a valid number of students!",
                        "INVALID NUMBER OF STUDENTS",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
