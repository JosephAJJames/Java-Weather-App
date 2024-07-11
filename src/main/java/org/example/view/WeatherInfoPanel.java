package org.example.view;

import javax.swing.*;
import java.awt.*;

public class WeatherInfoPanel extends JPanel {
    JLabel infoLabel = new JLabel();
    private JButton closeButton;
    private String infomartion;

    public WeatherInfoPanel() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());

        infoLabel = new JLabel();
        add(infoLabel, BorderLayout.CENTER);

        closeButton = new JButton("Close");
        closeButton.addActionListener(e -> setVisible(false));
        add(closeButton, BorderLayout.SOUTH);
    }

    public void setWeatherDescription(String format) {
        this.infomartion = format;
        infoLabel.setText(format);
    }
}
