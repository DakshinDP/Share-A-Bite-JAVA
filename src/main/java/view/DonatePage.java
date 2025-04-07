package main.java.view;

import main.java.model.Database;
import main.java.model.FoodItem;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class DonatePage extends JFrame {
    private JTextField foodNameField, expiryField, latField, lngField;
    private JRadioButton vegRadio, nonVegRadio;
    private JButton submitButton, locationButton;

    public DonatePage() {
        setTitle("Donate Food");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        foodNameField = new JTextField(20);
        expiryField = new JTextField(10);
        latField = new JTextField(10);
        lngField = new JTextField(10);
        vegRadio = new JRadioButton("Veg");
        nonVegRadio = new JRadioButton("Non-Veg");
        submitButton = new JButton("Submit");
        locationButton = new JButton("Get Current Location");

        locationButton.addActionListener(e -> {
            // Simulate location fetch (replace with real geolocation)
            latField.setText("12.9716");
            lngField.setText("77.5946");
        });

        submitButton.addActionListener(e -> {
            FoodItem item = new FoodItem();
            item.setId("G" + (int) (Math.random() * 1000));
            item.setFoodName(foodNameField.getText());
            item.setExpiryDate(expiryField.getText());
            item.setFoodType(vegRadio.isSelected() ? "Veg" : "Non-Veg");
            item.setLatitude(Double.parseDouble(latField.getText()));
            item.setLongitude(Double.parseDouble(lngField.getText()));
            Database.addFoodItem(item);
            JOptionPane.showMessageDialog(this, "Food donated successfully!");
        });

        add(new JLabel("Food Name:"));
        add(foodNameField);
        add(new JLabel("Expiry Date:"));
        add(expiryField);
        add(new JLabel("Location:"));
        add(latField);
        add(lngField);
        add(locationButton);
        add(vegRadio);
        add(nonVegRadio);
        add(submitButton);
        pack();
    }
}