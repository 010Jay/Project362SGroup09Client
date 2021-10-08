package za.ac.cput.user_interface;


import za.ac.cput.entity.Food;
import za.ac.cput.factory.FoodFactory;
import za.ac.cput.rest.FoodRestImpl;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodFormUserInterface extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblFoodID, lblFoodName, lblCategory, lblPrice;
    private  JLabel lblFoodID1,lblPrice1;
    private JComboBox comboBoxFoodName,comboBoxCategory;
    String [] category = {"Finger Foods","Mexican","Asian Dishes", "Traditional SA dishes","Italian","Dessert"};
    String [] foods = {"Onion Rings","Bread Sticks","Chicken strips","Calamari","Slap Chips","Burritos",
            "Nachos","Tacos","Tostadas","Enchiladas","Cheeseburger","Steak Sandwiches","Cheese toasts",};
    private JButton btnSubmit, btnExit;
    private Font ftHeading, ftText;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8;

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
        comboBoxFoodName = new JComboBox(foods);
        lblPrice1 = new JLabel(" ");


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


        //Add components to panels
        northPanel.add(lblHeading);
        northPanel.add(emptySpace1);

        centerPanel.add(lblFoodID);
        centerPanel.add(lblFoodID);
        centerPanel.add(emptySpace2);
        centerPanel.add(lblCategory);
        centerPanel.add(comboBoxCategory);
        centerPanel.add(lblFoodName);
        centerPanel.add(comboBoxFoodName);
        // centerPanel.add(emptySpace3);

        //centerPanel.add(emptySpace4);
        centerPanel.add(lblPrice);
        centerPanel.add(lblPrice1);
        centerPanel.add(emptySpace5);
        centerPanel.add(emptySpace6);
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

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

//    public void itemStateChanged(ItemEvent e) {
//        if (e.getSource() == comboBoxCategory ) {
//            JComboBox cbc = (JComboBox) e.getSource();
//            String message = (String) cbc.getSelectedItem();
//
//            switch (message) {
//                case " ":
//                    lblFoodID1.setText(" ");
//                    break;
//
//                case "Finger Foods":
//
//                    break;


    public void actionPerformed(ActionEvent e) {

        int foodID = Integer.parseInt(lblFoodID1.getText().trim());
        String category = comboBoxCategory.getActionCommand().trim();
        String foodName = comboBoxFoodName.getActionCommand().trim();
        Double price = Double.parseDouble(lblPrice1.getText().trim());


        //Create student object
        Food food = FoodFactory.createFood(foodID, category, foodName,price);

        if(e.getActionCommand().equals("Submit"))
        {
            //Check if all fields were included

                JOptionPane.showMessageDialog(null, "Please enter in all information!");

                //Submit information
                boolean result = FoodRestImpl.saveFood(food);

                //Check if query was successful;
                if(result == true)
                {
                    JOptionPane.showMessageDialog(null, "Information was successfully submitted.");

                    lblFoodID1.setText("");
                    comboBoxCategory.setSelectedIndex(0);
                    comboBoxFoodName.setSelectedIndex(0);
                    lblPrice1.setText("");

                    lblFoodID1.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Submission unsuccessful!");
                }
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

