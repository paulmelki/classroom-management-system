import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Student_Listing extends JFrame implements ActionListener {


    public static int TYPE_ADD = 0;
    public static int TYPE_DELETE = 1;

    private Classroom_View parentComponent;

    private int type;

    private JLabel titleLabel = new JLabel("Choose students");
    private DefaultListModel<String> listModel;
    private JList<String> listOfStudents;
        ArrayList<Integer> indices = new ArrayList<Integer>();

    private JButton choose_button = new JButton("Choose");
    private JButton cancel_button = new JButton("Cancel");

    private JPanel southPanel = new JPanel();


    public Student_Listing(Classroom_View parentComponent, int type) {

        this.parentComponent = parentComponent;
        this.type = type;

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Choose students");

        this.setLayout(new BorderLayout(4, 4));

        titleLabel.setBackground(new Color(7, 110, 147));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setPreferredSize(new Dimension(400, 45));
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        if (Main.students.size() > 0) {

            listModel = new DefaultListModel<String>();

            for (int i = 0; i < Main.students.size(); i++) {

                listModel.addElement(
                        Main.students.get(i).getId_student() + " - " + Main.students.get(i).getName_student()
                );

            }

            listOfStudents = new JList<>(listModel);
            listOfStudents.setPreferredSize(new Dimension(400, 315));
            this.add(listOfStudents, BorderLayout.CENTER);

            cancel_button.setBackground(Color.RED);
            cancel_button.setForeground(Color.WHITE);
            choose_button.setBackground(new Color(7, 110, 147));
            choose_button.setForeground(Color.WHITE);
            southPanel.add(cancel_button);
            southPanel.add(choose_button);
            choose_button.addActionListener(this);
            cancel_button.addActionListener(this);
            this.add(southPanel, BorderLayout.SOUTH);

            this.setVisible(true);

        }
    }


    public void returnSelectedIndicesToParent() {

        int index[] = this.listOfStudents.getSelectedIndices();
        ArrayList<Integer> indices = new ArrayList<Integer>();

        for (int ind : index) {

            indices.add(ind);
        }

        int operationType = this.type;
        this.parentComponent.receiveIndices(indices, operationType);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource().equals(this.choose_button)) {

            returnSelectedIndicesToParent();
            this.dispose();
        }

        else if (e.getSource().equals(this.cancel_button)) {

            this.dispose();
        }
    }
}
