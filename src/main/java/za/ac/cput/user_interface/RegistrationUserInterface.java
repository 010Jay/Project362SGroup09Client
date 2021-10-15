package za.ac.cput.user_interface;

import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.rest.LoginRestImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationUserInterface extends JFrame implements ActionListener {

    //Attributes
        private JPanel northPanel, centerPanel, southPanel;
        private JLabel lblHeading, lblUsername, lblPassword, lblStudentNumber;
        private  JTextField txtUsername, txtStudentNumber;
        private  JPasswordField txtPassword;
        private JButton btnRegister, btnExit;
        private Font ftHeading, ftText, ftTextBold;
        private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;

    //Constructor
    public RegistrationUserInterface()
    {
        //Initialize all Attributes
        super("Login Screen version: 1.0 by @Group09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Registration Screen", SwingConstants.CENTER);
        lblUsername = new JLabel("Username: ", SwingConstants.RIGHT);
        lblPassword = new JLabel("Password: ", SwingConstants.RIGHT);
        lblStudentNumber = new JLabel("Student Number: ", SwingConstants.RIGHT);

        txtUsername = new JTextField();
        txtStudentNumber = new JTextField();
        txtPassword = new JPasswordField();

        btnRegister = new JButton("Register");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace1 = new JLabel();
        emptySpace2 = new JLabel();
        emptySpace3 = new JLabel();
        emptySpace4 = new JLabel();
        emptySpace5 = new JLabel();
        emptySpace6 = new JLabel();
        emptySpace7 = new JLabel();
        emptySpace8 = new JLabel();
        emptySpace9 = new JLabel();
        emptySpace10 = new JLabel();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new FlowLayout());
            centerPanel.setLayout(new GridLayout(4,3));
            southPanel.setLayout(new GridLayout(2,2));

        //Set font
            lblHeading.setFont(ftHeading);
            lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblUsername.setFont(ftTextBold);
            lblPassword.setFont(ftTextBold);
            lblStudentNumber.setFont(ftTextBold);
            btnRegister.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            txtStudentNumber.setFont(ftText);
            txtUsername.setFont(ftText);
            txtPassword.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(emptySpace1);
            centerPanel.add(emptySpace9);
            centerPanel.add(emptySpace10);
            centerPanel.add(lblStudentNumber);
            centerPanel.add(txtStudentNumber);
            centerPanel.add(emptySpace2);
            centerPanel.add(lblUsername);
            centerPanel.add(txtUsername);
            centerPanel.add(emptySpace3);
            centerPanel.add(lblPassword);
            centerPanel.add(txtPassword);
            centerPanel.add(emptySpace4);
            centerPanel.setBackground(Color.decode("#CECECE"));

            southPanel.add(emptySpace6);
            southPanel.add(emptySpace7);
            southPanel.add(btnRegister);
            southPanel.add(btnExit);
            southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
            this.add(northPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
            btnRegister.addActionListener(this);
            btnExit.addActionListener(this);

        //Frame
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.pack();
            this.setSize(640, 260);
            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get student input
            String studentNumber = txtStudentNumber.getText().trim();
            String username = txtUsername.getText().trim();
            String password = String.valueOf(txtPassword.getPassword());

        if(e.getActionCommand().equals("Register"))
        {
            if(username.isEmpty() || password.isEmpty() || studentNumber.isEmpty()) //Check if username and password was given by student.
            {
                JOptionPane.showMessageDialog(null, "Please enter all information!");
            }
            else
            {
                Login login = LoginFactory.createLogin(studentNumber, username, password);

                boolean result = LoginRestImpl.saveRegistrationDetails(login); //Get the boolean result of method if the retrieval of the login details was successful.

                if (result == true) {
                    JOptionPane.showMessageDialog(null, "You are registered successfully");
                    new LoginUserInterface().setGui();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You could not be registered");
                    txtPassword.setText("");
                    txtPassword.requestFocus();
                }
            }
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new RegistrationUserInterface().setGui();
    }
}
