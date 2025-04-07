package main.java.view;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;

public class ReceivePage extends JFrame {
    private JFXPanel mapPanel;
    private JList<String> foodList;

    public ReceivePage() {
        setTitle("Receive Food");
        setLayout(new BorderLayout());

        // Leaflet Map (JavaFX WebView)
        mapPanel = new JFXPanel();
        initMap();

        // Food List
        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            ResultSet rs = Database.getAvailableFoodItems();
            while (rs.next()) {
                listModel.addElement(rs.getString("food_name") + " (ID: " + rs.getString("id") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        foodList = new JList<>(listModel);
        foodList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = foodList.getSelectedValue();
                String id = selected.split("ID: ")[1].replace(")", "");
                Database.claimFoodItem(id);
                JOptionPane.showMessageDialog(this, "Food claimed! Contact the donor.");
            }
        });

        add(mapPanel, BorderLayout.CENTER);
        add(new JScrollPane(foodList), BorderLayout.EAST);
        setSize(800, 600);
    }

    private void initMap() {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.getEngine().load(getClass().getResource("/map.html").toExternalForm());
            mapPanel.setScene(new Scene(webView));
        });
    }
}