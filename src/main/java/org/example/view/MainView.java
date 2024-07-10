package org.example.view;

import javax.swing.*;
import org.jxmapviewer.*;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;

import java.awt.*;


public class MainView extends JFrame {
    private JXMapViewer map = new JXMapViewer();

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
}
