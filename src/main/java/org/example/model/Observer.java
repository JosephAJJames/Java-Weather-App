package org.example.model;

import org.jxmapviewer.viewer.DefaultWaypoint;

public interface Observer {
    public void notifyObj(DefaultWaypoint waypoint);
}