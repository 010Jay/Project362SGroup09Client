/**
 * Author: Jason Jaftha 217009301
 * Description: Login Screen Gui Interface for students to log into the application.
 * File: LoginGui.java
 * Date: May 2021
 */

package za.ac.cput.user_interface;

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
        private Font ftHeading, ftText;
        private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7;

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

                lblHeading = new JLabel("Please login...", SwingConstants.CENTER);
                lblUsername = new JLabel("Username: ", SwingConstants.RIGHT);
                lblPassword = new JLabel("Password: ", SwingConstants.RIGHT);
                lblHyperlink = new JLabel("Not register? Click here!", SwingConstants.CENTER);

                txtUsername = new JTextField();
                txtPassword = new JPasswordField();

                btnLogin = new JButton("Login");
                btnExit = new JButton("Exit");

                ftHeading = new Font("Arial", Font.BOLD, 20);
                ftText = new Font("Arial", Font.PLAIN, 12);

                emptySpace1 = new JLabel();
                emptySpace2 = new JLabel();
                emptySpace3 = new JLabel();
                emptySpace4 = new JLabel();
                emptySpace5 = new JLabel();
                emptySpace6 = new JLabel();
                emptySpace7 = new JLabel();
        }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new GridLayout(2,1));
            centerPanel.setLayout(new GridLayout(3,3));
            southPanel.setLayout(new GridLayout(2,2));

       //Set font
            lblHeading.setFont(ftHeading);
            lblUsername.setFont(ftText);
            lblPassword.setFont(ftText);
            lblHyperlink.setFont(ftText);
            lblHyperlink.setForeground(Color.BLUE.darker());

       //Set mouse effect for hyperlink
            lblHyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

       //Add components to panels
            northPanel.add(lblHeading);
            northPanel.add(emptySpace1);

            centerPanel.add(lblUsername);
            centerPanel.add(txtUsername);
            centerPanel.add(emptySpace2);
            centerPanel.add(lblPassword);
            centerPanel.add(txtPassword);
            centerPanel.add(emptySpace3);
            centerPanel.add(emptySpace4);
            centerPanel.add(lblHyperlink);
            centerPanel.add(emptySpace5);
            centerPanel.setPreferredSize(new Dimension(480, 80));

            southPanel.add(emptySpace6);
            southPanel.add(emptySpace7);
            southPanel.add(btnLogin);
            southPanel.add(btnExit);

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
                    System.out.println("Go to the registration page..."); //Test
                }
            });

       //Frame
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.pack();
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
                        System.out.println("Go to next page..."); //Test
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


    //Set student number
        public void setLoginStudentNo(String studentNo)
        {
            this.studentNo = studentNo;
        }

    public static void main(String[] args) {

        new LoginUserInterface().setGui();

    }
}
