package za.ac.cput.user_interface;

/**
 * Author: ??
 * Description: ??
 * File: EntertainmentFormUserInterface.java
 * Date: 8 October 2021
 */

import za.ac.cput.entity.Entertainment;
import za.ac.cput.rest.EntertainmentRestImpl;
import za.ac.cput.rest.InvoiceRestImpl;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class EntertainmentUserInterface extends JFrame implements ActionListener {

    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel lblHeading;
    private JLabel lbl,lbl0, lbl1, lbl2, lbl3, lbl4, lbl5,lbl6;
    private JLabel lblEventCode;
    private JComboBox comboBox;
    private JTextArea lblAbout;
    private JLabel lblDate;
    private JLabel lblTime;
    private JLabel lblLocation;
    private JLabel lblCost;
    private  JLabel lblSecurity;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;
    private JButton btnSubmit, btnExit;
    private Font ftHeading, ftText, ftAbout, ftTextBold;

    private Set<Entertainment> events;

    public EntertainmentUserInterface(){
        super("Event Menu Screen version: 1.0 by @Group 09");

        panelNorth = new JPanel();
        lblHeading = new JLabel("Event Menu");
        panelCenter = new JPanel();

        lblEventCode = new JLabel("");
        comboBox = new JComboBox();
        lblAbout = new JTextArea("");
        lblAbout.setLineWrap(true);
        lblDate = new JLabel("");
        lblTime = new JLabel("");
        lblLocation = new JLabel("");
        lblCost = new JLabel("");
        lblSecurity = new JLabel("");

        lbl = new JLabel("Event Code: ", SwingConstants.RIGHT);
        lbl0 = new JLabel("Choose event: ", SwingConstants.RIGHT);
        lbl1 = new JLabel("About: ", SwingConstants.RIGHT);
        lbl2 = new JLabel("Date: ", SwingConstants.RIGHT);
        lbl3 = new JLabel("Time: ", SwingConstants.RIGHT);
        lbl4 = new JLabel("Location: ", SwingConstants.RIGHT);
        lbl5 = new JLabel("Cost: ", SwingConstants.RIGHT);
        lbl6 = new JLabel("Security: ", SwingConstants.RIGHT);

        panelSouth = new JPanel();
        btnSubmit = new JButton("Submit");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftAbout = new Font("Arial", Font.ITALIC, 12);
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
        emptySpace11 = new JLabel();
        emptySpace12 = new JLabel();
        emptySpace13 = new JLabel();

       //Populate the combobox
            events = EntertainmentRestImpl.getEntertainmentList();
            comboBox.addItem("Choose...");

            for(Entertainment evts : events)
            {
                comboBox.addItem(evts.getChooseEvent().toString());
            }
    }
    public void setGUI() {
        //NORTH PANEL
            panelNorth.setLayout(new FlowLayout());
            panelNorth.setBackground(Color.decode("#4863A0"));
            lblHeading.setForeground(Color.white);
            lblHeading.setFont(ftHeading);

        //CENTER PANEL
            panelCenter.setLayout(new GridLayout(9, 3));
            panelCenter.setBackground(Color.decode("#CECECE"));
            comboBox.setFont(ftText);
            lblAbout.setFont(ftAbout);
            lblAbout.setForeground(Color.GRAY);
            lblAbout.setBackground(Color.decode("#CECECE"));
            lblEventCode.setFont(ftText);
            lblCost.setFont(ftText);
            lblLocation.setFont(ftText);
            lblSecurity.setFont(ftText);
            lblDate.setFont(ftText);
            lblTime.setFont(ftText);
            lblTime.setForeground(Color.black);

            lbl.setFont(ftTextBold);
            lbl0.setFont(ftTextBold);
            lbl1.setFont(ftTextBold);
            lbl2.setFont(ftTextBold);
            lbl3.setFont(ftTextBold);
            lbl4.setFont(ftTextBold);
            lbl5.setFont(ftTextBold);
            lbl6.setFont(ftTextBold);

        //SOUTH PANEL
            panelSouth.setLayout(new GridLayout(2, 2));
            panelSouth.setBackground(Color.decode("#CECECE"));
            btnSubmit.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

        //NORTH
            panelNorth.add(lblHeading);

        //CENTER
            panelCenter.add(emptySpace1);
            panelCenter.add(emptySpace2);
            panelCenter.add(emptySpace3);

            panelCenter.add(lbl);
            panelCenter.add(lblEventCode);
            panelCenter.add(emptySpace13);

            panelCenter.add(lbl0);
            panelCenter.add(comboBox);
            panelCenter.add(emptySpace4);

            panelCenter.add(lbl1);
            panelCenter.add(lblAbout);
            panelCenter.add(emptySpace5);

            panelCenter.add(lbl2);
            panelCenter.add(lblDate);
            panelCenter.add(emptySpace6);

            panelCenter.add(lbl3);
            panelCenter.add(lblTime);
            panelCenter.add(emptySpace7);

            panelCenter.add(lbl4);
            panelCenter.add(lblLocation);
            panelCenter.add(emptySpace8);

            panelCenter.add(lbl5);
            panelCenter.add(lblCost);
            panelCenter.add(emptySpace9);

            panelCenter.add(lbl6);
            panelCenter.add(lblSecurity);
            panelCenter.add(emptySpace10);

        //SOUTH
            panelSouth.add(emptySpace11);
            panelSouth.add(emptySpace12);
            panelSouth.add(btnSubmit);
            panelSouth.add(btnExit);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnSubmit.addActionListener(this);
        btnExit.addActionListener(this);

        //Populate the rest of the fields when an event is chosen
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String eventChosen = (String) comboBox.getSelectedItem();

                    for(Entertainment evts : events)
                    {
                        if(eventChosen.equals(evts.getChooseEvent()))
                        {
                            lblEventCode.setText(String.valueOf(evts.getEventCode()));
                            lblAbout.setText(evts.getAbout());
                            lblDate.setText(evts.getDate());
                            lblTime.setText(evts.getTime());
                            lblLocation.setText(evts.getLocation());
                            lblCost.setText(evts.getCost());
                            lblSecurity.setText(evts.getSecurity());
                        }
                        else if (eventChosen.equals("Choose...")){
                            lblEventCode.setText("");
                            lblAbout.setText("");
                            lblDate.setText("");
                            lblTime.setText("");
                            lblLocation.setText("");
                            lblCost.setText("");
                            lblSecurity.setText("");
                        }
                    }
                }
            });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(640, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ed) {

        String eventCode = lblEventCode.getText().trim();
        String price = lblCost.getText().trim();

    if (ed.getActionCommand().equals("Submit")) {

        //Save event booking to the invoice table ??
            boolean result;

            if(lblEventCode.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose an event to book.");
            }else{
                result = InvoiceRestImpl.saveInvoice(null, eventCode, price); //Going to return false

                if(result){
                    JOptionPane.showMessageDialog(null, "There was an error booking the event.");
                }else {
                    JOptionPane.showMessageDialog(null, "You have successfully booked the event.");
                    new FoodUserInterface().setGui(); //Go to food menu
                    this.dispose();
                }
            }
    }
    else if(ed.getActionCommand().equals("Exit")) {
        System.exit(0);
    }
}

    public static void main(String[] args) {
        new EntertainmentUserInterface().setGUI();
    }
}

