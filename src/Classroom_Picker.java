import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Classroom_Picker extends JFrame implements ActionListener {


    private JMenuBar menuBar = new JMenuBar();

    private JMenu edit = new JMenu("Edit");
    private JMenuItem new_classroom_menuItem = new JMenuItem("Create new Classroom");
    private JMenuItem delete_classroom_menuItem = new JMenuItem("Delete a classroom");

    private ImageIcon image_no_clasrooms = new ImageIcon("images/no_classrooms.png");
    private JLabel label_no_classrooms = new JLabel(image_no_clasrooms);

    private JMenuItem refresh_button = new JMenuItem("Refresh");

    private ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
    private GridLayout gridLayout = new GridLayout(12, 5, 4, 4);

    public Classroom_Picker() {

        changeInterface();

        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Classrooms");
        this.setJMenuBar(this.menuBar);

        this.menuBar.add(this.edit);
        this.menuBar.add(refresh_button);
        this.edit.add(new_classroom_menuItem);
        this.edit.add(delete_classroom_menuItem);


        if (Main.classrooms.size() == 0) {

            this.add(label_no_classrooms);

        }

        this.new_classroom_menuItem.addActionListener(this);
        this.delete_classroom_menuItem.addActionListener(this);
        this.refresh_button.addActionListener(this);

        this.setVisible(true);
    }


    private void changeInterface() {

        if (Main.classrooms.size() > 0) {

            this.getContentPane().removeAll();

            this.setLayout(gridLayout);

            this.listOfButtons = new ArrayList<JButton>();

            for (int i = 0; i < Main.classrooms.size(); i++) {

                JButton button_classroom = new JButton(
                        Main.classrooms.get(i).getCode_classroom() + " - " +
                                Main.classrooms.get(i).getTitle_classroom());

                button_classroom.setBackground(new Color(12, 101, 116));
                button_classroom.setForeground(Color.WHITE);
                button_classroom.addActionListener(this);
                this.add(button_classroom);
                this.listOfButtons.add(button_classroom);
                this.paintComponent(this.getGraphics());
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.new_classroom_menuItem)) {

            Classroom_Creator cc = new Classroom_Creator();
            System.out.println("Number of Classrooms: " + Main.classrooms.size());

        } else if (e.getSource().equals(this.refresh_button)) {

            changeInterface();
        }

        for (int i = 0; i < this.listOfButtons.size(); i++) {

            if (e.getSource().equals(this.listOfButtons.get(i))) {
                Classroom_View classroom_view = new Classroom_View(Main.classrooms.get(i));
                this.dispose();
            }
        }


    }


    protected void paintComponent(Graphics g) {

        super.paintComponents(g);

    }

}

