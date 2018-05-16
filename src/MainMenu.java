import sun.applet.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainMenu extends JFrame implements ActionListener {

    /*
    DATA MEMBERS
     */

    // Main Menu Bar
    private JMenuBar menuBar = new JMenuBar();

    // Files Menu
    private JMenu file = new JMenu("Files");
    private JMenuItem createClassroom_menuItem = new JMenuItem("Create New Classroom");
    private JMenuItem registerNewStudent_menuItem = new JMenuItem("Register New Student");
    private JMenuItem addNewTest_menuItem = new JMenuItem("Add New Test");

    // Navigation Menu
    private JMenu navigation = new JMenu("Navigation");
    private JMenuItem goToClassrooms_menuItem = new JMenuItem("Go to my classrooms");
    private JMenuItem goToStudents_menuItem = new JMenuItem("Go to my students");
    private JMenuItem goToTest_menuItem = new JMenuItem("Go to my tests");

    // About Menu
    private JMenu about = new JMenu("About");
    private JMenuItem author_menuItem = new JMenuItem("About the Author");
    private JMenuItem software_menuItem = new JMenuItem("About the Software");
    private JMenuItem checkUpdates_menuItem = new JMenuItem("Check for updates");

    // Help Menu
    private JMenu help = new JMenu("Help");
    private JMenuItem checkDocumentation_menuItem = new JMenuItem("Check documentation");

    //North JPanel
    private JPanel northPanel = new JPanel();
    private ImageIcon welcome = new ImageIcon("welcome.png");
    private JLabel welcomingImage = new JLabel(welcome, SwingConstants.CENTER);

    // Center Panel
    private JPanel centerPanel = new JPanel(new GridLayout(5, 1, 4, 4));

    // Main Buttons
    private ImageIcon icon_goto_classroom = new ImageIcon("icons/classroom.png");
    private JButton button_goto_classroom = new JButton(icon_goto_classroom);
    private ImageIcon icon_goto_students = new ImageIcon("icons/students.png");
    private JButton button_goto_students = new JButton(icon_goto_students);
    private ImageIcon icon_goto_tests = new ImageIcon("icons/tests.png");
    private JButton button_goto_tests = new JButton(icon_goto_tests);

    // Smaller Buttons
    private ImageIcon icon_aboutAuthor = new ImageIcon("icons/icon_aboutAuthor.png");
    private JButton button_goto_aboutAuthor = new JButton(icon_aboutAuthor);
    private ImageIcon icon_exit = new ImageIcon("icons/icon_exit.png");
    private JButton button_exit = new JButton(icon_exit);

    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private BorderLayout southPanelLayout = new BorderLayout(20, 20);
    private JPanel southPanel = new JPanel(southPanelLayout);

    private String documentationLink = "https://drive.google.com/file/d/1ZkuoQsaCZ6xW9TukYtYxo-4iYl0v2LEI/view";

    public MainMenu() {

        this.setSize(800, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student Management System - Welcome");
        this.setJMenuBar(menuBar);

        this.setLayout(new BorderLayout(200, 4));

        menuBar.add(file);
        file.add(createClassroom_menuItem);
        file.add(registerNewStudent_menuItem);
        file.add(addNewTest_menuItem);

        menuBar.add(navigation);
        navigation.add(goToClassrooms_menuItem);
        navigation.add(goToStudents_menuItem);
        navigation.add(goToTest_menuItem);

        menuBar.add(about);
        about.add(author_menuItem);
        about.add(software_menuItem);
        about.add(checkUpdates_menuItem);

        menuBar.add(help);
        help.add(checkDocumentation_menuItem);

        northPanel.add(welcomingImage);
        this.add(northPanel, BorderLayout.NORTH);

        centerPanel.add(button_goto_classroom);
        centerPanel.add(button_goto_students);
        centerPanel.add(button_goto_tests);

        button_goto_aboutAuthor.setPreferredSize(new Dimension(210, 70));
        button_exit.setPreferredSize(new Dimension(210, 70));
        button_exit.addActionListener(this);
        southPanel.add(button_goto_aboutAuthor, BorderLayout.WEST);
        southPanel.add(button_exit, BorderLayout.EAST);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);

        this.button_goto_classroom.addActionListener(this);
        this.createClassroom_menuItem.addActionListener(this);
        this.goToClassrooms_menuItem.addActionListener(this);
        this.button_goto_students.addActionListener(this);
        this.goToStudents_menuItem.addActionListener(this);
        this.registerNewStudent_menuItem.addActionListener(this);

        this.checkDocumentation_menuItem.addActionListener(this);

        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.button_exit)) {

            System.exit(0);
        }

        else if (e.getSource().equals(this.button_goto_classroom)
                || e.getSource().equals(this.goToClassrooms_menuItem)) {

            Classroom_Picker cp = new Classroom_Picker();
        }

        else if (e.getSource().equals(createClassroom_menuItem)) {

            Classroom_Creator cc = new Classroom_Creator();
        }

        else if (e.getSource().equals(this.button_goto_students)
                || e.getSource().equals(this.goToStudents_menuItem)) {

            Student_Picker sp = new Student_Picker();
        }

        else if (e.getSource().equals(this.registerNewStudent_menuItem)) {

            Student_Creator sc = new Student_Creator();
        }

        else if (e.getSource().equals(this.checkDocumentation_menuItem)) {

            this.openWebpage(this.documentationLink);
        }



    }

    private void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
