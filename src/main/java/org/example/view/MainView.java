package org.example.view;

import javax.swing.*;
import org.jxmapviewer.*;
import org.jxmapviewer.viewer.*;

import java.util.ArrayList;
import java.awt.*;


public class MainView extends JFrame {
    private JXMapViewer map = new JXMapViewer();
    private DefaultWaypoint currentWayPoint;


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

    public DefaultWaypoint getCurrentWayPoint() {
        return this.currentWayPoint;
    }

    public void setCurrentWayPoint(DefaultWaypoint wayPoint) {
        this.currentWayPoint = wayPoint;
    }
}
