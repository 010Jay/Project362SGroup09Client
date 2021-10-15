package za.ac.cput.user_interface;

import za.ac.cput.entity.Beverage;
import za.ac.cput.rest.BeverageRestImpl;
import za.ac.cput.rest.InvoiceLineRestImpl;

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
    private JLabel lblBevCode1, lblPrice1;
    private JSpinner quantity;
    private JComboBox cmbCategory, cmbBevName;
    private JButton btnSubmit, btnExit;
    private Font ftHeading, ftText;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;

    Beverage[] beverageListBasedOnCategory;
    private BeverageRestImpl beverage = new BeverageRestImpl();
    String[] category = {"Choose...","Alcohol", "Caffeinated Drinks", "Non Alcoholic", "Soft Drinks"};

    public BeverageUserInterface() {

        super("Beverage Menu Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Beverage Menu", SwingConstants.CENTER);
        lblBevCode = new JLabel("Beverage ID: ", SwingConstants.RIGHT);
        lblCategory = new JLabel("Category: ", SwingConstants.RIGHT);
        lblBevName = new JLabel("Beverage Name: ", SwingConstants.RIGHT);
        lblQuantity = new JLabel("Quantity: ", SwingConstants.RIGHT);
        lblPrice = new JLabel("Price: ", SwingConstants.RIGHT);

        lblBevCode1 = new JLabel("");
        cmbCategory = new JComboBox(category);
        cmbBevName = new JComboBox();
        SpinnerModel model = new SpinnerNumberModel(1, 1, 10, 1);
        quantity = new JSpinner(model);
        lblPrice1 = new JLabel("");

        btnSubmit = new JButton("Submit");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);

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

        BeverageRestImpl.getBeverageList();
    }

    public void setGui() {

        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(6, 3));
        southPanel.setLayout(new GridLayout(2, 2));

        lblHeading.setFont(ftHeading);
        lblHeading.setForeground(Color.decode("#FFFFFF"));
        lblBevCode.setFont(ftText);
        lblBevCode1.setFont(ftText);
        lblCategory.setFont(ftText);
        lblBevName.setFont(ftText);
        lblQuantity.setFont(ftText);
        lblPrice.setFont(ftText);
        lblPrice1.setFont(ftText);

        northPanel.add(lblHeading);
        northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(emptySpace1);
        centerPanel.add(emptySpace9);
        centerPanel.add(emptySpace10);
        centerPanel.add(lblBevCode);
        centerPanel.add(lblBevCode1);
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
        centerPanel.add(lblPrice1);
        centerPanel.add(emptySpace6);
        centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace7);
        southPanel.add(emptySpace8);
        southPanel.add(btnSubmit);
        southPanel.add(btnExit);
        southPanel.setBackground(Color.decode("#CECECE"));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnSubmit.addActionListener(this);
        btnExit.addActionListener(this);

        cmbCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbBevName.removeAllItems();
                lblBevCode1.setText("");
                lblPrice1.setText("");
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
                            lblBevCode1.setText(String.valueOf(b.getBevCode()));
                            lblPrice1.setText(String.valueOf(b.getPrice()));
                        }
                    }
                }
            }
        });

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 320);
        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {

        if (e.getActionCommand().equals("Submit")) {

            String id = lblBevCode1.getText().trim();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null, "Please select a beverage item to order");
            }else{
                int totalQuantity = (Integer) quantity.getValue();
                System.out.println(totalQuantity);
                double price = Double.parseDouble(lblPrice1.getText().trim());
                double totalPrice = totalQuantity * price;
                System.out.println(totalPrice);
                String totalQuant = String.valueOf(totalQuantity);
                String totalPriceS = String.valueOf(totalPrice);

                boolean result = InvoiceLineRestImpl.saveInvoiceLine("", id, "", totalQuant, totalPriceS); //Will return true since all values will now be supplied to the InvoiceLine table

                if(result){
                    JOptionPane.showMessageDialog(null, "Your beverage order was successfully submitted.");
                    new StudentUserInterface().setGui();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Your beverage order could not be submitted.");
                }
            }
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main (String[]args){

        new BeverageUserInterface().setGui();
    }
}


