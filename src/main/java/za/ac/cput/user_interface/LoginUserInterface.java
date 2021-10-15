package za.ac.cput.user_interface;

/**
 * Author: Jason Jaftha 217009301
 * Description: Login Screen Gui Interface for students to log into the application.
 * File: LoginUserInterface.java
 * Date: May 2021
 */

import za.ac.cput.rest.LoginRestImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUserInterface extends JFrame implements ActionListener{

    //Attributes
        private JPanel northPanel, centerPanel, southPanel;
        private JLabel lblHeading, lblUsername, lblPassword, lblHyperlink;
        private  JTextField txtUsername;
        private  JPasswordField txtPassword;
        private JButton btnLogin, btnExit;
        private Font ftHeading, ftText, ftTextBold;
        private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;

        //Capture student number
            private String studentNo;

    //Constructor
        public LoginUserInterface()
        {
            //Initialize all Attributes
                super("Login Screen version: 1.0 by @Group09");

                northPanel = new JPanel();
                centerPanel = new JPanel();
                southPanel = new JPanel();

                lblHeading = new JLabel("Login Screen", SwingConstants.CENTER);
                lblUsername = new JLabel("Username: ", SwingConstants.RIGHT);
                lblPassword = new JLabel("Password: ", SwingConstants.RIGHT);
                lblHyperlink = new JLabel("Not registered? Click here!", SwingConstants.CENTER);

                txtUsername = new JTextField();
                txtPassword = new JPasswordField();

                btnLogin = new JButton("Login");
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
            btnLogin.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            lblHyperlink.setFont(ftText);
            lblHyperlink.setForeground(Color.BLUE.darker());

            txtUsername.setFont(ftText);
            txtPassword.setFont(ftText);

       //Set mouse effect for hyperlink
            lblHyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

       //Add components to panels
            northPanel.add(lblHeading);
            northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(emptySpace1);
            centerPanel.add(emptySpace8);
            centerPanel.add(emptySpace9);
            centerPanel.add(lblUsername);
            centerPanel.add(txtUsername);
            centerPanel.add(emptySpace2);
            centerPanel.add(lblPassword);
            centerPanel.add(txtPassword);
            centerPanel.add(emptySpace3);
            centerPanel.add(emptySpace4);
            centerPanel.add(lblHyperlink);
            centerPanel.add(emptySpace5);
            centerPanel.setBackground(Color.decode("#CECECE"));

            southPanel.add(emptySpace6);
            southPanel.add(emptySpace7);
            southPanel.add(btnLogin);
            southPanel.add(btnExit);
            southPanel.setBackground(Color.decode("#CECECE"));

       //Add panels to frame
            this.add(northPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(southPanel, BorderLayout.SOUTH);

       //Add action listener to buttons | mouse listener to hyperlink
            btnLogin.addActionListener(this);
            btnExit.addActionListener(this);
            lblHyperlink.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new RegistrationUserInterface().setGui();
                    disposeFrame();
                }
            });

       //Frame
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.pack();
            this.setSize(640, 260);
            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            //Get student input
                String username = txtUsername.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());

            if(e.getActionCommand().equals("Login"))
            {
                if(username.isEmpty() || password.isEmpty()) //Check if username and password was given by student.
                {
                    JOptionPane.showMessageDialog(null, "Please enter all information!");
                }
                else
                {
                    boolean result = LoginRestImpl.getLoginDetails(username, password); //Get the boolean result of method if the retrieval of the login details was successful.

                    if (result == true) {
                        JOptionPane.showMessageDialog(null, "Login was successful");
                        new EntertainmentUserInterface().setGUI();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
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

    public void disposeFrame()
    {
        this.dispose();
    }

    //Set student number
        public void setLoginStudentNo(String studentNo)
        {
            this.studentNo = studentNo;
        }

    public static void main(String[] args) {

        new LoginUserInterface().setGui();

    }
}
