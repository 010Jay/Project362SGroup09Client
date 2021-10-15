package za.ac.cput.user_interface;;

import za.ac.cput.entity.Invoice;
import za.ac.cput.rest.InvoiceRestImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class InvoiceUserInterface extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading;
    private JLabel lblInvoiceNumber,lblInvoiceDate, lblStudentNumber, lblEventCode, lblTotalPrice;
    private JLabel lblInvoiceNumber1,lblInvoiceDate1, lblStudentNumber1, lblEventCode1, lblTotalPrice1;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;
    private JButton btnLogout, btnExit;
    private Font ftHeading, ftText, ftTextBold;

    private Set<Invoice> invoiceList;
    private String studentNumber = "";

    public InvoiceUserInterface()
    {
        //Initialize all Attributes
            super("Invoice Detail Screen version: 1.0 by @Group09");

            northPanel = new JPanel();
            centerPanel = new JPanel();
            southPanel = new JPanel();

            lblHeading = new JLabel("Invoice Details", SwingConstants.CENTER);

            lblInvoiceNumber = new JLabel("Invoice Number: ", SwingConstants.RIGHT);
            lblInvoiceDate = new JLabel("Invoice Date: ", SwingConstants.RIGHT);
            lblStudentNumber = new JLabel("Student Number: ", SwingConstants.RIGHT);
            lblEventCode = new JLabel("Event Code: ", SwingConstants.RIGHT);
            lblTotalPrice = new JLabel("Total Price: ", SwingConstants.RIGHT);

            lblInvoiceNumber1 = new JLabel("");
            lblInvoiceDate1 = new JLabel("");
            lblStudentNumber1 = new JLabel("");
            lblEventCode1 = new JLabel("");
            lblTotalPrice1 = new JLabel("");

            btnLogout = new JButton("Logout");
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

            invoiceList = InvoiceRestImpl.getFoodList();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new FlowLayout());
            centerPanel.setLayout(new GridLayout(6,3));
            southPanel.setLayout(new GridLayout(2,2));

        //Set font
            lblHeading.setFont(ftHeading);
            lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblInvoiceNumber.setFont(ftTextBold);
            lblInvoiceDate.setFont(ftTextBold);
            lblStudentNumber.setFont(ftTextBold);
            lblEventCode.setFont(ftTextBold);
            lblTotalPrice.setFont(ftTextBold);
            btnLogout.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            lblInvoiceNumber1.setFont(ftText);
            lblInvoiceDate1.setFont(ftText);
            lblStudentNumber1.setFont(ftText);
            lblEventCode1.setFont(ftText);
            lblTotalPrice1.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(emptySpace1);
            centerPanel.add(emptySpace9);
            centerPanel.add(emptySpace10);

            centerPanel.add(lblInvoiceNumber);
            centerPanel.add(lblInvoiceNumber1);
            centerPanel.add(emptySpace2);

            centerPanel.add(lblInvoiceDate);
            centerPanel.add(lblInvoiceDate1);
            centerPanel.add(emptySpace3);

            centerPanel.add(lblStudentNumber);
            centerPanel.add(lblStudentNumber1);
            centerPanel.add(emptySpace4);

            centerPanel.add(lblEventCode);
            centerPanel.add(lblEventCode1);
            centerPanel.add(emptySpace5);

            centerPanel.add(lblTotalPrice);
            centerPanel.add(lblTotalPrice1);
            centerPanel.add(emptySpace6);
            centerPanel.setBackground(Color.decode("#CECECE"));

            southPanel.add(emptySpace7);
            southPanel.add(emptySpace8);
            southPanel.add(btnLogout);
            southPanel.add(btnExit);
            southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
            this.add(northPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
            btnLogout.addActionListener(this);
            btnExit.addActionListener(this);

        //Frame
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.pack();
            this.setSize(640, 300);
            this.setVisible(true);
    }

    public void setInvoiceDetails()
    {

        if(this.getStudentNumber() != null && this.studentNumber != ""){
            for(Invoice i : invoiceList)
            {
                if(getStudentNumber().equals(i.getStudentNumber()))
                {
                    lblInvoiceNumber1.setText(i.getInvoiceNumber());
                    lblInvoiceDate1.setText(i.getInvoiceDate());
                    lblStudentNumber1.setText(i.getStudentNumber());
                    lblEventCode1.setText(i.getEventCode());
                    lblTotalPrice1.setText(i.getTotalPrice());
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "There was an error getting your invoice details.");
        }
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Logout"))
        {
            new LoginUserInterface().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new InvoiceUserInterface().setGui();
    }
}
