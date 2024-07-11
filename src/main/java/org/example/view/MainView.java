package org.example.view;

import javax.swing.*;
import org.jxmapviewer.*;
import org.jxmapviewer.viewer.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.*;


public class MainView extends JFrame {
    private JXMapViewer map = new JXMapViewer();
    private DefaultWaypoint currentWayPoint;
    private WeatherInfoPanel whiteBoxPanel = new WeatherInfoPanel();


    public MainView() {
        setSize(800, 800);
        setTitle("Weather");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        this.map.setTileFactory(tileFactory);
        this.map.setZoom(5);
        GeoPosition pos = new GeoPosition(53.4071991, -2.99168);
        this.map.setAddressLocation(pos);
        this.map.setPanEnabled(true);  // Enable panning
        setLayout(new BorderLayout());
        add(this.map, BorderLayout.CENTER);
    }

    public JXMapViewer getMap() {
        return this.map;
    }

    public void setMap(JXMapViewer map) {
        this.map = map;
    }

    public void drawAgain() {
        this.whiteBoxPanel.setVisible(true);
        this.map.add(this.whiteBoxPanel);
        this.map.revalidate();
        this.map.repaint();
    }

    public void showWeatherPanel(GeoPosition pos, String desc, int temp) {
        whiteBoxPanel.setWeatherDescription(String.format("Description: %s, Temperature: %d°C", desc, temp));
        Point2D point2D = map.convertGeoPositionToPoint(pos);
        Point point = new Point((int) point2D.getX(), (int) point2D.getY());
        whiteBoxPanel.setSize(200, 100); // Set a preferred size for the panel
        whiteBoxPanel.setLocation(point.x - whiteBoxPanel.getWidth() / 2, point.y - whiteBoxPanel.getHeight() - 10);
        this.setWhiteBoxPanel(whiteBoxPanel);
    }

    public void setWhiteBoxPanel(WeatherInfoPanel panel) {
        this.whiteBoxPanel = panel;
        this.drawAgain();
    }

    public DefaultWaypoint getCurrentWayPoint() {
        return this.currentWayPoint;
    }

    public void setCurrentWayPoint(DefaultWaypoint wayPoint) {
        this.currentWayPoint = wayPoint;
    }
}
