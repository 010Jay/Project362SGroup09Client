package za.ac.cput.user_interface;

/**
 * Author: ??
 * Description: Food Screen Gui Interface for students to order food.
 * File: FoodUserInterface.java
 * Date: 8 October 2021
 */

import za.ac.cput.entity.Food;
import za.ac.cput.rest.FoodRestImpl;
import za.ac.cput.rest.InvoiceLineRestImpl;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodUserInterface extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblFoodID, lblFoodName, lblCategory, lblPrice, lblQuantity;
    private  JLabel lblFoodID1,lblPrice1;
    private JComboBox comboBoxFoodName,comboBoxCategory;
    private JButton btnSubmit, btnExit;
    private JSpinner quantity;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;

    Food[] foodListBasedOnCategory;
    private FoodRestImpl food = new FoodRestImpl();
    String [] category = {"Choose...", "Finger Foods","Mexican","Asian Dishes", "Traditional SA dishes","Italian","Takeaways","Desert"};

    public FoodUserInterface(){

        super("Food Menu Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Food Menu", SwingConstants.CENTER);
        lblFoodID = new JLabel("Food ID: ", SwingConstants.RIGHT);
        lblFoodName = new JLabel("Food Name: ", SwingConstants.RIGHT);
        lblCategory = new JLabel("Category: ", SwingConstants.RIGHT);
        lblPrice = new JLabel("Price: ", SwingConstants.RIGHT);

        lblFoodID1 = new JLabel(" ");
        comboBoxCategory = new JComboBox(category);
        comboBoxFoodName = new JComboBox();
        lblPrice1 = new JLabel(" ");

        lblQuantity = new JLabel("Quantity: ", SwingConstants.RIGHT);
        SpinnerModel model = new SpinnerNumberModel(1, 1, 10, 1);
        quantity = new JSpinner(model);

        btnSubmit = new JButton("Submit");
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

        FoodRestImpl.getFoodList(); //Get list of food when the Gui is started
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

            lblFoodID.setFont(ftTextBold);
            lblFoodName.setFont(ftTextBold);
            lblCategory.setFont(ftTextBold);
            lblPrice.setFont(ftTextBold);
            lblQuantity.setFont(ftTextBold);
            btnSubmit.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            lblFoodID1.setFont(ftText);
            lblPrice1.setFont(ftText);
            comboBoxCategory.setFont(ftText);
            comboBoxFoodName.setFont(ftText);
            quantity.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(emptySpace1);
            centerPanel.add(emptySpace9);
            centerPanel.add(emptySpace10);
            centerPanel.add(lblFoodID);
            centerPanel.add(lblFoodID1);
            centerPanel.add(emptySpace2);
            centerPanel.add(lblCategory);
            centerPanel.add(comboBoxCategory);
            centerPanel.add(emptySpace3);
            centerPanel.add(lblFoodName);
            centerPanel.add(comboBoxFoodName);

            centerPanel.add(emptySpace4);
            centerPanel.add(lblQuantity);
            centerPanel.add(quantity);
            centerPanel.add(emptySpace5);
            centerPanel.add(lblPrice);
            centerPanel.add(lblPrice1);
            centerPanel.setBackground(Color.decode("#CECECE"));

            southPanel.add(emptySpace7);
            southPanel.add(emptySpace8);
            southPanel.add(btnSubmit);
            southPanel.add(btnExit);
            southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
            this.add(northPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
            btnSubmit.addActionListener(this);
            btnExit.addActionListener(this);

            //Populate the comboBoxCategory, and comboBoxFoodName based on the category chosen
                comboBoxCategory.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        comboBoxFoodName.removeAllItems();
                        lblFoodID1.setText("");
                        lblPrice1.setText("");
                        String categoryChosen = (String) comboBoxCategory.getSelectedItem();
                        foodListBasedOnCategory = food.getFoodBasedOnCategory(categoryChosen);

                        for(Food f : foodListBasedOnCategory)
                        {
                            if(f != null) {
                                comboBoxFoodName.addItem(f.getName());
                            }
                        }
                    }
                });

            //Populate foodId and price based on the food item selected
                comboBoxFoodName.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String foodSelected = (String) comboBoxFoodName.getSelectedItem();

                        for(Food f : foodListBasedOnCategory)
                        {
                            if(f != null && foodSelected != null) {
                                if(foodSelected.equals(f.getName()))
                                {
                                    lblFoodID1.setText(String.valueOf(f.getFoodId()));
                                    lblPrice1.setText(String.valueOf(f.getPrice()));
                                }
                            }
                        }
                    }
                });

        //Frame
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.pack();
            this.setSize(640, 320);
            this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Submit"))
        {
            //Save order to the invoiceLine?? (FoodId and quantity and price of the food item which is require by the invoiceLine table)
                String id = lblFoodID1.getText().trim();

            if(id.equals("")){
                JOptionPane.showMessageDialog(null, "Please select a food item to order");
            }else{
                int totalQuantity = (Integer) quantity.getValue();
                System.out.println(totalQuantity); //Debug
                double price = Double.parseDouble(lblPrice1.getText().trim());
                double totalPrice = totalQuantity * price;
                System.out.println(totalPrice); //Debug
                String totalQuant = String.valueOf(totalQuantity);
                String totalPriceS = String.valueOf(totalPrice);

                boolean result = InvoiceLineRestImpl.saveInvoiceLine(id, "", totalQuant, "", totalPriceS); //Going to return false

                if(result){
                    JOptionPane.showMessageDialog(null, "Your food order could not be submitted.");
                }else{
                    JOptionPane.showMessageDialog(null, "Your food order was successfully submitted.");
                    new BeverageUserInterface().setGui();
                    this.dispose();
                }
            }
        }

        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        new FoodUserInterface().setGui();

    }
}

