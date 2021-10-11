package za.ac.cput.user_interface;

import za.ac.cput.entity.Beverage;
import za.ac.cput.rest.BeverageRestImpl;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * BeverageUserInterface.java
 *Beverage Gui
 * Author: Nonhlahla Hlungwani 218160658
 * Date: 10 October 2021
 */


public class BeverageUserInterface extends JFrame implements ActionListener {
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblBevCode, lblCategory, lblBevName, lblQuantity, lblPrice;
    private JTextField txtBevCode, txtPrice;
    private JSpinner quantity;
    private JComboBox cmbCategory, cmbBevName;
    private JButton btnSubmit, btnExit;
    private Font ftHeading, ftText;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8;

    Beverage[] beverageListBasedOnCategory;
    private BeverageRestImpl beverage = new BeverageRestImpl();
    String[] category = {"Alcohol", "Caffeinated Drinks", "Non Alcoholic", "Soft Drinks"};

    public BeverageUserInterface() {

        super("Beverage Screen version: 1.0 by @Nonhlahla Hlungwani");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Beverages", SwingConstants.CENTER);
        lblBevCode = new JLabel("Beverage Code: ", SwingConstants.RIGHT);
        lblCategory = new JLabel("Category: ", SwingConstants.RIGHT);
        lblBevName = new JLabel("Beverage Name: ", SwingConstants.RIGHT);
        lblQuantity = new JLabel("Quantity: ", SwingConstants.RIGHT);
        lblPrice = new JLabel("Price: ", SwingConstants.RIGHT);

        txtBevCode = new JTextField();
        cmbCategory = new JComboBox(category);
        cmbBevName = new JComboBox();
        quantity = new JSpinner();
        txtPrice = new JTextField();


        btnSubmit = new JButton("Submit");
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
        emptySpace8 = new JLabel();

        BeverageRestImpl.getBeverageList();
    }

    public void setGui() {

        northPanel.setLayout(new GridLayout(2, 1));
        centerPanel.setLayout(new GridLayout(5, 3));
        southPanel.setLayout(new GridLayout(2, 2));


        lblHeading.setFont(ftHeading);
        lblBevCode.setFont(ftText);
        lblCategory.setFont(ftText);
        lblBevName.setFont(ftText);
        lblQuantity.setFont(ftText);
        lblPrice.setFont(ftText);


        northPanel.add(lblHeading);
        northPanel.add(emptySpace1);

        centerPanel.add(lblBevCode);
        centerPanel.add(txtBevCode);
        centerPanel.add(emptySpace2);
        centerPanel.add(lblCategory);
        centerPanel.add(cmbCategory);
        centerPanel.add(emptySpace3);
        centerPanel.add(lblBevName);
        centerPanel.add(cmbBevName);
        centerPanel.add(emptySpace4);
        centerPanel.add(lblQuantity);
        centerPanel.add(quantity);
        centerPanel.add(emptySpace5);
        centerPanel.add(lblPrice);
        centerPanel.add(txtPrice);
        centerPanel.add(emptySpace6);
        centerPanel.setPreferredSize(new Dimension(480, 140));

        southPanel.add(emptySpace7);
        southPanel.add(emptySpace8);
        southPanel.add(btnSubmit);
        southPanel.add(btnExit);


        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);


        btnSubmit.addActionListener(this);
        btnExit.addActionListener(this);


        cmbCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbBevName.removeAllItems();
                String categoryChosen = (String) cmbCategory.getSelectedItem();
                beverageListBasedOnCategory = beverage.getBeverageBasedOnCategory(categoryChosen);

                for (Beverage b : beverageListBasedOnCategory) {
                    if (b != null) {
                        cmbBevName.addItem(b.getBevName());
                    }
                }
            }
        });

        cmbBevName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String beverageSelected = (String) cmbBevName.getSelectedItem();

                for (Beverage b : beverageListBasedOnCategory) {
                    if (b != null && beverageSelected != null) {
                        if (beverageSelected.equals(b.getBevName())) {
                            lblBevCode.setText(String.valueOf(b.getBevCode()));
                            lblPrice.setText(String.valueOf(b.getPrice()));
                        }
                    }
                }
            }
        });

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

        public void actionPerformed (ActionEvent e){

            if (e.getActionCommand().equals("Submit")) {

                String id = lblBevCode.getText().trim();
                int totalQuantity = (Integer) quantity.getValue();
                System.out.println(totalQuantity);
                double price = Double.parseDouble(lblPrice.getText().trim());
                double totalPrice = totalQuantity * price;
                System.out.println(totalPrice);
            } else if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }

        }


        public static void main (String[]args){

            new BeverageUserInterface().setGui();

        }
    }


