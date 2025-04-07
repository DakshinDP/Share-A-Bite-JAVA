import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.java.view.DonatePage;
import main.java.view.ReceivePage;

public class App {
    public static void main(String[] args) {
        // Home Page
        JFrame home = new JFrame("Share A Bite");
        home.setLayout(new FlowLayout());
        JButton donateBtn = new JButton("Donate");
        JButton receiveBtn = new JButton("Receive");
        donateBtn.addActionListener(e -> new DonatePage().setVisible(true));
        receiveBtn.addActionListener(e -> new ReceivePage().setVisible(true));
        home.add(donateBtn);
        home.add(receiveBtn);
        home.pack();
        home.setVisible(true);
    }
}
