package org.example.controller;

import org.example.model.WeatherObject;
import org.example.view.MainView;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import java.util.HashSet;
import java.util.Set;

public class WaypointRender {
    private MainView mainView;
    private WaypointPainter<DefaultWaypoint> painter = new WaypointPainter<DefaultWaypoint>();

    public WaypointRender(MainView mainView) {
        this.mainView = mainView;
        mainView.getMap().setOverlayPainter(this.painter);
    }

    public void renderWayPoint(DefaultWaypoint wayPoint) {
        Set<DefaultWaypoint> waypoints = new HashSet<DefaultWaypoint>();
        waypoints.add(wayPoint);
        this.painter.setWaypoints(waypoints);
        this.mainView.getMap().repaint();
    }
}
