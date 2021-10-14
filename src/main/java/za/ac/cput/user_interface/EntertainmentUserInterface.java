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

    private JPanel panelNorth, panelWest, panelCenter, panelSouth;
    private JLabel lblHeading;
    private JLabel imageIcon;
    private JLabel lbl,lbl0, lbl1, lbl2, lbl3, lbl4, lbl5,lbl6;
    private JLabel lblEventCode;
    private JComboBox comboBox;
    private JLabel lblText;
    private JLabel lblDate;
    private JLabel lblTime;
    private JLabel lblLocation;
    private JLabel lblCost;
    private  JLabel lblSecurity;
    private JLabel spc01,spc0, spc, spc1, spc2, spc3, spc4,spc5;
    private JLabel spcV01,spcV0, spcV, spcV14, spcV1, spcV2, spcV3, spcV4,spcV5;
    private JButton btnSave, btnClear, btnQuit;
    private Font ft, ft1, ft2;

    private Set<Entertainment> events;

    public EntertainmentUserInterface(){
        super("Entertainment Application ver 1.0");

        panelNorth = new JPanel();
        lblHeading = new JLabel("Entertainment");
        imageIcon = new JLabel();

        panelCenter = new JPanel();

        panelWest = new JPanel();
        spcV01 =new JLabel(" ");
        lblEventCode = new JLabel("");
        spc0 = new JLabel(" ");
        lbl0 = new JLabel("   Choose event: ");
        comboBox = new JComboBox();
        lblText = new JLabel(" ");
        lblDate = new JLabel(" ");
        spcV = new JLabel(" ");
        spcV0 = new JLabel(" ");
        spcV14 = new JLabel(" ");
        spcV1 = new JLabel(" ");
        lblTime = new JLabel(" ");
        spcV2 = new JLabel(" ");
        lblLocation = new JLabel(" ");
        spcV3 = new JLabel(" ");
        lblCost = new JLabel(" ");
        spcV4 = new JLabel(" ");
        lblSecurity = new JLabel(" ");
        spcV5 = new JLabel(" ");

        spc01 = new JLabel(" ");
        lbl = new JLabel("   Event Code: ");
        spc = new JLabel(" ");
        lbl1 = new JLabel("  About: ");
        spc1 = new JLabel(" ");
        lbl2 = new JLabel("  Date: ");
        spc2 = new JLabel(" ");
        lbl3 = new JLabel("  Time: ");
        spc3 = new JLabel(" ");
        lbl4 = new JLabel("   Location: ");
        spc4 = new JLabel(" ");
        lbl5 = new JLabel("   Cost: ");
        spc5 = new JLabel(" ");
        lbl6 = new JLabel("   Security:");


        panelSouth = new JPanel();
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnQuit = new JButton("Quit");

        ft = new Font("Segoe UI Black", Font.PLAIN, 40);
        ft1 = new Font("Arial", Font.PLAIN, 12);
        ft2 = new Font("Arial", Font.ITALIC, 12);

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
            imageIcon.setIcon(new ImageIcon("6.png"));
            panelNorth.setBackground(Color.decode("#072863"));
            lblHeading.setForeground(Color.white);
            lblHeading.setFont(ft);

        //CENTER PANEL
            panelCenter.setLayout(new GridLayout(17, 1));
            panelCenter.setBackground(Color.decode("#eceff1"));
            comboBox.setFont(ft1);
            lblText.setFont(ft2);
            lblText.setForeground(Color.GRAY);

            lblDate.setFont(ft1);
            lblTime.setFont(ft2);
            lblTime.setForeground(Color.black);

        //WEST PANEL
            panelWest.setLayout(new GridLayout(17, 1));
            lbl.setFont(ft1);
            lbl0.setFont(ft1);
            lbl1.setFont(ft1);
            lbl2.setFont(ft1);
            lbl3.setFont(ft1);
            lbl4.setFont(ft1);
            lbl5.setFont(ft1);
            lbl6.setFont(ft1);

            panelWest.setBackground(Color.decode("#eceff1"));

        //SOUTH PANEL
            panelSouth.setLayout(new GridLayout(1, 3));
            btnSave.setFont(ft1);
            btnClear.setFont(ft1);
            btnQuit.setFont(ft1);

        //NORTH
            panelNorth.add(lblHeading);
            panelNorth.add(imageIcon);

        //WEST
            panelWest.add(spc01);
            panelWest.add(lbl);
            panelWest.add(spc0);
            panelWest.add(lbl0);
            panelWest.add(spc);
            panelWest.add(lbl1);
            panelWest.add(spc1);
            panelWest.add(lbl2);
            panelWest.add(spc2);
            panelWest.add(lbl3);
            panelWest.add(spc3);
            panelWest.add(lbl4);
            panelWest.add(spc4);
            panelWest.add(lbl5);
            panelWest.add(spc5);
            panelWest.add(lbl6);

        //CENTER
            panelCenter.add(spcV01);
            panelCenter.add(lblEventCode);
            panelCenter.add(spcV0);
            panelCenter.add(comboBox);
            panelCenter.add(spcV14);
            panelCenter.add(lblText);
            panelCenter.add(spcV);
            panelCenter.add(lblDate);
            panelCenter.add(spcV1);
            panelCenter.add(lblTime);
            panelCenter.add(spcV2);
            panelCenter.add(lblLocation);
            panelCenter.add(spcV3);
            panelCenter.add(lblCost);
            panelCenter.add(spcV4);
            panelCenter.add(lblSecurity);
            panelCenter.add(spcV5);

        //SOUTH
            panelSouth.add(btnSave);
            panelSouth.add(btnClear);
            panelSouth.add(btnQuit);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnQuit.addActionListener(this);

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
                            lblText.setText(evts.getAbout());
                            lblDate.setText(evts.getDate());
                            lblTime.setText(evts.getTime());
                            lblLocation.setText(evts.getLocation());
                            lblCost.setText(evts.getCost());
                            lblSecurity.setText(evts.getSecurity());
                        }
                    }
                }
            });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 600);
    }

    @Override
    public void actionPerformed(ActionEvent ed) {

        String eventCode = lblEventCode.getText().trim();
        String price = lblCost.getText().trim();

    if (ed.getSource() == btnSave) {

        //Save event booking to the invoice table ??
            InvoiceRestImpl.saveInvoice(null, eventCode, price);
            JOptionPane.showMessageDialog(null, "Order was submitted.");
    }
    else if(ed.getSource() == btnClear) {
        lblEventCode.setText("");
        comboBox.setSelectedIndex(0);
        lblText.setText("");
        lblDate.setText("");
        lblTime.setText("");
        lblLocation.setText("");
        lblCost.setText("");
        lblSecurity.setText("");
    }
    else if(ed.getSource() == btnQuit) {
        System.exit(0);
    }
}

    public static void main(String[] args) {
        new EntertainmentUserInterface().setGUI();
    }
}

