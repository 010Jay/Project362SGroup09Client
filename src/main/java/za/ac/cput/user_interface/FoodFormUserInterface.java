package za.ac.cput.user_interface;

import za.ac.cput.entity.Food;
import za.ac.cput.rest.FoodRestImpl;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodFormUserInterface extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblFoodID, lblFoodName, lblCategory, lblPrice, lblQuantity;
    private  JLabel lblFoodID1,lblPrice1;
    private JComboBox comboBoxFoodName,comboBoxCategory;
    private JButton btnSubmit, btnExit;
    private JSpinner quantity;
    private Font ftHeading, ftText;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8;

    Food[] foodListBasedOnCategory;
    private FoodRestImpl food = new FoodRestImpl();
    String [] category = {"Finger Foods","Mexican","Asian Dishes", "Traditional SA dishes","Italian","Dessert","Takeaways","Desert"};

    public FoodFormUserInterface(){

        super("Food Form Screen version: 1.0 by @Jason Jaftha & Andy Hine");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Food Form", SwingConstants.CENTER);
        lblFoodID = new JLabel("Food ID: ", SwingConstants.RIGHT);
        lblFoodName = new JLabel("Food Name: ", SwingConstants.RIGHT);
        lblCategory = new JLabel("Category: ", SwingConstants.RIGHT);
        lblPrice = new JLabel("Price: ", SwingConstants.RIGHT);

        lblFoodID1 = new JLabel(" ");
        comboBoxCategory = new JComboBox(category);
        comboBoxFoodName = new JComboBox();
        lblPrice1 = new JLabel(" ");

        lblQuantity = new JLabel("Quantity: ", SwingConstants.RIGHT);
        quantity = new JSpinner();

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
        emptySpace8 =new JLabel();

        FoodRestImpl.getFoodList();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new GridLayout(2,1));
            centerPanel.setLayout(new GridLayout(5,3));
            southPanel.setLayout(new GridLayout(2,2));

        //Set font
            lblHeading.setFont(ftHeading);
            lblFoodID.setFont(ftText);
            lblFoodName.setFont(ftText);
            lblCategory.setFont(ftText);
            lblPrice.setFont(ftText);
            lblQuantity.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            northPanel.add(emptySpace1);

            centerPanel.add(lblFoodID);
            centerPanel.add(lblFoodID1);
            centerPanel.add(emptySpace2);
            centerPanel.add(lblCategory);
            centerPanel.add(comboBoxCategory);
            centerPanel.add(emptySpace3);
            centerPanel.add(lblFoodName);
            centerPanel.add(comboBoxFoodName);

            centerPanel.add(emptySpace4);
            centerPanel.add(lblPrice);
            centerPanel.add(lblPrice1);
            centerPanel.add(emptySpace5);
            centerPanel.add(lblQuantity);
            centerPanel.add(quantity);
            centerPanel.setPreferredSize(new Dimension(480, 140));

            southPanel.add(emptySpace7);
            southPanel.add(emptySpace8);
            southPanel.add(btnSubmit);
            southPanel.add(btnExit);

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
            this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Submit"))
        {
            //Save order to the invoiceLine?? (FoodId and quantity and price of the food item which is require by the invoiceLine table)
                String id = lblFoodID1.getText().trim();
                int totalQuantity = (Integer) quantity.getValue();
                System.out.println(totalQuantity); //Debug
                double price = Double.parseDouble(lblPrice1.getText().trim());
                double totalPrice = totalQuantity * price;
                System.out.println(totalPrice); //Debug
        }

        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        new FoodFormUserInterface().setGui();

    }
}

