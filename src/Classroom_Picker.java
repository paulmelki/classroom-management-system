import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Classroom_Picker extends JFrame implements ActionListener {


    private JMenuBar menuBar = new JMenuBar();

    private JMenu edit = new JMenu("Edit");
    private JMenuItem new_classroom_menuItem = new JMenuItem("Create new Classroom");
    private JMenuItem delete_classroom_menuItem = new JMenuItem("Delete a classroom");

    private ImageIcon image_no_clasrooms = new ImageIcon("images/no_classrooms.png");
    private JLabel label_no_classrooms = new JLabel(image_no_clasrooms);

    private DefaultListModel model = new DefaultListModel();

    private JButton arrayOfButtons[] = new JButton[50];
    private GridLayout gridLayout = new GridLayout(12, 5, 4, 4);

    public Classroom_Picker() {

        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Classrooms");
        this.setJMenuBar(this.menuBar);

        this.menuBar.add(this.edit);
        this.edit.add(new_classroom_menuItem);
        this.edit.add(delete_classroom_menuItem);


        if (Main.classrooms.size() == 0) {

            this.add(label_no_classrooms);

        } else {

            this.setLayout(gridLayout);
//            this.add(list_classrooms);

            for (int i = 0; i < Main.classrooms.size(); i++) {

                JButton button_classroom = new JButton(
                        Main.classrooms.get(i).getCode_classroom() + " - " +
                                Main.classrooms.get(i).getTitle_classroom());

                button_classroom.setBackground(new Color(7, 110, 147));
                button_classroom.setForeground(Color.WHITE);
                button_classroom.addActionListener(this);
                this.add(button_classroom);
                this.arrayOfButtons[i] = button_classroom;

            }

        }

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < this.arrayOfButtons.length; i++) {

            if (e.getSource().equals(arrayOfButtons[i])) {
                System.out.println(Main.classrooms.get(i).getTitle_classroom());
            }
        }


    }
}
