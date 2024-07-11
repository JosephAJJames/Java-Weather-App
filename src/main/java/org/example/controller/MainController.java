package org.example.controller;

import org.example.model.WeatherObject;
import org.example.view.MainView;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Set;
import org.jxmapviewer.viewer.WaypointPainter;

public class MainController extends AbstractSubject {
    private MainView mainView;
    private Set<Waypoint> waypoints;
    private WaypointRender renderer;

    public MainController(MainView view) {
        this.mainView = view;
        this.renderer = new WaypointRender(mainView);
        this.addEventListeners(view);
    }

    public WaypointRender getRenderer() {
        return this.renderer;
    }

    public void addEventListeners(MainView view) {
        JXMapViewer map = this.mainView.getMap();
        MainView mainView = this.mainView;
        WaypointRender renderer = this.getRenderer();

        if (renderer == null) {
            System.out.println("renderer is null");
        }

        MouseInputListener mouseInputListener = new PanMouseInputListener(map);
        map.addMouseListener(mouseInputListener);
        map.addMouseMotionListener(mouseInputListener);
        map.addMouseWheelListener(new ZoomMouseWheelListenerCenter(map));

        map.addMouseListener(new MapClickListener());
    }

    private class MapClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) { // Left-click
                Point point = e.getPoint();
                GeoPosition geoPosition = mainView.getMap().convertPointToGeoPosition(point);
                mainView.setCurrentWayPoint(new DefaultWaypoint(geoPosition));
                renderer.renderWayPoint(new DefaultWaypoint(geoPosition));
                MainController.this.notifyObservers(new DefaultWaypoint(geoPosition));
            }
        }
    }
}
